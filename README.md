# PayCheckCalculator
Sample paycheck calculator considering federal, state and other miscellaneous taxes for 2016

## Prerequisites
Install following to run the application:

* Eclipse
* Download Tomcat web server

## Steps

* Import application to Eclipse (Import > Import.. > Existing Project to Workspace)
* Add Tomcat to servers list in Eclipse and deploy the application (New > Other > Server > Server > Finish)
* Add -Ddb.path="C:\<PATH TO WORKSPACE>\PayCheckCalculator\payroll.db" to VM Arguments under Run As > Run Configurations.. > Arguments
* Run application on server
* Application should be up and accessible @ http://localhost:8080/PayCheckCalculator/

## Recreating DB
When there are additions / updates to DB scripts under > resources > DBScripts,

* Run > Java Resources > src > edu.itu.pcg.util.DataUtil.java as Java Application