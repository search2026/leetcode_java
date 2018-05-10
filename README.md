# Leetcode problems solved in Java

Some Java coding exercises. Under development and optimization.

## Requirements
* Java >= 1.8.171
* Gradle >= 4.7

## Generate an IntelliJ IDEA project

```bash
gradle idea
```

## Generate a file for a question

```bash
gradle -q question "-Pq=Some Question"
```

The above command will generate a source file called `src/main/java/some_question/SomeQuestion.java`, and you can write your solution in this file directly.

Unit tests are also embedded as inner classes of the main code. For an explanation of this design choice see Ben J. Christensen's [JUnit Tests as Inner Classes](http://benjchristensen.com/2011/10/23/junit-tests-as-inner-classes/).

## Run unit tests

If you write some unit tests, you can use the following command to run them.

```bash
# run all tests
gradle test 
# run TwoSum test only
gradle -Dtest.single=TwoSum test
# run TwoSum test only with some informnation
gradle -Dtest.single=TwoSum test --info
```

## Update Logs

6/4/2016
* Update leetcode questions to #353
* Add some unit tests

12/20/2015
* Update all leetcode coding questions (Up to #319)
* Few codes have unit tests

