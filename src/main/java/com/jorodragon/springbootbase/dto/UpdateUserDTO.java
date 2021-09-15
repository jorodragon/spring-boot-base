
package com.jorodragon.springbootbase.dto;

import lombok.*;
import org.hibernate.validator.constraints.URL;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    private String name;

    @Pattern(regexp="(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    private String phone;

    @Valid
    @URL(regexp="(https?:\\/\\/.*)", message="Avatar must be an url image")
    private String avatar;
}
