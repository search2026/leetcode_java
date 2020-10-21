# Leetcode problems solution collections in Java

A collection Java/SQL/Bash solutions to [leetcode problems](https://leetcode.com/problemset/all/). Still under development.

## Requirements
* Java >= 11.0.8
* Gradle == 6.6.1

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

## Problems

| Problems | Note |
|---|---|
| [Common Library](common/README.md) | |
| [Problems 1-100](problems1_100/README.md) | |
| [Problems 101-200](problems101_200/README.md) | |
| [Problems 201-300](problems201_300/README.md) | |
| [Problems 301-400](problems301_400/README.md) | |

## Abbreviations

Abbreviations are used to name identifier

| Abbreviations | Meaning |
|---|---|
| | |
| | |
| | |
| | |

## Update Logs

10/20/2020
* Minimum Java version is 11
* Minimum Gradle version is 6
* Fully support Junit 5
* Overhaul project structure
* Update tests for leetcode problems 1-400

6/4/2016
* Update leetcode questions up to #353
* Add some unit tests

12/20/2015
* Update all leetcode coding questions (Up to #319)
* Few codes have unit tests

