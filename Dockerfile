FROM maven:3.8.5-amazoncorretto-17 as builder
LABEL authors="chinthaka.gayan@gmail.com"
USER root
WORKDIR /tmp/app
COPY src ./src
COPY pom.xml ./

#This works only with the latest docker versions
RUN --mount=type=cache,target=/root/.m2 mvn clean package -Dmaven.test.skip
#RUN  mvn clean package -Dmaven.test.skip

#FROM amazoncorretto:17-al2-jdk
#USER root
#RUN apk add python3
#
#RUN mkdir /opt/resources \
#    && chmod -R 777 /opt/resources \
#    && mkdir /opt/tmp \
#    && chmod -R 777 /opt/tmp
#
#WORKDIR /opt/target
#COPY --from=builder  /tmp/app/target .
#COPY conf/application.properties /opt/resources
#COPY ["setup.sh", "env.py",  "./"]
#
#EXPOSE 8080 5005
#CMD ["sh","./setup.sh"]


FROM alpine:3.7

RUN apk update \
	&& apk upgrade \
	&& apk add --no-cache bash \
	&& apk add --no-cache --virtual=build-dependencies unzip \
	&& apk add --no-cache curl \
	&& apk add --no-cache openjdk7-jre

RUN apk add --no-cache python3 \
	&& python3 -m ensurepip \
	&& pip3 install --upgrade pip setuptools \
	&& rm -r /usr/lib/python*/ensurepip && \
	if [ ! -e /usr/bin/pip ]; then ln -s pip3 /usr/bin/pip ; fi && \
	if [[ ! -e /usr/bin/python ]]; then ln -sf /usr/bin/python3 /usr/bin/python; fi && \
	rm -r /root/.cache


RUN mkdir /opt/resources -p \
    && chmod -R 777 /opt/resources \
    && mkdir /opt/tmp \
    && chmod -R 777 /opt/tmp

WORKDIR /opt/target
COPY --from=builder  /tmp/app/target .
COPY conf/application.properties /opt/resources
COPY ["setup.sh", "env.py",  "./"]

EXPOSE 8080 5005
CMD ["sh","./setup.sh"]
