package com.example.movie_catalog_service.repositories;

import com.example.movie_catalog_service.models.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long> {


}
