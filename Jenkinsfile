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
                    sh 'docker cp test-runner:/app/target/surefire-reports/testng-results.xml $WORKSPACE/testng-results.xml'
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