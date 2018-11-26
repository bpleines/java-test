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
             mail bcc: '', body: "<b>It failed!</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: 'AUTOMATEDBUILDS', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "bpleines5qa@gmail.com";  
         }
    } 
}
