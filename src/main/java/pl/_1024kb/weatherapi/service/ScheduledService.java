package pl._1024kb.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl._1024kb.weatherapi.model.Data;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class ScheduledService
{
    private RestTemplateService restTemplateService;
    private FileService fileService;
    private List<String> weatherData;
    private String city = "Wroclaw";
    private ResponseEntity<Data> entity;

    @Autowired
    public ScheduledService(RestTemplateService restTemplateService, FileService fileService)
    {
        this.restTemplateService = restTemplateService;
        this.fileService = fileService;
        weatherData = new LinkedList<>();
    }

    public ResponseEntity<Data> saveData(String cityName){
        city = cityName;
        saveToFileWithDelay();
        return entity;
    }

    @Scheduled(fixedDelay = 5000)
    private void saveToFileWithDelay() {
        entity = restTemplateService.getWeatherData(city);
        String titleResult = restTemplateService.constructTitleResult(entity);
        String recordResult = restTemplateService.constructRecordResult(entity);
        weatherData.add(recordResult);
        fileService.saveWeather(titleResult + weatherData);
    }
}
