pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               def now = new Date()
                echo 'Building..'
                bat 'gradlew assembleRelease' 
                bat 'copy .\bin\App.apk ..\apps\${now}.apk'
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
