package com.zhang.zhanglibrary.util;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.zhang.zhanglibrary.threadpool.ThreadPool;

import android.graphics.drawable.Drawable;
import android.os.Handler;

/**
 * 异步图片加载类
 * 
 * @author zhang
 * 
 */
public class AsyncImageLoader {
	public Map<String, SoftReference<Drawable>> map = new HashMap<String, SoftReference<Drawable>>();

	public Handler handler = new Handler();

	/**
	 * 从网上获取图片
	 * 
	 * @param url
	 * @return
	 */
	public Drawable loadImageFromUrl(String url) {
		Drawable drawable = null;
		try {
			drawable = Drawable.createFromStream(new URL(url).openStream(),
					"image.gif");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return drawable;

	}

	/**
	 * 从缓存加载图片
	 * 
	 * @param url
	 * @param imageCallback
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Drawable loadImageCache(final String url,
			final ImageCallback imageCallback) {
		if (map.containsKey(url)) {
			SoftReference<Drawable> reference = map.get(url);

			if (reference.get() != null) {
				return reference.get();
			}
		}
		// 如果缓存没有，从网上获取
		ThreadPool.newInstance().execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				final Drawable drawable = loadImageFromUrl(url);
				map.put(url, new SoftReference<Drawable>(drawable));
				handler.post(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						imageCallback.iamgeLoaded(drawable);
					}
				});

			}
		});
		return null;
	}

	public interface ImageCallback {
		public void iamgeLoaded(Drawable drawable);
	}

}
