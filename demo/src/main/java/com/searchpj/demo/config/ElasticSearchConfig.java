package com.searchpj.demo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
//    @Override
//    public RestHighLevelClient elasticsearchClient() {
//        // http port 와 통신할 주소
//        ClientConfiguration configuration = ClientConfiguration.builder().connectedTo("localhost:9200").build();
//        return RestClients.create(configuration).rest();
//    }


}
