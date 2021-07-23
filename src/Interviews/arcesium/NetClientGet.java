package Interviews.arcesium;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Create a program to read Json objects and parse them. Create two object sets and calculate total value of holdings.
 */


public class NetClientGet {

    public String readEndPoint(String endpoint){
        String output = "";
        StringBuffer srb = new StringBuffer();
        try {

            //URL url = new URL("http://api.myjson.com/bins/1eleys");
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                srb.append(output);
                System.out.println(output);
            }
            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return srb.toString();

    }

    public List<Security> readHoldings(){
        List<Security> securities = null;
        try {
            String res = this.readEndPoint("http://api.myjson.com/bins/1eleys");
            System.out.println(res);

            Gson gson = new Gson();

            TypeToken<List<Security>> token = new TypeToken<List<Security>>() {};
            securities = gson.fromJson(res, token.getType());
            //Security security = gson.fromJson(res, Security.class);
            //System.out.println(securities);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return securities;
    }

    public List<SecurityPrice> readPrices(){
        List<SecurityPrice> securityPrices = null;
        try {
            String res = this.readEndPoint("http://api.myjson.com/bins/vf9ac");
            System.out.println(res);

            Gson gson = new Gson();

            TypeToken<List<SecurityPrice>> token = new TypeToken<List<SecurityPrice>>() {};
            securityPrices = gson.fromJson(res, token.getType());
            //Security security = gson.fromJson(res, Security.class);
            //System.out.println(securities);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return securityPrices;
    }

    public static double calculateHoldingValue(String date) {
        double totalValue = 0;
        try{
            List<Security> listOfSecs = new ArrayList<Security>();
            List<SecurityPrice> securityPrices = new ArrayList<SecurityPrice>();
            listOfSecs = new NetClientGet().readHoldings();
            securityPrices = new NetClientGet().readPrices();
            Map<String, Double> secPriceMap = new HashMap<String,Double>();
            for (SecurityPrice sec:securityPrices){
                if (date == sec.getDate()){
                    secPriceMap.put(sec.getSecurity(), sec.getPrice());
                }
            }

            for (Security sec:listOfSecs){
                if (date == sec.getDate()){
                    totalValue += sec.getQuantity()*secPriceMap.get(sec.getSecurity());
                }
            }

        }catch (Exception e) {

            e.printStackTrace();
        }
        return totalValue;
    }

    // http://localhost:8080/RESTfulExample/json/product/get
    public static void main(String[] args) {
        new NetClientGet().readHoldings();
    }

}

class Security{
    private String security;
    private int quantity;
    private String date;
    private String portfolio;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
class SecurityPrice{
    private String date;
    private String security;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;
}
