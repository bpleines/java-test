#!/usr/bin/env groovy
println env.JOB_NAME
println env.JOB_NAME.split("/")[0]
def result
switch(env.JOB_NAME.split("/")[0]) {
  case 'Pipeline1':
    project = 'pipeline1'
    break
  case 'Pipeline2':
    project = 'pipeline2'
    break
  default:
    project = ''
    break
}
result

if (project == 'pipeline1') {
pipeline {
    node {
        stage ('Pipeline1: Build Submodule') {
                'cd bpleines-app ; mvn clean install'
        }
        stage ('Pipeline1: Build Submodule 2') {
                'cd test-app2 ; mvn clean install'
        }
        stage ('Pipeline1: Promote') {
                if ( env.BRANCH_NAME == 'master' ) {   
                     'echo Promoted'
                }
        }
    }
    post {  
         failure { 
             'echo The pipeline failed something'
         }
         success {
             'echo The pipeline succeeded'
         }
    } 
}

if (project == 'pipeline2') {
pipeline {
    node {
        stage ('Pipeline1: Build Submodule') {
                'cd bpleines-app ; mvn clean install'
        }
        stage ('Pipeline1: Build Submodule 2') {
                'cd test-app2 ; mvn clean install'
        }
        stage ('Pipeline1: Promote') {
                if (env.BRANCH_NAME == 'master') {
                    'echo Promoted'
                }
        }
    }
    post {
         failure {
             'echo The pipeline failed something'
         }
         success {
             'echo The pipeline succeeded'
         }
    }
}
}
