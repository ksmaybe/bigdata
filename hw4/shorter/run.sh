#!/bin/bash
javac -classpath `yarn classpath` -d . LesserMapper.java
javac -classpath `yarn classpath` -d . LesserReducer.java
javac -classpath `yarn classpath`:. -d . Lesser.java

jar -cvf less.jar *.class

hadoop jar less.jar Lesser /user/sk7090/hw4_test/input/AB_NYC_2019.csv /user/sk7090/hw4_test/output

