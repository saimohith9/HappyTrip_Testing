pipeline {
         agent any
	tools {
 	 maven 'maven latest'
		jdk 'JDK 8'
 	}
	environment {
    PATH = "C:\\WINDOWS\\SYSTEM32"
	}
	stages {
		     stage('build & Test'){
            steps {
             bat 'mvn clean install'
             bat 'mvn compile'
             bat 'mvn test'
		bat 'java testng.xml'	
		}
		}
		}
	post{
		always{
		publishHTML(target : [allowMissing: false, 
			     alwaysLinkToLastBuild: false, 
			     keepAll: true,
			     reportDir: 'reports', 
			     reportFiles: 'HappyTripReport.html',
			     reportName: 'Mohith Report', 
			    ])
		}
	}
}
