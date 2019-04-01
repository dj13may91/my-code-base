package Competitive_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MakeRestCalls {

    private String GET_URL = "https://http-hunt.thoughtworks-labs.net/challenge/input";
    private String POST_URL = "https://http-hunt.thoughtworks-labs.net/challenge/output";

    private String header = "userId";
    private String header_key = "hrA4y5VDM";
    private String contentType = "application/json";

    public static void main(String[] args) throws IOException {
        MakeRestCalls calls = new MakeRestCalls();
        calls.makeGetRequest();
    }

    public void makeGetRequest() throws IOException {
        URL obj = new URL(GET_URL);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty(header, header_key);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + GET_URL);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());


    }

    public void makePostRequest() {

    }
}
