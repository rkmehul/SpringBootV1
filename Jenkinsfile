pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
               sh 'mvn -DskipTests clean install'
            }
        }
        stage("SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh 'mvn clean package sonar:sonar'
              }
            }
          }
    }
}