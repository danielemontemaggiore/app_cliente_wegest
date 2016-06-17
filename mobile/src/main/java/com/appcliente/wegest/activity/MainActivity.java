package com.appcliente.wegest.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.appcliente.wegest.R;
import com.appcliente.wegest.WebViewAppApplication;
import com.appcliente.wegest.WebViewAppConfig;
import com.appcliente.wegest.fragment.MainFragment;
import com.onesignal.OneSignal;


public class MainActivity extends AppCompatActivity
{
	public static final String EXTRA_URL = "url";

	private DrawerLayout mDrawerLayout;
	private NavigationView mNavigationView;
	private ActionBarDrawerToggle mDrawerToggle;
	private String mUrl;
	private InterstitialAd mInterstitialAd;
	private int mInterstitialCounter = 1;


	public static Intent newIntent(Context context)
	{
		Intent intent = new Intent(context, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		return intent;
	}


	public static Intent newIntent(Context context, String url)
	{
		Intent intent = new Intent(context, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra(EXTRA_URL, url);
		return intent;
	}


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);




		OneSignal.startInit(this).init();




		// handle intent extras
		Bundle extras = getIntent().getExtras();
		if(extras != null)
		{
			handleExtras(extras);
		}

		// setup action bar and drawer
		setupActionBar();
		setupDrawer(savedInstanceState);

		// bind data
		bindData();

		// init analytics tracker
		((WebViewAppApplication) getApplication()).getTracker();

		// admob
		setupInterstitialAd();
	}
	
	
	@Override
	public void onStart()
	{
		super.onStart();

		// analytics
		GoogleAnalytics.getInstance(this).reportActivityStart(this);
	}


