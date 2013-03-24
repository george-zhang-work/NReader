package com.nreader.bookshelf;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class BookshelfView extends ListView {

	public BookshelfView(Context context) {
		super(context);
	}
	
	public static class LayerView extends RelativeLayout {

		public LayerView(Context context) {
			super(context);
		}

	}

	public static class CoverView extends RelativeLayout {

		public CoverView(Context context) {
			super(context);

		}

	}
}
