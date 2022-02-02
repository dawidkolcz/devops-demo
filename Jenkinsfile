node {
  docker.image('maven:3.8.4-openjdk-11-slim').inside {
    stage('Build'){
      sh 'mvn -B -f ./spring-backend/pom.xml clean package -DskipTests'
    }
    stage('Unit-Test'){
       sh 'mvn -f ./spring-backend/pom.xml test'
    }
    stage('Integration-Test'){
       sh 'mvn -f ./spring-backend/pom.xml integration-test -Dgroups=integration'
    }
  }
  stage('Deploy'){
    sh "./start-docker-compose.sh"
  }
}
