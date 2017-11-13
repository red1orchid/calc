package curr.calc.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class HttpRequestsSender {
    public static ResponseEntity<String> sendGetRequest(String url, Map<String, Object> queryParams, Map<String, String> headers) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        addHeaders(requestHeaders, headers);
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);

        HttpEntity<String> httpEntity = new HttpEntity<>(null, requestHeaders);

        return restTemplate.exchange(buildString(url, queryParams), HttpMethod.GET, httpEntity, String.class);
    }

    private static void addHeaders(HttpHeaders requestHeaders, Map<String, String> headers) {
        if (headers != null) {
            for (String key : headers.keySet()) {
                requestHeaders.add(key, headers.get(key));
            }
        }
    }

    private static String buildString(String url, Map<String, ?> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                builder.queryParam(key, queryParams.get(key));
            }
        }

        return builder.toUriString();
    }
}
