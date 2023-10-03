package com.example.demo.controller;

import com.example.demo.model.Arduino;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/led")
public class LedController {

    Arduino arduino = new Arduino();

    @GetMapping(path="/ligar")
    public String ligar() {
        arduino.ligarLed();
        return "ligado";
    }

    @GetMapping(path="/desligar")
    public String desligar() {
        arduino.desligarLed();
        return "desligado";
    }

}
