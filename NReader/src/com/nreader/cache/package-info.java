package com.nreader.cache;

import java.io.File;

class CacheInfo {
	/**
	 * The cache root name. For a concrete application, it should be the application name.
	 * Here is nreader.
	 */
	static final String CACHE_ROOT_NAME = "cache";

	String mCacheDirName = null;

	/**
	 * The default bitmap cache size is 4Mib.
	 */
	static final int BITMAP_CACHE_SIZE = 4 * 1024 * 1024;

	/**
	 * To get the external directory name.
	 * 
	 * @param context the application context.
	 * @return the app external storage place, or null if there's no external storage
	 *         place.
	 */
	static String getAppExternalDirName(android.content.Context context) {
		if (context != null) {
			File dir = context.getExternalCacheDir();
			if (null != dir) {
				return dir.getPath() + File.separator + CACHE_ROOT_NAME;
			}
		}
		return null;
	}

	/**
	 * The interface should be implemented for every kind cache.
	 */
	interface CacheMethodInterface {
		/**
		 * To get the stored key for a given object. This is required, because different
		 * user maybe owns different values, but they have the same obj.
		 * 
		 * @param obj the original object.
		 * @return the key of this object.
		 */
		public abstract java.lang.Object getCacheKey(java.lang.Object obj);
	}
}