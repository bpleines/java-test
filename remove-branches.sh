#!/bin/bash
for feature in 1 2 3 4 5
do
    echo $feature
    git branch -d feature$feature
    git push origin --delete feature$feature
done
