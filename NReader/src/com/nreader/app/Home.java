package com.nreader.app;

import android.os.Bundle;
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

		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayHomeAsUpEnabled(false);
	}

	private void configSlidingMenu() {
		SlidingMenu sliding = getSlidingMenu();
		sliding.setMode(SlidingMenu.LEFT);
		sliding.setFadeDegree(0.35f);
		sliding.setBehindOffsetRes(R.dimen.sliding_behind_offset);
		sliding.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sliding.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
		/**
		 * Callback to be invoked when the slidingmenu is Opened and previous state of
		 * sliding menu status is closed.
		 */
		sliding.setOnOpenListener(new SlidingMenu.OnOpenListener() {

			@Override
			public void onOpen() {
				Toast.makeText(Home.this, "Sliding Menu is Open", Toast.LENGTH_LONG)
						.show();
			}
		});
		/**
		 * Callback to be invoked when the slidingmenu is Closed and previous state of
		 * sliding menu status is opened.
		 */
		sliding.setOnCloseListener(new SlidingMenu.OnCloseListener() {

			@Override
			public void onClose() {
				Toast.makeText(Home.this, "Sliding Menu is Close", Toast.LENGTH_LONG)
						.show();
			}
		});
		/**
		 * Callback to be invoked when the slidingmenu is Opened nomater whate the
		 * previous state of sliding menu is.
		 */
		sliding.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {

			@Override
			public void onOpened() {
				// Toast.makeText(Home.this, "Sliding Menu is Opened", Toast.LENGTH_LONG)
				// .show();
			}
		});
		/**
		 * Callback to be invoked when the slidingmenu is Opened nomater whate the
		 * previous state of sliding menu is.
		 */
		sliding.setOnClosedListener(new SlidingMenu.OnClosedListener() {

			@Override
			public void onClosed() {
				// Toast.makeText(Home.this, "Sliding Menu is Closed", Toast.LENGTH_LONG)
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