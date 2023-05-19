package in.stackroute.ust.customer.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record CustomerDto(
        int id,
        @NotBlank @NotEmpty String name,
        @NotBlank @NotEmpty @Email String email,
        @NotBlank @NotEmpty String password) {
}
