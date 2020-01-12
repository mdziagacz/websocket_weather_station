package weather_station_websocket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {
    private long id;
    private String device;
    private String dataTime;
    private Double value;
}
