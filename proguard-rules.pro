# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
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
-ignorewarnings
-dontwarn javax.annotation.**
-dontwarn javax.inject.**
# OkHttp3
-dontwarn okhttp3.logging.**
-keep class okhttp3.internal.**{*;}
-dontwarn okio.**
# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
# RxJava RxAndroid


#zxing
-keep class com.google.zxing.** {*;}
-dontwarn com.google.zxing.**


# Gson
-keep class com.google.gson.stream.** { *; }
-keepattributes EnclosingMethod


#实体类
-keep class com.example.godcode.bean.**{*;}

-keep class com.example.godcode.greendao.entity.**{*;}


#自定义控件
-keep class com.example.godcode.ui.view.**{*;}

#pinyin4j
-dontwarn net.soureceforge.pinyin4j.**

-dontwarn demo.**


-keep class net.sourceforge.pinyin4j.** { *;}

#evenBus

-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }



# greendao
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties
# If you do not use SQLCipher:
-dontwarn org.greenrobot.greendao.database.**
# If you do not use Rx:
-dontwarn rx.**


-dontwarn java.lang.invoke.**
#weixin
-keep class com.tencent.mm.opensdk.** {
*;
}
-keep class com.tencent.wxop.** {
*;
}
-keep class com.tencent.mm.sdk.** {
*;
}

#webSocket
-dontwarn org.java_websocket.**
-keep class org.java_websocket*.** {*; }

-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

-dontwarn pl.droidsonroids.gif.**
-keep class pl.droidsonroids.gif.**{*;}

-dontwarn net.orfjackal.retrolambda**
-keep class net.orfjackal.retrolambda.**{*;}

-dontwarn com.jakewharton**
-keep class com.jakewharton.**{*;}

-dontwarn com.android.support**
-keep class com.android.support.**{*;}


#友盟
-dontwarn com.umeng.**
-dontwarn com.taobao.**
-dontwarn anet.channel.**
-dontwarn anetwork.channel.**
-dontwarn org.android.**
-dontwarn org.apache.thrift.**
-dontwarn com.xiaomi.**
-dontwarn com.huawei.**
-dontwarn com.meizu.**

-keepattributes *Annotation*

-keep class com.taobao.** {*;}
-keep class org.android.** {*;}
-keep class anet.channel.** {*;}
-keep class com.umeng.** {*;}
-keep class com.xiaomi.** {*;}
-keep class com.huawei.** {*;}
-keep class com.meizu.** {*;}
-keep class org.apache.thrift.** {*;}

-keep class com.alibaba.sdk.android.**{*;}
-keep class com.ut.**{*;}
-keep class com.ta.**{*;}

-keep public class **.R$*{
   public static final int *;
}

-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}



