#!/usr/bin/env bash

set -e

java -jar lib/objectmacro.jar -d tests/objectmacro/common/intermediate/ tests/objectmacro/common/back-tests/cycle2.objectmacro
java -jar lib/objectmacro-back.jar -d tests/objectmacro/java -p back.cycle.macro tests/objectmacro/common/intermediate/cycle2.intermediate
java -jar lib/objectmacro.jar -d tests/objectmacro/common/intermediate/ tests/objectmacro/common/graph_generator.objectmacro
java -jar lib/objectmacro-back.jar -d tests/objectmacro/java -p graph_generator.macro tests/objectmacro/common/intermediate/graph_generator.intermediate
javac -cp tests/objectmacro/java/ -d classes/ tests/objectmacro/java/back/*.java tests/objectmacro/java/back/cycle/*.java tests/objectmacro/java/graph_generator/*.java
#java -cp classes/ back.cycle.SequentialCase
java -cp classes/ back.cycle.PerformanceRandomCase
