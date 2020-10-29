#!/usr/bin/env bash

# Solution using head, wc, and cut commands
ncol=`head -n1 file.txt | wc -w`

for i in `seq 1 $ncol`
do
    echo `cut -d' ' -f$i file.txt`
done

# Solution using head, wc, xargs, cut, and paste commands
head -1 file.txt | wc -w | xargs seq 1 | xargs -I{} -n 1 sh -c "cut -d ' ' -f{} file.txt | paste -sd ' ' -"

# Solution using awk programming
awk '{for(i=0;++i<=NF;)a[i]=a[i]?a[i] FS $i:$i}END{for(i=0;i++<NF;)print a[i]}' file.txt
