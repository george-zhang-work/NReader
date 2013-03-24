package com.nreader.bookshelf;

import com.nreader.R;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class BookshelfViewAdapter extends BaseAdapter {
	private static final String TAG = "BookshelfViewAdapter";
	/**
	 * The default maximum number of books in every layer. It's should be an
	 * positive value.
	 */
	public static final int DEFAULT_LAYER_MAX_BOOKS_NUMBER = 3;

	/**
	 * The maximum number of books in every layer.
	 */
	private int mLayerMaxBooksNumber = DEFAULT_LAYER_MAX_BOOKS_NUMBER;

	private Context mContext;
	private BooksCovers mBooksCovers;

	public BookshelfViewAdapter(Context context, BooksCovers booksCovers) {
		mContext = context;
		mBooksCovers = booksCovers;
	}

	/**
	 * To set the layer's maximum books count.
	 * 
	 * @param layerMaxBooksCount
	 */
	public void setLayerMaxBookCount(int layerMaxBooksCount) {
		if (layerMaxBooksCount <= 0) {
			Log.e(TAG,
					"in setLayerMaxBookCount(layerMaxBookCount), and layerMaxBookCount should an positive integer.");
		} else if (layerMaxBooksCount != mLayerMaxBooksNumber) {
			mLayerMaxBooksNumber = layerMaxBooksCount;
			notifyDataSetChanged();
		}
	}

	/**
	 * This method is used to get the layer count. Invoke
	 * 
	 * @see {@link #getLayerCount()}
	 * @see {{@link #getBooksCount()}
	 */
	@Override
	public int getCount() {
		return (mBooksCovers.size() + mLayerMaxBooksNumber - 1) / mLayerMaxBooksNumber;
	}

	/**
	 * @return the total displayed books count.
	 */
	public int getBooksCount() {
		return mBooksCovers.size();
	}

	/**
	 * Return the layer count.
	 */
	public int getLayerCount() {
		return getCount();
	}

	@Override
	public Object getItem(int position) {
		return mBooksCovers;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.bookself_layer, null);
		}
		return convertView;
	}
}
