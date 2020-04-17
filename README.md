# Online Store Web API

* [Summary](#summary)
* [General guidelines](#general-guidelines)
* [Functions](#functions)
* [Dependencies](#dependencies)
* [Get on Docker](#get-on-docker)


## Summary
This document contains descritpions, instructions, and some examples for a Java Springboot and MySQL based Web API service that handles the back-end logic of buying, selling, product exploration, and user management functionalities for an online store.

## Dependencies
For manual installation, the following packages have to be present in the installation environment:
* Java 11 SDK
* Springboot version 2.2.6.RELEASE
* MySQL 5.7 (or higher)
* Java MySQL connector
For automatic installation, refer to the pom.xml file in this repo, or to the Docker installation document in this repo.

## General guidelines
* The API consists of a set of public functions.
* A function can be accessed via an HTTP request using a unique URL.
* The parameters of a function are passed as URL parameters or in the body of the HTTP request in JSON format.


# Functions
* [User Registration](#user-registration)
* [List Users](#list-users)

## User Registration

### Request Type
    POST

### URL
    /<user_type>/register

### Body
    {
        "username": <username>,
        "email": <email>,
        "password": <password>,
        "name": <name>,
        additional: <additional_information>
    }
### Action
Verifies that the given credentials meet the following criteria:
* None of the required parameters is null or empty
* The username, email, and password lengths are within a predefined range
* The given email string is a valid email
* The username and the email are not already existent in the database

If the criteria is met, these credentials are mapped to the database.

### Response
Possible (but not all) status responses:
* Error: Username already exists
* Error: e-mail already exists
* Error: username cannot be empty and must be between 5 and 16 characters
* Error: Unhandled Exception
* OK

### Request Body Example
    {
        "username": "user1",
        "email": "email@domain.com",
        "password": "1234",
        "name": "my_name",
        "socialID": "ID123"
    }
    
## List Users
### Request Type
    GET
### URL
    /user/users
### Body
This function requires no body.
### Action
Fetches all registered users from the database and returns them in a list.
### Response
    {
    [{user1}, {user2}, ....]
    }
### Response Body Example
    {   
        [
            {
                "username": "user1",
                "email": "email@domain.com",
                "password": "1234",
                "name": "my_name",
                "socialID": "ID_YYY"
            },
            {
                "username": "user2",
                "email": "email2@domain.com",
                "password": "12345",
                "name": "my_name",
            }
        ]
    }
