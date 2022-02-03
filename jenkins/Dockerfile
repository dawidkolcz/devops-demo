FROM jenkins/jenkins:jdk11
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
USER root
RUN apt update && apt install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt update && apt install -y docker-ce-cli
RUN curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" \
      -o /usr/local/bin/docker-compose
RUN chmod +x /usr/local/bin/docker-compose

USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean:1.25.2 docker-workflow:1.28 git:4.10.3"
