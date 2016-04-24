java-exercise
========

Some Java coding exercises. Under development and optimization.

## Requirements
* Java >= 1.8
* Gradle >= 2.12

## Generate an IntelliJ IDEA project

```bash
gradle idea
```

## Generate a file for a question

```bash
gradle question "-Pq=Some Question"
```

The above command will generate a source file called `src/main/java/some_question/SomeQuestion.java`, and you can write your solution in this file directly.

Unit tests are also embedded as inner classes of the main code. For an explanation of this design choice see Ben J. Christensen's [JUnit Tests as Inner Classes](http://benjchristensen.com/2011/10/23/junit-tests-as-inner-classes/).

## Run unit tests

If you write some unit tests, you can use the following command to run them.

```bash
# run all tests
./gradlew test 
# run TwoSum test only
./gradle -Dtest.single=TwoSum test
```

## Update Logs

12/20/2015
* Update all leetcode coding questions (Up to #319)
* Few codes have unit tests

