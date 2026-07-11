# Monsoon Mitra - Build Setup Instructions

## Prerequisites for Building

Before building the APK, ensure these tools are installed:

### 1. Java Development Kit (JDK) 11 or Higher
```bash
# Download JDK 11+
https://www.oracle.com/java/technologies/downloads/#java11

# Set JAVA_HOME environment variable
Windows: 
  Control Panel → System → Environmental Variables
  Add JAVA_HOME = C:\Program Files\Java\jdk-11.x.x (or your JDK path)

Mac/Linux:
  export JAVA_HOME=$(/usr/libexec/java_home -v 11)
  Add to ~/.zshrc or ~/.bashrc
```

### 2. Android SDK
```bash
# Install Android Studio which includes Android SDK
https://developer.android.com/studio

# Required SDK components:
- SDK Platform 24 (Android 7.0)
- SDK Platform 34 (Android 14)
- Build tools 34.0.0
- Android Emulator (optional)
```

### 3. Update Environment Variables
```bash
# Windows PowerShell (Admin):
[Environment]::SetEnvironmentVariable("ANDROID_HOME", "C:\Users\YourUsername\AppData\Local\Android\Sdk", "User")
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-11", "User")

# Linux/Mac:
export ANDROID_HOME=~/Android/Sdk
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home
```

### 4. Verify Installation
```bash
# Check Java
java -version
javac -version

# Check Android SDK
$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager --list
```

---

## Building the Monsoon Mitra APK

### Step 1: Navigate to Project Directory
```bash
cd C:\Users\Amisha\StudioProjects\GIT_PROJECT\MonsoonCare
```

### Step 2: Clean Previous Builds
```bash
# Windows:
.\gradlew.bat clean

# Mac/Linux:
./gradlew clean
```

### Step 3: Configure API Keys
Before building, update `Constants.java`:
```java
// File: app/src/main/java/com/monsoon/care/utils/Constants.java
public static final String OPENWEATHER_API_KEY = "YOUR_ACTUAL_API_KEY_HERE";
```

Get free API key from: https://openweathermap.org/api

### Step 4: Build Debug APK
```bash
# Windows:
.\gradlew.bat assembleDebug

# Mac/Linux:
./gradlew assembleDebug

# Output location:
app/build/outputs/apk/debug/app-debug.apk
```

### Step 5: Build Release APK (Production)
```bash
# Windows:
.\gradlew.bat assembleRelease

# Mac/Linux:
./gradlew assembleRelease

# Output location:
app/build/outputs/apk/release/app-release-unsigned.apk
```

---

## Complete Build Process with Output

### Building Debug APK

```bash
# Command
./gradlew assembleDebug

# Output (expected):
> Task :app:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :app:checkDebugManifest
> Task :app:generateDebugBuildConfig
> Task :app:compileDebugJavaWithJavac
> Task :app:processDebugResources
> Task :app:mergeDebugResources
> Task :app:bundleDebugAssets
> Task :app:compressDebugAssets
> Task :app:generateDebugResources
> Task :app:packageDebugResources
> Task :app:parseDebugLocalBinaryResources
> Task :app:createDebugCompatibleScreenManifests
> Task :app:extractDeepLinksForDebug
> Task :app:processDebugManifestForPackage
> Task :app:splitsDiscoveryTaskDebug
> Task :app:processDebugResources
> Task :app:compileDebugSources
> Task :app:packageDebugAssets
> Task :app:createDebugApkListingFileRedirect
> Task :app:packageDebug
> Task :app:assembleDebug

BUILD SUCCESSFUL in 45s

# Generated file:
C:\Users\Amisha\StudioProjects\GIT_PROJECT\MonsoonCare\app\build\outputs\apk\debug\app-debug.apk
```

---

## APK Details

### Debug APK
- **Filename**: `app-debug.apk`
- **Size**: ~25-35 MB (with all dependencies)
- **Debuggable**: Yes
- **Minified**: No
- **Application ID**: `com.monsoon.care`
- **Version Name**: `1.0.0`
- **Version Code**: `1`

### Release APK
- **Filename**: `app-release-unsigned.apk`
- **Size**: ~10-15 MB (ProGuard optimized)
- **Debuggable**: No
- **Minified**: Yes (ProGuard)
- **Application ID**: `com.monsoon.care`
- **Version Name**: `1.0.0`
- **Version Code**: `1`

---

## Installing APK on Device/Emulator

### Install Debug APK
```bash
# Windows/Mac/Linux:
.\gradlew.bat installDebug

# Or manually:
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Install Release APK
```bash
# First sign the APK (for release only)
jarsigner -verbose -sigalg SHA256withRSA -digestalg SHA-256 \
  -keystore monsoon.keystore \
  app/build/outputs/apk/release/app-release-unsigned.apk \
  monsoon-key

# Then install
adb install app/build/outputs/apk/release/app-release-signed.apk
```

---

## Running on Emulator

### Start Android Emulator
```bash
# List available emulators
emulator -list-avds

# Start emulator
emulator -avd emulator_name

# Or use Android Studio: AVD Manager
```

### Install and Run
```bash
# Install app
adb install app/build/outputs/apk/debug/app-debug.apk

# Launch app
adb shell am start -n com.monsoon.care/.ui.activities.SplashActivity

# View logs
adb logcat com.monsoon.care:V *:S
```

---

## Advanced Build Options

### Build with Specific Build Type
```bash
# Debug variant (default)
./gradlew assembleDebug

# Release variant
./gradlew assembleRelease

# Build and install in one command
./gradlew installDebug

