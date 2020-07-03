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
		}
		}
		}
	post{
		always{
		publishHTML(target : [allowMissing: false, 
			     alwaysLinkToLastBuild: false, 
			     keepAll: true, 
			     reportFiles: 'HappyTripReport.html',
			     reportName: 'Mohith Report', 
			    ])
		}
	}
}
