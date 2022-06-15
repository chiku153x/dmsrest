#!/bin/bash
export APP_PROP="/opt/resources/application.properties"
python env.py ${APP_PROP}
cat ${APP_PROP}
java -jar dmsrest-0.0.1-SNAPSHOT.jar --spring.config.location=${APP_PROP} --spring-boot.run.jvmArguments="-Xms4048m -Xmx8096m"
