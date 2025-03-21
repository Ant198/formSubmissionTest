pipeline {
    agent any
    stages {
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

            testNG()
            allure includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
            script {
                            sh 'docker compose down'
                        }
        }
    }
}