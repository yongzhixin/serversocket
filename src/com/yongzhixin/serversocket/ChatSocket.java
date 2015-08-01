package com.yongzhixin.serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	private Socket socket;

	public ChatSocket(Socket socket) {
		this.socket = socket;
	}

	public void out(String out) {
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
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream(), "UTF-8"));
			String line=null;
			while((line=br.readLine())!=null){
				ChatManager.getChatManager().publish(this, line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
