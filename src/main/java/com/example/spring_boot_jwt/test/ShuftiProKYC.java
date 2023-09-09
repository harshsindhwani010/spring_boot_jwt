package com.example.spring_boot_jwt.test;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ShuftiProKYC {
    public static void main(String[] args) throws Exception {
        String url = "https://api.shuftipro.com/";
        String CLIENT_ID = "A7aGih3n9PDlkhomHYQRFYjdHSSH35k0g3rvfFVtBhxgg9cYaZ1694088546";
        String SECRET_KEY = "bY8hSGn02p5bUSuOWpQ5PmLpLaF9BQVI";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // Add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString((CLIENT_ID + ":" + SECRET_KEY).getBytes(StandardCharsets.UTF_8));
        con.setRequestProperty("Authorization", basicAuth);

        String payload = "{\n    \"reference\": \"5667456341\",\n    \"callback_url\": \"http://www.example.com/\",\n    \"email\": \"johndoe@example.com\",\n    \"country\": \"GB\",\n    \"language\": \"EN\",\n    \"verification_mode\": \"any\",\n    \"ttl\": 60,\n    \"face\": {\n        \"proof\": \"\"\n    },\n    \"document\": {\n        \"proof\": \"\",\n        \"additional_proof\": \"\",\n        \"supported_types\": [\n            \"id_card\",\n            \"driving_license\",\n            \"passport\"\n        ],\n        \"name\": {\n            \"first_name\": \"John\",\n            \"middle_name\": \"Middleman\",\n            \"last_name\": \"Doe\"\n        },\n        \"dob\": \"1980-11-12\",\n        \"age\": 18,\n        \"issue_date\": \"1990-09-07\",\n        \"expiry_date\": \"2050-10-10\",\n        \"gender\": \"M\",\n        \"document_number\": \"0989-7752-6291-2387\",\n        \"allow_offline\": \"1\",\n        \"allow_online\": \"1\"\n    },\n    \"address\": {\n        \"proof\": \"\",\n        \"supported_types\": [\n            \"id_card\",\n            \"bank_statement\"\n        ],\n        \"name\": {\n            \"first_name\": \"John\",\n            \"middle_name\": \"Middleman\",\n            \"last_name\": \"Doe\"\n        },\n        \"full_address\": \"3339 Maryland Avenue, Largo, Florida\",\n        \"address_fuzzy_match\": \"1\",\n        \"issue_date\": \"1990-09-07\"\n    },\n    \"consent\": {\n        \"proof\": \"\",\n        \"supported_types\": [\n            \"handwritten\",\n            \"printed\"\n        ],\n        \"text\": \"My name is John Doe and I authorise this transaction of $100/- Date: July 15, 2020\",\n        \"allow_offline\": \"1\",\n        \"allow_online\": \"1\"\n    },\n    \"phone\": {\n        \"phone_number\": \"+4400000000\",\n        \"random_code\": \"23234\",\n        \"text\": \"Your verification code is 23234\"\n    },\n    \"background_checks\": {\n        \"name\": {\n            \"first_name\": \"John\",\n            \"middle_name\": \"Middleman\",\n            \"last_name\": \"Doe\"\n        },\n        \"dob\": \"1980-11-12\"\n    }\n}";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(payload);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Payload : " + payload);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        System.out.println(in.toString());
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Print the response
        System.out.println(response.toString());
    }
}
