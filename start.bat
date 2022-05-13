chcp 65001
javac -encoding utf-8 -d ./out/production/Slovar -sourcepath ./src src/Main/Main.java 
java  -Dfile.encoding=UTF-8 -cp ./out/production/Slovar Main.Main
pause