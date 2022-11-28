javac -cp ".;JFlex.jar;java-cup-11a-RELEASE150.jar;java-cup-11a-runtime.jar" Compiler.java
mkdir src
copy entrada.txt src
java -cp ".;JFlex.jar;java-cup-11a-RELEASE150.jar;java-cup-11a-runtime.jar" Compiler