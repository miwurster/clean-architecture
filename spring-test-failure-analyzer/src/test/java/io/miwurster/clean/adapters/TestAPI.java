package io.miwurster.clean.adapters;

import io.miwurster.clean.adapter.HtmlMail;
import io.miwurster.clean.adapter.IHtmlMailClient;
import io.miwurster.clean.adapter.MailClientAdapter;
import io.miwurster.clean.core.IConfigurationReader;
import io.miwurster.clean.core.ITestCaseProvider;
import io.miwurster.clean.core.MailNotificationInteractor;
import io.miwurster.clean.core.Status;
import io.miwurster.clean.core.TestCase;
import java.util.List;
import lombok.Getter;

public class TestAPI {

    public static HtmlMail simulateInternalError(Exception exception) {

        var fakeMailClient = new FakeMailClient();
        var adapter = new MailClientAdapter(fakeMailClient);

        var interactor = new MailNotificationInteractor(
            new FakeConfigurationReader(),
            new FakeTestCaseProvider(),
            adapter
        );

        interactor.notifyInternalError(42, exception);

        return fakeMailClient.getMail();
    }

    @Getter
    private static class FakeMailClient implements IHtmlMailClient {

        private HtmlMail mail;

        @Override
        public void sendMail(HtmlMail mail) {
            this.mail = mail;
        }
    }

    private static class FakeConfigurationReader implements IConfigurationReader {

        @Override
        public String getMailSender() {
            return "noreply@test.com";
        }

        @Override
        public List<String> getApplicationOperators() {
            return List.of("user1@test.com", "user2@test.com");
        }
    }

    private static class FakeTestCaseProvider implements ITestCaseProvider {

        @Override
        public TestCase getTestCase(int testCaseId) {
            return new TestCase(42, "Test 1", "12345", Status.PASSED);
        }
    }
}
