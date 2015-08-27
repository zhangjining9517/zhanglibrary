package com.zhang.zhanglibrary;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

/**
 * 
 * 类名：TextViewHtmlMultifyActivity 说明: 通过html 改变一行文本中的个别字体的样式
 * 
 * @author zjn
 */
public class TextViewHtmlMultifyActivity extends Activity_Base {
	TextView mTextView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textviewlink);

		mTextView = (TextView) findViewById(R.id.textView1);
		String source = "这只是一个测试，测试<u>下划线</u>、<i>斜体字</i>、<font color='red'>红色字</font>的格式";
		mTextView.setText(Html.fromHtml(source));
	}
}
