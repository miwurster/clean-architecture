package io.miwurster.clean.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void shouldReturnFalseWhenPasswordIsTooShort() {
        var user = User.builder()
            .name("test")
            .password("123")
            .build();

        assertThat(user.isPasswordValid()).isFalse();
    }

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        var user = User.builder()
            .name("test")
            .password("123456")
            .build();

        assertThat(user.isPasswordValid()).isTrue();
    }
}
