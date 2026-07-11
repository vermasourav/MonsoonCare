# Monsoon Mitra - Complete Setup Guide for Your Machine

## Step 1: Install Java Development Kit (JDK) 11

### Download JDK 11
1. Go to: https://www.oracle.com/java/technologies/downloads/
2. Select **Java SE 11** (LTS version)
3. Download **Windows x64 Installer** (jdk-11.x.x_windows-x64_bin.exe)
4. File size: ~165 MB

### Install Java
1. Run the installer: `jdk-11.x.x_windows-x64_bin.exe`
2. Click "Next" and accept license
3. Keep default installation path: `C:\Program Files\Java\jdk-11.0.x`
4. Wait for installation to complete
5. Click "Finish"

### Verify Java Installation
```bash
# Open PowerShell and run:
java -version

# Expected output:
java version "11.x.x"
Java(TM) SE Runtime Environment
```

---

## Step 2: Set JAVA_HOME Environment Variable

### Windows PowerShell (Admin)
```powershell
# Run PowerShell as Administrator

# Check Java installation path
Get-ChildItem "C:\Program Files\Java\"

# Set JAVA_HOME permanently for current user
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-11.0.x", "User")

# Set JAVA_HOME for all users (needs Admin)
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-11.0.x", "Machine")

# Verify
$env:JAVA_HOME
# Should output: C:\Program Files\Java\jdk-11.0.x
```

### Using GUI (Control Panel)
1. Open "Edit the system environment variables"
2. Click "Environment Variables" button
3. Under "User variables", click "New"
4. Variable name: `JAVA_HOME`
5. Variable value: `C:\Program Files\Java\jdk-11.0.x`
6. Click "OK" and close all windows
7. Restart PowerShell/Terminal

### Verify in New Terminal
```powershell
# Close and reopen PowerShell

# Check JAVA_HOME
$env:JAVA_HOME

# Should display your Java path

# Run:
java -version

# Should show Java 11
```

---

## Step 3: Install Android Studio & SDK

### Download Android Studio
1. Go to: https://developer.android.com/studio
2. Click "Download Android Studio" for Windows
3. File size: ~1.2 GB
4. Accept license and download

### Install Android Studio
1. Run: `android-studio-2023.x.x-windows.exe`
2. Click "Next" on setup wizard
3. Choose installation path (default is fine)
4. Select components:
   - ✅ Android Studio
   - ✅ Android Virtual Device
5. Click "Install"
6. Wait ~5-10 minutes
7. Click "Finish" and "Start Android Studio"

### Android SDK Setup (First Launch)
1. Select "Don't import settings" (unless upgrading)
2. Click "Next" through welcome screens
3. Accept Android SDK license
4. Android Studio downloads SDK components
5. Wait 10-15 minutes for setup to complete

### Verify Android SDK Installation
```powershell
# Check Android SDK location
# Typically: C:\Users\YourUsername\AppData\Local\Android\Sdk

# Set ANDROID_HOME variable (Admin PowerShell):
[Environment]::SetEnvironmentVariable("ANDROID_HOME", "C:\Users\YourUsername\AppData\Local\Android\Sdk", "User")

# Verify
$env:ANDROID_HOME
```

---

## Step 4: Install Required Android SDK Packages

### Method 1: Using Android Studio GUI
1. Open Android Studio
2. Go to: **Tools → SDK Manager**
3. Ensure the following are installed:
   - Android SDK Platform 24 (Android 7.0)
   - Android SDK Platform 34 (Android 14)
   - Android SDK Build Tools 34.0.0
   - Android Emulator (optional)
   - Android SDK Platform-Tools

4. Click "Apply" and accept licenses
5. Wait for downloads/installation

### Method 2: Using Command Line
```powershell
# Set SDK path if not already set
$env:ANDROID_HOME = "C:\Users\YourUsername\AppData\Local\Android\Sdk"

# List available packages
& "$env:ANDROID_HOME\cmdline-tools\latest\bin\sdkmanager.bat" --list

# Install specific packages (after accepting license)
echo y | & "$env:ANDROID_HOME\cmdline-tools\latest\bin\sdkmanager.bat" "platforms;android-24"
echo y | & "$env:ANDROID_HOME\cmdline-tools\latest\bin\sdkmanager.bat" "platforms;android-34"
echo y | & "$env:ANDROID_HOME\cmdline-tools\latest\bin\sdkmanager.bat" "build-tools;34.0.0"
```

