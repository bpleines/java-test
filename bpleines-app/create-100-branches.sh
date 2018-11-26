#!/bin/bash
for feature in 5 6 7 8 9
do
    echo $feature
    git checkout -b feature$feature
    git push -u --set-upstream origin feature$feature
done
