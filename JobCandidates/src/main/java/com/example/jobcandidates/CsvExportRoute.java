package com.example.jobcandidates;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.model.dataformat.CsvDataFormat;

@Component
public class CsvExportRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        CsvDataFormat csvFormat = new CsvDataFormat();
        csvFormat.setDelimiter(";");

        from("timer:fetchData?fixedRate=true&period=3600000")
                .setBody(constant("SELECT first_and_last_name, jmbg, year_of_birth, mail, telephone_number, is_employed, last_change FROM Candidate"))
                .to("jdbc:datasource")
                .marshal(csvFormat)
                .process(exchange -> {
                    String headers = "first_and_last_name;jmbg;year_of_birth;mail;telephone_number;is_employed;last_change\n";
                    String body = exchange.getIn().getBody(String.class);
                    exchange.getIn().setBody(headers + body);
                })
                .to("file:/C:/Users/Vladimir/Desktop/testing/JobCandidates?fileName=candidates.csv&fileExist=Override")
                .log("CSV file written to C:/Users/Vladimir/Desktop/testing/JobCandidates/candidates.csv");
    }
}


