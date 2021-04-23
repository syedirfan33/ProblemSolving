package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyUrl {
    String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String HOST = "http://tinyurl.com/";
    Map<String, String> longVsShortMap = new HashMap<>(); // This map is for performance improvements id duplicate longurls are being used
    Map<String, String> shortVsLongMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longVsShortMap.containsKey(longUrl)) return HOST + longVsShortMap.get(longUrl);
        String key = getKey();

        while (shortVsLongMap.containsKey(key))
            key = getKey();

        longVsShortMap.put(longUrl, key);
        shortVsLongMap.put(key, longUrl);
        return HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(HOST.length());
        return shortVsLongMap.get(key);
    }

    private String getKey() {
        StringBuilder key = new StringBuilder();
        // i can be of any length
        for (int i = 0; i < 6; i++) {
            int idx = (int) (Math.random() * SEED.length()); // generates random int between 0 to 61 (62 exclusive)
            key.append(SEED.charAt(idx));
        }
        return key.toString();
    }
}
