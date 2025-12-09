package com.example.movie_streaming_service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogService {

    //using this url and load balancer I will be able to access one instance of this service, this url we are defining because we have the same in eureka as well
    private static  final String CATALOG_SERVICE="http://movie-catalog-service";
    @Autowired
    RestTemplate restTemplate;

    public String getMoviePath(Long movieinfoid){
        //using this url and load balancer I will be able to access one instance of this service
        var response= restTemplate.getForEntity(CATALOG_SERVICE+"/movie-info/find-path-by-id/{movieinfoid}",String.class,movieinfoid);
        return response.getBody();
    }

}
