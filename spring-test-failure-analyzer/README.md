# Test Failure Analyzer using Java with Spring Boot

Case study to implement the "Test Failure Analyzer" using Java and Spring Boot.

As a general case study I use a simple application that is sending emails to a list of recipients.
The application analyzes test failures from a CI/CD pipeline (stored in a database) and sends out emails to the responsible developers.
A detail description of the cases can be found [here](https://www.plainionist.net/Implementing-Clean-Architecture-CaseStudy-Mails).

```
Context:

The application, this feature is designed for, analyzes test failures from our
CI/CD pipeline (stored in some test database) and creates defects in our defect
database. The application also has a simple configuration file containing,
e.g., properties to fill certain defect fields like “Assigned To”.

The feature we were reviewing is supposed to send e-mails to our development
teams in case some test failures could not be processed properly because of:
- some network failure broke the whole CI/CD pipeline execution,
- an internal error in our application happened (e.g., due to corruption of
  the configuration file or a programming error),
- or, the database storing the test failures from our CI/CD pipeline is down.
```
