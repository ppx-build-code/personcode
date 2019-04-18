package com.dyu.frame.protocol;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author dyu 2019.04.17
 */
public class TalkHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);

        System.out.println(message);
        session.sendMessage(new TextMessage(("fuck you bitch --> " + session.getId()).getBytes()));
        Thread.sleep(5000);
        session.sendMessage(new TextMessage("this is next message..."));

    }
}
