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
if (env.BRANCHNAME == 'master') {
        stage ('Promote') {
                steps {
                    sh 'echo Promoted'
                }
        }
}
    }
}
