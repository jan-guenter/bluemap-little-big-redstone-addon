# BlueMap Little Big Redstone Add-on

A Java 21 add-on for the exact BlueMap 5.23 feature backport and the
`little-big-redstone-1.9.8-mc1.21.1` profile in All the Mons `1.2.0`.

Status: `0.1.0-alpha.3` migrates the renderer to BlueMap commit
`7e07f4e74ec1e92a6ead9aa1e66054af3e133aac`. The owner accepted the full-pack
BlueMap and Minecraft review on 2026-08-30, but that review used a 60,465-byte
instrumented native-5.23 overlay with SHA-256
`167565da6f6e3bd23b084a96f4a62ce99f071348d4a47f7e85dabe11b7a95441`.
It did not run the production JAR. A separate sealed runtime gate for the exact
production JAR must pass before merge, tagging, or publication.

The exact artifact gate replaces the unsupported dynamic models for all
sixteen colored microchips with static cubes using the installed top, side,
and bottom textures.

The alpha.3 candidate JAR is 60,091 bytes with SHA-256
`0e5e4133980917d504fd5bac3c1776219ddc7d34353bb65810f2480170e57522`.
Two clean Gradle 9.6.1 builds produced the same production JAR, sources JAR,
POM, and Gradle module metadata bytes. Reproducible build output does not
replace the pending runtime proof for that exact production JAR.

## Build

Clone with the exact development-tool and runtime-module submodules:

```bash
git clone --recurse-submodules \
  https://github.com/jan-guenter/bluemap-little-big-redstone-addon.git
```

For an existing clone, initialize it before running Gradle:

```bash
git submodule update --init --recursive -- \
  tooling/bluemap-addon-toolkit modules/bluemap-addon-runtime \
  modules/bluemap-addon-adapter-api
```

The settings preflight accepts only the exact toolkit, runtime, and Adapter API
gitlinks and source trees. An uninitialized, changed, or dirty submodule fails
before project evaluation. It also rejects every Gradle version other than
`9.6.1`, because Gradle module metadata is tool-version-sensitive.

```bash
gradle --no-daemon -PbluemapSourcePath=../bluemap-backport clean check build
```

`check` is the quick Java/checkstyle/archive gate. `prototypeCheck` additionally
requires every exact candidate JAR property and validates the comparison
gallery. See `provenance/upstreams.json` for immutable artifact identities and
the [execution guide](docs/EXECUTION.md) for the prototype-to-release loop.

## Install

Place the production JAR in BlueMap's add-on pack directory and restart the
BlueMap JVM. Removal plus one restart restores stock behavior; the add-on
creates no custom world state.

Set `-Dbluemap.little_big_redstone.disabled=true` to leave the exact profile inactive.

## Scope boundary

The first implementation covers the neutral microchip shell only. Live logic,
port and signal overlays, contents, particles, and animation stay
deterministic-neutral.

No Little Big Redstone binary, source, class, asset, captured mesh, or gallery is
bundled in the add-on.

The production JAR compiles the two pinned runtime-module sources and the four
pinned Adapter API sources into the add-on. It installs or nests neither module
JAR. No production `bluemap522` package remains.