# Build with verbose output
./gradlew assembleDebug --info

# Build specific app module
./gradlew :app:assembleDebug
```

### Build with Custom Properties
```bash
# Override properties
./gradlew assembleDebug \
  -Dorg.gradle.jvmargs="-Xmx4g" \
  --parallel \
  --daemon

# Without daemon (if issues)
./gradlew assembleDebug --no-daemon
```

---

## Signing Release APK

### Create Keystore (One-time)
```bash
keytool -genkey -v -keystore monsoon.keystore \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias monsoon-key

# Answer prompts:
# - First/Last name: Monsoon Mitra
# - Organization: Your Organization
# - Country: Your Country Code (IN for India)
# - Password: Strong password (remember this!)
```

### Sign APK
```bash
jarsigner -verbose -sigalg SHA256withRSA -digestalg SHA-256 \
  -keystore monsoon.keystore \
  app/build/outputs/apk/release/app-release-unsigned.apk \
  monsoon-key

# Verify signature
jarsigner -verify -verbose -certs \
  app/build/outputs/apk/release/app-release-unsigned.apk

# Rename for Play Store
ren app-release-unsigned.apk app-release-signed.apk
```

### Zipalign APK (Optional, for Play Store)
```bash
# Align APK for optimal performance
zipalign -v 4 \
  app/build/outputs/apk/release/app-release-unsigned.apk \
  app-release-aligned.apk

# Then sign the aligned APK
jarsigner -verbose -sigalg SHA256withRSA -digestalg SHA-256 \
  -keystore monsoon.keystore \
  app-release-aligned.apk \
  monsoon-key
```

---

## Troubleshooting

### Build Fails: "Unable to find valid gradle wrapper/"
```
Solution: 
1. Ensure gradle/wrapper/gradle-wrapper.properties exists
2. Run: ./gradlew clean
3. Gradle will auto-download wrapper on next run
```

### Build Fails: "JAVA_HOME is not set"
```
Solution:
# Windows (Admin PowerShell):
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-11", "Machine")

# Mac/Linux:
export JAVA_HOME=$(/usr/libexec/java_home -v 11)
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 11)' >> ~/.zshrc

# Then restart terminal and build again
```

### Build Fails: "Gradle sync failed"
```
Solution:
./gradlew clean
./gradlew build --refresh-dependencies
```

### APK Too Large
```
Solution:
1. Enable ProGuard: minifyEnabled true
2. Enable Resource Shrinking: shrinkResources true
3. Use App Bundle format (.aab)
```

---

## Build Verification Checklist

- [ ] Java 11+ installed: `java -version`
- [ ] Android SDK installed: Check `$ANDROID_HOME`
- [ ] SDK Manager configured
- [ ] Constants.java updated with API key
- [ ] google-services.json placed in app/ folder
- [ ] No compilation errors: `./gradlew build`
- [ ] APK generated: Check `app/build/outputs/apk/`
- [ ] APK installable: `adb install app-debug.apk`
- [ ] App launches: Check device/emulator

---

## Build Optimization Tips

### Faster Builds
```bash
# Use daemon (keeps Gradle running)
./gradlew assembleDebug --daemon

# Parallel builds
./gradlew assembleDebug --parallel

# Only assemble, don't test
./gradlew assembleDebug --no-test

# Specific module
./gradlew :app:assemble
```

### Reduce Build Time
```gradle
// In build.gradle
android {
    // Disable tests in debug build
    testBuildType = "release"
    
    // Optimize for dev builds
    compileOptions {
        incremental true
    }
}
```

---

## What's Included in APK

- ✅ 10 Activities with full UI
- ✅ 4 Adapters for RecyclerView
- ✅ 1 ViewModel with LiveData
- ✅ Repository pattern implementation
- ✅ Room Database setup
- ✅ All required resources (layouts, strings, colors)
- ✅ Firebase configuration
- ✅ Retrofit API client setup
- ✅ Material Design components
- ✅ Accessibility features
- ✅ Security libraries (encrypted preferences)

---

## Next Steps After Build

1. **Test on device/emulator**
   ```bash
   .\gradlew.bat installDebug
   ```

2. **Verify features**
   - Test all activities
   - Check layouts
   - Verify permissions requests

3. **Integrate APIs**
   - Add OpenWeather API key
   - Setup Firebase project
   - Configure backend URLs

4. **Submit to Play Store**
   - Sign release APK
   - Upload to Google Play Console
   - Fill app details
   - Submit for review

---

## Useful Commands Summary

| Command | Purpose |
|---------|---------|
| `./gradlew build` | Full project build |
| `./gradlew assembleDebug` | Build debug APK |
| `./gradlew assembleRelease` | Build release APK |
| `./gradlew installDebug` | Build and install debug |
| `./gradlew test` | Run unit tests |
| `./gradlew clean` | Remove build files |
| `./gradlew tasks` | List all Gradle tasks |
| `./gradlew --info build` | Verbose build output |

---

## System Requirements

- **OS**: Windows 10+, macOS 10.12+, Linux (Ubuntu 16.04+)
- **RAM**: Minimum 4GB (8GB recommended)
- **Disk Space**: Minimum 5GB for SDK and build files
- **Java**: JDK 11 or higher
- **Android SDK**: API 24-34

---

**Created**: July 11, 2026
**For**: Monsoon Mitra v1.0.0

---

For detailed information, see:
- README.md - Project overview
- IMPLEMENTATION_GUIDE.md - Development guide
- PROJECT_SUMMARY.md - Feature summary

