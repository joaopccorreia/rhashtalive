package com.livestream.rhastalive.websocketserver;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

@ServerEndpoint(value = "")
public class WebServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session.toString());
    }

    @OnMessage
    public void onMessage(Session session, byte[] img) {
        ByteBuffer buffer = ByteBuffer.wrap(img);

        try {
            session.getBasicRemote().sendBinary(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {

        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
