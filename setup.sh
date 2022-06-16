#!/bin/bash
export APP_PROP="/opt/resources/application.properties"
sed -i "s/V_DB_URL/${DB_URL}/g" ${APP_PROP}
sed -i "s/V_DB_USER/${DB_USER}/g" ${APP_PROP}
sed -i "s/V_DB_PASS/${DB_PASS}/g" ${APP_PROP}
cat ${APP_PROP}
java -jar dmsrest-0.0.1-SNAPSHOT.jar --spring.config.location=${APP_PROP} --spring-boot.run.jvmArguments="-Xms4048m -Xmx8096m"
