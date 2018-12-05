#!/usr/bin/env groovy
println env.JOB_NAME;
println env.JOB_NAME.split("/")[0];
println env.BRANCH_NAME;

node {
    stage ('Get Changed Files') {
      checkout scm
      def workspace = pwd()
      sh "echo ${workspace}"
      sh "./detect_branch_changes.sh ${env.BRANCH_NAME}"
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
