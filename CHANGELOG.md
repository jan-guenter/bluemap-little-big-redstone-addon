# Changelog

## 0.1.0-alpha.3 - 2026-08-30

- Target only BlueMap feature-backport commit
  `7e07f4e74ec1e92a6ead9aa1e66054af3e133aac` and API commit
  `285c9a60eff3ac2b0cab308ce1058d1565be0971`.
- Move the family adapter from `bluemap522` to `bluemap523`.
- Compile Adapter API `0.1.0-alpha.2` from its exact source gitlink and remove
  the local runtime-identity, registry, and extension-factory copies.
- Preserve the microchip catalog, installed-texture model construction,
  exact-artifact admission, gallery, and stock fallback.
- Pin candidate, CI, and release artifact generation to Gradle `9.6.1` so the
  recorded module metadata remains reproducible.

## 0.1.0-alpha.2 - 2026-08-30

- Pinned BlueMap Add-on Runtime `v0.1.0-alpha.1` as a source-only submodule.
- Replaced the local artifact-pin and exact-artifact detector copies with the
  runtime module's package-normalized byte-equivalent implementations.

## 0.1.0-alpha.1 - 2026-08-25

- Generated a fail-closed Java 21 BlueMap add-on seed for `little-big-redstone-1.9.8-mc1.21.1`.
- Added installed-texture static models for all sixteen microchip colors.
- Added a bounded sixteen-color comparison gallery and stone control.
- Passed disposable full-pack visual staging and owner acceptance.
