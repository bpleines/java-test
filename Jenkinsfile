#!/usr/bin/env groovy
println env.JOB_NAME;
println env.JOB_NAME.split("/")[0];
println env.BRANCH_NAME;

node {
    stage ('Get Changeset') {
      commitChangeset = sh(returnStdout: true, script: "git checkout master ; git diff --name-only ${env.BRANCH_NAME}").trim()
      sh "echo ${commitChangeset}"
    }
    stage ('Pipeline1: Build Submodule 2') {
            sh 'cd test-app2'
    }
    if ( env.BRANCH_NAME == 'master' ) {
    stage ('Pipeline1: Promote') {
           //
    }
    } 
}
