# 🏦 Bank Account

[![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)](https://www.oracle.com/java/)
[![JUnit](https://img.shields.io/badge/JUnit-5-green?logo=junit5)](https://junit.org/junit5/)
[![Maven](https://img.shields.io/badge/Maven-3.9.6-red?logo=apachemaven)](https://maven.apache.org/)
[![Coverage](https://img.shields.io/badge/Coverage-93%25-brightgreen?logo=codecov)](#)

## 📌 Description

Java program that models the behavior of a **bank account** with inheritance and polymorphism.  
It includes classes for savings accounts and checking accounts, with balance management, withdrawals, deposits, fees, and overdrafts.

- ✅ Object-oriented design with inheritance
- ✅ UML diagram included
- ✅ Complete unit tests
- ✅ Code coverage ≥ 70%

## 🚀 Getting Started

### Prerequisites

- JDK 21
- Maven 3.9.6+
- Git

### Installation

```bash
git clone https://github.com/dmbiee/exercise-java-bank_account.git
cd exercise-java-bank_account
mvn clean install
```

📝 Implementation Requirements

    Account class with:

        Balance (float)

        Number of deposits (int, initial 0)

        Number of withdrawals (int, initial 0)

        Annual interest rate (float)

        Monthly fee (float, initial 0)

    Methods:

        deposit(float amount)

        withdraw(float amount)

        calculateMonthlyInterest()

        monthlyStatement()

        printAccountDetails()

    Savings Account:

        Active/inactive depending on minimum balance $10,000

        Limit of 4 withdrawals without extra fees

    Checking Account:

        Attribute overdraft

        Allows withdrawals greater than balance

        Deposits reduce overdraft

📊 UML

```mermaid
classDiagram
        Account <|-- CheckingAccount
        Account <|-- SavingAccount

        class Account {
          -float balance
          -int depositCount
          -int withdrawCount
          -float annualRate
          -float monthlyFee
          +Account(float balance, float anualRate)
          +deposit(float amount)
          +withdraw(float amount)
          +monthlyStatement()
          +calculateMonthlyInterest()
          +String printInfo()
          +setMonthFee(float monthFee)
          +float getBalange()
          +int getDepositCount()
          +int getWithdrawCount()
          +float getAnnualRate()
          +float getMonthlyFee()
        }

        class CheckingAccount {
          -int overdraft
          +CheckingAccount(float balance, float anualRate)
          +withdraw(float amount)
          +deposit(float amount)
          +monthlyStatement()
          +String printInfo()
        }

        class SavingAccount {
          -boolean isAcive
          +SavingAccount(float balance, float anualRate)
          +updateActiveStatus()
          +deposit(float amount)
          +withdraw(float amount)
          +monthlyStatement()
          +printInfo()
        }
```

📸 Test Coverage

![Test coverage](./assets/test-coverage.png)
---
(screenshot from VSCode)