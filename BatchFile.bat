@echo off
echo "Name of the file containing the input sample is: argument"
echo "Name of the empty file is: Empty"
javac *.java
java Arxmlfiles argument.arxml
java Arxmlfiles Empty.arxml
java Arxmlfiles argument
pause