#!/usr/bin/env bash

java -jar lib/objectmacro.jar -d tests/objectmacro/common/intermediate/ tests/objectmacro/common/graph_generator.objectmacro
java -jar lib/objectmacro-back.jar -d tests/objectmacro/java -p graph_generator.macro tests/objectmacro/common/intermediate/graphe_generator.intermediate
javac -cp tests/objectmacro/java/ -d classes/ tests/objectmacro/java/back/*.java tests/objectmacro/java/back/cycle/*.java
java -cp classes/ back.cycle.Performance
