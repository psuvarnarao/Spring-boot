package in.stackroute.ust.customer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record LoginDto(
        @NotBlank @NotEmpty @Email String email,
        @NotBlank @NotEmpty String password
) {
}
