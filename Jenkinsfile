#!/usr/bin/env groovy
switch(env.JOB_NAME.split("/")[0])
{
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

if (project == 'pipeline1') {
pipeline {
    agent {
        docker { image 'maven:3-alpine' }
    }
    stages {
        stage ('Pipeline1: Build Submodule') {
            steps {
                sh 'cd bpleines-app ; mvn clean install'
            }
        }
        stage ('Pipeline1: Build Submodule 2') {
            steps {
                sh 'cd test-app2 ; mvn clean install'
            }
        }
        stage ('Pipeline1: Promote') {
                when {
                    expression { env.BRANCH_NAME == 'master' }   
                }
                steps {
                    sh 'echo Promoted'
                }
        }
    }
    post {  
         failure { 
             sh 'echo The pipeline failed, do something' 
         }
         success {
             sh 'echo The pipeline succeeded!'
         }
    } 
}
}

if (project == 'pipeline2') {
pipeline {
    agent {
        docker { image 'maven:3-alpine' }
    }
    stages {
        stage ('Pipeline1: Build Submodule') {
            steps {
                sh 'cd bpleines-app ; mvn clean install'
            }
        }
        stage ('Pipeline1: Build Submodule 2') {
            steps {
                sh 'cd test-app2 ; mvn clean install'
            }
        }
        stage ('Pipeline1: Promote') {
                when {
                    expression { env.BRANCH_NAME == 'master' }
                }
                steps {
                    sh 'echo Promoted'
                }
        }
    }
    post {
         failure {
             sh 'echo The pipeline failed, do something'
         }
         success {
             sh 'echo The pipeline succeeded!'
         }
    }
}
}

