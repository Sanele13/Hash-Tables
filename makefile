#!/bin/tcsh

#This make file result in the compiling of all my classes.

JAVAC=javac
JFLAGS=-g

*.class:*.java
	$(JAVAC) $(JFLAGS) *.java
clean:
	rm *.class
