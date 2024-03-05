package io.miwurster.clean;

import static org.assertj.core.api.Assertions.assertThat;

import io.miwurster.clean.adapters.TestAPI;
import org.junit.jupiter.api.Test;

public class MailNotificationTests {

    @Test
    void shouldCreateHtmlEmailOnInternalError() {
        var mail = TestAPI.simulateInternalError(new RuntimeException("Ups"));

        assertThat(mail.getBody()).contains("Ups").contains("<body>");
    }
}
