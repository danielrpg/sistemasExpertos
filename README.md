Jess Install in /opt

cd sistemasExpertos

ln -s /opt/yourJessVersion/lib lib

javac -d classes/ -classpath lib/jess.jar modelo/*.java Inicio.java

cd classes

java -classpath ../lib/jess.jar:. sistemasExpertos.Inicio
