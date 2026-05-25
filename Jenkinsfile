pipeline {
    agent {
        label 'jenkins-agent'
    }
    environment {
        dockerName = credentials("dockerName")
        dockerpass = credentials("dockerpass")
    }
    tools {
        jdk 'jdk-11'
        maven 'maven-354'
    }
    stages {
        stage("git java app") {
            steps {
                git 'https://github.com/Hassan-Eid-Hassan/cicd-lab2.git'
            }
        }
        stage("Build java app") {
            steps {
                sh "mvn package install -DskipTests"
            }
        }
        stage("Test java app") {
            steps {
                sh "mvn test"
            }
        }
        stage("archive java app") {
            steps {
                archiveArtifacts artifacts: '**/*.jar', followSymlinks: false
            }
        }
        stage("docker login") {
            steps {
                sh "docker login -u ${dockerName} -p ${dockerpass}"
            }
        }
    }
}