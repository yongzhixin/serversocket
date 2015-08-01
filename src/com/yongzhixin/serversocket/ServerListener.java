package com.yongzhixin.serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener implements Runnable {

	@SuppressWarnings("resource")
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			while (true) {
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "有客户端连接到了本机的8888端口...");
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
