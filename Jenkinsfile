#!/usr/bin/env groovy
println env.JOB_NAME;
println env.JOB_NAME.split("/")[0];
println env.BRANCH_NAME;

node {
    stage ('Get Changed Files') {
      commitChangeset = sh(returnStdout: true, script: "git checkout master ; git diff --name-only ${env.BRANCH_NAME}").trim()
      sh "echo ${commitChangeset}"
    }
    stage ('Build Submodule') {
            sh 'cd test-app2'
    }
    if ( env.BRANCH_NAME == 'test1' ) {
        stage ('Pipeline1: Promote') {
           //
        }
    } 
}
