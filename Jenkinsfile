pipeline {
   environment {
    registryCredential = 'Dockerhub'
  }
  agent any
  stages {


    stage('Docker Build') {
      steps {

      sh "docker build -t cmik/ricettario:latest ."

  }
}
   stage('Docker Push') {

      steps {
          script {
            docker.withRegistry( '', registryCredential ) {
               sh "docker push cmik/ricettario:latest"
        }
      }
    }
  }
    stage('Deploy on k8s') {
      steps {
        
          sh "kubectl create namespace jdk"
          sh "kubectl apply -f Deployment.yaml"
          sh "kubectl apply -f Service.yaml"

      }
  }

 }
}
