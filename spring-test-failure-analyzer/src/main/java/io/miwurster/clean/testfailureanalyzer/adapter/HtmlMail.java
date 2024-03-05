package io.miwurster.clean.testfailureanalyzer.adapter;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HtmlMail {

    private String sender;
    private List<String> recipients;
    private String body;
}
