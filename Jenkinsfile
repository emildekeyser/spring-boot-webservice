pipeline {
    agent any
    stages {
	/* stage('Checkout') { */
	/*     steps { */
	/* 	checkout scm */
	/*     } */
	/* } */
	stage('Build') {
	    steps {
		sh './gradlew bootJar'
	    }
	}
	stage('Deploy') {
	    steps {
		sh '''

		FILE=/tmp/deploy.pid  
		[ -f $FILE ] && kill -15 $(cat $FILE)			
		JENKINS_NODE_COOKIE=dontKillMe nohup java -jar ./build/libs/umami-0.1.0.jar &
		echo $! > /tmp/deploy.pid

		'''
	    }
	}
    }

}

