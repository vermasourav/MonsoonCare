# Monsoon Mitra - Implementation Guide

## Overview

This guide provides detailed instructions on setting up, configuring, and extending the Monsoon Mitra Android application.

## 1. Initial Setup

### 1.1 Android Studio Setup
1. Download and install Android Studio (Latest version recommended)
2. Install required SDKs:
   - Android SDK 24 (Android 7.0)
   - Android SDK 34 (Android 14)
   - Build tools version 34.0.0

### 1.2 Project Import
```bash
# Clone the repository
git clone https://github.com/your-org/MonsoonCare.git

# Navigate to project
cd MonsoonCare

# Open in Android Studio
- File → Open → Select MonsoonCare folder
```

### 1.3 Build Configuration
```gradle
# settings.gradle includes ':app' module
# build.gradle defines project-wide settings
# gradle.properties stores version info

# Build the project
./gradlew build
```

## 2. API Integration

### 2.1 Weather API Configuration

#### OpenWeatherMap API
```java
// In Constants.java
public static final String OPENWEATHER_API_KEY = "YOUR_API_KEY_HERE";

// API Base URL
https://api.openweathermap.org/data/2.5/

// Example endpoints:
GET /weather?lat={lat}&lon={lon}&appid={apikey}&units=metric
GET /forecast?lat={lat}&lon={lon}&appid={apikey}&id=5&units=metric
```

#### Implementation
```java
// WeatherApiService.java defines endpoints
// RetrofitClient.java configures HTTP client
// WeatherRepository.java handles data flow

// Usage example
WeatherRepository repository = new WeatherRepository();
repository.getCurrentWeather(latitude, longitude, language, new WeatherRepository.WeatherCallback() {
    @Override
    public void onSuccess(Weather weather) {
        // Handle success
    }
    
    @Override
    public void onError(String error) {
        // Handle error
    }
});
```

### 2.2 Firebase Configuration

#### Setup
1. Create Firebase project at https://firebase.google.com/
2. Download `google-services.json`
3. Place in `app/` directory
4. Enable required services:
   - Authentication
   - Cloud Messaging
   - Analytics
   - Crashlytics
   - Realtime Database (optional)

#### Firebase Services Used
```
// Authentication
FirebaseAuth.getInstance()

// Cloud Messaging
FirebaseMessaging.getInstance()

// Analytics
FirebaseAnalytics.getInstance()

// Crashlytics
FirebaseCrashlytics.getInstance()
```

### 2.3 Geolocation API

#### Google Play Services Location
```java
// Requires permission:
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />

// Implementation in services/LocationUpdateService.java
FusedLocationProviderClient fusedLocationClient;
fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);

fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
    if (location != null) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
    }
});
```

## 3. Database Setup

### 3.1 Room Database Initialization
```java
// In MonsoonCareApplication.onCreate()
MonsoonCareDatabase db = MonsoonCareDatabase.getInstance(this);
```

### 3.2 Adding New Entities

Create entity classes in `data/db/entities/`:
```java
@Entity(tableName = "my_table")
public class MyEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    
    public String data;
}
```

Create DAOs in `data/db/dao/`:
```java
@Dao
public interface MyDao {
    @Insert
    void insert(MyEntity entity);
    
    @Query("SELECT * FROM my_table")
    LiveData<List<MyEntity>> getAll();
}
```

Update database class:
```java
@Database(entities = {MyEntity.class}, version = DB_VERSION)
public abstract class MonsoonCareDatabase {
    public abstract MyDao myDao();
}
```

## 4. Feature Implementation

### 4.1 Adding a New Activity

1. **Create XML Layout** (`res/layout/activity_new_feature.xml`)
2. **Create Activity Class** (`ui/activities/NewFeatureActivity.java`)
3. **Create ViewModel** (if needed) (`viewmodels/NewFeatureViewModel.java`)
4. **Update AndroidManifest.xml**
5. **Add to MainActivity navigation**

### 4.2 Creating RecyclerView Adapters

```java
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MyData> dataList;
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_my_data, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyData item = dataList.get(position);
        holder.bind(item);
    }
    
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    
    public void setData(List<MyData> data) {
        this.dataList = data;
        notifyDataSetChanged();
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        // Views and binding logic
    }
}
```

### 4.3 Implementing ViewModel Logic

```java
public class MyViewModel extends AndroidViewModel {
    private MutableLiveData<MyData> dataLiveData;
    private MyRepository repository;
    
    public MyViewModel(Application application) {
        super(application);
        repository = new MyRepository();
        dataLiveData = new MutableLiveData<>();
    }
    
    public LiveData<MyData> getData() {
        return dataLiveData;
    }
    
    public void fetchData(String param) {
        repository.getData(param, new Callback() {
            @Override
            public void onSuccess(MyData data) {
                dataLiveData.setValue(data);
            }
            
            @Override
            public void onError(Exception e) {
                // Handle error
            }
        });
    }
}
```

## 5. Permissions Handling

### 5.1 Manifest Permissions
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

