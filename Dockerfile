FROM gradle:4.2.1-jdk8-alpine

RUN mkdir clubservice
COPY . ./clubservice

WORKDIR clubservice
 
ENV PATH="/opt/gradle/bin:${PATH}" 
ENV GRADLE_HOME="/opt/gradle/bin"
ENV PORT='9999'

EXPOSE ${PORT}
CMD ["gradle", "run"]
