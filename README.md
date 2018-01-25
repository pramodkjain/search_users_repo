This application let's user search all public GitHub repositories by using their user-ids 
on single page web-application. The frontend is based on Angular and backend is a SpringBoot
application providing rest services to the frontend. SpringBoot is ideal for micro-services
architecture since it is lightweight web-server based on Tomcat. SpringBoot also provides 
MVC framework(SpringMVC), data(SpringData) framework to perform CRUD operations and Spring 
RestTemplate frameworks to access GitHub API over the network.

Frontend is developed using Angular which supports single page application architecture. 
NPM is used as a frontend package manager and also to build frontend code and deploy in a 
small web-server for faster development in local environment.

This application does not need any state based on current requirements, so it can scale 
horizontally very well. We have two option for deployment. The first option is to package
frontend code with backend and run more than one instance of SpringBoot server behind a load balancer. 
And the second option is to run frontend code in Apache server behind a load balancer and 
run more than one instance of SpringBoot server behind a load balancer which will support 
all rest call needed by the frontend code.  

For development, I have used H2 in-memory database but in production, any RDBMS can be 
used like MySql etc.

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
1.) 'Find Repositories' button is disbaled till some text is keyed in 'User Id' input text box.
<br/>
<br/>
2.) User's avatar image,userid and a link to GitHub page is provided under user detail section.
<br/>
<br/>
3.) Repository name, description and stargazers count is presented under repositories detail section as a list. 
<br/>
<br/>
4.) Users get informed with various messages on top of the page, like when no repositry is found for a keyed-in user-id or
when same user-id is searched again with-in 3 minutes. Sucess is shown in green background color and error in the red background color.
<br/>
<br/>

 