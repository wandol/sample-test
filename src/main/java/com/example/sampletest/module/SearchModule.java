package com.example.sampletest.module;

import com.example.sampletest.vo.SearchVO;
import com.example.sampletest.vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class SearchModule {

    public List<Map<String, String>> restSearch(SearchVO searchVO) {

        String jsonInString = "";
        HashMap<String, Object> result = new HashMap<String, Object>();
        try {

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            UriComponents uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/user-service/users").build();

            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
            ResponseEntity<User> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, User.class);
            log.info(resultMap.getBody().getEmail());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            e.printStackTrace();
        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
            e.printStackTrace();
        }

        return null;
    }
}
