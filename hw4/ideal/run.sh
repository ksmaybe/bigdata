#!/bin/bash
javac -classpath `yarn classpath` -d . IdealMapper.java
javac -classpath `yarn classpath` -d . IdealReducer.java
javac -classpath `yarn classpath`:. -d . Ideal.java

jar -cvf ideal.jar *.class

hadoop jar ideal.jar Ideal /user/sk7090/hw4_test/input/AB_NYC_2019.csv /user/sk7090/hw4_test/output

