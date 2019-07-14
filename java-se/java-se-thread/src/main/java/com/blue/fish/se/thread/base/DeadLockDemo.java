package com.blue.fish.se.thread.base;

public class DeadLockDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Test(true));
		Thread t2 = new Thread(new Test(false));
		t1.start();
		t2.start();
	}

	static class Test implements Runnable{
		private boolean flag;
		public Test(boolean flag){
			this.flag = flag;
		}
		@Override
		public void run() {
			if(flag){
				synchronized(MyLock.obj1){
					System.out.println("if obj1");
					synchronized(MyLock.obj2){
						System.out.println("if obj2");
					}
				}
			}else{
				synchronized(MyLock.obj2){
					System.out.println("else obj2");
					synchronized(MyLock.obj1){
						System.out.println("else obj1");
					}
				}
			}
		}
	}

	static class MyLock{
		static Object obj1 = new Object();
		static Object obj2 = new Object();
	}
}

