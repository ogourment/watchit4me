@echo off
if [%GRAILS_HOME%]==[] goto setenv
goto theend

:setenv
set GRAILS_HOME=\code\001-ThirdParty\grails
set APPENGINE_HOME=\tools\appengine-java-sdk-1.2.2
set PATH=%PATH%;%GRAILS_HOME%\bin

:theend
echo Environment set