# library
My project which I realized as part of SKNI SGH Java Spring course.
The aim of the project was to consolidate the material processed during the course.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
The application is a simple library system. 
It allows you to search for books based on the author's name or title and returning back data in the form of JSON.
Additionally it gives possibility to add a new book to database, view information about the selected book, and delete books from the database.

## Technologies
Project is created with:
* Java 11
* Maven 3.6.1
* Spring Boot 2.2.2
* Hibernate 5.4.10
* H2 database 1.4.200
* Apache Tomcat
* Thymleaf

## Setup
To use override <property name="connection.url"> in hibernate.cfg.xml file with your
path to db file.
App start at http://localhost:8000/books
