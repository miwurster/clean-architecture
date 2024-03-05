package io.miwurster.clean.testfailureanalyzer.core;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MailNotificationInteractor {

    private final IConfigurationReader configurationReader;
    private final ITestCaseProvider testCaseProvider;
    private final IMailClient mailClient;

    public void notifyInternalError(int testCaseId, Exception exception) {
        var mail = new InternalErrorMail();
        mail.setSender(configurationReader.getMailSender());
        mail.setRecipients(configurationReader.getApplicationOperators());
        mail.setTestCase(testCaseProvider.getTestCase(testCaseId).getName());
        mail.setErrorMessage(exception.getMessage());
        mail.setStackTrace(Arrays.toString(exception.getStackTrace()));

        mailClient.sendMail(mail);
    }

    public void checkMissingTestCases(String buildId) {
        // some more business logic goes here to detect that there was a network issue

        var mail = new NetworkFailureMail();
        mail.setSender(configurationReader.getMailSender());
        mail.setRecipients(configurationReader.getApplicationOperators());
        mail.setBuildId(buildId);
        // mail.setTestAgents(...);

        mailClient.sendMail(mail);
    }
}
