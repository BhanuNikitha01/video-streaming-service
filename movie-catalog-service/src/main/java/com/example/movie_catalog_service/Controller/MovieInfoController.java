package com.example.movie_catalog_service.Controller;

import com.example.movie_catalog_service.models.MovieInfo;
import com.example.movie_catalog_service.repositories.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MovieInfoController {

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @PostMapping("/movie-info/save")
    public List<MovieInfo> saveAll(@RequestBody List<MovieInfo> movieInfoList){
       return movieInfoRepository.saveAll(movieInfoList);
    }

    @GetMapping("/movie-info/getMovies")
    public List<MovieInfo> getAllMovies()   {
        return movieInfoRepository.findAll();
    }

    @GetMapping("/movie-info/find-path-by-id/{movieinfoid}")
    public String findpathById(@PathVariable long movieinfoid){
        var videoinfooptional= movieInfoRepository.findById(movieinfoid);
        return videoinfooptional.map(MovieInfo::getPath)
                .orElse(null);
    }
}