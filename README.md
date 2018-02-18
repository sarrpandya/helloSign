# How to Run Tests in Local Machine
1.Clone git url into your local Mac machine or import directly into eclipse

2.Open Terminal and Type "mvn clean install -DenvName=qa" command (where I have store amazon url under property file just to demonstrate dynemic url )  

OR

3.Right click run as testNG of UITests / BackendTest or Run testng.xml file


# How to see Test Results
1.Once you finish running test case Go to test-out and open emailable report for HTML report

# Solution Approach
1.I have Used Page Object model framework where I have store all the web elements location in separated class with necessary method

2.I have Kept Test Class separated where I have written all test validation.

3.I have added small Test case to validate 200 Response status of Amazon under backedTest Java file

# Note : This tests has mouseover events so please dont hover your mouse in browser while running the tests
# Note : Please run tests in Mac machine and Firefox latest version
# Note : Sometime depending on internet speed / advertise message on Amazon website some tests may get fail so please make sure you run tests in high internet Speed.
