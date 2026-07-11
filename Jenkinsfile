pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ecommerce-app:latest .'
            }
        }

        stage('Deploy to Swarm') {
            steps {
                sh 'docker stack deploy -c swarm-deploy.yml ecommerce'
            }
        }
    }

    post {
        failure {
            sh 'docker service rollback ecommerce_web || true'
        }
    }
}
