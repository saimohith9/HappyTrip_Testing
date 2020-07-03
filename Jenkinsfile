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
             bat 'mvn pom.xml clean install'
             bat 'mvn pom.xml compile'
             bat 'mvn pom.xml test'
		}
		}
		}
		publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: './reports', reportFiles: 'HappyTripReport.html', reportName: 'Mohith Report', reportTitles: ''])
}