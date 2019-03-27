FROM frolvlad/alpine-java
MAINTAINER praneeth0448@gmail.com
COPY /src/ /home/user/hello
WORKDIR /home/user/hello
RUN javac LastAccessed.java
CMD ["java","LastAccessed"]