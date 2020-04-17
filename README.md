# Online Store Web API

* [Summary](#summary)
* [General guidelines](#general-guidelines)
* [Functions](#functions)

## Summary
This document contains descritpions, instructions, and some examples for a Java Springboot and MySQL based Web API service that handles the back-end logic of buying, selling, product exploration, and user management functionalities for an online store.

## General guidelinessssss
* The API consists of a set of public functions.
* A function can be accessed via an HTTP request using a unique URL.
* The parameters of a function are passed as URL parameters or in the body of the HTTP request in JSON format.


# Functions
## 1- User Registration

### Request Type
    POST

### URL
    /<user_type>/register

### Body
    {
    "userInfo": {
        "username": <username>,
        "email": <email>,
        "password": <password>,
        "name": <name>
    },
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

### Example
    {
    "userInfo": {
        "username": "user1",
        "email": "email@domain.com",
        "password": "1234",
        "name": "my_name"
    },
    "socialID": "ID123",
    }
