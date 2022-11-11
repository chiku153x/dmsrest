FROM maven:3.8.5-amazoncorretto-17 as builder
LABEL authors="chinthaka.gayan@gmail.com"
USER root
RUN echo "11-11-2022_1"
WORKDIR /tmp/app
COPY src ./src
COPY pom.xml ./

#This works only with the latest docker versions
RUN --mount=type=cache,target=/root/.m2 mvn -T 8 clean package -Dmaven.test.skip
#RUN  mvn -T 8 clean package -Dmaven.test.skip

FROM amazoncorretto:17-al2-jdk
USER root
RUN echo "11-11-2022_0"
RUN mkdir /opt/resources \
    && chmod -R 777 /opt/resources \
    && mkdir /opt/tmp \
    && chmod -R 777 /opt/tmp

WORKDIR /opt/target
COPY --from=builder  /tmp/app/target .
COPY conf/application.properties /opt/resources
RUN mkdir /home/docs
RUN chmod -R 777 /home/docs
COPY ["setup.sh",  "./"]

EXPOSE 8080 5005
CMD ["sh","./setup.sh"]
