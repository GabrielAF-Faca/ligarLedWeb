package com.example.demo.model;

public class Arduino {
    private ControlePorta arduino;

    public Arduino(){
        arduino = new ControlePorta("COM3",9600);//Windows - porta e taxa de transmissão
        //arduino = new ControlePorta("/dev/ttyUSB0",9600);//Linux - porta e taxa de transmissão
    }

    public void ligarLed() {
        System.out.println("Ligando LED");
        arduino.enviaDados(1);
    }

    public void desligarLed() {
        System.out.println("Desligando LED");
        arduino.enviaDados(2);
    }

}
