pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ant198/formSubmissionTest.git'
            }
        }

         stage('build and test') {
            steps {
                script{
                    sh 'docker compose up --build test-runner'
                }
            }
         }
    }
    post {
        always {
            script {
                sh 'docker compose down'
            }
            testNG()
            allure includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
        }
    }
}