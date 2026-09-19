# Android Launcher

A custom Android home-screen launcher built with Kotlin and Android Studio, based on the **Android Launcher Development Plan**.

## Project goals

- Scan and display installed applications
- Support drag-and-drop app rearrangement
- Create custom folders for app organization
- Persist app positions and user preferences
- Support home-screen customization such as themes and grid size
- Handle real-time app installation/uninstallation

## Technology stack

| Component | Technology |
|---|---|
| Language | Kotlin |
| IDE | Android Studio |
| Database | Room (SQLite) |
| Minimum SDK | API 28 (Android 9) |
| Target SDK | API 35+ (Android 15) |
| Architecture | MVVM with LiveData |
| UI | RecyclerView; Jetpack Compose optional |

## Project structure

```
AndroidLauncher/
├── app/
│   └── src/main/
│       ├── java/com/example/launcher/
│       │   ├── activities/
│       │   ├── adapters/
│       │   ├── database/
│       │   ├── models/
│       │   ├── services/
│       │   ├── viewmodels/
│       │   └── utils/
│       └── res/
├── docs/
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## Core dependencies

The development plan specifies Room 2.6.0, AndroidX AppCompat 1.6.1, Lifecycle 2.6.2, Kotlin Coroutines 1.7.3, RecyclerView 1.3.2, Material 1.10.0, JUnit 4.13.2 and AndroidX Test 1.1.5.

## Development phases

1. **Setup — Days 1-3:** Android Studio project, Room database, schema, folder structure and dependencies.
2. **App Discovery — Days 4-6:** PackageManager queries, AppInfo, AppListService and app grid.
3. **Database & Persistence — Days 7-9:** DAO, positions, preferences and migrations.
4. **Drag & Drop — Days 10-14:** ItemTouchHelper, long press, animations and position updates.
5. **Settings & Customization — Days 15-18:** SettingsActivity, themes, grid size, folders and optional widgets.
6. **Testing & Optimization — Days 19-23:** device testing, profiling, bug fixing, icon caching and UI polish.

## Expected timeline

- MVP: 3-4 weeks
- Polished version: 8-10 weeks

## Required Android APIs

LauncherApps, PackageManager, LauncherActivityInfo, BroadcastReceiver, ItemTouchHelper, WindowManager, SharedPreferences/Room, ActivityManager and Intent Filters.

## Important implementation notes

- Add the HOME category intent filter so the app can be selected as a launcher.
- Handle app installation/uninstallation using PACKAGE_ADDED and PACKAGE_REMOVED broadcasts.
- Use Room transactions for atomic layout updates.
- Use RecyclerView/ViewHolder and asynchronous icon loading for performance with many apps.
- Handle permission denial and missing/unavailable applications gracefully.
- Commit after each major feature.

## Build

Open the repository in Android Studio, allow Gradle to sync, then run the app on an Android 9+ device or emulator.

## Documentation

See [docs/development-plan.md](docs/development-plan.md) for the complete project instructions derived from the development plan.
