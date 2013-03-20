/*
 * Copyright (C) 2012 The Android Open Source Project Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed
 * to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the
 * License.
 */

package com.nreader.cache;

import android.os.Build;

/**
 * Class containing some static utility methods.
 */
public class Utils {
	private Utils() {
	};

	/**
	 * Can use static final constants like FROYO, declared in later versions of the OS
	 * since they are inlined at compile time. This is guaranteed behavior.
	 */
	public static boolean hasFroyo() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
	}

	/**
	 * Can use static final constants like GINGERBREAD, declared in later versions of the
	 * OS since they are inlined at compile time. This is guaranteed behavior.
	 */
	public static boolean hasGingerbread() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
	}

	/**
	 * Can use static final constants like HONEYCOMB, declared in later versions of the OS
	 * since they are inlined at compile time. This is guaranteed behavior.
	 */
	public static boolean hasHoneycomb() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}

	/**
	 * Can use static final constants like HONEYCOMB_MR1, declared in later versions of
	 * the OS since they are inlined at compile time. This is guaranteed behavior.
	 */
	public static boolean hasHoneycombMR1() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
	}

	/**
	 * Can use static final constants like JELLY_BEAN, declared in later versions of the
	 * OS since they are inlined at compile time. This is guaranteed behavior.
	 */
	public static boolean hasJellyBean() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
	}
}
