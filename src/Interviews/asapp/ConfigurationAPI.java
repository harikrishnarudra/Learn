package Interviews.asapp;

import Interviews.amz.demo.Solution;

import java.util.ArrayList;
import java.util.List;

// Design an API to read a configuration file of host:port lines, parse them, and return the host and port round robin (ie, in a circular fashion)

// asapp.com:1234
// cnn.com:8080

// console.log(getEntry()); // asapp.com, 1234 
// console.log(getEntry()); // cnn.com, 8080
// console.log(getEntry()); // asapp.com, 1234



public class ConfigurationAPI {

    private static List<String> input = new ArrayList<>();

    private int lastReadValue = -1;

    public ConfigurationAPI(List<String> inp) {
        this.input = inp;
    }

    private void setLastReadValue(int lastReadValue) {
        this.lastReadValue = lastReadValue;
    }

    private int getLastReadValue() {
        return this.lastReadValue;
    }

    public Config getEntry() {
        int lastValue = this.getLastReadValue();
        if (input != null && !input.isEmpty()) {
            int newIndex = (lastValue + 1) % input.size();
            String str = input.get(newIndex);
            String[] ips = str.split(":");
            int port = Integer.parseInt(ips[1]);
              /*
              if(ips.length>2){
                int port = Integer.parseInt(ips[1]);
              }else{
                newIndex = (newIndex+1)%input.size();
              }*/
            setLastReadValue(newIndex);
            return new Config(ips[0], port);
        }
        return new Config();
    }


    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("asapp.com:1234");
        strings.add("bbc.com");
        strings.add("cnn.com:8080");
        strings.add("times.com:8080");
        strings.add("zoom.com:8080");
        strings.add("bbc.com:8080");

        ConfigurationAPI s = new ConfigurationAPI(strings);
        for (int i = 0; i < 6; i++) {
            Config c = s.getEntry();
            System.out.println(c.getHost() + ":" + c.getPort());
        }

    }

}

class Config {
    private String host;
    private int port;

    public Config() {
    }

    public Config(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return this.host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return this.port;
    }

}
