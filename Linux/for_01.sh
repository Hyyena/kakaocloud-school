#! /bin/sh

cnt = 0
for num in 1 2 3 4 5
do
  echo ">> No.$cnt : $num"
  cnt = `expr $cnt + 1`
done

exit 0
