@echo off
set jarName=kotlin-code-1.0-SNAPSHOT.jar
echo "test mvn compiler"
call mvn clean package
java -jar ./target/%jarName%
echo "run stop!"
pause
