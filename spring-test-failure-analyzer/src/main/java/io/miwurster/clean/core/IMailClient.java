package io.miwurster.clean.core;

public interface IMailClient {

    void sendMail(InternalErrorMail mail);

    void sendMail(NetworkFailureMail mail);
}
