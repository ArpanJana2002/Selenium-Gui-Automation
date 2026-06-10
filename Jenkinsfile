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

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -Dheadless=true'
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
            emailext(
                subject: "SUCCESS: ${JOB_NAME} #${BUILD_NUMBER}",
                mimeType: 'text/html',
                to: 'recipient-email@example.com',
                attachmentsPattern: 'test-output/ExtentReport.html',
                body: """
                    <h2>Automation Execution Successful</h2>

                    <p><b>Project:</b> ${JOB_NAME}</p>
                    <p><b>Build Number:</b> ${BUILD_NUMBER}</p>
                    <p><b>Status:</b> SUCCESS</p>

                    <p>
                        <a href="${BUILD_URL}">
                            Open Jenkins Build
                        </a>
                    </p>

                    <p>
                        Extent Report has been attached to this email.
                    </p>
                """
            )
        }

        failure {
            emailext(
                subject: "FAILED: ${JOB_NAME} #${BUILD_NUMBER}",
                mimeType: 'text/html',
                to: 'recipient-email@example.com',
                attachmentsPattern: 'test-output/ExtentReport.html',
                body: """
                    <h2>Automation Execution Failed</h2>

                    <p><b>Project:</b> ${JOB_NAME}</p>
                    <p><b>Build Number:</b> ${BUILD_NUMBER}</p>
                    <p><b>Status:</b> FAILED</p>

                    <p>
                        <a href="${BUILD_URL}">
                            Open Jenkins Build
                        </a>
                    </p>

                    <p>
                        Extent Report has been attached to this email.
                    </p>
                """
            )
        }
    }
}
