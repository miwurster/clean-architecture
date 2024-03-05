package io.miwurster.clean.adapter;

import io.miwurster.clean.core.IMailClient;
import io.miwurster.clean.core.InternalErrorMail;
import io.miwurster.clean.core.NetworkFailureMail;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MailClientAdapter implements IMailClient {

    private final IHtmlMailClient htmlMailClient;

    @Override
    public void sendMail(InternalErrorMail mail) {
        var htmlMail = new HtmlMail();
        htmlMail.setSender(mail.getSender());
        htmlMail.setRecipients(mail.getRecipients());
        htmlMail.setBody("<html><body><h1>Internal Error</h1><p>" + mail.getErrorMessage() + "</p></body></html>");

        htmlMailClient.sendMail(htmlMail);
    }

    @Override
    public void sendMail(NetworkFailureMail mail) {
        var htmlMail = new HtmlMail();
        htmlMail.setSender(mail.getSender());
        htmlMail.setRecipients(mail.getRecipients());
        htmlMail.setBody("<html><body><h1>Network Failure</h1><p>" + mail.getBuildId() + "</p></body></html>");

        htmlMailClient.sendMail(htmlMail);
    }
}
