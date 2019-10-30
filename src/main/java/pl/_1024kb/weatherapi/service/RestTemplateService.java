package pl._1024kb.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl._1024kb.weatherapi.model.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.TimeZone;

@Service
public class RestTemplateService
{
    @Value("${resource.weather}")
    private String API_URI;
    @Value("${api.key}")
    private String API_KEY;
    private static final String DELIMITER = " | ";
    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private RestTemplate restTemplate;

    @Autowired
    public RestTemplateService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Data> getWeatherData(String city)
    {
        return restTemplate.getForEntity(String.format(API_URI, city, API_KEY), Data.class);
    }

    public String constructTitleResult(ResponseEntity<Data> entity)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(Objects.requireNonNull(entity.getBody()).getName()).append(DELIMITER)
                .append(convertTimeUnix(entity.getBody().getSys().getSunrise())).append(DELIMITER)
                .append(convertTimeUnix(entity.getBody().getSys().getSunset())).append(System.lineSeparator());

        return sb.toString();
    }

    public String constructRecordResult(ResponseEntity<Data> entity)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(convertTimeUnix(Objects.requireNonNull(entity.getBody()).getDt())).append(DELIMITER)
                .append(entity.getBody().getMain().getTemp()).append(DELIMITER)
                .append(entity.getBody().getMain().getHumidity()).append(DELIMITER)
                .append(entity.getBody().getMain().getPressure()).append(DELIMITER)
                .append(entity.getBody().getWind().getSpeed()).append(System.lineSeparator());

        return sb.toString();
    }

    private LocalDateTime convertTimeUnix(Long unixTime)
    {
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(unixTime*1000), TimeZone.getDefault().toZoneId());
        //LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(unixTime), ZoneId.systemDefault());
        //LocalDateTime date = Instant.ofEpochMilli(unixTime)
                        //.atZone(ZoneId.systemDefault())
                        //.toLocalDateTime();

        String formatDateTime = date.format(FORMATTER);

        return LocalDateTime.parse(formatDateTime, FORMATTER);
    }
}
