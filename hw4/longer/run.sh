#!/bin/bash
javac -classpath `yarn classpath` -d . LongerMapper.java
javac -classpath `yarn classpath` -d . LongerReducer.java
javac -classpath `yarn classpath`:. -d . Longer.java

jar -cvf long.jar *.class

hadoop jar long.jar Longer /user/sk7090/hw4_test/input/AB_NYC_2019.csv /user/sk7090/hw4_test/output

