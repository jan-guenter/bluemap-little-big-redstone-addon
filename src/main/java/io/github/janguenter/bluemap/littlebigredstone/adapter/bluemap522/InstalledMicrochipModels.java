/*
 * SPDX-License-Identifier: MIT
 */

package io.github.janguenter.bluemap.littlebigredstone.adapter.bluemap522;

import com.flowpowered.math.vector.Vector3f;
import de.bluecolored.bluemap.core.map.hires.block.BlockRendererType;
import de.bluecolored.bluemap.core.resources.ResourcePath;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.ResourcePack;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.blockstate.BlockState;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.blockstate.Variant;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.blockstate.VariantSet;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.blockstate.Variants;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.model.Element;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.model.Face;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.model.Model;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.model.TextureVariable;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.texture.Texture;
import de.bluecolored.bluemap.core.util.Direction;
import de.bluecolored.bluemap.core.util.Key;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/** Replaces the unsupported dynamic loader with installed-texture static cubes. */
final class InstalledMicrochipModels {

    private InstalledMicrochipModels() {
    }

    static boolean install(ResourcePack pack) {
        if (!validInstalledInputs(pack)) {
            return false;
        }
        for (String color : MicrochipCatalog.COLORS) {
            Key modelKey = MicrochipCatalog.staticModelKey(color);
            pack.getModels().put(modelKey, cube(color));
            pack.getBlockStates().put(
                    MicrochipCatalog.blockKey(color), singleVariant(modelKey)
            );
        }
        return true;
    }

    private static boolean validInstalledInputs(ResourcePack pack) {
        for (String color : MicrochipCatalog.COLORS) {
            BlockState state = pack.getBlockStates().get(MicrochipCatalog.blockKey(color));
            if (state == null || state.getMultipart() != null || state.getVariants() == null) {
                return false;
            }
            List<Variant> variants = new ArrayList<>();
            state.forEach(variants::add);
            if (variants.size() != 1) {
                return false;
            }
            Variant variant = variants.getFirst();
            if (variant.getRenderer() != BlockRendererType.DEFAULT
                    || !MicrochipCatalog.originalModelKey(color).equals(variant.getModel())
                    || variant.isTransformed() || variant.isUvlock()) {
                return false;
            }
            Model original = pack.getModels().get(MicrochipCatalog.originalModelKey(color));
            if (original == null) {
                return false;
            }
            if (pack.getTextures().get(MicrochipCatalog.sideTextureKey(color)) == null
                    || pack.getTextures().get(MicrochipCatalog.topTextureKey(color)) == null
                    || pack.getTextures().get(MicrochipCatalog.bottomTextureKey(color)) == null) {
                return false;
            }
        }
        return true;
    }

    private static Model cube(String color) {
        Map<Direction, Face> faces = new EnumMap<>(Direction.class);
        for (Direction direction : Direction.values()) {
            Key texture = switch (direction) {
                case UP -> MicrochipCatalog.topTextureKey(color);
                case DOWN -> MicrochipCatalog.bottomTextureKey(color);
                default -> MicrochipCatalog.sideTextureKey(color);
            };
            faces.put(direction, new Face(
                    new TextureVariable(new ResourcePath<Texture>(texture))
            ));
        }
        return new Model(new Element(
                new Vector3f(0F, 0F, 0F),
                new Vector3f(16F, 16F, 16F),
                faces
        ));
    }

    private static BlockState singleVariant(Key model) {
        return new BlockState(new Variants(
                new VariantSet[0],
                new VariantSet(new Variant(new ResourcePath<Model>(model)))
        ));
    }
}
