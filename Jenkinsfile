pipeline {
    agent docker { image: maven:3.9.9-eclipse-temurin-21 }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ant198/formSubmissionTest.git'
            }
        }

         stage('build and test') {
            steps {
                script{
                    sh 'mvn clean test'
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