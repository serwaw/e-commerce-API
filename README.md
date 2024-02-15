# e-commerce-API
## Introduction
This project contains of only one single-endpoint that will take a list of watch-id items and return the total cost of all the watches.
The project is build on the springboot framework.

## Routes
| Route     |Method|Description|
|-----------|---|---|
| /checkout |POST|Calculates prices and returns a calculated sum|


## Installation guide
 * clone the repo from git (or in this case open the zip-file)
 * run `mvn clean install`
 * start `Main`

## Approaching the task
After reading the task I did some time thinking about how to set up the modules and what should be separated in different modules.
Then I started coding mostly the shell for many of the methods I knew I needed before writing most of the code.
The last thing I did was to write the tests and correcting some errors. 

## What needs to be improved
 * The tests in this project does not cover many cases and more tests should be included.
 * A better integration test is also needed.
 * Adding and using swagger