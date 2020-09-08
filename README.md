# Leetcode problems solution collections in Java

A collection Java solutions to [leetcode problems](https://leetcode.com/problemset/all/). Still under development.

## Requirements
* Java >= 11.0.8
* Gradle == 5.6.3


## Intellij Settings
* Recommended version: Intellij IDEA Community 2020.2.1+
* project structure level: SDK default 11
* Gradle settings ==> runs tests uses ==> "IntelliJ IDEA"

## Run unit tests

If you write some unit tests, you can use the following command to run them.

```bash
# run all tests
gradle test 
# run TwoSum test only
gradle -Dtest.single=TestTwoSum test
# run TwoSum test only with some informnation
gradle -Dtest.single=TestTwoSum test --info
```

## Update Logs

9/25/2020
* Minimum Java version is 11
* Minimum Gradle version is 5.6.3
* Fully support Junit 5
* Overhaul project structure

6/4/2016
* Update leetcode questions to #353
* Add some unit tests

12/20/2015
* Update all leetcode coding questions (Up to #319)
* Few codes have unit tests

