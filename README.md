# Feature Request Application


## Getting Started

This application was developed using Spring Boot, H2 Database, JPA and Angular.

## Requirements

Java - 8.x

Maven - 4.x.x

Angular - 10.x.x

## Steps to Setup

**1. Install latest version of nodejs from https://nodejs.org/en/

**2. In Eclipse/Spring STS import FeatureRequest Project

Steps : 
    Click on File menu
    Click on Import sub menu
    Search for 'Existing projects into Workspace' option and click next
    Browse folder and click on finish

**4. Build the angular code**

go to FeatureRequest\fecode\featurerequest

```bash
```
run command : npm install

build command : ng build --prod

**5. Build and run the app using maven**

go to FeatureRequest\

```bash

mvn clean install
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

Feature Requests API
GET - /api/v1/featurerequests - Get All Feature Requests
POST - /api/v1/featurerequest - Add Feature Request

You can test them using postman or any other rest client.

## Running the tests

To run the unit tests, call mvn test