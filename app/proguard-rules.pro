# ProGuard rules for Monsoon Care Application

# Keep application classes
-keep class com.monsoon.care.** { *; }
-keep class com.monsoon.care.ui.** { *; }
-keep class com.monsoon.care.data.** { *; }
-keep class com.monsoon.care.services.** { *; }
-keep class com.monsoon.care.network.** { *; }
-keep class com.monsoon.care.viewmodels.** { *; }
-keep class com.monsoon.care.utils.** { *; }

# Keep enums
-keepclassmembers enum com.monsoon.care.** {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep model classes (entities)
-keep class com.monsoon.care.data.models.** { *; }
-keep class com.monsoon.care.data.db.entities.** { *; }

# Keep View constructors for layout inflation
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

# Keep Firebase classes
-keep class com.google.firebase.** { *; }
-keep interface com.google.firebase.** { *; }

# Keep Retrofit classes
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# Keep Gson classes
-keep class com.google.gson.** { *; }
-keep class com.monsoon.care.data.models.** { <fields>; }

# Keep Room classes
-keep class androidx.room.** { *; }
-keep @androidx.room.Database class * { *; }
-keepclassmembers class * {
    @androidx.room.* <methods>;
}

# Keep OkHttp classes
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Keep LiveData and ViewModel
-keep class androidx.lifecycle.** { *; }
-keep class androidx.lifecycle.ViewModel { *; }

# Keep Android support libraries
-keep class androidx.** { *; }
-keep interface androidx.** { *; }

# Keep logging library
-keep class com.orhanobut.logger.** { *; }

# Remove logging calls in release build
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# Generic signature classes
-keepattributes Signature

# Keep source file and line numbers for crash reporting
-keepattributes SourceFile,LineNumberTable

# Rename source file to help obfuscation
-renamesourcefileattribute SourceFile

# Don't obfuscate certain classes
-dontobfuscate

# Optimization level
-optimizationpasses 5

# Use unique class member names
-useuniqueclassmembernames

# Remove unused code
-dontshrink

# Verbose logging
-verbose

# Rules for native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

