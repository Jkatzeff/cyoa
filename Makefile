#Makefile
#Compiles all files and runs CYOA program
JAVASRC = cyoa.java Room.java List.java LList.java ReadFile.java Stack.java Helper.java
MAINCLASS = cyoa
CLASSES = cyoa.class List.class LList.class ReadFile.class Room.class Stack.class Helper.class
all: ${CLASSES} 
test: ${CLASSES}
	java cyoa demo.adventure
${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}
clean:
	rm *.class ${JARFILE}
.PHONY: clean all