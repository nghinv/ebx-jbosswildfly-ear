# ebx-jbosswildfly-ear

## setup WildFly

download wildfly-14.0.1.Final.zip

unzip wildfly-14.0.1.Final.zip

run ```wildfly-14.0.1.Final/bin/add-user.sh```

*  Management User
*  username: mickael
*  password: mickael

update wildfly-14.0.1.Final/bin/standalone.conf

*  find ```JAVA_OPTS="$JAVA_OPTS -Djboss.modules.system.pkgs=$JBOSS_MODULES_SYSTEM_PKGS -Djava.awt.headless=true"```
*  add below ```JAVA_OPTS="$JAVA_OPTS -Debx.home=/path/to/EBXHOME"```
*  add below ```JAVA_OPTS="$JAVA_OPTS -Debx.properties=/path/to/EBXHOME/ebx.properties"```

update wildfly-14.0.1.Final/standalone/configuration/standalone.xml

*  find ```<datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">```
*  you can customize your own jndi datasource

update EBXHOME/ebx.properties

*  ebx.license=XXXXX-XXXXX-XXXXX-XXXXX

http://127.0.0.1:9990

## run WildFly

```
wildfly-14.0.1.Final/bin/standalone.sh
```

open http://127.0.0.1:8080/ebx

## Build

```
mvn clean install && cd buildear && mvn clean install && cp target/app-1.0.0.ear wildfly-14.0.1.Final/standalone/deployments/
wildfly-14.0.1.Final/bin/standalone.sh
```
