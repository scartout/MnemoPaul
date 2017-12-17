MNEMOPAUL - developed by Pawe³ Dudek
© 2017
Version 1.x.x


How to use:

(Read "Admin-User guide.pdf" for more)
1.Prepare database according to the scheme in "Admin-User guide.pdf" document (application tested on MySql database), remember about default values, autoincrements and other constraints;
2.Run MnemoPaul on Tomcat Server (8.5.x version);
3.Register your own user, if you need administrator rights, alter you role in MySql database;
4.Log in.


Business goal:

Portals like Quizlet offer flashcards repeats focus on all words repeats. Desktop applications like Anki allow better, more effective repeat method, mnemonic system. MnemoPaul join both that advantages - mnemonic online repeats.


Technologies used:

- Java EE
- Tomcat
- Bootstrap
- HTML5
- CSS
- JSTL
- EL
- JDBC
- Maven
- Hibernate
- JUnit
- MD5


Planned changes in the future:

- Replace GET method with POST in 'ReviewController' and 'ReviewChoiseController' - now deck parameter is forwarded to path, it isn't the best solution because if you modify the path in some cases you might run somebody else's deck;
- Implementation of Deck Sharing - other user might allow you to copy theirs cards;
- Implementation of cards import from file - it is important to add new cards from Anki, Quizlet and other applications easily and fast;
- Implementation of review settings - parameter 'max decks per day' will be added;
- New account user confirmation - user will activate their account after register by click the link in their e-mail from MnemoPaul service;
- Launching MnemoPaul on remote server - initially application will be tested by my friends;
- Implementation of SHA-256 passwords security.


About tests:

Tests are implemented as showcase, in this application black-box tests playing a bigger role.