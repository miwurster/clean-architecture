package io.miwurster.clean.testfailureanalyzer;

import io.miwurster.clean.testfailureanalyzer.adapter.MailClientAdapter;
import io.miwurster.clean.testfailureanalyzer.core.IConfigurationReader;
import io.miwurster.clean.testfailureanalyzer.core.IMailClient;
import io.miwurster.clean.testfailureanalyzer.core.ITestCaseProvider;
import io.miwurster.clean.testfailureanalyzer.core.MailNotificationInteractor;
import io.miwurster.clean.testfailureanalyzer.io.ConfigurationReader;
import io.miwurster.clean.testfailureanalyzer.io.MailClient;
import io.miwurster.clean.testfailureanalyzer.io.TestCaseProvider;
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
