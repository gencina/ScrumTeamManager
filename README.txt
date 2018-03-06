----------------------------------------------------------
INTRODUCTION
----------------------------------------------------------
The application Scrum Team Manager lists the users assign to scrum teams and their permissions.
The information will be printed in the screen. 


----------------------------------------------------------
REQUIREMENTS
----------------------------------------------------------
The application requires JAVA 1.6


----------------------------------------------------------
HOW TO USE
----------------------------------------------------------
In Windows or Linux 

1- Unzip ScrumTeamManager.zip
2- Open a command line 
3- Go to folder ScrumTeamManager
4- Execute java -jar deploy/scrumTeamManager.jar_txt

If you need to test different test files replace or modify UserAssignment.txt

Sample data format:  

	{%user email%}, {%team%}, {%role1%}:{%role2%}:{%role3%}


----------------------------------------------------------
DESIGN
----------------------------------------------------------

File structure:

ScrumTeamManager
|__classes
|__deploy
|__sampleData
|__src
|  |__stm
|      |__ config
|      |__ domain
|      |__ process
|      |__ test
|__README.txt
|__UserAssigment.txt


ScrumTeamManager : project folder.
classes: contains the compiled classes.
deploy:  contains the executable archive scrumTeamManager.jar.
sampleData: folder with test files.
src: contains the source code:
 __config: contains ConfigurationManager class which initializes the data and manages the file access.
 __domain: contains User class which defines the user attributes and behavior.
 __process: contains AssignmentProcess class which determines and updates the user permissions.
 __test: contains TestProcess class which is the main class.
README.txt: this file explains briefly the purpose, requirements and project structure.
UserAssigment.txt: this file contains the user permissions that need to be updated.