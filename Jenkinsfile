pipeline { 
    agent any  
    stages { 
        stage('Build & Deploy to Nexus') { 
            steps { 
              sh 'mvn -s settings.xml -DskipTests clean install deploy'
            }
        }
         
       
    }
}
