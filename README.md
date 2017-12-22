MNEMOPAUL - developed by Pawe³ Dudek
© 2017
Version 1.x.x


How to use:

(Read "Admin-User guide.pdf" for more)
1.Prepare database according to the scheme in "Admin-User guide.pdf" document (application tested on MySql database), remember about default values, autoincrements and other constraints;
2.Run MnemoPaul on Tomcat Server (8.0.x version);
3.Register your own user. If you need administrator rights, alter you role in MySql database;
4.Log in.


Business goal:

Portals like Quizlet offer flashcards repeats focus on all words repeats. Desktop applications like Anki allow better, more effective repeat method, mnemonic system. MnemoPaul join both that advantages - mnemonic online repeats. Moreover, MnemoPaul provide additional methods non-existing in aforementioned solutions. 


Technologies used:

- Java EE
- Tomcat
- Bootstrap
- HTML
- CSS
- JSTL
- EL
- JDBC
- Maven
- Hibernate
- JUnit
- MD5


Planned changes in the future:

- Adding of Deck Sharing - other user might allow you to copy theirs cards;
- Extension to import cards from file - it is important to add new cards from Anki, Quizlet and other applications easily and fast;
- Implementation of review settings - parameter 'max decks per day' will be added;
- Account user confirmation - user will activate their account after register by click the link in their e-mail from MnemoPaul service;
- Launching MnemoPaul on remote server - initially application will be tested by my friends;
- Replacing MD5 by SHA-256.


About tests:

The tests have been implemented as showcase. In this application black-box tests playing a bigger role.