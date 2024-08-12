#!/bin/sh
export SPRING_OPTS=$@
exec java -XX:+HeapDumpOnOutOfMemoryError -XX:+UseZGC -server ${JAVA_OPTS} -jar ${JAR_FILE} ${SPRING_OPTS}
