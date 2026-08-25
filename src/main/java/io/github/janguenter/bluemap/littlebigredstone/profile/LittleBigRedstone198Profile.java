/*
 * SPDX-License-Identifier: MIT
 */

package io.github.janguenter.bluemap.littlebigredstone.profile;

import java.util.List;

/** Exact All the Mons 1.2.0 profile `little-big-redstone-1.9.8-mc1.21.1`. */
public final class LittleBigRedstone198Profile {

    public static final String PROFILE_ID = "little-big-redstone-1.9.8-mc1.21.1";
    public static final List<ArtifactPin> ARTIFACTS = List.of(
            new ArtifactPin(
                    "littleBigRedstone",
                    "little_big_redstone",
                    "1.9.8-1.21.1",
                    "little-big-redstone-1.9.8-1.21.1.jar",
                    1_415_860L,
                    "ba4eac4050528c274db4b8b43c38152ef58407298f499d28b13c97a7ca8a0896"
            )
    );

    private LittleBigRedstone198Profile() {
    }
}