### 5.2 Runtime Permissions
```java
// Check permission
if (ContextCompat.checkSelfPermission(this, 
    Manifest.permission.ACCESS_FINE_LOCATION) 
    != PackageManager.PERMISSION_GRANTED) {
    
    // Request permission
    ActivityCompat.requestPermissions(this,
        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
        PERMISSION_CODE);
}

// Handle result
@Override
public void onRequestPermissionsResult(int requestCode, 
    String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    
    if (requestCode == PERMISSION_CODE) {
        if (grantResults.length > 0 
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission granted
        } else {
            // Permission denied
        }
    }
}
```

## 6. Notification Management

### 6.1 Push Notifications
```java
// In MonsoonFirebaseService.java
@Override
public void onMessageReceived(RemoteMessage remoteMessage) {
    if (remoteMessage.getNotification() != null) {
        sendNotification(
            remoteMessage.getNotification().getTitle(),
            remoteMessage.getNotification().getBody()
        );
    }
}

private void sendNotification(String title, String messageBody) {
    Intent intent = new Intent(this, MainActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
        PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
    
    NotificationCompat.Builder builder = 
        new NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(title)
        .setContentText(messageBody)
        .setContentIntent(pendingIntent);
    
    NotificationManager manager = getSystemService(NotificationManager.class);
    manager.notify(0, builder.build());
}
```

### 6.2 Notification Channels (Android O+)
```java
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    NotificationChannel channel = new NotificationChannel(
        "monsoon_alerts",
        "Monsoon Alerts",
        NotificationManager.IMPORTANCE_HIGH
    );
    NotificationManager manager = getSystemService(NotificationManager.class);
    manager.createNotificationChannel(channel);
}
```

## 7. Testing

### 7.1 Unit Testing
```java
// In app/src/test/java/com/monsoon/care/
@RunWith(AndroidJUnit4.class)
public class WeatherRepositoryTest {
    
    @Test
    public void testGetWeatherSuccess() {
        // Test implementation
    }
    
    @Test
    public void testGetWeatherError() {
        // Test error handling
    }
}
```

### 7.2 Instrumented Testing
```java
// In app/src/androidTest/java/com/monsoon/care/
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = 
        new ActivityScenarioRule<>(MainActivity.class);
    
    @Test
    public void testActivityLaunches() {
        onView(withId(R.id.weather_temp)).check(matches(isDisplayed()));
    }
}
```

## 8. Building and Deployment

### 8.1 Debug Build
```bash
./gradlew assembleDebug
```

### 8.2 Release Build
```bash
./gradlew assembleRelease
```

### 8.3 Signing APK
```bash
# Create keystore (one time)
keytool -genkey -v -keystore monsoon.keystore -keyalg RSA -keysize 2048 -validity 10000

# Sign APK
jarsigner -verbose -sigalg SHA256withRSA -digestalg SHA-256 
-keystore monsoon.keystore app-release-unsigned.apk alias_name
```

### 8.4 ProGuard Obfuscation
Enable in `build.gradle`:
```gradle
buildTypes {
    release {
        minifyEnabled true
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
    }
}
```

## 9. Performance Optimization

### 9.1 Memory Optimization
```java
// Use weak references for listeners
private WeakReference<Context> contextRef;

// Clear resources in onDestroy
@Override
protected void onDestroy() {
    super.onDestroy();
    contextRef.clear();
}
```

### 9.2 Network Caching
```java
// Set cache interceptor in RetrofitClient
int cacheSize = 10 * 1024 * 1024; // 10 MB
Cache cache = new Cache(context.getCacheDir(), cacheSize);

OkHttpClient client = new OkHttpClient.Builder()
    .cache(cache)
    .build();
```

## 10. Security Best Practices

### 10.1 Secure Storage
```java
// Use EncryptedSharedPreferences
PreferenceManager.initialize(context);
PreferenceManager.putString("secure_data", "value");
```

### 10.2 API Key Management
```java
// Store in BuildConfig or secure configuration
String apiKey = BuildConfig.WEATHER_API_KEY;

// Or use separate config file not in git
if (DEBUG) {
    return "debug_key";
} else {
    return "production_key";
}
```

### 10.3 Input Validation
```java
private String validateLocation(String location) {
    if (location == null || location.trim().isEmpty()) {
        throw new IllegalArgumentException("Location cannot be empty");
    }
    return location.trim();
}
```

## 11. Troubleshooting

### Common Issues and Solutions

#### Issue: App crashes on startup
```
Solution: Check AndroidManifest.xml for missing activity declarations
         Verify all required permissions are declared
         Check build.gradle for dependency conflicts
```

#### Issue: Network requests failing
```
Solution: Verify API key is correct in Constants.java
         Check internet permission in manifest
         Ensure HTTPS is required in data_extraction_rules.xml
```

#### Issue: Database migration errors
```
Solution: Update DB_VERSION in Constants.java
         Implement migration or use fallbackToDestructiveMigration()
         Clear app data if developing locally
```

## 12. Next Steps

1. Configure all API keys
2. Set up Firebase project
3. Build and test on emulator/device
4. Integrate with backend services
5. Implement unit tests
6. Submit to Google Play Store

---

For more information, refer to:
- README.md: Project overview
- CONTRIBUTING.md: Developer guidelines
- Android Documentation: https://developer.android.com/

