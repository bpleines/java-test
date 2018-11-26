pipeline {
    agent {
        docker { image 'maven:3-alpine' }
    }
    stages {
        stage ('Build Submodule') {
            steps {
                sh 'cd bpleines-app ; mvn clean install'
            }
        }
        stage ('Build Submodule 2') {
            steps {
                sh 'cd test-app2 ; mvn clean install'
            }
        }
        stage ('Promote') {
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
