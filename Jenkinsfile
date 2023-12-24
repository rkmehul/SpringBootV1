pipeline { 
    agent any  
    stages { 
        stage('Build & Deploy to Nexus') { 
            steps { 
              sh 'mvn -X -s settings.xml -DskipTests clean install deploy'
            }
        }
         
       
    }
}
