package com.sapient.service;

import com.sapient.entity.Movie;
import com.sapient.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie get(UUID uuid) throws Exception {
        Optional<Movie>movie=this.movieRepository.findById(uuid);
        if (movie.isPresent()){
            throw new Exception("No Movie is Available");
        }
        return movie.get();
    }

    @Override
    public List<Movie> search(String pattern) {
        Iterable<Movie> iterable= this.movieRepository.findAll();
        List<Movie> movies=new ArrayList<>();

        iterable.forEach(movie -> {
            if (movie.getName().contains(pattern)) {
            movies.add(movie);
            }
            });
        return movies;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies=new ArrayList<>();
        this.movieRepository.findAll().forEach(movie -> {
            movies.add(movie);
        });
    return movies;
    }

    @Override
    public Movie save(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        this.movieRepository.delete(this.get(id));
        return true ;
    }
}
