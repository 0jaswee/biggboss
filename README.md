# Hotstar Background Player (experimental)

An Android WebView launcher for https://www.jiohotstar.com/. Log in only through the official website. This is not affiliated with JioHotstar.

**Important:** This app DOES NOT guarantee screen-off/background playback. WebView, DRM and site restrictions may stop audio. It does not bypass DRM or download streams. The app keeps the screen awake while it is in the foreground.

## Build using GitHub (no Android Studio required)
1. Create a GitHub repository.
2. Upload **all project files and folders**, including `.github/workflows/build-apk.yml` (GitHub's web upload may hide dot-folders on some devices; check it is present).
3. Go to Actions > Build Android APK > Run workflow, or push to main.
4. Once the run succeeds, open the run and download `HotstarBackgroundPlayer-debug-apk` under Artifacts.
5. Extract the artifact ZIP and install `app-debug.apk` on Android. Only install builds you trust.

## Limitations
- Some sites reject embedded WebViews.
- Fullscreen, DRM and background playback are site/device dependent.
- No password collection or custom login form; credentials are handled by the website.
