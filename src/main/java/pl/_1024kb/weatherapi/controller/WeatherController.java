package pl._1024kb.weatherapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController
{
    @RequestMapping("/")
    public String home()
    {
        return "home";
    }
}
