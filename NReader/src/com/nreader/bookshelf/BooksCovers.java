package com.nreader.bookshelf;

import java.util.ArrayList;

public class BooksCovers {
	private ArrayList<CoverEntry> mCovers;
	
	public BooksCovers() {
		mCovers = new ArrayList<BooksCovers.CoverEntry>();
	}

	public int size() {
		return 30;//mCovers.size();
	}

	/**
	 * The books cover entry.
	 */
	public static class CoverEntry {
		public String mCategory;
		public String mImageUrl;
		public String mBookName;
		public String mTagName;
		public String mAuthorName;
	}
}
