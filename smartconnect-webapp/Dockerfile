FROM jboss/wildfly:latest

MAINTAINER "Agata Bereza"

ADD target/ROOT.war /opt/jboss/wildfly/standalone/deployments/

RUN wildfly/bin/add-user.sh admin admin --silent

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

#ADD config /opt/jboss/wildfly/config/

#COPY target/ROOT.war /opt/jboss/wildfly/config/

#CMD ["/opt/jboss/wildfly/config/execute.sh"]