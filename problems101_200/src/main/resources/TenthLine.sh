#!/usr/bin/env bash

# Solution using head and tail commands.
tail -n+10 file.txt | head -1

# Solution using sed
sed -n '10p' file.txt

# Solution using awk
awk 'NR==10' file.txt
