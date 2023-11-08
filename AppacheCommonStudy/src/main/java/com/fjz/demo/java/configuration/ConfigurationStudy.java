package com.fjz.demo.java.configuration;


import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class ConfigurationStudy {


    private void testJson() {
        InputStream is = ConfigurationStudy.class.getClassLoader().getResourceAsStream("test.json");

        try {
            System.out.println("test json");
            JSONConfiguration configuration = new JSONConfiguration();
            configuration.read(new InputStreamReader(is));
            int age = configuration.getInt("age");
            String name = configuration.getString("name");
            System.out.println("age = " + age);
            System.out.println("name = " + name);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void testIni() {
        InputStream is = ConfigurationStudy.class.getClassLoader().getResourceAsStream("test.ini");

        try {
            System.out.println("test ini");

            INIConfiguration configuration = new INIConfiguration();
            configuration.read(new InputStreamReader(is));
            int age = configuration.getInt("age");
            String name = configuration.getString("name");
            System.out.println("age = " + age);
            System.out.println("name = " + name);

        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void testProperty() {
        InputStream is = ConfigurationStudy.class.getClassLoader().getResourceAsStream("test.property");

        try {
            System.out.println("test property");

            PropertiesConfiguration configuration = new PropertiesConfiguration();
            configuration.read(new InputStreamReader(is));
            int age = configuration.getInt("age");
            String name = configuration.getString("name");
            System.out.println("age = " + age);
            System.out.println("name = " + name);

        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        // ConfigurationStudy study = new ConfigurationStudy();
        //
        // study.testJson();
        // study.testIni();
        // study.testProperty();

        // new ProcessTest().test();

        


    }

}