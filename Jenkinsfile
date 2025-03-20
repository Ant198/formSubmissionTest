pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ant198/formSubmissionTest.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    dockerImage = docker.build("test_form:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('test') {
            steps {
                sh 'docker run -it -p 4444:4444 test_form:${env.BUILD_NUMBER}'
            }
        }

    }
    post {
        always {
            testNG()
            allure includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
        }
    }
}