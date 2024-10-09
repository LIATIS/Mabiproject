package com.searchpj.demo.elasticService;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Service
public class ElasticService {
	
//    @Value("${oci.es.url}")
//    private String hostname; // localhost
//
//    @Value("${oci.es.port}")
//    private Integer port; // 9200

	private RestClient ElasticClient() {
		String host = "localhost";
		int port = 9200;

		String encodedApiKey = "Change me to encoded API Key";

		BasicCredentialsProvider credsProv = new BasicCredentialsProvider();
		credsProv.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "Change me elasticsearch password"));

	    // Create the low-level client
	    RestClient restClient = RestClient
	            .builder(new HttpHost(host, port, "https"))
	            .setDefaultHeaders(new Header[]{
	                    new BasicHeader("Authorization", "ApiKey " + encodedApiKey)
	            })
	            .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
	                    .setDefaultCredentialsProvider(credsProv)
	            )
	            .build();

	    // Create the transport with a Jackson mapper
	    ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

	    // And create the API client
	    ElasticsearchClient esClient = new ElasticsearchClient(transport);

	    /*
	        Write something to do here
	    */
	    return restClient;
	}
	
	public String elasticsevice(int a) throws IOException {
	    RestClient restClient = ElasticClient();

        // Elasticsearch 작업 코드 작성 (예: 색인 생성, 데이터 검색)

        // 클라이언트 종료
        try {
        	restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
        return "ㅇㄴㅇㄴ"; 
	}
}
