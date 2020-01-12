package weather_station_websocket.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Humidity {
    private long id;
    private String device;
    private String dataTime;
    private Double value;
}
