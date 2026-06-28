pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/PriyankaV-cmd/E-commerce-Application.git'
            }
        }
        stage('Build WAR') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t priyankadockrs/ecommerce-app:${BUILD_NUMBER} .'
            }
        }
        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                echo $DOCKER_PASS | docker login -u priyankadockrs --password-stdin
                docker push priyankadockrs/ecommerce-app:${BUILD_NUMBER}
                docker tag priyankadockrs/ecommerce-app:${BUILD_NUMBER} priyankadockrs/ecommerce-app:latest
                docker push priyankadockrs/ecommerce-app:latest
            '''
                }
            }
        }
        stage('Deploy to Swarm') {
            steps {
                sh 'docker service update --image priyankadockrs/ecommerce-app:${BUILD_NUMBER} ecommerce-service || docker service create --name ecommerce-service --replicas 3 -p 8080:8080 priyankadockrs/ecommerce-app:${BUILD_NUMBER}'
            }
        }
    }
    post {
        failure {
            echo 'Deployment failed. Rolling back...'
            sh 'docker service rollback ecommerce-service'
        }
    }
}
