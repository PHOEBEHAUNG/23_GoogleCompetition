#!/bin/sh

for file in "."/*
do
  if [[ $file == *".cpp" ]]; then
    ouputName=$(echo $file | cut -d"." -f 2)
#    echo ${file}
#    echo ${ouputName}
#    echo ${ouputName:1}
    ouputName=${ouputName:1}
    g++ "$file" -o $ouputName
  fi
done


