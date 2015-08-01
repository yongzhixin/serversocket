package com.yongzhixin.serversocket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket implements Runnable {
	private Socket socket;

	public ChatSocket(Socket socket) {
		this.socket = socket;
	}

	private void out(String out) {
		try {
			socket.getOutputStream().write(out.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			count++;
			out("loop:" + count);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
