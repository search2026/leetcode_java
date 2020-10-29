#!/usr/bin/env bash

# Solution using grep command
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file-phone-numbers.txt
# use GNU grep in MacOs
ggrep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file-phone-numbers.txt

# Solution using sed
sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file-phone-numbers.txt
# use GNU sed in MacOs
gsed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file-phone-numbers.txt

# Solution using awk
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file-phone-numbers.txt
