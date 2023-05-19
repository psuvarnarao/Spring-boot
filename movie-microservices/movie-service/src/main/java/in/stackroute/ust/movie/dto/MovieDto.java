package in.stackroute.ust.movie.dto;

import in.stackroute.ust.movie.exceptions.InvalidMovieDataException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record MovieDto(
        int id,
        @NotNull(message = "Movie title cannot be null")
        @NotEmpty(message = "Movie title cannot be empty")
        @NotBlank(message = "Movie title cannot be blank")
        String title
) {

}
