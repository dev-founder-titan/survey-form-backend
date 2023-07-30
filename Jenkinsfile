pipeline{
    agent any
    environment {
        def BUILDVERSION = sh(script: "echo `date +%s`", returnStdout: true).trim()
    }

    stages {
        stage("Building Student Survey Form page") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_PASS', passwordVariable: 'C_PASS', usernameVariable: 'C_USER')]) {
                        checkout scm
                        sh "rm -rf *.jar"
                        sh 'mvn clean package -DskipTests=true'
                        sh 'echo ${BUILDVERSION}'
                        println(C_PASS+" "+C_USER)
                        sh 'docker login -u devbravo1996 -p ${C_PASS}'
                        sh 'docker build -t devbravo1996/surveyformbackend:${BUILDVERSION} .'
                    }
                }
            }
        }
        stage("Pushing Image to DockerHub") {
            steps {
                script {
                    sh "docker push devbravo1996/surveyformbackend:${BUILDVERSION}"
                }
            }
        }
        stage("Deploying to Rancher") {
            steps {
                sh 'kubectl set image deployment/surveyform-backend-deployment surveyform-backend=devbravo1996/surveyformbackend:${BUILDVERSION} -n surveyform-backend'
            }
        }
    }
}