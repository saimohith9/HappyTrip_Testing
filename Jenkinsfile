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
		     bat 'mvn test'
             bat 'mvn clean install'
            	}
		}
		}
	post{
                success{
archiveArtifacts(artifacts: './reports/*.html', allowEmptyArchive: true)
			notifyBuild('SUCCESS')
}
		failure{
		notifyBuild('FAILED')
		}
		//always{
		//publishHTML(target : [allowMissing: false, 
		//	     alwaysLinkToLastBuild: false, 
		//	     keepAll: true, 
		//	     reportFiles: 'HappyTripReport.html',
		//	     reportName: 'Mohith Report', 
		//	    ])
		//}
	}
}
				def notifyBuild(String buildStatus) {
  // build status of null means successful
//  buildStatus = buildStatus ?: 'SUCCESS'
		
		def summary = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
		def details = //"""<p><b>${buildStatus}</b> : Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
		   // <p>Check console output at ${env.BUILD_URL}; ${env.JOB_NAME} [${env.BUILD_NUMBER}];</p>
		  """${SCRIPT, template='groovy-html.template'}"""
		
		emailext attachmentsPattern: '*reports/*.html' ,body: details,subject: summary,to:'saimohith49@gmail.com' 
}
