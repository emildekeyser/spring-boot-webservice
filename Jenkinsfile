pipeline {
    agent any
    stages {
	stage('Checkout') {
	    steps {
		checkout scm
	    }
	}
	stage('Build') {
	    steps {
		sh './gradlew bootJar'
	    }
	}
	stage('Deploy') {
	    steps {
		JENKINS_NODE_COOKIE=dontKillMe java -jar ./build/libs/umami-0.1.0.jar
	    }
	}
    }

}

