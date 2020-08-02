FROM openjdk:11 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
COPY . .
RUN ./gradlew  clean build -x test


FROM openjdk:11
ENV APP_HOME=/usr/app/
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/seguradora-0.0.1-SNAPSHOT.jar .
EXPOSE 9091
CMD ["java","-jar","seguradora-0.0.1-SNAPSHOT.jar"]