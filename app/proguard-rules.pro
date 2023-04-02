# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

## Parcelable
###########
-keep class * implements android.os.Parcelable {
      public static final android.os.Parcelable$Creator *;
   }

## Serializable
###############
-keepnames class * extends java.io.Serializable

# KOTLINX SERIALIZATION
-keepattributes *Annotation*, InnerClasses
#-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-keep,includedescriptorclasses class com.napptilus.willywonka.**$$serializer { *; }
-keepclassmembers class com.napptilus.willywonka.** {
    *** Companion;
}
-keepclasseswithmembers class com.napptilus.willywonka.** {
    kotlinx.serialization.KSerializer serializer(...);
}
# END OF - KOTLINX SERIALIZATION

## Retrofit
###########

# Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
# EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
#-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

# Ignore FragmentContainerView used by jetpack navigation library
-keep class * extends androidx.fragment.app.FragmentContainerView{}

# CRASHLYTICS
-keepattributes SourceFile,LineNumberTable        # Keep file names and line numbers.
-keep public class * extends java.lang.Exception  # Optional: Keep custom exceptions.


# Navigation
-keep class * extends com.napptilus.willywonka.commonsui.navigation.Destination
-keep class * extends com.napptilus.willywonka.commonsui.navigation.DestinationDeclaration
-keep class com.napptilus.willywonka.presentation.RootNavGraph
-keepclassmembers class * extends com.napptilus.willywonka.commonsui.navigation.Destination {public <methods>;}