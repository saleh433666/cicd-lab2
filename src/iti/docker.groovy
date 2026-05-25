package edu.iti; 

def build(imageName , imageTag){
    sh "docker build -t ${imageName}:${imageTag}"
}

def push(imageName , imageTag){
    sh "docker build -t ${imageName}:${imageTag}"
}

def login(userName , passWord){
    sh "docker login -u ${userName} -p ${passWord}"
}