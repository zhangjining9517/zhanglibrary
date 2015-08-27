package com.zhang.zhanglibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class StrandarView extends View {

	public StrandarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int width = getMeasureLength(widthMeasureSpec, true);
		int height = getMeasureLength(heightMeasureSpec, false);
		setMeasuredDimension(width, height);
	}

	/**
	 * 标准测距方法写发
	 * 
	 * @param measureSpec
	 * @param isWidth
	 * @return
	 */
	private int getMeasureLength(int measureSpec, boolean isWidth) {
		// TODO Auto-generated method stub
		int measureMode = MeasureSpec.getMode(measureSpec);
		int measureSize = MeasureSpec.getSize(measureSpec);
		int size = 0;
		int padding = isWidth ? getPaddingLeft() + getPaddingRight()
				: getPaddingTop() + getPaddingBottom();
		if (measureMode == MeasureSpec.EXACTLY) {
			size = measureSize;
		} else {
			// 计算自适应的尺寸
			size = padding + 800;
			if (measureMode == MeasureSpec.AT_MOST) {
				// 取最小值
				size = Math.min(size, measureSpec);
			}
		}
		return size;
	}

}
