pipeline {
    agent any
    stages {
        stage('clean') {
            steps {
                sh './mvnw clean'
            }
        }
        stage('build') {
            steps {
                sh './mvnw package'
            }
        }
    }
}