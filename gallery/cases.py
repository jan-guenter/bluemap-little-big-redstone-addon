#!/usr/bin/env python3
# SPDX-License-Identifier: MIT
"""Bounded comparison gallery for all sixteen microchip colors."""

from __future__ import annotations

from dataclasses import dataclass


NAMESPACE = "little_big_redstone_gallery"
ENVELOPE = (173, 99, 173, 192, 103, 189)


@dataclass(frozen=True)
class Placement:
    case_id: str
    label: str
    x: int
    y: int
    z: int
    block_state: str
    expected: str


COLORS = (
    "white",
    "orange",
    "magenta",
    "light_blue",
    "yellow",
    "lime",
    "pink",
    "gray",
    "light_gray",
    "cyan",
    "purple",
    "blue",
    "brown",
    "green",
    "red",
    "black",
)


PLACEMENTS = tuple(
    Placement(
        f"microchip-{color}",
        f"{color} microchip neutral shell",
        176 + (index % 4) * 3,
        100,
        176 + (index // 4) * 3,
        f"little_big_redstone:{color}_microchip",
        "installed-texture-cube-visible",
    )
    for index, color in enumerate(COLORS)
) + (
    Placement(
        "stock-control",
        "stone stock rendering control",
        190,
        100,
        185,
        "minecraft:stone",
        "stock-visible",
    ),
)
