package com.efexunn.user.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserResponse {
    private int userId;
    private String firstname;
    private String lastname;
    private String email;
}
