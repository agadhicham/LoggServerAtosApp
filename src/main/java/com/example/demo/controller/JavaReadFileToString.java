package com.example.demo.controller;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class JavaReadFileToString
{
 
   @GetMapping(value="/dow")
    private static String readLineByLineJava8(@PathVariable String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        System.out.println(contentBuilder.toString());

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n")); System.out.println(contentBuilder.toString());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
 System.out.println(contentBuilder.toString());
        return contentBuilder.toString();
    }
}