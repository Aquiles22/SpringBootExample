package com.pagatodo.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NonNull
    private String username;
 
    @NonNull
    private String password;
    
}
