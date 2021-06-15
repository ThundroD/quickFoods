FROM openjdk:11
WORKDIR /app
COPY . /app
RUN javac quickFoods/*.java
CMD java quickFoods/QuickFoods