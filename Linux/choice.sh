#! /bin/sh

echo ">> favorite choice : Yena / Chaewon / Yuri"
case "$1" in
  Yena)
    echo ">> choice : Yena";;
  Chaewon)
    echo ">> choice : Chaewon";;
  Yuri)
    echo ">> choice : Yuri";;
  *)
    echo "No Choice";;
esac

exit 0
