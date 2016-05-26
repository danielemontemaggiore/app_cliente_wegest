WebView App Documentation
=========================


## Intro

This is a documentation for WebView App created by [Robo Templates](http://robotemplates.com/). WebView App is a native Android application. You can find here useful info about configuring, customizing, building and publishing the app.

* [WebView App on Codecanyon](http://codecanyon.net/item/universal-android-webview-app/8431507)
* [Video preview on YouTube](https://www.youtube.com/watch?v=mcEXzYXvC94)
* [Live demo on Google Play](https://play.google.com/store/apps/details?id=com.robotemplates.webviewapp)


## Features

* Support for Ice Cream Sandwich (Android 4.0.3) and newer
* Developed with Android Studio & Gradle
* Material design following Android Design Guidelines
* Ten color themes (blue, brown, gray, green, lime, orange, purple, red, teal, violet)
* Thirty menu icons
* Action bar
* Navigation drawer menu with optional categories (easily customizable)
* Pull-to-Refresh
* Share dialog
* Intents (e-mail, sms, phone call, map, store)
* Geolocation
* Download manager
* File picker for uploading files
* Fast and powerful webview engine based on the Chromium
* WebView supports JavaScript, Cookies, CSS, images, videos and other standard web tools and technologies
* HTML5 videos, YouTube, Vimeo, JW Player
* Fullscreen video
* Support for opening links in external browser (customizable rules)
* Local pages (available in offline)
* Error handling
* Offline handling
* Progress bar when loading the page
* Runtime permissions
* Google Analytics
* AdMob (banner and interstitial ad)
* Push notifications (OneSignal.com, GCM)
* RTL
* Customization (enable/disable action bar, navigation drawer menu, pull-to-refresh etc.)
* Responsive design (portrait, landscape, handling orientation change)
* Support for high-resolution displays (xxxhdpi)
* Multi-language support
* Possibility to build the project without Android Studio / Eclipse (using Gradle & Android SDK)
* Easy configuration
* Well documented
* Top quality clean code created by experienced senior Android developer
* Free support


## Android Studio & SDK

This chapter describes how to install Android Studio and Android SDK. You don't have to install Android Studio, but it's better. The project can be built without Android Studio, using Gradle and Android SDK. Gradle is a build system used for building final APK file.

1. Install [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Install [Android SDK](https://developer.android.com/sdk/index.html)
3. Run Android SDK Manager and [download necessary SDK packages](https://developer.android.com/sdk/installing/adding-packages.html), make sure that you have installed Android SDK Tools, Android SDK Platform-tools, Android SDK Build-tools, Android Support Repository, Android Support Library, Google Play services and Google USB Driver
4. Install [Android Studio](https://developer.android.com/sdk/index.html)
5. Now you should be able to open/edit the Android project and build APK
6. You can also install [Genymotion](http://www.genymotion.com/) - fast Android emulator


## Project Structure

Project has the following structure (directories are marked by square braces):

- [doc] - documentation
- [extras] - contains extras
- [extras]/[keystore]
- [extras]/[keystore]/webviewapp.jks - keystore certificate for signing APK
- [extras]/[keystore]/webviewapp.properties - alias and password for keystore
- [gradle]
- [gradle]/[wrapper] - Gradle Wrapper
- [mobile] - main module
- [mobile]/[libs] - contains 3rd party libraries (not used)
- [mobile]/[src] - contains source code
- [mobile]/[src]/[main]
- [mobile]/[src]/[main]/[assets] - asset files (local html pages)
- [mobile]/[src]/[main]/[java] - java sources
- [mobile]/[src]/[main]/[res] - xml resources, drawables
- [mobile]/[src]/[main]/AndroidManifest.xml - manifest file
- [mobile]/build.gradle - main build script
- [mobile]/proguard-rules.pro - Proguard config (not used)
- .gitignore - Gitignore file
- build.gradle - parent build script
- gradle.properties - build script properties containing path to keystore
- gradlew - Gradle Wrapper (Unix)
- gradlew.bat - Gradle Wrapper (Windows)
- README.md - readme file
- settings.gradle - build settings containing list of modules

Java packages:

- com.robotemplates.webviewapp - contains application class and main config class
- com.appcliente.wegest.activity - contains activities representing screens
- com.appcliente.wegest.fragment - contains fragments with main application logic
- com.appcliente.wegest.listener - contains event listeners
- com.appcliente.wegest.utility - contains utilities
- com.appcliente.wegest.view - contains custom views and layouts
- im.delight.android.webview - implementation of advanced webview component
- name.cpr - implementation of video enabled webview component


## Configuration

This chapter describes how to configure the project to be ready for publishing. All these steps are very important!


### 1. Import

Unzip the package and import/open the project in Android Studio. Choose "Import project" on Quick Start screen and select "webviewapp-x.y.z" directory.

If you want, you can build and run the app right away to test it. Connect your device or [emulator](http://developer.android.com/tools/devices/index.html) to your computer. Make sure you have installed all necessary [drivers](http://developer.android.com/tools/extras/oem-usb.html) for your Android device and you also enabled [USB debugging in Developer options](http://developer.android.com/tools/device.html). To build and run the app in Android Studio, just click on Main menu -> Run -> Run 'mobile'. Choose a running device and confirm.


### 2. Rename Package Name

[The package name](http://developer.android.com/guide/topics/manifest/manifest-element.html#package) serves as a unique identifier for the application. It is also unique in the Google Play store. Once you publish your application, you cannot change the package name. The package name defines your application's identity, so if you change it, then it is considered to be a different application and users of the previous version cannot update to the new version. Default package name is "com.robotemplates.webviewapp" so you have to rename it to something else.

1. Create new package in _java_ directory, e.g. "com.mycompany.myapp". In Project window, right click on _mobile/src/main/java_ directory -> New -> Package. Enter your package name and confirm.
2. Select all packages and classes in "com.robotemplates.webviewapp" and move (drag) them to the new package. Confirm by click on "Refactor" button and then "Do Refactor".
3. Delete the old package "com.robotemplates.webviewapp".
4. Open _mobile/src/main/AndroidManifest.xml_ and rename the package name. Select package name "com.robotemplates.webviewapp" and rewrite it to your new package name, e.g. "com.mycompany.myapp".
5. Clean the project. Main menu -> Build -> Clean Project.
6. Replace all occurrences of "com.robotemplates.webviewapp" for a new package name, e.g. "com.mycompany.myapp". Right click on _mobile_ directory -> Replace in Path -> set old and new package names, "Case sensitive" to true -> Find -> Replace -> All Files.
7. Clean the project again. Main menu -> Build -> Clean Project.
8. Synchronize the project. Main menu -> Tools -> Android -> Sync Project with Gradle Files.

**Note:** If you see "Activity class does not exist" error, restart Android Studio.


### 3. Rename Application Name

Open _mobile/src/main/res/values/strings.xml_ and change "WebView App" to your own name. Change _app\_name_ and _navigation\_header\_title_ strings.


### 4. Create Launcher Icon

Right click on _mobile/src/main/res_ directory -> New -> Image Asset -> Asset type "Launcher Icons", Resource name "ic\_launcher", create the icon as you wish, you can set clipart, text, shape, color etc. -> Next -> Finish.

You can also change the icon by replacing _ic\_launcher.png_ file in _mipmap-mdpi_, _mipmap-hdpi_, _mipmap-xhdpi_, _mipmap-xxhdpi_, _mipmap-xxxhdpi_ directories. See [Android Cheatsheet for Graphic Designers](http://petrnohejl.github.io/Android-Cheatsheet-For-Graphic-Designers/#screen-densities-and-icon-dimensions) for correct launcher icon dimensions.

Don't forget to change also the icon for a push notification by replacing _ic\_stat\_onesignal\_default.png_ file in _drawable-mdpi_, _drawable-hdpi_, _drawable-xhdpi_, _drawable-xxhdpi_, _drawable-xxxhdpi_ directories.

You can also change the logo shown in the navigation drawer header. It is stored in _mobile/src/main/res/drawable-xxxhdpi/navigation\_header\_logo.png_.

**Note:** _ic\_launcher.png_ is the launcher icon and _ic\_stat\_onesignal\_default.png_ is the icon for the push notification.

**Tip:** Another possibility is to create launcher icons using [Android Asset Studio](http://romannurik.github.io/AndroidAssetStudio/icons-launcher.html).


### 5. Choose Color Theme

Open _mobile/src/main/AndroidManifest.xml_ and change value of `application.android:theme` attribute. There are 10 themes you can use:

* Theme.WebViewApp.Blue
* Theme.WebViewApp.Brown
* Theme.WebViewApp.Gray
* Theme.WebViewApp.Green
* Theme.WebViewApp.Lime
* Theme.WebViewApp.Orange
* Theme.WebViewApp.Purple
* Theme.WebViewApp.Red
* Theme.WebViewApp.Teal
* Theme.WebViewApp.Violet


### 6. Setup Navigation and Web Pages

Open _mobile/src/main/res/values/navigation.xml_. There are 4 string arrays:

* List of titles in the navigation drawer menu.
* List of webview URLs. You can specify URL link to a web page on the Internet or URL link to a local page stored in _assets_ directory. Local page does not require Internet connection. URL to the local page must be in this format: `file:///android_asset/example.html`. If you want to add a category, leave the item empty. Menu item without URL is considered as a category item.
* List of icons in the navigation drawer menu.
* List of share messages. Each webview page can be shared via e-mail, sms, social networks etc. Share button is in the action bar. You can specify a message which will be posted. Use `{TITLE}` or `{URL}` tags if you want to insert a title or a URL link of the page. If you don't want to share the page, keep the item empty.

You can add/remove/modify menu items as you need. If you want to use local pages, copy HTML files to _mobile/src/main/assets_ directory and set proper paths in _navigation\_url\_list_ array. See the path format above.

**Important:** each of these 4 arrays must contain the same number of items.


### 7. Setup Google Analytics

Open configuration file _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set value of `ANALYTICS_TRACKING_ID` constant to your own UA tracking id. Leave the constant empty if you don't want to use Google Analytics.


### 8. Setup AdMob

Open configuration file _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set values of `ADMOB_UNIT_ID_BANNER` and `ADMOB_UNIT_ID_INTERSTITIAL` constants to your own unit ids (banner id and interstitial id). Leave these constants empty if you don't want to use AdMob.

Interstitial ad will be shown after each x clicks on navigation drawer menu. Frequency of showing AdMob interstitial ad can be set in `ADMOB_INTERSTITIAL_FREQUENCY` constant.

You can also specify your test device id in `ADMOB_TEST_DEVICE_ID` constant and use test mode when you are debugging the app. Requesting test ads is recommended when you are testing your application on a real device so you do not request invalid impressions. You can find your hashed device id in Android Monitor (Logcat) output by requesting an ad when debugging on your device. Open Android Monitor (Logcat) in Android Studio and look for "To get test ads on this device, call adRequest.addTestDevice("XXXXXX…");". You can use filter/search to find this information in the log. That XXX string is the hashed device id. This applies only to real devices, not emulators. Emulators are considered as test devices by default so you don't have to care about it.


### 9. Setup Push Notifications

Application uses [OneSignal.com](https://onesignal.com/) for push notifications. You need to create a new OneSignal account if you don't have one. You have to create a new project in [OneSignal admin](https://onesignal.com/) and also create a new project in [Google Developers Console](https://console.developers.google.com), because OneSignal uses Google's GCM technology (Google Cloud Messaging). Follow [OneSignal documentation](https://documentation.onesignal.com/docs/android-generating-a-gcm-push-notification-key) to setup the project. You need to get "Project number" in Google Developers Console, enable Google Cloud Messaging API and create a new "Server key". Everything is described step by step in the OneSignal documentation. Make sure that you create a "Server key", not "Android key". When you are done, just paste the "Server key" in OneSignal admin in configuration wizard. Then open _mobile/build.gradle_ and setup `onesignal_app_id` and `onesignal_google_project_number` constants. You can find these constants in android -> defaultConfig -> manifestPlaceholders list. You can get `onesignal_app_id` value from OneSignal admin and `onesignal_google_project_number` value from Google Developers Console. Leave these constants empty if you don't want to use push notifications.

When user taps on a notification, the app is opened and home page is loaded. If you want to load a specific page, you have to send the notification with additional data. Open [OneSignal admin](https://onesignal.com/) -> New Message -> Options -> Launch URL -> Yes and set the link. Other alternative is New Message -> Options -> Include Additional Data -> Yes and set "url" as a key and the link as a value. Both variants have the same result - the app will be opened with the specified URL.

**Tip:** _ic\_stat\_onesignal\_default.png_ is the icon for a push notification. You can change it if you want.


### 10. Create Signing Keystore

You need to create your own keystore to [sign an APK file](http://developer.android.com/tools/publishing/app-signing.html) before [publishing on Google Play](http://developer.android.com/distribute/googleplay/start.html). You can create the keystore via [keytool utility](http://docs.oracle.com/javase/7/docs/technotes/tools/solaris/keytool.html) which is part of Java JDK. On Windows, you can find it usually in _C:\Program Files\Java\jdkX.Y.Z\bin_. On Mac, you can find it usually in _/Library/Java/JavaVirtualMachines/jdkX.Y.Z/Contents/Home/bin_.

1. Run following command: `keytool -genkey -v -keystore webviewapp.jks -alias <your_alias> -keyalg RSA -keysize 2048 -validity 36500` where `<your_alias>` is your alias name. For example your company name or app name.
2. Copy new _webviewapp.jks_ file into _extras/keystore_ directory.
3. Open _extras/keystore/webviewapp.properties_ and set keystore alias and passwords.
4. Done. Remember that _webviewapp.jks_ and _webviewapp.properties_ are automatically read by Gradle script when creating a release APK via _assembleRelease_ command. Paths to these files are defined in _gradle.properties_.

**Note:** You can also create a keystore directly in Android Studio. Main menu -> Build -> Generate Signed APK -> Create new. If you do it this way, don't forget for step 2 and 3 above. Keystore name has to be _webviewapp.jks_ and should be stored in _extras/keystore_ directory.


## Customization

This chapter describes optional customizations of the app.


### Action Bar and Pull-to-Refresh Gesture

You can enable/disable action bar (toolbar) or pull-to-refresh gesture in the configuration file. Just open _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set `ACTION_BAR` or `PULL_TO_REFRESH` constants to true/false.


### Navigation Drawer Menu

You can enable/disable navigation drawer menu in the configuration file. Just open _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set `NAVIGATION_DRAWER` constant to true/false.

You can enable/disable background image in the header of the navigation drawer menu. Just open _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set `NAVIGATION_DRAWER_HEADER_IMAGE` constant to true/false. If it is disabled, accent color will be used for the background. Background image is stored in _mobile/src/main/res/drawable-xxxhdpi/navigation\_header\_bg.png_. Logo shown in the header is stored in _mobile/src/main/res/drawable-xxxhdpi/navigation\_header\_logo.png_.

You can also enable/disable menu icon tint. Just open _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set `NAVIGATION_DRAWER_ICON_TINT` constant to true/false. Only transparent PNG icons can be tinted so if you don't use transparent icons, it is recommended to disable icon tint. Tint color is defined in _@color/navigation\_icon\_tint_ attribute in _mobile/src/main/res/values/colors.xml_.


### Geolocation

Application supports geolocation. Keep in mind, that some users might have geolocation disabled on their device. Geolocation requires permission to access GPS. Permission request is shown on start of the app. If user decide to reject the permission, geolocation will not work. If you don't use geolocation on your web, it is better to disable it, because permission request will not be shown. You can enable/disable geolocation in the configuration file. Just open _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set `GEOLOCATION` constant to true/false.


### Open Links in External Browser

If you click on some link in the webview, web page is opened directly in the webview by default. Pages can be opened in external browser. If you need this behavior, just open configuration file _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and set `OPEN_LINKS_IN_EXTERNAL_BROWSER = true`.

You can also set rules which links will be opened in external browser and which ones will be loaded in internal webview. Open configuration file _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and add/remove rules in `LINKS_OPENED_IN_EXTERNAL_BROWSER` or `LINKS_OPENED_IN_INTERNAL_WEBVIEW` arrays. If URL link of the page contains the string from the array, it will be opened in external browser/internal webview. These rules have higher priority than `OPEN_LINKS_IN_EXTERNAL_BROWSER` option. For example "http://www.example.com/?target=blank" will be opened externally and "http://www.example.com/?target=webview" will be opened internally.


### Download Manager

This feature allows to download files from the web into the device. Just click on the download link and the file will be automatically downloaded into DOWNLOAD directory. File URL must have a specific format so download manager can recognize it is a downloadable file - URL must ends with the supported extension (zip, pdf, mp3, avi etc.), e.g. _http://www.example.com/path/mediafile.mp3_ or _http://www.example.com/path/mediafile.mp3?arg1=1&arg2=2_. You can see progress of downloading in the notification panel. You can modify supported file formats in the configuration file. Just open _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and add/remove file types in `DOWNLOAD_FILE_TYPES` array as you need. Keep this array empty if you don't want to use download manager.


### Intents in HTML

Application supports [Android Intents](http://developer.android.com/guide/components/intents-filters.html). You can add a special link to your HTML file and you will be able to run appropriate external app to perform some action. For example send an e-mail or call somebody. Following intents are supported (example URI):

* HTTP web page: http://android.com
* HTTPS web page: https://google.com
* E-mail: mailto:someone@example.com?subject=Hello
* Phone call: tel:+0123456789
* SMS: sms:+0123456789
* Map point: geo:50.087474,14.421206
* Map search: geo:0,0?q=Czech+Republic


### Custom Colors and Icons

You can customize colors in _mobile/src/main/res/values/colors.xml_.

There are 30 icons which you can use for navigation drawer menu. If you need to create an icon for navigation drawer menu, it is recommended to use [Android Asset Studio](http://romannurik.github.io/AndroidAssetStudio/index.html). See [Android Cheatsheet for Graphic Designers](http://petrnohejl.github.io/Android-Cheatsheet-For-Graphic-Designers/#screen-densities-and-icon-dimensions) for correct icon dimensions.


### Multi-Language Support

Create a new directory _mobile/src/main/res/values-xx_ where _xx_ is an [ISO 639-1 code](http://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) of the language you want to translate. For example "values-es" for Spanish, "values-fr" for French, "values-de" for German etc. Copy strings.xml and navigation.xml from _mobile/src/main/res/values_ into the new directory. Now you can translate texts or use different URL links for specific languages. The language is automatically determined by the system device settings. If there is no match with _values-xx_ language, default language in _mobile/src/main/res/values_ is selected. See [Localizing with Resources](http://developer.android.com/guide/topics/resources/localization.html) for more info.


### Uploading Files

Application supports uploading files however there is a known bug on Android 4.4 so the upload might not work properly. See official [Android Issue Tracker](https://code.google.com/p/android/issues/detail?id=62220) for more info.


### Video in HTML

Application supports HTML5 video, YouTube, Vimeo, JW Player etc. in fullscreen mode.


## Building & Publishing

This chapter describes how to build APK file using Gradle and prepare app for publishing. Android Studio uses Gradle for building Android applications.

You don't need to install Gradle on your system, because there is a [Gradle Wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html). The wrapper is a batch script on Windows, and a shell script for other operating systems. When you start a Gradle build via the wrapper, Gradle will be automatically downloaded and used to run the build.

1. Open the project in Android Studio
2. Open configuration file _mobile/src/main/java/com/robotemplates/webviewapp/WebViewAppConfig.java_ and check if everything is setup correctly
3. Open main build script _mobile/build.gradle_ and check version constants
4. Run `gradlew assemble` in Android Studio terminal, make sure you are running the command from root directory of the project
5. After the build is finished, APK file should be available in _mobile/build/outputs/apk_ directory

**Note:** You will also need a "local.properties" file to set the location of the SDK in the same way that the existing SDK requires, using the "sdk.dir" property. Example of "local.properties" on Windows: `sdk.dir=C:\\adt-bundle-windows\\sdk`. Alternatively, you can set an environment variable called "ANDROID\_HOME". Android Studio will take care of it.

**Tip:** Command `gradlew assemble` builds both - debug and release APK. You can use `gradlew assembleDebug` to build debug APK. You can use `gradlew assembleRelease` to build release APK. Debug APK is signed by debug keystore. Release APK is signed by your own keystore, stored in _/extras/keystore_ directory.

**Signing process:** Keystore passwords are automatically loaded from property file during building the release APK. Path to this file is defined in "keystore.properties" property in "gradle.properties" file. If this property or the file does not exist, user is asked for passwords explicitly.


### Versioning

Open the main build script _mobile/build.gradle_. There are 4 important constants for defining version code and version name.

* VERSION\_MAJOR
* VERSION\_MINOR
* VERSION\_PATCH
* VERSION\_BUILD

Keep in mind that versions have to be incremental. See [Versioning Your Applications](http://developer.android.com/tools/publishing/versioning.html#appversioning) in Android documentation for more info.


## Dependencies

* [AdvancedWebView](https://github.com/delight-im/Android-AdvancedWebView)
* [Android Support Library](http://developer.android.com/tools/support-library/index.html)
* [Google Play Services](http://developer.android.com/google/play-services/index.html)
* [OneSignal](https://onesignal.com/)
* [VideoEnabledWebView](https://github.com/cprcrack/VideoEnabledWebView)


## Changelog

* Version 1.0.0
	* Initial release
* Version 1.1.0
	* AdMob support
	* Configuration for opening links in webview
* Version 1.2.0
	* Update Gradle script to be compatible with Android Studio 1.0
	* Download manager
	* Open links directly in the webview by default
	* Show progress bar when loading nested link
	* Fix refreshing of the current page
	* Fix text color of the HTML select
	* Fix Google Play intent
* Version 1.3.0
	* Material design
	* New color themes
	* New set of menu icons
	* Rules for opening links in external browser or internal webview
	* Support for uploading files
* Version 1.4.0
	* Push notifications
	* Launcher icon as a mipmap
	* Fix empty placeholder
* Version 2.0.0
	* Better webview performance with faster loading and caching
	* Geolocation
	* Fullscreen video
	* Better design
	* Navigation drawer menu with optional categories
	* Interstitial ads
	* Runtime permissions
	* Title and URL link of the page in share message
	* Pull-to-Refresh gesture on offline and empty screen
	* RTL
	* One config file for everything (Google Analytics, AdMob, Parse, enable/disable extra features)
	* Update SDK and libraries
	* Huge refactoring of the code with many improvements and optimizations
* Version 2.1.0
	* OneSignal.com push notification service (Parse.com is shutting down)
	* Configuration for navigation drawer menu icon tint


## Developed by

[Robo Templates](http://robotemplates.com/)


## License

[Codecanyon license](http://codecanyon.net/licenses/standard)