---

## Step 5: Set Up PATH Environment Variable (Optional but Recommended)

### Add Android Tools to PATH
```powershell
# Admin PowerShell:

# Get current PATH
$currentPath = [Environment]::GetEnvironmentVariable("Path", "User")

# Add Android SDK tools
$androidPath = "C:\Users\YourUsername\AppData\Local\Android\Sdk\platform-tools;C:\Users\YourUsername\AppData\Local\Android\Sdk\emulator"
$newPath = "$currentPath;$androidPath"

# Set updated PATH
[Environment]::SetEnvironmentVariable("Path", $newPath, "User")
```

### Verify ADB Installation
```powershell
# Close and reopen PowerShell
adb --version

# Should output ADB version
```

---

## Step 6: Open Monsoon Mitra Project in Android Studio

### Import Project
1. Open Android Studio
2. **File → Open**
3. Navigate to: `C:\Users\Amisha\StudioProjects\GIT_PROJECT\MonsoonCare`
4. Click "OK"
5. Click "Trust Project" when prompted

### Wait for Gradle Sync
- Gradle will automatically download dependencies
- First sync takes 5-10 minutes
- Check "Sync" tab at bottom for progress

### Verify Project Setup
1. Look for "Build → Make Project" at top
2. If no red errors, project is properly configured
3. Check Event Log for any warnings

---

## Step 7: Configure API Keys

### Add OpenWeather API Key
1. Go to: https://openweathermap.org/api
2. Sign up (free tier available)
3. Copy your API key
4. In Android Studio, open:
   ```
   app/src/main/java/com/monsoon/care/utils/Constants.java
   ```
5. Find line:
   ```java
   public static final String OPENWEATHER_API_KEY = "YOUR_API_KEY_HERE";
   ```
6. Replace with your actual key:
   ```java
   public static final String OPENWEATHER_API_KEY = "abc123def456...";
   ```

### Firebase Configuration (Optional for First Build)
1. For now, blank `google-services.json` is fine
2. You can integrate Firebase later

---

## Step 8: Build Debug APK

### Method 1: Using Android Studio GUI
1. Click **Build → Make Project** (or Ctrl+F9)
2. Wait for build to complete (first build takes 5-10 minutes)
3. Check "Build" tab at bottom for success
4. APK location shown in logs

### Method 2: Using Terminal
```powershell
# Navigate to project
cd C:\Users\Amisha\StudioProjects\GIT_PROJECT\MonsoonCare

# Build debug APK
.\gradlew.bat assembleDebug

# Or build and install
.\gradlew.bat installDebug
```

### Expected Output
```
> Task :app:assembleDebug
...
BUILD SUCCESSFUL in 45s

APK generated at:
app/build/outputs/apk/debug/app-debug.apk
```

---

## Step 9: Launch App on Emulator

### Start Android Emulator
1. In Android Studio: **Tools → Device Manager**
2. Click "Create Device" or select existing
3. Select a device (e.g., Pixel 5)
4. Select system image (API 34)
5. Click "Play" button to start emulator
6. Wait 30-60 seconds for emulator to boot

### Install and Run App
```powershell
# From project directory
.\gradlew.bat installDebug

# Or in Android Studio:
# - Click "Run" button (green play button)
# - Select emulator from device list
# - App will install and launch
```

### View Logs
```powershell
# Open Android Studio Logcat (View → Tool Windows → Logcat)
# Or command line:
adb logcat com.monsoon.care:V *:S
```

---

## Step 10: Build Release APK (Production)

### Create Signing Key (One-time)
```powershell
cd C:\Users\Amisha\StudioProjects\GIT_PROJECT\MonsoonCare\app

# Generate keystore
keytool -genkey -v -keystore monsoon.keystore `
  -keyalg RSA -keysize 2048 -validity 10000 `
  -alias monsoon-key

# Answer prompts:
# First and last name: Monsoon Mitra
# Organization unit: Engineering
# Organization: Monsoon Mitra
# City or Locality: Your City
# State or Province: Your State
# Country Code: IN (for India)
# Password: Remember this!
```

