pipeline{
   agent {
        label 'jenkins-agent'
    }
   environment {
        dockerName = credentials ("dockerName")
        dockerpass = credentials ("dockerpass")
    }
   tools {
        jdk 'jdk-11'
        maven 'maven-354'
    }
   stages{
    stage("Build java app"){
        steps{
            sh "mvn package install -Dskiptest"
        }
    }
    stage("Test java app"){
        steps{
            sh "mvn package test"
        }
    }
    stage("archive java app"){
        steps{
            archiveArtifacts artifacts: '**/*.jar', followSymlinks: false
        }
    }
    stage("docker login "){
        sh "docker login -u ${dockerName} -p ${dockerpass}"
    }
    
   }
}