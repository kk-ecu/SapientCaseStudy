package com.sapient.controller;

import com.sapient.entity.Movie;
import com.sapient.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@RestController
@RequestMapping("api/movie")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @RequestMapping("/{uuid}")
    ResponseEntity<Movie> read(@PathVariable("uuid") String uuid)  {
        Movie movie=null;
        try
        {
            movie=this.movieService.get(UUID.fromString(uuid));
            return  new ResponseEntity<Movie>(movie, null, HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<Movie>(movie,null,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    Movie create(@RequestBody Movie movie){
        movie=this.movieService.save(movie);
        return  movie;
    }

    @GetMapping
    @RequestMapping("/all")
    List<Movie> getAll(){
        return this.movieService.getAll();
    }



    @GetMapping
    @RequestMapping("/search")
    List<Movie> search(String pattern){
        return this.movieService.search(pattern);
    }

    @PutMapping
    @RequestMapping("/")
    Movie update(Movie movie){
        movie=this.movieService.update(movie);
        return  movie;
    }

}
