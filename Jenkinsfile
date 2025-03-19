pipeline {
    agent any
    environment {
            DOCKER_HOST = 'tcp://192.168.56.101:2375' // IP твоєї Ubuntu VM
    }
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