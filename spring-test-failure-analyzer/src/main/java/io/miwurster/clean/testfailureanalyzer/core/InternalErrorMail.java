package io.miwurster.clean.testfailureanalyzer.core;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternalErrorMail {

    private String sender;
    private List<String> recipients;
    private String testCase;
    private String errorMessage;
    private String stackTrace;
}
