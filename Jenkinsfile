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
             bat 'mvn compile'
		      bat 'mvn test -Dbrowser=chrome'
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
		}
}
				def notifyBuild(String buildStatus) {		
		def summary = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
		def details = '${SCRIPT, template="groovy-html.template"}'
			//"""<p><b>${buildStatus}</b> : Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
		  //  <p>Check console output at ${env.BUILD_URL}; ${env.JOB_NAME} [${env.BUILD_NUMBER}];</p>"""
		
		emailext attachmentsPattern: 'reports/*.html' ,body: details,subject: summary, mimeType: 'text/html',to:'saimohith49@gmail.com' 
}
