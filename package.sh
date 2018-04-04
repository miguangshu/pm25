#!/bin/bash
mvn clean package -Ptest -Dmaven.test.skip=true
#ssh root@115.28.109.174 sh /usr/local/yimu/yimu-server/bin/shutdown.sh
#echo 'sleep 15s'
#sleep 15
#ssh root@115.28.109.174 rm -rf /usr/local/yimu/yimu-server/webapps/*
#scp apidoc.zip root@115.28.109.174:/usr/local/yimu/yimu-server/webapps
scp target/pm25-1.0-SNAPSHOT.war mgs@222.128.13.159:/home/mgs/tomcat8/webapps
#ssh root@115.28.109.174 unzip /usr/local/yimu/yimu-server/webapps/apidoc.zip -d /usr/local/yimu/yimu-server/webapps/
#ssh root@115.28.109.174 sh /usr/local/yimu/yimu-server/bin/startup.sh

scp target/pm25-1.0-SNAPSHOT.war root@116.196.116.153:/usr/local/tomcat/apache-tomcat-8.5.23/webapps
#buptIot632
#LuckyDog666


