package com.java2nb.novel.core.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class HttpUtil {

    private static RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");


    public static String getByHttpClient(String url) {
        try {

            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            if (forEntity.getStatusCode() == HttpStatus.OK) {
                return forEntity.getBody();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getByHttpClientWithChrome(String url) throws InterruptedException {

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML," +
                    "like" + " Gecko) Chrome/87.0.4280.67 Safari/537.36");
/*            headers.add("cookie", "bgcolor=; font=; size=; fontcolor=; width=; clickbids=9");
            headers.add("referer", "https://www.mcmssc.com/");
            headers.add("host", "www.mcmssc.com");*/
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            ResponseEntity<String> forEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity,
                    String.class);

            if (forEntity.getStatusCode() == HttpStatus.OK) {
                return forEntity.getBody();
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("========>" + url);
//            Thread.sleep(1000 * 10);
            e.printStackTrace();
            return null;
        }
    }
}
