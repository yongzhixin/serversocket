package com.yongzhixin.serversocket;

import java.util.Vector;

public class ChatManager {
	private static volatile ChatManager chatManager = null;
	private Vector<ChatSocket> vector = new Vector<ChatSocket>();

	private ChatManager() {

	}

	public static ChatManager getChatManager() {
		if (chatManager == null) {
			synchronized (ChatManager.class) {
				if (chatManager == null) {
					chatManager = new ChatManager();
				}
			}
		}
		return chatManager;
	}

	public void add(ChatSocket cs) {
		vector.add(cs);
	}

	public void publish(ChatSocket cs, String msg) {
		for (ChatSocket c : vector) {
			if (!cs.equals(c)) {
				c.out(msg);
			}
		}
	}
}
