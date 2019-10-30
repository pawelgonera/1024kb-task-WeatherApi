package pl._1024kb.weatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl._1024kb.weatherapi.model.Data;
import pl._1024kb.weatherapi.service.FileService;
import pl._1024kb.weatherapi.service.ScheduledService;

import java.io.IOException;

@Controller
public class WeatherController
{
    private ScheduledService scheduledService;
    private FileService fileService;

    @Autowired
    WeatherController(FileService fileService, ScheduledService scheduledService) {
        this.fileService = fileService;
        this.scheduledService = scheduledService;
    }

    @RequestMapping("/")
    public String home()
    {
        fileService.clearFile();
        return "home";
    }

    @PostMapping("/search")
    public String getWeather(Model model, @RequestParam String city) {
        ResponseEntity<Data> entity = scheduledService.saveData(city);
        model.addAttribute("data", entity.getBody());
        return "weather";
    }


}