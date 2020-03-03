javac -classpath `yarn classpath` -d . AirbnbMapper.java
javac -classpath `yarn classpath` -d . AirbnbReducer.java
javac -classpath `yarn classpath`:. -d . Airbnb.java

jar -cvf air.jar *.class

hadoop jar air.jar Airbnb /user/sk7090/hw4_test/input/AB_NYC_2019.csv /user/sk7090/hw4_test/output

