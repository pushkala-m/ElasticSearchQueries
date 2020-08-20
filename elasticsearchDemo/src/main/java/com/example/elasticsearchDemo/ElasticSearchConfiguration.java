package com.example.elasticsearchDemo;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ElasticSearchConfiguration  {

    @Value("${elasticsearch.host}")
    public String host;
    @Value("${elasticsearch.port}")
    public int port;


    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    @Bean
    public RestHighLevelClient client() {

        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port));
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }
}