	@Override
	public void onResume()
	{
		super.onResume();
	}
	
	
	@Override
	public void onPause()
	{
		super.onPause();
	}
	
	
	@Override
	public void onStop()
	{
		super.onStop();

		// analytics
		GoogleAnalytics.getInstance(this).reportActivityStop(this);
	}
	
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent)
	{
		super.onActivityResult(requestCode, resultCode, intent);

		// forward activity result to fragment
		Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container_drawer_content);
		if(fragment != null)
		{
			fragment.onActivityResult(requestCode, resultCode, intent);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// action bar menu
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// open or close the drawer if home button is pressed
		if(mDrawerToggle.onOptionsItemSelected(item))
		{
			return true;
		}

		// action bar menu behavior
		switch(item.getItemId())
		{
			case android.R.id.home:
				Intent intent = MainActivity.newIntent(this);
				startActivity(intent);
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}


	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}


	@Override
	public void onConfigurationChanged(Configuration newConfiguration)
	{
		super.onConfigurationChanged(newConfiguration);
		mDrawerToggle.onConfigurationChanged(newConfiguration);
	}


	@Override
	public void onBackPressed()
	{
		if(mDrawerLayout.isDrawerOpen(Gravity.LEFT))
		{
			mDrawerLayout.closeDrawer(Gravity.LEFT);
		}
		else
		{
			super.onBackPressed();
		}
	}


	private void setupActionBar()
	{
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		ActionBar bar = getSupportActionBar();
		bar.setDisplayUseLogoEnabled(false);
		bar.setDisplayShowTitleEnabled(true);
		bar.setDisplayShowHomeEnabled(true);
		bar.setDisplayHomeAsUpEnabled(WebViewAppConfig.NAVIGATION_DRAWER);
		bar.setHomeButtonEnabled(WebViewAppConfig.NAVIGATION_DRAWER);
		if(!WebViewAppConfig.ACTION_BAR) bar.hide();
	}


	private void setupDrawer(Bundle savedInstanceState)
	{
		// reference
		mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
		mNavigationView = (NavigationView) findViewById(R.id.activity_main_drawer_navigation);

		// add menu items
		MenuItem firstItem = setupMenu(mNavigationView.getMenu());

		// menu icon tint
		if(!WebViewAppConfig.NAVIGATION_DRAWER_ICON_TINT)
		{
			mNavigationView.setItemIconTintList(null);
		}

		// navigation listener
		mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
		{
			@Override
			public boolean onNavigationItemSelected(MenuItem item)
			{
				// show interstitial ad
				if(WebViewAppConfig.ADMOB_INTERSTITIAL_FREQUENCY > 0 && mInterstitialCounter % WebViewAppConfig.ADMOB_INTERSTITIAL_FREQUENCY == 0)
				{
					showInterstitialAd();
				}
				mInterstitialCounter++;

				// select drawer item
				selectDrawerItem(item);
				return true;
			}
		});

		// drawer toggle
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close)
		{
			@Override
			public void onDrawerClosed(View view)
			{
				supportInvalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView)
			{
				supportInvalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// disable navigation drawer
		if(!WebViewAppConfig.NAVIGATION_DRAWER)
		{
			mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.LEFT);
		}

		// show initial fragment
		if(savedInstanceState == null)
		{
			if(mUrl == null)
			{
				selectDrawerItem(firstItem);
			}
			else
			{
				selectDrawerItem(mUrl);
			}
		}
	}


	private MenuItem setupMenu(Menu menu)
	{
		// title list
		String[] titles = getResources().getStringArray(R.array.navigation_title_list);

		// url list
		String[] urls = getResources().getStringArray(R.array.navigation_url_list);

		// icon list
		TypedArray iconTypedArray = getResources().obtainTypedArray(R.array.navigation_icon_list);
		Integer[] icons = new Integer[iconTypedArray.length()];
		for(int i=0; i<iconTypedArray.length(); i++)
		{
			icons[i] = iconTypedArray.getResourceId(i, -1);
		}
		iconTypedArray.recycle();

		// clear menu
		menu.clear();

		// add menu items
		Menu parent = menu;
		MenuItem firstItem = null;
		for(int i = 0; i < titles.length; i++)
		{
			if(urls[i].equals(""))
			{
				// category
				parent = menu.addSubMenu(Menu.NONE, i, i, titles[i]);
			}
			else
			{
				// item
				MenuItem item = parent.add(Menu.NONE, i, i, titles[i]);
				if(icons[i] != -1) item.setIcon(icons[i]);
				if(firstItem == null) firstItem = item;
			}
		}

		return firstItem;
	}


	private void setupInterstitialAd()
	{
		if(WebViewAppConfig.ADMOB_UNIT_ID_INTERSTITIAL != null && !WebViewAppConfig.ADMOB_UNIT_ID_INTERSTITIAL.equals(""))
		{
			mInterstitialAd = new InterstitialAd(this);
			mInterstitialAd.setAdUnitId(WebViewAppConfig.ADMOB_UNIT_ID_INTERSTITIAL);
			mInterstitialAd.setAdListener(new AdListener()
			{
				@Override
				public void onAdClosed()
				{
					loadInterstitialAd();
				}
			});
			loadInterstitialAd();
		}
	}


	private void selectDrawerItem(MenuItem item)
	{
		int position = item.getItemId();

		String[] urlList = getResources().getStringArray(R.array.navigation_url_list);
		String[] shareList = getResources().getStringArray(R.array.navigation_share_list);

		Fragment fragment = MainFragment.newInstance(urlList[position], shareList[position]);
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.container_drawer_content, fragment).commitAllowingStateLoss();

		item.setCheckable(true);
		mNavigationView.setCheckedItem(position);
		getSupportActionBar().setTitle(item.getTitle());
		mDrawerLayout.closeDrawers();
	}


	private void selectDrawerItem(String url)
	{
		Fragment fragment = MainFragment.newInstance(url, "");
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.container_drawer_content, fragment).commitAllowingStateLoss();

		mNavigationView.setCheckedItem(-1);
		getSupportActionBar().setTitle(getString(R.string.app_name));
		mDrawerLayout.closeDrawers();
	}


	private void handleExtras(Bundle extras)
	{
		if(extras.containsKey(EXTRA_URL))
		{
			mUrl = extras.getString(EXTRA_URL);
		}
	}


	private void loadInterstitialAd()
	{
		if(mInterstitialAd != null)
		{
			AdRequest adRequest = new AdRequest.Builder()
					.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
					.addTestDevice(WebViewAppConfig.ADMOB_TEST_DEVICE_ID)
					.build();
			mInterstitialAd.loadAd(adRequest);
		}
	}


	private void showInterstitialAd()
	{
		if(WebViewAppConfig.ADMOB_UNIT_ID_INTERSTITIAL != null && !WebViewAppConfig.ADMOB_UNIT_ID_INTERSTITIAL.equals(""))
		{
			if(mInterstitialAd != null && mInterstitialAd.isLoaded())
			{
				mInterstitialAd.show();
			}
		}
	}


	private void bindData()
	{
		// reference
		NavigationView navigationView = (NavigationView) findViewById(R.id.activity_main_drawer_navigation);

		// inflate navigation header
		if(navigationView.getHeaderView(0) == null)
		{
			View headerView = getLayoutInflater().inflate(R.layout.navigation_header, navigationView, false);
			navigationView.addHeaderView(headerView);
		}

		// navigation header content
		if(navigationView.getHeaderView(0) != null)
		{
			// reference
			View headerView = navigationView.getHeaderView(0);

			// header background
			if(WebViewAppConfig.NAVIGATION_DRAWER_HEADER_IMAGE)
			{
				//headerView.setBackgroundResource(R.drawable.navigation_header_bg);
			}
		}
	}
}
