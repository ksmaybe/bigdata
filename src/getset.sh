#!/usr/bin/env bash
rm *.class
rm *.jar
hdfs dfs -mkdir hw2_test
hdfs dfs -mkdir hw2_test/input
hdfs dfs -put input.txt hw2_test/input
hdfs dfs -ls hw2_test/input
./run.sh

hdfs dfs -cat hw2_test/output/part-r-00000
