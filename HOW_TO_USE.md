# How to use Alfred

First, Install Alfred, [click here](https://sourceforge.net/projects/nkg447-alfred/) to download.

*Alfred* is used as a command line tool which takes the following arguments - <br />
-c , --code [filename] - File name of the source code file.<br />
-i , --input [filename] - File name of the file containing the input.<br />
-o , --output [filename] - File name of the file containing the expected output.<br />

For Example - 
```
$ alfred -c FlippingMatrix.py -i input -o output 
```
The default name of input and output file are "input" and "output".Therefore the below command would also work -
```
$ alfred -c FlippingMatrix.py
```
will have an output - 
```
executing -  python FlippingMatrix.py
python FlippingMatrix.py exitValue() 0
time taken 43ms
////////////////
Testcase Passed
////////////////

Input - 
1
2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108

----------------------------------------------------------

Your Output - 
414

```
