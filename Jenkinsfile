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
		sh 'gradlew bootJar'
	    }
	}
	stage('Deploy') {
	    steps {
		echo 'Deploying....'
	    }
	}
    }

}

