# Testing Twilio APIs to send SMS and make calls

## Installation
Put your Twilio credentials in application.properties

Install with maven:

`mvn clean install`

## API Request
Create a sendMessage request using GET
`http://localhost:8080/api/sendMessage?recipient=123456789&body=testing`

Create a makeCall request using GET
`http://localhost:8080/api/makeCall?recipient=123456789&body=testing`