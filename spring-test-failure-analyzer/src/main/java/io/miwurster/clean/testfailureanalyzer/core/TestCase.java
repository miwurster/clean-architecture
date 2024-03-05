package io.miwurster.clean.testfailureanalyzer.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    private int id;
    private String name;
    private String buildId;
    private Status status;
}
