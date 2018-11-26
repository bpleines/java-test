#!/bin/bash
for feature in 5 6 7 8 9
do
    echo $feature
    git checkout -d feature$feature
    git push -u --delete feature$feature
done
