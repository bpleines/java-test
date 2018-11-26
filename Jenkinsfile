pipeline {
    agent {
        docker { image 'maven:3-alpine' }
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ('Build Submodule') {
            steps {
                sh 'cd bpleines-app ; mvn clean install'
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
             sh 'echo The build failed' 
         }
    } 
}
