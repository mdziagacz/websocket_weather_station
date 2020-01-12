package weather_station_websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import weather_station_websocket.domain.Temperature;

public class TemperatureController {

    @MessageMapping("/sendMeasurement")
    @SendTo("/device")
    public Temperature sendMeasurement(Temperature temperature){
        return temperature;
    }

}
