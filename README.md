This application let's user search all GitHub repositories on single page web-application. 
The frontend is based on Angular and backend is a SpringBoot application providing rest 
services to the frontend. SpringBoot is ideal for microservices atrchitecture since it is 
lightweight webserver based on Tomcat. SpringBoot also provides MVC framework(SpringMVC), 
data(SpringData) framework to perform CRUD operations and Spring RestTemplate to access 
GitHub API over the network.

Frontend is developed using Angular which supports single page application atrchitecture. 
NPM is used as a frontend package manager and also to build frontend code and deploy in a 
small webserver for faster development in local environment.

This application does not need any state based on current requirements, so it can scale 
horizontally very well. We have two option for deployment. The first option is to package
frontend code with backend and run more than one instance of SpringBoot server behind a load balancer. 
And the second option is to run frontend code in Apache server behind a load balancer and 
run more than one instance of SpringBoot server behind a load balancer which will support 
all rest call needed by the frontend code.  

For development, I
have used H2 in-memory database but in production, any RDBMS can be used like MySql etc.

<h1>Frontend Commands:</h1>

1.) npm run start - Start the ng serve with proxy to pass rest call to Spring Boot
 backend application.
 
<h1>Backend Commands:</h1>
<br/>
1.) Run the Spring Boot Server 


<h1>Build for Production:</h1>
1.) npm run build - Builds frontend and copy frontend artifacts to Spring Boot backend
 the application so that site can be accessed from 8080 port.
<br/>
2.) mvn package - To build the jar. Run this command from '$ROOT/server' folder.
<br/>
3.) java -jar users-repo-application-0.0.1-SNAPSHOT.jar
<br/> 
Above command can be run from '$ROOT/server/target' folder. I have also checked in latest jar under '$ROOT/lib' directory.

<h1>URL to access application deployed on AWS</h1>
<a href='http://54.202.122.152:8080/'>http://54.202.122.152:8080/</a>


<h1>Application Features:</h1>
1.) Line item description text box supports type-ahead feature e.g.  if one types character "r" , 
suggestion dropdown shows "regular", "referral bonus", "reward" entries.
<br/>
<br/>
2.) "Preview" button is always enabled and shows the current state of an invoice in the modal pane in a formatted view.
<br/>
<br/>
3.) Form validation is implemented and "Send" button is only enabled when all form entries have been validated. A little green color padding on the leftmost side of form control shows entry is valid and little red padding means entered data is not in correct format.
<br/>
<br/>
4.) Users get informed with various messages on top of the page, like when the invoice is created successfully in the system or
when invoice with the same name already exists in the system. Sucess is shown in green background color and error in the red background color.
<br/>
<br/>
5.) Users can also modify an existing invoice. Once users start typing characters into invoice name text field, existing invoices
whose name start with same characters are shown in suggest box. Once the user selects a particular invoice from the suggestion list, invoice
form is populated with existing invoice details and users can modify it.

 