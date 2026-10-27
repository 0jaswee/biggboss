# Hotstar Background Player (experimental)

Android WebView app that opens the official JioHotstar website. Use **Open JioHotstar / Login** to sign in on the provider's own page, then navigate to Bigg Boss.

**Try Background Audio** is experimental: it avoids explicitly pausing the WebView when the app is backgrounded. It does **not** bypass DRM, create a media session, or guarantee audio when the screen is locked. The service may disallow login or video playback in WebView entirely. No login credentials are collected by this project.

## Build APK on GitHub

1. Create a repository at https://github.com/new.
2. Upload the *contents* of this folder to the repository root, including `.github/workflows/build-apk.yml`.
3. Open Actions > Build Android APK > Run workflow.
4. Download the artifact and extract `app-debug.apk`.

The project has not been built or device-tested in this environment.
