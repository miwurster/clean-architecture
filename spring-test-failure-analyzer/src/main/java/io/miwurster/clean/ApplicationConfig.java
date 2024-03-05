package io.miwurster.clean;

import io.miwurster.clean.adapter.MailClientAdapter;
import io.miwurster.clean.core.IConfigurationReader;
import io.miwurster.clean.core.IMailClient;
import io.miwurster.clean.core.ITestCaseProvider;
import io.miwurster.clean.core.MailNotificationInteractor;
import io.miwurster.clean.io.ConfigurationReader;
import io.miwurster.clean.io.MailClient;
import io.miwurster.clean.io.TestCaseProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public MailNotificationInteractor mailNotificationInteractor(IConfigurationReader configurationReader,
                                                                 ITestCaseProvider testDetailsProvider,
                                                                 IMailClient mailClient) {
        return new MailNotificationInteractor(configurationReader, testDetailsProvider, mailClient);
    }

    @Bean
    public IConfigurationReader configurationReader() {
        return new ConfigurationReader();
    }

    @Bean
    public ITestCaseProvider testDetailsProvider() {
        return new TestCaseProvider();
    }

    @Bean
    public IMailClient mailClient() {
        return new MailClientAdapter(new MailClient());
    }
}
