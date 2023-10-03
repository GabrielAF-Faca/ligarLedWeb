package com.example.demo.model;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.OutputStream;

public class ControlePorta {
    private OutputStream serialOut;
    private int taxa;
    private String portaCOM;

    public ControlePorta(String portaCOM, int taxa) {
        this.portaCOM = portaCOM;
        this.taxa = taxa;
        this.initialize();
    }

    private void initialize() {
        try {
            //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
            CommPortIdentifier portId = null;
            try {
                portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);

            }catch (NoSuchPortException npe) {
                System.out.println("Porta COM não encontrada");
            }
            //Abre a porta COM
            SerialPort port = (SerialPort) portId.open("Comunicação serial", this.taxa);
            serialOut = port.getOutputStream();
            port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial
                    SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                    SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                    SerialPort.PARITY_NONE); //receber e enviar dados
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            serialOut.close();
        }catch (IOException e) {
            System.out.println("Não foi possível fechar a porta COM");
        }
    }


    public void enviaDados(int opcao){
        System.out.println("Enviando dado " + opcao);
        try {
            serialOut.write(opcao);
        } catch (IOException ex) {
            System.out.println("Não foi possível enviar dados");
        }
    }
}
