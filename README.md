# ClusteredData Warehouse
ClusteredData Warehouse is a data warehouse system developed by the Scrum team at Bloomberg for analyzing FX deals. This system aims to accept FX deal details, validate and persist them into a chosen database, ensuring accuracy and reliability in the analysis of financial transactions.

# Table of Contents
- Introduction
- Requirements
- Getting Started
- Setup
- Usage
- Error Handling
- Logging
- Testing
- Documentation
- Repository

__INTRODUCTION:__
The ClusteredData Warehouse system is designed to accept and process FX deal details, ensuring that each deal is accurately validated, saved to the database, and tracked to prevent duplicate imports.

__REQUIREMENTS:__
Java (JDK 17)
Your preferred IDE or text editor
Docker and Docker Compose
PostgreSQL database
Git

__GETTING STARTED:__
Clone the GitHub repository: git clone https://github.com/Jonathan463/ClusteredData_Warehouse.git
Navigate to the project directory: cd ClusteredDataWarehouse

__SETUP:__
Use PostgreSQL database and ensure it's running locally or available remotely.
Configure the database connection details in the application's configuration files.
Ensure Docker and Docker Compose are installed.
Prepare the sample data file for ingestion.

__USAGE:__
Build the project using Maven: mvn clean install or maven clean build
Start the application using the provided Docker Compose setup: docker-compose up -d

__ERROR HANDLING:__
The application employs robust error handling mechanisms and bean validation to ensure data integrity and prevent incorrect or incomplete data from being imported.

_LOGGING:_
Logging is implemented using a standard logging framework Log4j and SLF4J, providing detailed information about the application's operations and any potential issues.

__TESTING:__
Unit tests have been created to thoroughly validate the application's components and functionalities. To run tests and check coverage:

__DOCUMENTION:__
For detailed information about the application's architecture, code structure, and usage, please refer to the documentation file.

__REPOSITORY:__
The source code and related files for the ClusteredData Warehouse project can be found in the GitHub repository: https://github.com/Jonathan463/ClusteredData_Warehouse


By the Scrum team at Bloomberg | August 18, 202
