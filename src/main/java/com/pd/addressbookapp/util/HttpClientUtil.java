package com.pd.addressbookapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpClientUtil {

    private static final String QUERY_PARAM = "query";
    private static final String USER_COUNT_PARAM = "total";
    private static final String PAGE_SIZE_PARAM = "limit";
    private static final String PAGE_INDEX_PARAM = "offset";

    public static String get(String url, String token, String query, boolean userCount, int pageSize, int pageIndex) throws IOException {
        if (isNullOrEmpty(url)) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        String finalUrl = buildUrlWithParams(url, query, userCount, pageSize, pageIndex);
        HttpURLConnection connection = (HttpURLConnection) URI.create(finalUrl).toURL().openConnection();

        connection.setRequestMethod("GET");
        if (!isNullOrEmpty(token)) {
            connection.setRequestProperty("Authorization",token);
        }
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP request failed with code: " + responseCode);
        }

        try (InputStream is = connection.getInputStream()) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } finally {
            connection.disconnect();
        }
    }

    private static String buildUrlWithParams(String baseUrl, String query, boolean userCount, int pageSize, int pageIndex) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);

        Map<String, String> params = new LinkedHashMap<>();
        if (!isNullOrEmpty(query)) {
            params.put(QUERY_PARAM, URLEncoder.encode(query, StandardCharsets.UTF_8));
        }
        if (userCount) {
            params.put(USER_COUNT_PARAM, String.valueOf(userCount));
        }
        if (pageSize > 0) {
            params.put(PAGE_SIZE_PARAM, String.valueOf(pageSize));
        }
        if (pageIndex > 0) {
            params.put(PAGE_INDEX_PARAM, String.valueOf(pageIndex));
        }

        if (!params.isEmpty()) {
            urlBuilder.append('?');
            params.forEach((key, value) -> urlBuilder.append(key).append('=').append(value).append('&'));
            urlBuilder.setLength(urlBuilder.length() - 1); // remove trailing '&'
        }

        return urlBuilder.toString();
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
