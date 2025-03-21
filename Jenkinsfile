pipeline {
    agent {
            label 'docker_agent'
        }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ant198/formSubmissionTest.git'
            }
        }

         stage('build and test') {
            steps {
                script{
                    sh 'docker compose up -d selenium test-runner'
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