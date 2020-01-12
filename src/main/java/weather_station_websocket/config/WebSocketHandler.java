package weather_station_websocket.config;

import com.google.gson.Gson;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.*;

public class WebSocketHandler extends AbstractWebSocketHandler {
    List<String> messages = new ArrayList<>();
    Set<WebSocketSession> sessionList = new HashSet<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("New Text Message Received");
        System.out.println(message);
        sessionList.add(session);
        messages.add(message.getPayload());
        if(message.getPayload().equals("connecting")){
            session.sendMessage(new TextMessage("connected"));
        } else {
            for (WebSocketSession thisSession: sessionList) {
                if (!session.getId().equals(thisSession.getId())) {
                    thisSession.sendMessage(message);
                }
            }
        }
    }
    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        System.out.println("New Binary Message Received");
        session.sendMessage(message);
    }
}
