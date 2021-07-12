package com.example.sampletest.main;

import com.example.sampletest.module.SearchModule;
import com.example.sampletest.vo.SearchResultVO;
import com.example.sampletest.vo.SearchVO;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Main {

    Environment env;
    SearchModule searchModule;

    public Main(Environment env, SearchModule searchModule) {
        this.env = env;
        this.searchModule = searchModule;
    }

    public void request() {

        //  파라미터 세팅

        //  쿼리 세팅
        SearchVO searchVO = makeQuery();

        //  rest request
        List<Map<String,String>> result = searchModule.restSearch(searchVO);

        //  json -> make csv
       // makeCsv(result);
    }

    private SearchVO makeQuery() {

        // 쿼리세팅
        String query = "";
        // 정렬
        String orderBy = "";
        // 볼륨

        // 필드
        return SearchVO.builder()
                    .query(query)
                    .limit("30")
                    .select(env.getProperty("SEARCH.SELECT"))
                    .volume(env.getProperty("SEARCH.IP"))
                    .orderBy(orderBy)
                .build();
    }

    private static void makeCsv(SearchResultVO result) {
    }
}
