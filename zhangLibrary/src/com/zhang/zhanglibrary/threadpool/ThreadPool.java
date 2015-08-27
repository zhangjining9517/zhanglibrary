package com.zhang.zhanglibrary.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的工具类
 * 
 * @author zhang
 * 
 */
public class ThreadPool {

	/** 根据cpu的任务数来确定线程池的尺寸 */
	private static final int THREAD_SIZE = Runtime.getRuntime().availableProcessors() * 3 + 2;

	private static ThreadPool m_ThreadPool;

	private static Object object = new Object();

	private static ExecutorService m_ExecutorService;

	private ThreadPool() {
		m_ExecutorService = Executors.newFixedThreadPool(THREAD_SIZE);
	}

	public static ThreadPool newInstance() {
		synchronized (object) {
			if (m_ThreadPool == null) {
				m_ThreadPool = new ThreadPool();
			}
			return m_ThreadPool;
		}
	}

	/**
	 * 线程池执行的方法
	 * 
	 * @param runnable
	 */
	public static void execute(Runnable runnable) {
		m_ExecutorService.execute(runnable);
	}

}
