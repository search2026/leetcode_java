## Linux Shell Related Problems

### Readings

- [UNIX Tutorial for Beginners](http://www.ee.surrey.ac.uk/Teaching/Unix/)
- [Sh - the Bourne Shell ](https://www.grymoire.com/Unix/Bourne.html)
- [Top 50 Linux Commands With Examples](https://www.puttygen.com/linux-commands)
- [sed & awk, 2nd Edition, by Dale Dougherty and Arnold Robbins](https://github.com/levunguyen/CGDN-Ebooks/blob/master/Sed%20%26%20Awk.pdf)
- Both awk and sed are tools that transform text. But awk can do more things besides just manipulating text. It is a programming language by itself with most of the things you learn in programming, like arrays, loops, if/else flow control etc. You can "program" in sed as well, but you won't want to maintain the code written in it.

### MacOs install GNU commands
- install brew from [here](https://brew.sh/) if not installed
- install GNU grep, GNU sed, and GNU awk
```
brew install grep # use ggrep command to invoke GNU grep
brew install gnu-sed # use gsed command to invoke GNU sed
brew install gawk # use gawk command to invoke GNU awk
```

### Leetcode Problems

[192. Word Frequency](https://leetcode.com/problems/word-frequency/) 
- [Solutions in Linux commands and awk](../problems101_200/src/main/resources/WordFrequency.sh)

[193. Valid Phone Numbers](https://leetcode.com/problems/valid-phone-numbers/)
- [Solutions in Linux commands, sed and awk](../problems101_200/src/main/resources/ValidPhoneNumbers.sh)

[194. Transpose File](https://leetcode.com/problems/transpose-file/)
- [Solutions in Linux commands and awk](../problems101_200/src/main/resources/TransposeFile.sh)

[195. Tenth Line](https://leetcode.com/problems/tenth-line/)
- [Solutions in Linux commands and awk](../problems101_200/src/main/resources/TenthLine.sh)
