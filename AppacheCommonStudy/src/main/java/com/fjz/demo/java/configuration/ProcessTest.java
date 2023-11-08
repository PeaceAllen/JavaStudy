package com.fjz.demo.java.configuration;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessTest {


    public void test() {


        try {
            // String cmd = "ls";
            String cmd = "ffprobe country.mp3";
            Process process = Runtime.getRuntime().exec(cmd, null, new File("/Users/fengjz/Desktop/bg_music_processing"));

            // 有时候process.getInputStream()没有输出，但是process.getErrorStream()却有输出
            // BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));


            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }


            int exitCode = 0;
            try {
                exitCode = process.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("exit code = " + exitCode);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
