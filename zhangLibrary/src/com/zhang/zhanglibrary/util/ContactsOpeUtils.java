package com.zhang.zhanglibrary.util;

import java.util.ArrayList;
import java.util.List;

import com.zhang.zhanglibrary.entity.Contact;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;

/**
 * 
 * 类名：ContactsOpeUtils 说明: 手机联系人操作的工具类
 * 
 * @author zjn
 */
public class ContactsOpeUtils {

	/**
	 * 获取手机联系人
	 * 
	 * @param ctx
	 */
	public void getPhoneContacts(Context ctx) {
		ContentResolver cr = ctx.getContentResolver();

		// 取得电话本中开始一项的光标

		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
				null, null, null);
		List<Contact> list = new ArrayList<Contact>();
		Contact contact = null;
		// 向下移动一下光标

		while (cursor.moveToNext()) {
			contact = new Contact();
			// 取得联系人名字
			int nameFieldColumnIndex = cursor
					.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			contact.contactName = cursor.getString(nameFieldColumnIndex);
			// 取得电话号码
			int numberFieldColumnIndex = cursor
					.getColumnIndex(PhoneLookup.NUMBER);// 报错，返回值为-1.
			contact.contactNumber = cursor.getString(numberFieldColumnIndex);
			list.add(contact);
		}
		cursor.close();
	}
}
