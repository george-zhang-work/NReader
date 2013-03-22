package com.nreader.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.nreader.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class Home extends SlidingFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.sliding_view_above_layout);
		setBehindContentView(R.layout.sliding_view_behind_layout);

		configSlidingMenu();

		configActionBar();
	}

	/**
	 * Configure the custom action bar.
	 */
	private void configActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bookshelf_header_bg));
		// actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
		// ActionBar.DISPLAY_SHOW_HOME
		// | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_CUSTOM
		// | ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO);
		// ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
		// ActionBar.LayoutParams.MATCH_PARENT,
		// ActionBar.LayoutParams.MATCH_PARENT);
		// View actionBarView = View.inflate(this, R.layout.custom_actionbar,
		// null);
		// actionBar.setCustomView(actionBarView, layoutParams);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayHomeAsUpEnabled(false);
	}

	/**
	 * Configure the sliding menu
	 */
	private void configSlidingMenu() {
		SlidingMenu sliding = getSlidingMenu();
		sliding.setMode(SlidingMenu.LEFT);
		sliding.setFadeDegree(0.35f);
		sliding.setBehindOffsetRes(R.dimen.sliding_behind_offset);
		sliding.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sliding.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
		/**
		 * Callback to be invoked when the sliding menu is Opened and previous
		 * state of sliding menu status is closed.
		 */
		sliding.setOnOpenListener(new SlidingMenu.OnOpenListener() {

			@Override
			public void onOpen() {
				Toast.makeText(Home.this, "Sliding Menu is Open", Toast.LENGTH_LONG).show();
			}
		});
		/**
		 * Callback to be invoked when the sliding menu is Closed and previous
		 * state of sliding menu status is opened.
		 */
		sliding.setOnCloseListener(new SlidingMenu.OnCloseListener() {

			@Override
			public void onClose() {
				Toast.makeText(Home.this, "Sliding Menu is Close", Toast.LENGTH_LONG).show();
			}
		});
		/**
		 * Callback to be invoked when the sliding menu is Opened no mater what
		 * the previous state of sliding menu is.
		 */
		sliding.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {

			@Override
			public void onOpened() {
				// Toast.makeText(Home.this, "Sliding Menu is Opened",
				// Toast.LENGTH_LONG)
				// .show();
			}
		});
		/**
		 * Callback to be invoked when the sliding menu is Opened no mater what
		 * the previous state of sliding menu is.
		 */
		sliding.setOnClosedListener(new SlidingMenu.OnClosedListener() {

			@Override
			public void onClosed() {
				// Toast.makeText(Home.this, "Sliding Menu is Closed",
				// Toast.LENGTH_LONG)
				// .show();
			}
		});
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
	}
}