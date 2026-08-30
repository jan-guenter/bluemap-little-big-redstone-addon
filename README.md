# BlueMap Little Big Redstone Add-on

A Java 21 BlueMap add-on for the exact `little-big-redstone-1.9.8-mc1.21.1` profile in All the Mons
`1.2.0` / Minecraft `1.21.1`.

Status: `0.1.0-alpha.2` integration candidate based on the owner-accepted
`0.1.0-alpha.1` renderer. The exact artifact gate replaces the unsupported
dynamic models for all sixteen colored microchips with static cubes using the
installed top, side, and bottom textures.

## Build

Clone with the exact development-tool and runtime-module submodules:

```bash
git clone --recurse-submodules \
  https://github.com/jan-guenter/bluemap-little-big-redstone-addon.git
```

For an existing clone, initialize it before running Gradle:

```bash
git submodule update --init --recursive -- \
  tooling/bluemap-addon-toolkit modules/bluemap-addon-runtime
```

The settings preflight accepts only the committed toolkit gitlink at its exact
expected commit. It applies the same checks to the source-only runtime module.
An uninitialized, changed, or dirty submodule fails before project evaluation.

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

The production JAR compiles the two pinned runtime-module Java sources into the
add-on. It does not install or nest a shared runtime JAR.
