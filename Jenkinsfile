node {
    docker.image('maven:3.8.4-openjdk-17-slim').inside('-v $HOME/.m2:/root/.m2') {
      stage('Build'){
        sh 'mvn -B -f /repo/spring-backend/pom.xml clean package -DskipTests'
      }
      stage('Unit-Test'){
        sh 'mvn -f /repo/spring-backend/pom.xml test'
      }
      stage('Integration-Test'){
        sh 'mvn -f /repo/spring-backend/pom.xml integration-test -Dgroups=integration'
      }
    }
  stage('Deploy'){
    sh '/repo/start-docker-compose.sh'
  }
}
