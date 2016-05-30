package com.appcliente.wegest;


import com.appcliente.wegest.BuildConfig;

public class WebViewAppConfig
{
	// true for showing action bar
	public static final boolean ACTION_BAR = true;

	// true for enabling navigation drawer menu
	public static final boolean NAVIGATION_DRAWER = true;

	// true for enabling background image in the header of the navigation drawer menu,
	// otherwise accent color will be used,
	// background image is stored in navigation_header_bg.png
	public static final boolean NAVIGATION_DRAWER_HEADER_IMAGE = true;

	// true for enabling icon tint in the navigation drawer menu,
	// note that only transparent PNG icons can be tinted,
	// tint color is defined in @color/navigation_icon_tint
	public static final boolean NAVIGATION_DRAWER_ICON_TINT = true;

	// true for enabling pull-to-refresh gesture
	public static final boolean PULL_TO_REFRESH = false;

	// true for enabling geolocation
	public static final boolean GEOLOCATION = false;

	// tracking id for Google Analytics,
	// leave this constant empty if you do not want to use Google Analytics
	public static final String ANALYTICS_TRACKING_ID = "UA-XXXXXXXX-X";

	// unit ids for AdMob,
	// leave these constants empty if you do not want to use AdMob
	public static final String ADMOB_UNIT_ID_BANNER = "ca-app-pub-XXXXXXXXXXXXXXXXXXXXXXXXXXX";
	public static final String ADMOB_UNIT_ID_INTERSTITIAL = "ca-app-pub-XXXXXXXXXXXXXXXXXXXXXXXXXXX";

	// test device id for AdMob,
	// setup this constant if you want to avoid invalid impressions,
	// you can find your hashed device id in the logcat output by requesting an ad when debugging on your device
	public static final String ADMOB_TEST_DEVICE_ID = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

	// frequency of showing AdMob interstitial ad,
	// ad will be shown after each x clicks on navigation drawer menu
	public static final int ADMOB_INTERSTITIAL_FREQUENCY = 10;

	// true for opening webview links in external web browser rather than directly in the webview
	public static final boolean OPEN_LINKS_IN_EXTERNAL_BROWSER = false;

	// rules for opening links in external browser,
	// if URL link contains the string, it will be opened in external browser,
	// these rules have higher priority than OPEN_LINKS_IN_EXTERNAL_BROWSER option
	public static final String[] LINKS_OPENED_IN_EXTERNAL_BROWSER = {
			"target=blank",
			"target=external",
			"play.google.com/store",
			"youtube.com/watch"
	};

	// rules for opening links in internal webview,
	// if URL link contains the string, it will be loaded in internal webview,
	// these rules have higher priority than OPEN_LINKS_IN_EXTERNAL_BROWSER option
	public static final String[] LINKS_OPENED_IN_INTERNAL_WEBVIEW = {
			"target=webview",
			"target=internal"
	};

	// list of file extensions for download,
	// if webview URL ends with this extension, that file will be downloaded via download manager,
	// leave this array empty if you do not want to use download manager
	public static final String[] DOWNLOAD_FILE_TYPES = {
			".zip", ".rar", ".pdf", ".doc", ".xls",
			".mp3", ".wma", ".ogg", ".m4a", ".wav",
			".avi", ".mov", ".mp4", ".mpg", ".3gp"
	};

	// debug logs, value is set via build config in build.gradle
	public static final boolean LOGS = BuildConfig.LOGS;
}
