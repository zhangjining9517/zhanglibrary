package com.zhang.zhanglibrary;


import com.zhang.zhanglibrary.util.AsyncImageLoader;
import com.zhang.zhanglibrary.util.AsyncImageLoader.ImageCallback;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity);
		loadImage("http://www.baidu.com/img/baidu_logo.gif", R.id.imageview1);
		loadImage("http://www.baidu.com/img/baidu_logo.gif", R.id.imageview2);
		loadImage("http://cache.soso.com/30d/img/web/logo.gif", R.id.imageview3);
		loadImage("http://csdnimg.cn/www/images/csdnindex_logo.gif",
				R.id.imageview4);
		loadImage("http://images.cnblogs.com/logo_small.gif", R.id.imageview5);
	}

	AsyncImageLoader asyncImageLoader = new AsyncImageLoader();

	@SuppressWarnings("static-access")
	private void loadImage(final String url, final int id) {
		// TODO Auto-generated method stub

		Drawable d = asyncImageLoader.loadImageCache(url, new ImageCallback() {

			@Override
			public void iamgeLoaded(Drawable drawable) {
				// TODO Auto-generated method stub

				((ImageView) TestActivity.this.findViewById(id))
						.setImageDrawable(drawable);
			}
		});

		if (d != null) {

			((ImageView) TestActivity.this.findViewById(id))
					.setImageDrawable(d);
		}

		// ThreadPool.newInstance().execute(new Runnable() {
		//
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// Log.i("test", "Thread TasKID =" + getTaskId() +" ");
		// Drawable drawable = null;
		// try {
		// drawable = Drawable.createFromStream(
		// new URL(string).openStream(), "image.gif");
		// if (drawable == null) {
		// Log.d("test", "null drawable");
		// } else {
		// Log.d("test", "not null drawable");
		// }
		// // 为了测试缓存而模拟的网络延时
		// SystemClock.sleep(2000);
		// Message msg = Message.obtain();
		// msg.arg1 = id;
		// msg.obj = drawable;
		// handler.sendMessage(msg);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		// }
		// });

	}

}
