#!/bin/bash

### Compiling on a terminal
### We assume this script to be in the same directory as "poo_ihm2"


find . -name '*.java' > tempo

while read -r string; do
		string_size=${#string}
		string_without_leading_chars=${string:2:${string_size}}
		set -x
		
		## The generated .class files are located next to the related .java files
		## It makes finding the way to non-class files (.fxml, .css files) easier.
		javac -Xlint:all -Xdiags:verbose ${string_without_leading_chars}
				
		{ set +x; } &> /dev/null
done < tempo

rm tempo

# To run the application
## 1) Edit poo_ihm2/course/configuration/config.properties => set "localRootDirectory" to the path leading to "poo_ihm2"
## For instance, if "poo_ihm2" is located in /home/user/src, write:
## localRootDirectory=file:///home/user/src

## 2) Inside the directory containing "poo_ihm2", enter the command
## java poo_ihm2.course.Main


# To remove all .class files from "poo_ihm2":
## find poo_ihm2 -name '*.class' -exec rm {} \;
