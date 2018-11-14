FROM jboss/wildfly:14.0.1.Final

USER root

RUN /opt/jboss/wildfly/bin/add-user.sh mickael mickael --silent

ENV EBX_HOME /data/app/ebx
RUN mkdir -p ${EBX_HOME} \
  && chown -R jboss:0 /data \
  && chmod -R g+rw /data

COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/
COPY standalone.conf /opt/jboss/wildfly/bin/
COPY ebx.properties /data/app/ebx/

COPY app.ear /opt/jboss/wildfly/standalone/deployments/

VOLUME ["/data/app/ebx"]
EXPOSE 9990 8080

USER jboss
