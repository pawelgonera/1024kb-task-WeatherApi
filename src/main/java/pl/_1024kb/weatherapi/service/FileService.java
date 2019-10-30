package pl._1024kb.weatherapi.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;

@Service
public class FileService
{
    private static File FILE = new File("/data.txt");

    public void saveWeather(String result){
        try (OutputStream out = Files.newOutputStream(FILE.toPath()))
        {
            out.write(result.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void clearFile()
    {
        try (OutputStream out = Files.newOutputStream(FILE.toPath()))
        {
            out.write("".getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}