FROM maven:3.8.5-amazoncorretto-17 as builder
LABEL authors="chinthaka.gayan@gmail.com"
USER root
WORKDIR /tmp/app
COPY src ./src
COPY pom.xml ./

#This works only with the latest docker versions
RUN --mount=type=cache,target=/root/.m2 mvn clean package -Dmaven.test.skip
#RUN  mvn clean package -Dmaven.test.skip

FROM amazoncorretto:17.0.3-al2
USER root
RUN yum install -y python3

RUN mkdir /opt/resources \
    && chmod -R 777 /opt/resources \
    && mkdir /opt/tmp \
    && chmod -R 777 /opt/tmp

WORKDIR /opt/target
COPY --from=builder  /tmp/app/target .
COPY conf/application.properties /opt/resources
COPY ["setup.sh", "env.py",  "./"]

EXPOSE 8080 5005
CMD ["sh","./setup.sh"]
