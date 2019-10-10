# MatchGame
This is a Java Web App overview through a famous game MatchesGame.

# Description 
This project is used to demonstrate a quick overview about Java Web App with Tomcat as an App Server.
This is the first version of this app. It can be improved.
It demonstrates:
- Local and Remote Tomcat configuration
- Maven usages (dependency management, packaging, project management)
- Git usages (deployment, git flow)
- Integrate BootStrap 4 
- JSP and Java logic implementation 

Some features are schedule on the next version. Please, see the Features part.

# Author
######Mathieu LE VEVE

# Maven
This project is a Maven Project. It follows the following design:

***Version used:3.5.0***

```
MatchGame
 |-- src
 |    |-- main
 |         |-- java
 |         |    |-- webapp
 |         |         |-- common
 |         |         |     |-- config
 |         |         |      |-- *.java
 |         |         |     |-- utils
 |         |         |       |-- *.java
 |         |         |-- models
 |         |         |    |-- player
 |         |         |       |-- *.java
 |         |         |-- servlet
 |         |         |    |-- *.java
 |         |         |-- *.java
 |         |-- resources
 |         |-- web
 |              |-- css
 |              |-- fonts
 |              |-- js
 |              |-- WEB-INF
 |              |    `-- web.xml
 |              `-- jsp
 |                   `-- matchgame.jsp
 |              |-- index.jsp
 |    |-- test
 |    |     |-- [...]
```

# Prerequisites - Dev part
1. Having JKE 12 installed
2. Download, install and configure Tomcat 9.0.26 _LATEST RELEASE_
3. Install a git tool (git bash/ Git Ui and configure)
4. Type `git clone [project_repo]` for cloning this project in your local working environment.

# Working steps - V0.1
- [x] Design the project, install tools and configure them as well.
- [ ] Integrate JQuery, Bootstrap, and package them into the project.
- [x] Making the project as much as stable
- [x] Push the main changes to the dev pipeline
- [x] Create JSP - Home & Game
- [ ] Customize the HTML pages
- [x] Implement the match game logic
- [ ] Build and Run successfully
- [ ] Refactor code
- [ ] Documentation updated

# Tomcat Part

***Version used:9.0.26***

***Downloading link:[Tomcat 9.0.26](http://miroir.univ-lorraine.fr/apache/tomcat/tomcat-9/v9.0.26/bin/apache-tomcat-9.0.26-windows-x64.zip)***

***How configuring Tomcat after downloading:***

****On Local Environment (I am using IntelliJ)****
- Decompress the .ZIP file
- Configure your Tomcat home to your download location > apache-tomcat-9.0.26-windows-x64 file.
- Making sure that your Port 8080 is free. Otherwise, change this config to another one in your local environment.
 
***Launching Tomcat:It works on `localhost:8080/App/` by default.***

****Deploy on Remote Environment****
- Install Tomcat 9.0.26 (My OS is Windows)
- Configure your Tomcat controls.
- Launch a Tomcat service. It starts on `<ip_machine>:8080` by default.
- Go to Manage App control
- Deploy the WAR file contained inside `./out/artifacts/App` to Tomcat repo.
- Start the new Tomcat service in `<ip_machine>:8080/App`


# Features

- Improve the Maven lifecyle management (automated deployment to Tomcat, dependencies, packaging, run tests ...)
- Improve the GameConfig design pattern
- Implement completely the HTML pages (bootstrap, js, etc...)
- Improve the Deployment configuration (put dynamically the app context un web.xml)
- Add UT
- Add CI/CD processes
- No doGet, use doPost
- BootStrap wa snot integrated successfully after the deployment. Should be fixed.
