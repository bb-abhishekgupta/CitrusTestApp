package com.poc.citrusadtester.servicesImpl;

import com.google.gson.Gson;
import com.poc.citrusadtester.models.AdRequest;
import com.poc.citrusadtester.models.SvcResponse;
import com.poc.citrusadtester.services.CitrusAdRequestInterface;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class CitrusAdReqSvcImpl implements CitrusAdRequestInterface {

    @Override
    public SvcResponse requestAdCitrus(AdRequest adRequest) throws IOException {

        Gson gson = new Gson();
        String json = gson.toJson(adRequest);

        System.out.println("Input in string:" +json);

        URL url = new URL("https://staging-integration.citrusad.com/v1/ads/generate");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Basic sk_InMAAhL3Y1kD-AhRs5anX9VIYShiNDVkNjVhYi1iYjdhLTRhYTMtYThlMy1lZTc3Zjc2NmI0Mjk=");

        OutputStream os = con.getOutputStream();
        os.write(json.getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + con.getResponseMessage());

        SvcResponse svcResponse = new SvcResponse();
        svcResponse.setStatus(responseCode);
        svcResponse.setMessage(con.getResponseMessage());

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            svcResponse.setBody(response);
            System.out.println(response.toString());
        }
        con.disconnect();




        return svcResponse;
    }
}
