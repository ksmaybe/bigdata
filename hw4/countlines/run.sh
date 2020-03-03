#!/bin/bash
javac -classpath `yarn classpath` -d . CountlinesMapper.java
javac -classpath `yarn classpath` -d . CountlinesReducer.java
javac -classpath `yarn classpath`:. -d . Countlines.java

jar -cvf count.jar *.class

hadoop jar count.jar Countlines /user/sk7090/hw4_test/input/AB_NYC_2019.csv /user/sk7090/hw4_test/output

