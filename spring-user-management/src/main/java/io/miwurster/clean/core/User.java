package io.miwurster.clean.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String password;

    public boolean isPasswordValid() {
        return password != null && password.length() > 5;
    }
}
