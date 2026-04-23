pipeline {
    agent any

    tools {
        maven 'Maven 3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                dir('demo-app') {  
                    sh 'mvn clean test'
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'demo-app/**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline complete'
        }
        success {
            echo 'All tests passed!'
        }
        failure {
            echo 'Tests failed!'
        }
    }
}