#!/usr/bin/env groovy
println env.JOB_NAME;
println env.JOB_NAME.split("/")[0];
println env.BRANCH_NAME;

node {
    stage ('Get Changed Files') {
      def workspace = pwd()
      sh "echo ${workspace}"
      dir (workspace) {
          sh 'detect_branch_changes.sh'
      }
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
