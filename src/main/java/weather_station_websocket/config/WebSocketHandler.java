package weather_station_websocket.config;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.*;

public class WebSocketHandler extends AbstractWebSocketHandler {
    Set<WebSocketSession> sessionList = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessionList.add(session);
        session.sendMessage(new TextMessage("hello user"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("New Text Message Received");
        System.out.println(message);
        for (WebSocketSession thisSession : sessionList) {
            if (!session.getId().equals(thisSession.getId())) {
                thisSession.sendMessage(message);
            }
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        System.out.println("New Binary Message Received");
        session.sendMessage(message);
        for (WebSocketSession thisSession : sessionList) {
            if (!session.getId().equals(thisSession.getId())) {
                thisSession.sendMessage(message);
            }
        }
    }
}
