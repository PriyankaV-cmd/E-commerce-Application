E‑Commerce Application Deployment

📂 Project Overview
This repository contains a sample E‑Commerce Application deployed using a CI/CD pipeline with:
GitHub → source control
Maven → build system (WAR packaging)
Jenkins → automated pipeline
Docker → containerization
Docker Swarm → orchestration & scaling
Tomcat → application server

🚀 Setup Instructions - Clone Repo
git clone https://github.com/yourgitusername/reponame.git
cd E-commerce-Application

Build WAR with Maven
mvn clean package

Build Docker Image
docker build -t your-dockerhub-user/ecommerce-app:latest .

Push Image to Docker Hub
docker login
docker push your-dockerhub-user/ecommerce-app:latest

Deploy to Docker Swarm
docker swarm init   # only once per cluster
docker stack deploy -c swarm-deploy.yml ecommerce

📈 Scaling
Default replicas: 3
Scale up during sale events:
docker service scale ecommerce-app=5

🔄 Rollback
If deployment fails:
docker service rollback ecommerce-app

Rollback proof can be shown via:
docker service ps ecommerce-app
output: Look for ROLLBACK state in tasks.

🛠️ CI/CD Pipeline (Jenkinsfile)
Stages:
Checkout → Pull code from GitHub
Build WAR → mvn clean package
Build Docker Image → docker build
Push Image → Docker Hub
Deploy to Swarm → Update/create service
Rollback on Failure → docker service rollback

✅ Deliverables Checklist
pom.xml → WAR packaging
Servlet + JSP + web.xml → minimal app code
Dockerfile → Tomcat image with WAR
Jenkinsfile → CI/CD pipeline
swarm-deploy.yml → Swarm service config
Rollback proof → Jenkins post‑failure rollback + Swarm rollback logs