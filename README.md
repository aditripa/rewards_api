# Project Structure
rewards-api
│
├── src/main/java
│   └── com/example/rewards
│       ├── RewardsApiApplication.java
│       │
│       ├── controller
│       │   └── RewardsController.java
│       │
│       ├── service
│       │   └── RewardsService.java
│       │
│       ├── repository
│       │   └── TransactionRepository.java
│       │
│       ├── model
│       │   ├── Transaction.java
│       │   ├── MonthlyReward.java
│       │   └── CustomerRewardResponse.java
│       │
│       └── exception
│           ├── CustomerNotFoundException.java
│           └── GlobalExceptionHandler.java
│
├── src/test/java
│   └── com/example/rewards
│       ├── controller
│       │   └── RewardsControllerTest.java
│       │
│       └── service
│           └── RewardsServiceTest.java
│
├── pom.xml
├── README.md
└── .gitignore

# REST API Endpoint

## Get Customer Rewards
### Request
GET /api/rewards/{customerId}
### Example
GET /api/rewards/101

# How to Run the Application
## Prerequisites

Install:
- Java 17
- Maven
- Eclipse IDE or IntelliJ IDEA

# Run Using Eclipse
1. Import project as Maven project
2. Open:
RewardsApiApplication.java
3. Right click
Run As → Java Application

# Run Using Maven
Open terminal inside project directory:
mvn spring-boot:run

# Build Project
mvn clean install

# Run Tests
mvn test

# API Testing 
## URL
http://localhost:8080/api/rewards/101


# GitHub Commands
git init
git add .
git commit -m "v1 commit"
git branch -M main
git remote add origin <repository-url>
git push -u origin main
