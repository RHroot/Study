#!/usr/bin/env bash

echo "Compiling Java Project...💀"

mkdir -p bin lib

javac -cp "lib/*" -d bin src/main/java/com/analyzer/*.java

echo "Compilation complete!💀"
echo "Run🚀 with: ./run.sh"
