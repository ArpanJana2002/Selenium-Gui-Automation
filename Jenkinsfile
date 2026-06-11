pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git(
                    branch: 'main',
                    url: 'https://github.com/ArpanJana2002/Selenium-Gui-Automation.git'
                )
            }
        }

        stage('Verify Maven') {
            steps {
                bat '"C:\\Program Files\\Apache\\apache-maven-3.9.16\\bin\\mvn.cmd" -version'
            }
        }

        stage('Build & Test') {
            steps {
                bat '"C:\\Program Files\\Apache\\apache-maven-3.9.16\\bin\\mvn.cmd" clean test -Dheadless=true'
            }
        }
    }

    post {

        always {

            archiveArtifacts(
                artifacts: 'test-output/**',
                allowEmptyArchive: true
            )

            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent Automation Report'
            ])
        }

        success {
            echo 'Automation Execution Successful'
        }

        failure {
            echo 'Automation Execution Failed'
        }
    }
}
