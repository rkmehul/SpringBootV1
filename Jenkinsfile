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
                sh 'mvn -DskipTests clean package sonar:sonar'
              }
            }
          }
    }
}