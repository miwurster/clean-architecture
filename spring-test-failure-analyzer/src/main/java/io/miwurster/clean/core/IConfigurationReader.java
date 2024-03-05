package io.miwurster.clean.core;

import java.util.List;

public interface IConfigurationReader {

    String getMailSender();

    List<String> getApplicationOperators();
}
