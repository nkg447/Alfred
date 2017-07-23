# Alfred
Your own butler to run your code against test cases.<br />
<img src="https://vignette1.wikia.nocookie.net/batman/images/2/2c/Batman_TAS_-_Alfred_Pennyworth.jpg/revision/latest?cb=20170629213713" width="100">

## Getting Started
These instructions will help you get the project up and running on your local machine.

### Prerequisites
Install these softwares before going further - 
* *JAVA*
* *MAVEN* to install -> [how to install](https://www.mkyong.com/maven/how-to-install-maven-in-ubuntu/)

### Installing
Execute the following commands to install the project.
```
pathToMavenFolder/bin/mvn install
```
usually the pathToMavenFolder is "/usr/share/maven/".
After the maven build execute the install.sh file to install Alfred
```
chmod 777 install.sh
./install.sh
```
#### How To Use : 
see [HOW_TO_USE.md](https://github.com/nkg447/Alfred/blob/master/HOW_TO_USE.md)

## Language Supported 
* JAVA
* C++
* PYTHON
* C

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [JCommander](jcommander.org) - Parse Command Line Parameters

