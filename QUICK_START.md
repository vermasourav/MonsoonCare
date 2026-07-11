# Monsoon Mitra - Quick Start Guide

Get the Monsoon Mitra Android app up and running in minutes!

## 🚀 5-Minute Setup

### 1. Clone & Open Project (1 min)
```bash
git clone https://github.com/your-org/MonsoonCare.git
cd MonsoonCare
# Open in Android Studio: File → Open
```

### 2. Install Dependencies (2 min)
Android Studio will automatically download required SDKs and Gradle dependencies during the first build.

```bash
# Or manually
./gradlew build
```

### 3. Configure APIs (1 min)

**OpenWeather API:**
```java
// File: app/src/main/java/com/monsoon/care/utils/Constants.java
public static final String OPENWEATHER_API_KEY = "YOUR_KEY_HERE";
```
[Get free API key](https://openweathermap.org/api)

**Firebase (Optional for now):**
- Create project at https://firebase.google.com/
- Download `google-services.json`
- Place in `MonsoonCare/app/` folder

### 4. Run the App (1 min)
```bash
# On emulator or physical device
./gradlew installDebug
# Then click Run in Android Studio
```

---

## 📁 Project Structure at a Glance

```
MonsoonCare/
├── app/
│   ├── src/main/
│   │   ├── java/com/monsoon/care/
│   │   │   ├── ui/           ← Screens & layouts
│   │   │   ├── data/         ← Database & API
│   │   │   ├── services/     ← Background services
│   │   │   └── utils/        ← Helper functions
│   │   └── res/              ← Images, colors, strings
│   └── build.gradle          ← Dependencies
├── README.md                 ← Full documentation
├── IMPLEMENTATION_GUIDE.md   ← Detailed setup guide
└── PROJECT_SUMMARY.md        ← What's been created
```

---

## 💡 Key Files to Know

| File | Purpose |
|------|---------|
| `MainActivity.java` | Main app dashboard |
| `Constants.java` | API keys & configuration |
| `WeatherRepository.java` | API communication |
| `WeatherApiService.java` | API endpoints |
| `MonsoonCareDatabase.java` | Local database setup |
| `activity_main.xml` | Main UI layout |

---

## 🎮 Exploring the App

### Main Features
1. **Splash Screen** → Shows app loading
2. **Onboarding** → Language & location selection
3. **Dashboard** → Weather & alerts overview
4. **Weather Detail** → 7-day forecast view
5. **Checklist** → Emergency preparedness items
6. **Travel Advisory** → Safe routes & timing
7. **Community** → User-reported incidents
8. **AI Assistant** → Chat with safety recommendations
9. **Settings** → Preferences & accessibility

### How to Navigate
- Each activity is in `ui/activities/` folder
- Each activity has corresponding `activity_*.xml` layout
- Adapters in `ui/adapters/` handle list displays
- ViewModels in `viewmodels/` manage data

---

## 🧪 Running Tests

```bash
# Unit tests
./gradlew test

# UI tests (needs emulator/device connected)
./gradlew connectedAndroidTest

# Specific test class
./gradlew test --tests WeatherRepositoryTest
```

---

## 🔨 Building APK

### Debug Build (Fast - for testing)
```bash
./gradlew assemble
```
APK located in: `app/build/outputs/apk/debug/`

### Release Build (Slow - for production)
```bash
./gradlew assembleRelease
```
APK located in: `app/build/outputs/apk/release/`

---

## 🐛 Common Issues & Fixes

### Issue: Gradle sync fails
**Solution:**
```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

### Issue: App crashes on startup
**Solution:**
```
1. Check AndroidManifest.xml for all activities declared
2. Ensure all activities have corresponding Java files
3. Clear app data: Settings → Apps → Monsoon Mitra → Storage → Clear Data
```

### Issue: Weather API not working
**Solution:**
```
1. Verify API key in Constants.java
2. Check internet permission in manifest
3. Test API with: https://openweathermap.org/api
```

---

## 📚 Learning Path

### Beginner (Learn the basics)
1. Read `README.md` for overview
2. Open `MainActivity.java` to see main UI
3. Check `activity_main.xml` to understand layout
4. Run the app and explore all screens

### Intermediate (Understand architecture)
1. Review `MVVM` pattern in `DashboardViewModel.java`
2. Study `WeatherRepository.java` (`Repository Pattern`)
3. Examine `AlertAdapter.java` (RecyclerView adapter)
4. Explore `MonsoonCareDatabase.java` (Room database)

### Advanced (Modify & extend)
1. Read `IMPLEMENTATION_GUIDE.md` for detailed patterns
2. Follow `CONTRIBUTING.md` for code standards
3. Add new features using existing patterns
4. Write unit tests for your changes

---

## 🎯 First Development Task

**Add a simple feature (10-15 minutes):**

1. **Go to** `WeatherDetailActivity.java`
2. **Find** the `loadWeatherDetails()` method
3. **Change** this line:
   ```java
   currentTemp.setText("28°C");
   ```
   To:
   ```java
   currentTemp.setText("32°C - Sunny");
   ```
4. **Rebuild** and run the app: `Shift+F10`
5. **Verify** the change appears in Weather Detail screen

---

## 🔗 Important Links

- **Android Docs**: https://developer.android.com/
- **Material Design**: https://material.io/design/
- **Retrofit Guide**: https://square.github.io/retrofit/
- **Room Database**: https://developer.android.com/training/data-storage/room
- **LiveData**: https://developer.android.com/topic/libraries/architecture/livedata

---

## 💬 Getting Help

### If Something Breaks
1. Check `Logcat` (Android Studio bottom panel)
2. Search error message in Android documentation
3. Review relevant file in `IMPLEMENTATION_GUIDE.md`
4. Check similar implementations in codebase

### Useful Gradle Commands
```bash
./gradlew --help           # See all commands
./gradlew tasks            # List all available tasks
./gradlew build -i         # Build with info flag
./gradlew clean            # Clean build files
```

---

## ✅ Checklist to Get Started

- [ ] Cloned the repository
- [ ] Opened in Android Studio
- [ ] Gradle sync completed
- [ ] Set OpenWeather API key
- [ ] Ran on emulator/device
- [ ] Explored all screens
- [ ] Read README.md
- [ ] Reviewed PROJECT_SUMMARY.md
- [ ] Made first code change
- [ ] Rebuilt and tested

---

## 🎉 You're Ready!

Congratulations! The complete Monsoon Mitra Android app is now set up. You can:

✅ Explore the codebase
✅ Run the application
✅ Make modifications
✅ Add new features
✅ Build production APK
✅ Deploy to devices

---

## 📞 Quick Reference

**Key Packages:**
- `ui/activities/` - Screen implementations
- `ui/adapters/` - List view adapters
- `data/` - Database, models, API
- `network/` - API services
- `services/` - Background tasks
- `utils/` - Helper functions

**Main Classes:**
- `MainActivity.java` - Dashboard
- `WeatherRepository.java` - API calls
- `MonsoonCareDatabase.java` - Database setup
- `Constants.java` - Configuration

**Configuration Files:**
- `build.gradle` - Dependencies
- `AndroidManifest.xml` - App permissions
- `Constants.java` - API keys

---

**Happy Coding!** 🚀

For detailed information, see `IMPLEMENTATION_GUIDE.md`

Last Updated: July 11, 2026

