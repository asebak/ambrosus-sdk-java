package com.ambrosus.java;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class Utils {
    public static String BuildQueryString(HashMap<String, Object> parameters) {
        if (parameters.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder("?");

        final String[] sep = {""};


        parameters.entrySet().stream()
                .filter(x -> x.getValue() != null)
                .forEach(e -> {
                    try {
                        sb.append(sep[0]);
                        sb.append(URLEncoder.encode(e.getKey(), "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode(e.getValue().toString(), "UTF-8"));
                        sep[0] = "&";

                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                });

        String result = sb.toString();
        return result.length() == 1 ? "" : result;
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
