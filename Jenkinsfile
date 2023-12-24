pipeline {
    agent any

    environment {
        MAVEN_BUILD_NUMBER = sh(script: 'echo $BUILD_NUMBER', returnStdout: true).trim()
    }

    stages {
        stage('Build & Deploy to Nexus') {
            steps {
                script {
                    sh "mvn -X -s settings.xml -DskipTests clean install deploy -Dbuild.number=${MAVEN_BUILD_NUMBER}"
                    sh "systemctl start docker"
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    // Build your Docker image with the build argument
                    sh 'docker build --build-arg BUILD_NUMBER=${BUILD_NUMBER} -t expense-tracker:latest .'
                }
            }
        }
    }
}
