# How to use Alfred

First, Install Alfred using the instructions given in [README.md](https://github.com/nkg447/Alfred/blob/master/README.md).

*Alfred* is used as a command line tool which takes the following arguments - <br />
-c , --code [filename] - File name of the source code file.<br />
-i , --input [filename] - File name of the file containing the input.<br />
-o , --output [filename] - File name of the file containing the expected output.<br />

For Example - 
```
alfred -c NextNumber.java -i input.txt -o output.txt
```
will have an output - 
```
executing -  javac NextNumbers.java
executing -  java  NextNumbers
java  NextNumbers exitValue() 0
time taken 134ms
////////////////
Testcase Passed
////////////////


Expected Output - 
-536870912
largest - 1879048192
zeros - 29
smallest - -1

----------------------------------------------------------

Your Output - 
-536870912
largest - 1879048192
zeros - 29
smallest - -1
```
