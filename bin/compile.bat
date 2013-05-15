set JAVA_HOME=C:\Program Files\Java\jdk1.5.0_22
set PATH=%JAVA_HOME%\bin
set tomcatpath=C:\Users\Robert\Pictures\tomcat\lib
set webapppath=C:\Users\Robert\Pictures\tomcat\webapps\ROOT\WEB-INF\classes
set openejbpath=C:\Users\Robert\Pictures\tomcat\webapps\openejb\lib
javac -cp %tomcatpath%\servlet-api.jar;%openejbpath%\javaee-api-5.0-3.jar %webapppath%\*.java %webapppath%\bean\*.java %webapppath%\ejb\*.java