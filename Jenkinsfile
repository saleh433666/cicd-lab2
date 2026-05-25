pipeline {
    agent {
        label 'jenkins-agent'
    }
    environment {
        dockerName = credentials("dockername")
        dockerpass = credentials("dockerpass")
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
                sh "docker login -u ${dockername} -p ${dockerpass}"
            }
        }
    }
}