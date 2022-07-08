pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               
                echo 'Building..'
                bat 'gradlew assembleRelease' 
                script {
                    DATE_TAG = java.time.LocalDate.now()
                    DATETIME_TAG = java.time.LocalDateTime.now()
                }
                bat 'copy .\bin\App.apk ..\apps\${DATETIME_TAG}.apk'
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
