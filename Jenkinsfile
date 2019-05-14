pipeline {
    agent any
    stages {
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
		JENKINS_NODE_COOKIE=dontKillMe nohup java -jar ./build/libs/umami-0.1.0.jar >umami.out &
		echo $! > /tmp/deploy.pid

		'''
	    }
	}
    }

}

