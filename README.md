# MnemoPaul - developed by Pawel Dudek
© 2017
Version 1.2.0


## How to use:

(Read "Admin-User guide.pdf" for more)
1. Prepare database according to the scheme in "Admin-User guide.pdf" document (application tested on MySql database), remember about default values, autoincrements and other constraints;
2. Run MnemoPaul on Tomcat Server (8.0.x version);
3. Register your own user. If you need administrator rights, alter you role in MySql database;
4. Log in.


## Cards export:

Export default folder is "C:/Users/{Current User}/Desktop". You might change it in pl.scartout.mnemopaul.controller.ExportController.java class (constant EXPORT_FOLDER).


## Business goal:

Portals like Quizlet offer flashcards repeats focus on all words repeats. Desktop applications like Anki allow better, more effective repeat method, mnemonic system. MnemoPaul join both that advantages - mnemonic online repeats. Moreover, MnemoPaul provide additional methods non-existing in aforementioned solutions. 


## Technologies used:

- Java EE, Hibernate
- Javascript, JQuery, HTML, CSS, Bootstrap, JSP, EL
- Maven
- Tomcat
- JUnit, EqualsVerifier
