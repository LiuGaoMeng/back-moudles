package com.augurit.water;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication(scanBasePackages = "com.augurit.water")
@MapperScan({"com.augurit.water.**.mapper"})
public class MapDisplay {

    public static void main(String[] args) {
        SpringApplication.run(MapDisplay.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }
//    /**
//     * 识别目前使用的是什么数据源
//     * @return
//     */
//    @Bean
//    public DatabaseIdProvider getDatabaseIdProvider() {
//        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
//        Properties properties = new Properties();
//        properties.setProperty("Oracle", "oracle");
//        properties.setProperty("MySQL", "mysql");
//        properties.setProperty("DM DBMS", "oracle");
//        databaseIdProvider.setProperties(properties);
//        return databaseIdProvider;
//    }

}
