package io.miwurster.clean.testfailureanalyzer.io;

import io.miwurster.clean.testfailureanalyzer.core.IConfigurationReader;
import java.util.List;

public class ConfigurationReader implements IConfigurationReader {

    @Override
    public String getMailSender() {
        return null;
    }

    @Override
    public List<String> getApplicationOperators() {
        return null;
    }
}
