# Exercise!
  * A REST API presenting aggregated information for a user has been built
  * Shows the account/credit card/debit card/power of attorney for the user, as well as credit card/debit card which the user has been authorized for
  * Example call:
    http://localhost:8080/users-info/Super duper employee
    Returns:
    ```json
    {"accounts":[{"owner":"Super duper employee","balance":-125.0,"created":"12-10-2007","ended":null}],"debitCards":[{"id":"4444","status":"ACTIVE","cardNumber":1111.0,"sequenceNumber":32.0,"cardHolder":"Super duper employee","contactless":false,"atmLimit":{"limit":100.0,"periodUnit":"PER_DAY"},"posLimit":{"limit":10000.0,"periodUnit":"PER_MONTH"}},{"id":"4444","status":"ACTIVE","cardNumber":1111.0,"sequenceNumber":32.0,"cardHolder":"Super duper employee","contactless":false,"atmLimit":{"limit":100.0,"periodUnit":"PER_DAY"},"posLimit":{"limit":10000.0,"periodUnit":"PER_MONTH"}}],"creditCards":[],"poas":[{"id":"0002","grantor":"Super duper company","grantee":"Super duper employee","account":"NL23RABO987654321","direction":"GIVEN","authorizations":["DEBIT_CARD","VIEW","PAYMENT"],"cards":[{"id":"4444","type":"DEBIT_CARD"}]},{"id":"0003","grantor":"Super duper company","grantee":"Super duper employee","account":"NL23RABO343434343","direction":"GIVEN","authorizations":["VIEW","PAYMENT"],"cards":null},{"id":"0004","grantor":"Super duper employee","grantee":"Super duper company","account":"NL23RABO123123123","direction":"RECEIVED","authorizations":["VIEW","PAYMENT"],"cards":null}]}
    ```
  * Other uses can be
    * Frodo Basggins
    * Boromir
    * Super duper company
    * Aragorn
    * Fellowship of the ring
    * etc..
    
  
"# Rabo-POA" 
