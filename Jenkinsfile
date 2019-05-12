pipeline {
    agent any
    stages {
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

