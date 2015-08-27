package com.zhang.zhanglibrary.receiver;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * 需要配置文件添加对应权限 <uses-permission android:name="android.permission.RECEIVE_SMS"/>
 * <!-- 注册Receiver,并且设置优先级 --> <receiver
 * android:name=".AutoMsgBroadCastReceiver" android:exported="false">
 * <intent-filter android:priority="1000"> <action
 * android:name="android.provider.Telephony.SMS_RECEIVED"/> </intent-filter>
 * </receiver> 类名：AutoMsgBroadCastReceiver 说明: 自动接收短信的广播
 * 
 * @author zjn
 */
public class AutoMsgBroadCastReceiver extends BroadcastReceiver {

	// 广播消息类型
	public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if (SMS_RECEIVED_ACTION.equals(action)) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Object[] objects = (Object[]) bundle.get("pdus");
				// 解析短信
				SmsMessage[] smsMessages = new SmsMessage[objects.length];
				for (int i = 0; i < smsMessages.length; i++) {
					byte[] pdu = (byte[]) objects[i];
					smsMessages[i] = SmsMessage.createFromPdu(pdu);
				}
				// 解析完内容分析具体参数
				for (SmsMessage sms : smsMessages) {
					String smsContent = sms.getMessageBody();
					// 获取发送人
					String sender = sms.getOriginatingAddress();
					// 获取发送日期
					Date date = new Date(sms.getTimestampMillis());
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String sendTime = sdf.format(date);
					if ("电话号码".equals(sender)) {// 编写处理

					}
				}
			}
		}

	}

}
