javac -encoding utf-8 -d ./target/classes -sourcepath ./src/main/java src/main/java/com/dictionary/Main.java
java  -Dfile.encoding=UTF-8 -cp ./target/classes dictionary.Main qwe
pause