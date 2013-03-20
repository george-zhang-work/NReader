package com.nreader.cache;

import java.io.File;

import com.nreader.cache.CacheInfo.CacheMethodInterface;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class BitmapCache extends LruCache<String, Bitmap> implements CacheMethodInterface {

	public static final String BITMAP_CACHE_NAME = "bitmap";

	private BitmapCache instance;

	private File mBitmapDir;

	public BitmapCache getInstance(Context context) {
		if (instance == null) {
			instance = new BitmapCache(context);
		}
		return instance;
	}

	private BitmapCache(Context context) {
		super(CacheInfo.BITMAP_CACHE_SIZE);
		String dirName = CacheInfo.getAppExternalDirName(context);
		if (null != dirName) {
			mBitmapDir = new File(dirName + File.separator + BITMAP_CACHE_NAME);
			if (!mBitmapDir.exists()) {
				if (!mBitmapDir.mkdirs()) {
					mBitmapDir = null;
				}
			}
		}
	}

	@Override
	protected int sizeOf(String key, Bitmap value) {
		if (null != value) {
			return getByteCount(value);
		}
		return super.sizeOf(key, value);
	}

	/**
	 * Called to get the bitmap size. This method should be called, because the
	 * {@link Bitmap#getByteCount()} requires API level 12. They have the same
	 * implementation.
	 * 
	 * @param bm the bitmap to get its size.
	 * @return the bm's bytes count, or zero if bm equals null.
	 */
	public int getByteCount(Bitmap bm) {
		if (null != bm) {
			return bm.getRowBytes() * bm.getHeight();
		}
		return 0;
	}

	@Override
	public Object getCacheKey(Object obj) {
		return null;
	}
}
