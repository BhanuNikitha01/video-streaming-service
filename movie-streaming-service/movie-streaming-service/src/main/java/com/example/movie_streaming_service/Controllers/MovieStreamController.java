package com.example.movie_streaming_service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
public class MovieStreamController {

    public static final String VIDEO_DIRECTORY ="D:\\";

    @Autowired
    MovieCatalogService movieCatalogService;

    @GetMapping("/stream/{videopath}")
    public ResponseEntity<InputStreamSource> streamVideo(@PathVariable String videopath) throws FileNotFoundException {
        File file = new File(VIDEO_DIRECTORY+ videopath);
        if(file.exists()){
            InputStreamSource inputStreamSource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().contentType(MediaType.valueOf("video/mp4"))
                    .body(inputStreamSource);
        }
        else{
           return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/stream/with-id/{videoinfoid}")

    public ResponseEntity<InputStreamSource> streamVideoById(@PathVariable Long videoinfoid) throws FileNotFoundException{
        String moviePath= movieCatalogService.getMoviePath(videoinfoid);
        return streamVideo(moviePath);
    }
}
