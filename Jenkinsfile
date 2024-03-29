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
                }
            }
        }
        /*stage('Docker Build') {
            steps {
                    
                script {
                    // Build your Docker image with the build argument
                    sh 'buildah build -t expense-tracker:latest'
                    //sh 'sleep 300'
                }
                            
            }
        }*/
    }
}