### Build Release APK
```powershell
cd C:\Users\Amisha\StudioProjects\GIT_PROJECT\MonsoonCare

# Build release
.\gradlew.bat assembleRelease

# Sign it
cd app
jarsigner -verbose -sigalg SHA256withRSA -digestalg SHA-256 `
  -keystore monsoon.keystore `
  build/outputs/apk/release/app-release-unsigned.apk `
  monsoon-key

# Rename for clarity
ren build/outputs/apk/release/app-release-unsigned.apk app-release-signed.apk
```

---

## Complete Setup Checklist

- [ ] JDK 11 installed and `java -version` works
- [ ] `JAVA_HOME` environment variable set
- [ ] Android Studio installed
- [ ] Android SDK installed with platforms 24 & 34
- [ ] Build Tools 34.0.0 installed
- [ ] `ANDROID_HOME` environment variable set
- [ ] Project imports into Android Studio without errors
- [ ] Gradle sync completes successfully
- [ ] OpenWeather API key added to Constants.java
- [ ] Debug APK builds without errors
- [ ] APK installs on emulator
- [ ] App launches and shows splash screen

---

## Troubleshooting

### Gradle Build Fails
```
Problem: "./gradlew.bat is not recognized"
Solution: Use full path: C:\Users\Amisha\...\gradlew.bat assembleDebug

Problem: "JAVA_HOME not set"
Solution: Run steps in "Set JAVA_HOME Environment Variable" above

Problem: "SDK not found"
Solution: Set ANDROID_HOME and reinstall SDK packages
```

### Emulator Won't Start
```
Problem: Emulator takes too long or won't start
Solution: 
1. Check disk space (need 5GB+)
2. Enable virtualization in BIOS (for Windows)
3. Restart Android Studio
4. Try different emulator device
```

### App Crashes on Launch
```
Problem: App force closes or crashes
Solution:
1. Check Logcat for errors (Android Studio)
2. Verify AndroidManifest.xml is complete
3. Check all activities are declared
4. Ensure minimum permissions are granted
```

---

## Quick Reference Commands

```powershell
# Check Java
java -version
javac -version

# Check SDK
$env:ANDROID_HOME
adb --version

# Build
.\gradlew.bat clean
.\gradlew.bat build
.\gradlew.bat assembleDebug
.\gradlew.bat installDebug

# Install on connected device
adb install app/build/outputs/apk/debug/app-debug.apk

# View logs
adb logcat

# List devices/emulators
adb devices

# Start shell on emulator
adb shell
```

---

## Files Created in Project

```
MonsoonCare/
├── app/
│   ├── src/main/
│   │   ├── java/com/monsoon/care/     (All Java code)
│   │   ├── res/                        (All resources)
│   │   └── AndroidManifest.xml         (App configuration)
│   ├── build.gradle                    (Dependencies & build config)
│   └── google-services.json            (Firebase config)
├── build.gradle                        (Project config)
├── settings.gradle                     (Module settings)
├── gradle.properties                   (Version info)
├── gradlew & gradlew.bat              (Gradle wrapper)
└── Documentation files                 (README, guides, etc.)
```

---

## Next Steps

1. ✅ Complete the setup steps above
2. ✅ Build and test debug APK on emulator
3. ✅ Verify all 10 activities load properly
4. ✅ Test permissions and location features
5. ✅ Build release APK when ready for distribution

---

## Support & Resources

- **Android Documentation**: https://developer.android.com/docs
- **Gradle Build Guide**: https://gradle.org/
- **Monsoon Mitra Docs**: See README.md, IMPLEMENTATION_GUIDE.md
- **Java Documentation**: https://docs.oracle.com/javase/11/

---

**Date**: July 11, 2026
**Project**: Monsoon Mitra v1.0.0
**Target OS**: Windows 10+
**Java Version**: 11 (minimum)
**Android SDK**: API 24-34

Good luck building Monsoon Mitra! 🚀

