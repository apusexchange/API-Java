package com.apus.sdkjava.rest;

import com.apus.sdkjava.common.JsonFormat;
import com.apus.sdkjava.domain.response.ApusResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class RestService<REQ, RES extends ApusResponse> {
    private String url;

    public RestService(String url) {
        this.url = url;
    }

    public void post(final REQ request, final Class<RES> responseType, final ApusCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String charset = "UTF-8";
                    // Create the connection
                    HttpURLConnection connection;

                    connection = (HttpURLConnection) new URL(url).openConnection();

                    connection.setDoOutput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Accept-Charset", charset);
                    connection.setRequestProperty("Content-type", "application/json");
                    String content = JsonFormat.convertToJson(request);
                    OutputStream output = connection.getOutputStream();
                    output.write(content.getBytes(charset));
                    output.close();
                    if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        callback.onResponse(JsonFormat.convertToResponseError(connection.getResponseCode()));
                        return;
                    }
                    InputStream inputStream = connection.getErrorStream();
                    if (inputStream == null)
                        inputStream = connection.getInputStream();

                    BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream, charset));

                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = responseReader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    responseReader.close();
                    callback.onResponse(JsonFormat.convertToResponse(response.toString(), responseType));

                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onResponse(JsonFormat.convertToResponseError(404));

                }
            }
        }).start();

    }

    public void delete(final REQ request, final Class<RES> responseType, final ApusCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String charset = "UTF-8";
                    HttpURLConnection connection;

                    connection = (HttpURLConnection) new URL(url).openConnection();
                    String content = JsonFormat.convertToJson(request);

                    connection.setDoOutput(true);
                    connection.setRequestMethod("DELETE");
                    connection.setRequestProperty("Accept-Charset", charset);
                    connection.setRequestProperty("Content-type", "application/json");
                    connection.setRequestProperty("Content-Length", String.valueOf(content.getBytes(charset).length));
                    OutputStream output = connection.getOutputStream();
                    output.write(content.getBytes(charset));
                    output.close();
                    if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        callback.onResponse(JsonFormat.convertToResponseError(connection.getResponseCode()));
                        return;
                    }
                    InputStream inputStream = connection.getErrorStream();
                    if (inputStream == null)
                        inputStream = connection.getInputStream();

                    BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream, charset));

                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = responseReader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    responseReader.close();
                    callback.onResponse(JsonFormat.convertToResponse(response.toString(), responseType));

                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onResponse(JsonFormat.convertToResponseError(404));

                }
            }
        }).start();

    }


    private String convertToString(Map<String, String> params) {
        StringBuilder message = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (message.toString().equals("")) {
                message = new StringBuilder("?");
                message.append(entry.getKey()).append("=").append(entry.getValue());
            } else {
                message.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }

        }

        return message.toString();

    }

    public void get(final Map<String, String> params, final Class<RES> responseType, final ApusCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL obj = new URL(url+convertToString(params));
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("Accept-Charset", "UTF-8");
                    con.setRequestProperty("Content-type", "application/json");
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) { // success
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                con.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();

                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();

                        callback.onResponse(JsonFormat.convertToResponse(response.toString(), responseType));
                    } else {
                        callback.onResponse(JsonFormat.convertToResponseError(con.getResponseCode()));

                    }
                } catch (Exception e) {
                    callback.onResponse(JsonFormat.convertToResponseError(404));

                }


            }
        }).start();

    }


    public interface ApusCallback {
        void onResponse(ApusResponse apusResponse);
    }
}
