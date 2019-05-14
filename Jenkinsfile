pipeline {
    agent any
    stages {
	stage('Build') {
	    steps {
		sh './gradlew bootJar'
	    }
	}
	stage('Publish docker image') {
	    steps {
		sh '''

			docker build -t user1user1/umami .'
			docker login -u user1user1 -p r0599128'
			docker push user1user1/umami' 

		'''
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

