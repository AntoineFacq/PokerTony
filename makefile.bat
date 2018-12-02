@echo off
set source=C:\Users\antoi\Documents\GitHub\Poker-java\PokerTony\src\
set bin=C:\Users\antoi\Documents\GitHub\Poker-java\PokerTony\bin\
set PaD=C:\Users\antoi\Documents\GitHub\Poker-java\PokerTony\lib\PaD.jar

set CLASSPATH=%bin%;%PaD%
set JAVAPATH=%PaD%;%source%

:: Delete older compiled code
cd %bin%
del *.class /f /q

:: List not compiled files
cd %source%
dir /s/b/a-d *.java > src.txt

:: Compile java code and put the file in the bin folder
javac -cp %JAVAPATH% -encoding utf8  -d %bin% @src.txt

:: Execute code
java -cp %CLASSPATH% PokerTony



