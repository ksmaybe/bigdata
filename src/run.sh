javac -classpath `yarn classpath` -d . WordCounterMapper.java
javac -classpath `yarn classpath` -d . WordCounterReducer.java
javac -classpath `yarn classpath`:. -d . WordCounter.java

jar -cvf wordCount.jar *.class

hadoop jar wordCount.jar WordCounter /user/sk7090/hw2_test/input/input.txt /user/sk7090/hw2_test/output

