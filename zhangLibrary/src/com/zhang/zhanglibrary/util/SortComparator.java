package com.zhang.zhanglibrary.util;

import java.util.Comparator;

import com.zhang.zhanglibrary.entity.BaseObject;

public class SortComparator implements Comparator<BaseObject> {

	// @Override
	// public int compare(Object o1, Object o2) {
	// // // TODO Auto-generated method stub
	// // BaseObject baseObject = (BaseObject) o1;
	// // BaseObject baseObject2 = (BaseObject) o2;
	// return baseObject2.id - baseObject.id;
	// }

	@Override
	public int compare(BaseObject o1, BaseObject o2) {
		// TODO Auto-generated method stub
		return o1.id - o2.id;
	}

}
