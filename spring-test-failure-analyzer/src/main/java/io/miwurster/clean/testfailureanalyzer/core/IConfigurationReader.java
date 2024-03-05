package io.miwurster.clean.testfailureanalyzer.core;

import java.util.List;

public interface IConfigurationReader {

    String getMailSender();

    List<String> getApplicationOperators();
}
