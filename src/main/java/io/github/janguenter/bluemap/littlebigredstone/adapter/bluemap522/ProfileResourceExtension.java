/*
 * SPDX-License-Identifier: MIT
 */

package io.github.janguenter.bluemap.littlebigredstone.adapter.bluemap522;

import de.bluecolored.bluemap.core.resources.pack.resourcepack.ResourcePack;
import de.bluecolored.bluemap.core.resources.pack.resourcepack.ResourcePackExtension;
import de.bluecolored.bluemap.core.util.Key;
import io.github.janguenter.bluemap.addon.runtime.artifact.ExactArtifactDetector;
import io.github.janguenter.bluemap.littlebigredstone.activation.AddonRuntime;
import io.github.janguenter.bluemap.littlebigredstone.profile.LittleBigRedstone198Profile;

import java.nio.file.Path;
import java.util.Set;

/** Exact-artifact admission hook for Little Big Redstone microchip models. */
final class ProfileResourceExtension implements ResourcePackExtension {

    private final ResourcePack resourcePack;
    private final AddonRuntime runtime;

    ProfileResourceExtension(ResourcePack resourcePack, AddonRuntime runtime) {
        this.resourcePack = resourcePack;
        this.runtime = runtime;
    }

    @Override
    public void loadResources(Iterable<Path> roots) {
        if (Boolean.getBoolean("bluemap.little_big_redstone.disabled")) {
            runtime.inactive("operator-disabled");
            return;
        }
        if (!ExactArtifactDetector.matchesAll(roots, LittleBigRedstone198Profile.ARTIFACTS)) {
            runtime.inactive("exact-artifact-missing-or-duplicate");
            return;
        }

        if (!InstalledMicrochipModels.install(resourcePack)) {
            runtime.inactive("required-installed-resource-missing");
            return;
        }
        runtime.activate();
    }

    @Override
    public Set<Key> collectUsedTextureKeys() {
        return runtime.active() ? MicrochipCatalog.textureKeys() : Set.of();
    }

    @Override
    public void bake() {
        if (runtime.active()) {
            System.out.println(
                    "BlueMap Little Big Redstone add-on active: 16 microchip models."
            );
        }
    }
}
