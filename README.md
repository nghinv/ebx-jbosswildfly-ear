# ebx-jbosswildfly-ear

## build

use jdk8

```
mvn clean install && cp buildear/target/buildear-1.0.0.ear ./app.ear
docker build -t wildfly-mdm:0.0.1 .
```

### To boot in standalone mode

```
put your ebxLicense in ~/.profile
export EBXLICENSE=XXXXX-XXXXX-XXXXX-XXXXX
source ~/.profile

docker run -p 8080:8080 -p 9990:9990 --rm --name ebx1 --mount type=volume,src=wildfly1,dst=/data/app/ebx -e "EBXLICENSE=$EBXLICENSE" -it wildfly-mdm:0.0.1 /opt/jboss/wildfly/bin/standalone.sh -bmanagement 0.0.0.0 -b 0.0.0.0

open http://127.0.0.1:9990
open http://127.0.0.1:8080/ebx
```

### configuration

#### user

you can change that in Dockerfile

*  Management User
*  username: mickael
*  password: mickael

#### java opts

EBXHOME and ebx.properties defined in standalone.conf

*  ```JAVA_OPTS="$JAVA_OPTS -Debx.home=/data/app/ebx"```
*  ```JAVA_OPTS="$JAVA_OPTS -Debx.properties=/data/app/ebx/ebx.properties"```

to customize the db datasource, see standalone.xml

*  find ```<datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">```
*  you can customize your own jndi datasource

## troubleshoot env variables

```
docker run --rm -e "EBXLICENSE=$EBXLICENSE" -it wildfly-mdm:0.0.1 printenv
```

## troubleshoot image

```
docker run --rm --name ebx1 -it wildfly-mdm:0.0.1 /bin/bash
/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0
/opt/jboss/wildfly/bin/standalone.sh -bmanagement 0.0.0.0 -e "EBXLICENSE=$EBXLICENSE"
```

## connect to running container

```
docker exec -it ebx1 /bin/bash
```

## export docker files

```
docker cp ebx1:/data/app/ebx/ebxLog ebxLog/
docker cp ebx1:/opt/jboss/wildfly/standalone/configuration/standalone.xml .
docker cp ebx1:/opt/jboss/wildfly/bin/standalone.conf .
```

## Docker cleanup

Delete dangling and untagged images

```
docker rmi $(docker images -q -f dangling=true)
```
