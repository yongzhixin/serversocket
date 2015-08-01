package com.yongzhixin.serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener implements Runnable {

	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			while (true) {
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "�пͻ������ӵ��˱�����8888�˿�...");
				new Thread(new ChatSocket(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
