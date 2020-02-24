#!/usr/bin/env bash
rm *.class
rm *.jar
hdfs dfs -mkdir hw4_test
hdfs dfs -mkdir hw4_test/input
hdfs dfs -put AB_NYC_2019.csv hw4_test/input
hdfs dfs -ls hw4_test/input
bash run.sh

hdfs dfs -cat hw4_test/output/part-r-00000
