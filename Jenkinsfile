node {
    agent any
    stages {
	stage('Checkout') {
	    checkout scm
	}
	stage('Build') {
	    sh 'gradlew bootJar'
	}
	stage('Deploy') {
	    echo 'Deploying....'
	}
    }

}

