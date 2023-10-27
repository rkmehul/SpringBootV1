pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
              sh 'mvn -s settings.xml -DskipTests clean install'
            }
        }
         stage('Deploy') { 
            steps { 
              sh 'mvn -s settings.xml deploy'
            }
        }
       
    }
}
