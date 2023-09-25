package com.batov.vkbotmoney.Service;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ApiVkService {
    private String accessToken = "vk1.a.FhY0KHUCjlKUWApzlrQ0Q1sfljaAlnioUYVXF-LBsMIPWmIat9GJST8bvJNUrWIS8HhS5bL7IhguHgknUxbkFXH_BfDZfesgsIbvb9Rx_9WWoZpS8WUq6sgHdWp_AeiKuEy-xcuRX6IY0TJz62nx-h68A8SypvKKLUMS4uIL9L633xBXwDLtINPC893ruNxN69Kxw0u--bWSCgR1jpj88g"; // Замените на ваш токен доступа
    private int peer_ids = 2000000001;

    public void vk(String message) {
        try {
            URL url = new URL("https://api.vk.com/method/messages.send");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String postData = "access_token=" + accessToken +
                    "&peer_ids=" + peer_ids +
                    "&message=" + message +
                    "&random_id=" + 0 +
                    "&v=5.131";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
            } else {
                log.error("Ошибка при отправке запроса: " + responseCode);
            }
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
    }
}
