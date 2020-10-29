#!/usr/bin/env bash

# Solution using head, wc, and cut commands
nCol=$(head -n1 file-to-transpose.txt | wc -w)

for i in $(seq 1 "$nCol"); do
  # shellcheck disable=SC2046
  # shellcheck disable=SC2005
  echo $(cut -d' ' -f"$i" file-to-transpose.txt)
done

# Solution using head, wc, xargs, cut, and paste commands
head -1 file-to-transpose.txt | wc -w | xargs seq 1 | xargs -I{} -n 1 sh -c "cut -d ' ' -f{} file-to-transpose.txt | paste -sd ' ' -"

# Solution using awk programming
awk '{for(i=0;++i<=NF;)a[i]=a[i]?a[i] FS $i:$i}END{for(i=0;i++<NF;)print a[i]}' file-to-transpose.txt
