/* Requires the Docker Pipeline plugin */
pipeline {
    agent { label 'Test' }
    stages {
        stage('build') {
            steps {
                echo 'Hello World'
            }
        }
        stage('deploy') {
            steps {
                echo 'This is the deploy stage'
            }
        }
    }
}