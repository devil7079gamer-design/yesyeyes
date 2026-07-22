# Keep Kotlin classes

-keep class kotlin.** { *; }

# Keep Android components

-keep class ** extends android.app.Activity { *; }

-keep class ** extends android.app.Application { *; }

-keep class ** extends android.app.Service { *; }


# Keep WebView JavaScript interfaces

-keepclassmembers class * {

    @android.webkit.JavascriptInterface <methods>;

}


# Keep Firebase

-keep class com.google.firebase.** { *; }

-dontwarn com.google.firebase.**


# Keep Gson / JSON

-keepattributes Signature

-keepattributes *Annotation*


# Keep model classes

-keep class __PACKAGE_NAME__.** { *; }


# Remove logs in release

-assumenosideeffects class android.util.Log {

    public static *** d(...);

    public static *** v(...);

    public static *** i(...);

}