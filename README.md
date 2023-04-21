# ARXML-files-reader:

-A program that reads an ARXML file containing a list of containers and reorders the containers alphabetically by their short names.

-ARXML stands for Autosar xml.

-Autosar stands for AUTomotive Open System Architecture.

# Program Description:

the program should perform the following steps:

-the program reads an ARXML file containing a list of containers, each with a unique ID,and a name Sub-Container "SHORT-NAME".

-reorders the containers alphabetically by their name sub- container “"SHORT-NAME".

-The output file (containing the reordered containers) shall be named as the same of the input file concatenated with “_mod.arxml”.

# Requirements:

-The name of the arxml file shall be an argument which needs to passed through the command line.

-If the file is not having .arxml extension then you should trigger a user defined checked exception “NotVaildAutosarFileException”.

-If the file is empty, then you should trigger user defined unchecked exception “EmptyAutosarFileException”.

-The output file shall be named as the same of the input file concatenated with “_mod.arxml”.

-Any missing requirement is considered.

# Files Description:

-**argument.arxml**: ARXML file containing input sample to be ordered.

-**Empty.arxml**: ARXML empty file to test (Empty Autosar File Exception).

-**argument_mod**: ARXML file containing the output after runing the program.

-**Arxmlfiles.java**: JAVA file of the program (containing all classes used in the implmentation).

-**BatchFile.bat**: a batch file that runs the program invoking the three possible cases:

1-Input is: argument.arxml (containing sample input) ----> Output is argument_mod. (containing reordered containers).

2-Input is: Empty.arxml (Empty file) ----> Output is "Empty Autosar File Exception".

3-Input is: argument (without .arxml-extension) ----> Output is  "NotVaildAutosarFileException".
