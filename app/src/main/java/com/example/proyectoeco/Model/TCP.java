package com.example.proyectoeco.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP extends Thread {

    //Singleton
    private static TCP unicaInstancia;

    private TCP(){}
    //Singleton

    public static TCP getInstance(){
        if(unicaInstancia == null){
            unicaInstancia = new TCP();

        }
        return unicaInstancia;
    }

    //Atributos

    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;

    @Override
    public void run() {
        super.run();
        try {
            //2. Servidor intentando conectar
            socket = new Socket("192.168.39.156",5000);
            System.out.println("Cliente conectado");
            //3. Conectados
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            writer = new BufferedWriter(osw);
            InputStream is = socket.getInputStream();
            InputStreamReader isw = new InputStreamReader(is);
            reader = new BufferedReader(isw);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Message
    public void Message(String msg) {
        new Thread(
                () -> {
                    try {
                        writer.write(msg + "\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

}
