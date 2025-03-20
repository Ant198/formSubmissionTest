pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ant198/formSubmissionTest.git'
            }
        }

         stage('build') {
            steps {
                script{
                    sh 'docker build -t test_form${BUILD_NUMBER} .'
                }
            }
         }

        stage('run test') {
            steps {
                script {
                    sh 'docker run -it --net test-network test_form_c test_form${BUILD_NUMBER}'
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