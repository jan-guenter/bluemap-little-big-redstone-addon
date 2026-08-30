/*
 * SPDX-License-Identifier: MIT
 */

package io.github.janguenter.bluemap.littlebigredstone.adapter.bluemap523;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MicrochipCatalogTest {

    @Test
    void ownsAllSixteenDyeColorsAndTheirInstalledTextures() {
        assertEquals(16, MicrochipCatalog.COLORS.size());
        assertEquals(16, MicrochipCatalog.COLORS.stream().distinct().count());
        assertEquals(48, MicrochipCatalog.textureKeys().size());
        assertTrue(MicrochipCatalog.COLORS.contains("light_blue"));
        assertEquals(
                "little_big_redstone:red_microchip",
                MicrochipCatalog.blockKey("red").getFormatted()
        );
    }
}
