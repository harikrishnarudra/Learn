package com.practice.hackerrank.firstMock;


import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


class Record{
    private String Title;
    private int year;
    private String imdbID;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}

class Response{
    int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_Pages() {
        return total_Pages;
    }

    public void setTotal_Pages(int total_Pages) {
        this.total_Pages = total_Pages;
    }

    public List<Record> getData() {
        return data;
    }

    public void setData(List<Record> data) {
        this.data = data;
    }

    int per_page;
    int total;
    int total_Pages;
    List<Record> data;
}

public class RestAPIGetMovies {

    /*
     * Complete the 'getMovies' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER year
     *  2. STRING query
     */

    public static List<List<String>> getMovies(int year, String query) {
        List<List<String>> results = new ArrayList<>();
        try {
//            String reqUrl = "https://jsonmock.hackerrank.com/api/movies?Year=%d&page=<pageNumber>";
            String format = String.format("https://jsonmock.hackerrank.com/api/movies?Year=%d&page=%d", year, 1);

            URL url = new URL(format);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("accept", "application/json");

            InputStream responseStream = connection.getInputStream();

            ObjectMapper mapper = new ObjectMapper();

            Response response = mapper.readValue(responseStream, Response.class);


            int total_pages = 1;
            if(response!=null){
                total_pages = response.getTotal_Pages();
                List<Record> data = response.getData();
                results = processData(data, query, results);
            }
            for(int i=2;i<=total_pages;i++){
                format = String.format("https://jsonmock.hackerrank.com/api/movies?Year=%d&page=%d", year, i);
                url = new URL(format);

                connection = (HttpURLConnection) url.openConnection();

                connection.setRequestProperty("accept", "application/json");

                responseStream = connection.getInputStream();

                mapper = new ObjectMapper();

//                Response response = mapper.readValue(responseStream, Response.class);
            }



        }catch (IOException ioException){
            ioException.printStackTrace();
        }

        return results;

    }

    public static List<List<String>> processData(List<Record> records, final String query, List<List<String>> results){
        boolean startsWith = query.startsWith("*");
        boolean endsWith = query.endsWith("*");
        boolean both = startsWith && endsWith;
        List<String> resultList = new ArrayList<>();

        for(int i=0;i<records.size(); i++){
            Record record = records.get(i);
            String title = record.getTitle();
            if(both && title.contains(query)){
                resultList.add(record.getImdbID());
                resultList.add(title);
            }
            else if(startsWith && title.startsWith(query)){
                resultList.add(record.getImdbID());
                resultList.add(title);

            } else if (endsWith && title.endsWith(query)) {
                resultList.add(record.getImdbID());
                resultList.add(title);
            }
            results.add(resultList);
        }
        return results;
    }

}
