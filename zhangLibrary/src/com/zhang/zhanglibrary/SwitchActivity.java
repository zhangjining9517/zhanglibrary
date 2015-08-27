package com.zhang.zhanglibrary;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

import com.zhang.zhanglibrary.customview.switchs.CheckSwitchButton;
import com.zhang.zhanglibrary.customview.switchs.SlideSwitchView;
import com.zhang.zhanglibrary.customview.switchs.SlideSwitchView.OnSwitchChangedListener;

/**
 * 
 * 类名：SwitchActivity 说明: 自定义开关的activity
 * 
 * @author zjn
 */
public class SwitchActivity extends Activity {
	private ToggleButton mTogBtn;
	private CheckSwitchButton mCheckSwithcButton;
	private CheckSwitchButton mEnableCheckSwithcButton;
	private SlideSwitchView mSlideSwitchView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}

	private void initView() {
		mTogBtn = (ToggleButton) findViewById(R.id.mTogBtn); // 获取到控件
		mTogBtn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					// 选中
				} else {
					// 未选中
				}
			}
		});// 添加监听事件
		mCheckSwithcButton = (CheckSwitchButton) findViewById(R.id.mCheckSwithcButton);
		mEnableCheckSwithcButton = (CheckSwitchButton) findViewById(R.id.mEnableCheckSwithcButton);
		mCheckSwithcButton.setChecked(false);
		mCheckSwithcButton
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked) {
							mEnableCheckSwithcButton.setEnabled(false);
							mSlideSwitchView.setEnabled(false);
						} else {
							mEnableCheckSwithcButton.setEnabled(true);
							mSlideSwitchView.setEnabled(true);
						}
					}
				});
		mSlideSwitchView = (SlideSwitchView) findViewById(R.id.mSlideSwitchView);
		mSlideSwitchView.setOnChangeListener(new OnSwitchChangedListener() {

			@Override
			public void onSwitchChange(SlideSwitchView switchView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {

				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
