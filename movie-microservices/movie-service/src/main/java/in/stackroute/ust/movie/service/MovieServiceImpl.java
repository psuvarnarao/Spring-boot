package in.stackroute.ust.movie.service;

import in.stackroute.ust.movie.domain.Movie;
import in.stackroute.ust.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements  MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public Optional<Movie> findByIdOrTitle(int id, String title) {
        return movieRepository.findByIdOrTitle(id, title);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
