package com.appcliente.wegest.listener;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;


public class WebViewOnKeyListener implements View.OnKeyListener
{
	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event)
	{
		if(event.getAction() == KeyEvent.ACTION_DOWN)
		{
			WebView webView = (WebView) v;

			switch(keyCode)
			{
				case KeyEvent.KEYCODE_BACK:
					if(webView.canGoBack())
					{
						webView.goBack();
						return true;
					}
					break;
			}
		}

		return false;
	}
}
