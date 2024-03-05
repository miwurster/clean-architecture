package io.miwurster.clean.testfailureanalyzer.core;

public interface IMailClient {

    void sendMail(InternalErrorMail mail);

    void sendMail(NetworkFailureMail mail);
}
