package com.yongzhixin.serversocket;


public class MyServerSocket {

	public static void main(String[] args) {
		new Thread(new ServerListener()).start();
	}

}
