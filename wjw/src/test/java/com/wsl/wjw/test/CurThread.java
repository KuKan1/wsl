package com.wsl.wjw.test;

public class CurThread {

	public static void main(String[] args) {
		new Thread(new InnerThread()).start();
	}
	
}

class InnerThread implements Runnable {
	volatile int ct = 9;
	@Override
	public void run() {
		System.out.println("当前ct = "+ ct);
		while (true) {
			System.out.println("ct = "+ct);
			ct--;
			if(ct == 2){
				System.out.println("ct = 2");
				return;
			}
		/*	if(ct == 5){
				System.out.println("ct = 5");
				break;
			}*/
			
			System.out.println("当前ct = "+ ct);
		}
	}
	
}

