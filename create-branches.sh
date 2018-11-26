#!/bin/bash
for feature in 1 2 3 4 5
do
    echo $feature
    git checkout -b feature$feature
    git push -u --set-upstream origin feature$feature
done
