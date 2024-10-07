# my-java-project-to-kotlin

Project Requirements:
1. Checking git version
   open terminal, text in terminal: 'git version'
   if there is an error like 'No developer tools were found, requesting install.' then you can follow the instructions in 'https://github.com/git-guides/install-git'.
2. Install the latest JDK.
3. Create the project by using Generic Repository Pattern.

Project:
*   Using the Generic Repository Pattern will help make the project more scalable, maintainable, and aligned with the principles of Object-Oriented Programming (OOP).
  
                             BankingSystemProject
                           └── src
                               └── main
                                   └── java
                                       └── com
                                           └── example
                                               └── bankingsystem
                                                   ├── enums
                                                   │   ├── Gender.java
                                                   │   └── TransactionCode.java
                                                   ├── models
                                                   │   ├── BaseEntity.java
                                                   │   ├── Customer.java
                                                   │   ├── Card.java
                                                   │   └── Transaction.java
                                                   ├── repositories
                                                   │   ├── BaseRepository.java
                                                   │   ├── CustomerRepository.java
                                                   │   ├── CardRepository.java
                                                   │   └── TransactionRepository.java
                                                   ├── services
                                                   │   └── BankingService.java
                                                   ├── utils
                                                   │   └── IDGenerator.java
                                                   └── Main.java

*   The BankingService ensures that:
   -   Cards can only be added if the customer exists.
   -   Transactions can only be created if both the card and the corresponding customer exist.
     
*   Additional requirements step-by-step:
   -   Use enum for Gender and TransactionCode.
   -   Add validation for email (must match email regular expression).
   -   Add validation for birthdate (cannot be in the future or before 19450101).
   -   Ensure every ID (Customer, Card, and Transaction) is incremental and unique.
   -   Card No can support 16-20 digits, and can't start with 0.
     
*    Unit Tests: This approach ensures your project is well-structured, maintainable, and meets core requirements. 
   -   Repositories are tested for CRUD operations.
   -   Service classes are tested for business rules and logic.
   -   Utility classes are tested for ID generation. 

                          BankingSystemProject
                        └── src
                            └── test
                                └── java
                                    └── com
                                        └── example
                                            └── bankingsystem
                                                ├── services
                                                │   └── BankingServiceTest.java
                                                ├── repositories
                                                │   ├── CustomerRepositoryTest.java
                                                │   ├── CardRepositoryTest.java
                                                │   └── TransactionRepositoryTest.java
                                                └── utils
                                                    └── IDGeneratorTest.java

