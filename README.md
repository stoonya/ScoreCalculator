# ScoreCalculator
 
Given a set of JSON objects (in a file is fine), for each unique ID field show the unique IPs associated with it and the number of times that IP appeared.  Also, sum the score for that ID.  Make no assumptions about the incoming JSON.

Example input:

{"id":"test","score":12,"ip":"1.2.3.4","message":"Hi"}

{"id":"test","score":5,"ip":"1.2.3.5"}

{"id":"test","score":17,"ip":"1.2.3.4"}

{"id":"test2","score":9,"ip":"1.2.3.4"}

 

Example output:

test:

    1.2.3.5: 1

    1.2.3.4: 2

    score: 34

test2:

    1.2.3.4: 1

    score: 9

 

Goal: Design and implement both the program to accomplish this, and the script to test the program in Java.
