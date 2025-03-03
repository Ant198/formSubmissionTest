pipeline {
    agent any
    stages {
       stage('Run the test') {
            steps {
                bat 'mvn clean test'
            }
       }
    }
    post {
        always {
          testNG()
        }
      }
}