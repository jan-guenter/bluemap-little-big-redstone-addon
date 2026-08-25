/*
 * SPDX-License-Identifier: MIT
 */

package io.github.janguenter.bluemap.littlebigredstone.adapter.bluemap522;

import de.bluecolored.bluemap.core.util.Key;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Exact installed resource keys for the sixteen colored microchips. */
final class MicrochipCatalog {

    static final List<String> COLORS = List.of(
            "white", "orange", "magenta", "light_blue",
            "yellow", "lime", "pink", "gray",
            "light_gray", "cyan", "purple", "blue",
            "brown", "green", "red", "black"
    );

    private MicrochipCatalog() {
    }

    static Key blockKey(String color) {
        return Key.parse("little_big_redstone:" + color + "_microchip");
    }

    static Key originalModelKey(String color) {
        return Key.parse("little_big_redstone:block/" + color + "_microchip");
    }

    static Key staticModelKey(String color) {
        return Key.parse("bluemap_little_big_redstone:block/" + color + "_microchip");
    }

    static Key sideTextureKey(String color) {
        return Key.parse("little_big_redstone:block/microchip/side/" + color);
    }

    static Key topTextureKey(String color) {
        return Key.parse("little_big_redstone:block/microchip/top/" + color);
    }

    static Key bottomTextureKey(String color) {
        return Key.parse("little_big_redstone:block/microchip/bottom/" + color);
    }

    static Set<Key> textureKeys() {
        LinkedHashSet<Key> keys = new LinkedHashSet<>();
        for (String color : COLORS) {
            keys.add(sideTextureKey(color));
            keys.add(topTextureKey(color));
            keys.add(bottomTextureKey(color));
        }
        return Set.copyOf(keys);
    }
}
