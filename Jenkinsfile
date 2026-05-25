pipeline {
    agent {
        label 'jenkins-agent'
    }
    environment {
        dockerName = credentials("docker-name")
        dockerpass = credentials("docker-pass")
    }
    tools {
        jdk 'jdk-11'
        maven 'maven-354'
    }
    stages {
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
                sh "docker login -u ${docker-name} -p ${docker-pass}"
            }
        }
    }
}