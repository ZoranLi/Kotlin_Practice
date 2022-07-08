pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               
                echo 'Building..'
                bat 'gradlew assembleRelease' 
               
                echo %date%
                bat 'copy .\\bin\\App.apk ..\\apps\\app.apk'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
