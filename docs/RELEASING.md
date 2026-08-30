# Releasing

Prototype work is intentionally light. Before owner acceptance, run only the
focused Java checks, exact candidate verifier, gallery checks, and disposable
staging comparison needed to get useful visual feedback.

After the owner accepts the candidate:

1. Initialize the pinned toolkit, runtime module, and Adapter API with
   `git submodule update --init --recursive -- tooling/bluemap-addon-toolkit modules/bluemap-addon-runtime modules/bluemap-addon-adapter-api`.
2. Confirm the bounded gallery still matches the owner-accepted scope and
   record the exact artifact used for that review.
3. If the reviewed artifact used instrumentation or an overlay, run a separate
   sealed runtime gate with the exact production JAR. Do not promote the
   release until it passes.
4. Freeze the production JAR's non-manifest entry hashes in
   `provenance/accepted-staging-entries.sha256` with the one-time
   `bluemap-addon-toolkit jar-entries write` command.
5. Change `addon_version` from the SNAPSHOT to its final version through a PR.
6. Build production JAR, sources JAR, POM, and Gradle module metadata with the
   exact promotion Java, Gradle `9.6.1`, and BlueMap inputs.
7. Put their exact sizes and SHA-256 values in `gradle.properties` and complete
   `provenance/release.json`.
8. Run `verifyReleaseCandidate -PreleaseTag=v<version>` with all exact candidate
   JAR Gradle properties.
9. Merge the reviewed commit, create an annotated `v<version>` tag at that
   commit, and let `.github/workflows/release.yml` publish.
10. Compare every downloaded release asset to the locally accepted bytes.
11. Update the private root portfolio, queue, and `workspace.json` in a separate
   orchestration commit.

The tag must exactly equal `v<addon_version>`. No release authorizes production
deployment.

The command sequence and required release-provenance fields are recorded in
[`EXECUTION.md`](EXECUTION.md).
