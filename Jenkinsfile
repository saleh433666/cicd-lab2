@Library('saleh-lib')_
pipeline {
    agent {
        label 'jenkins-agent'
    }
    environment {
        dockerName = credentials("dockerName")
        dockerpass = credentials("dockerPass")
    }
    tools {
        jdk 'jdk-11'
        maven 'maven-354'
    }
    stages {
        stage("Checkout") {
             steps {
                 git branch: 'main',
                         url: 'https://github.com/saleh433666/cicd-lab2.git'
    }
}
        stage("Build java app") {
            steps {
                sh "mvn package install -DskipTests"
            }
        }
        stage("Test java app") {
    steps {
        sh "mvn test || true"   
    }
}
        stage("archive java app") {
            steps {
                archiveArtifacts artifacts: '**/*.jar', followSymlinks: false
            }
        }
        stage("build docker"){
            steps{
                script{
                    def s7 = new edu.iti.docker()
                    s7.build("hassane/java" , "v1")
                }
               
            }
        }
        stage("docker login") {
            steps {
                script{
                    def s7 = new edu.iti.docker()
                    s7.login("${dockerName}" , "${dockerPass}")
                }
            }
        }
    }
}