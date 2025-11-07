pipeline {
    agent any
    stages {
        stage('Verificar Repositório') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], useRemoteConfigs: [[url: 'https://github.com/Reidosrato/CorridaBaratas']]])
            }
        }

        stage('Instalar Dependências') {
            steps {
                script {
                    // Atualiza o PATH se necessário
                    env.PATH = "/usr/bin:$PATH"
                    // Instalar as dependências Maven antes de compilar o projeto
                    bat 'mvn clean install'  // Instala as dependências do Maven
                }
            }
        }

        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'corridabaratas'
                    def imageTag = "${appName}:${env.BUILD_ID}"

                    // Construir a imagem Docker
                    bat "docker build -t ${imageTag} ."
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'corridabaratas'
                    def imageTag = "${appName}:${env.BUILD_ID}"

                    // Parar e remover o container existente, se houver
            		bat "docker stop ${appName} || exit 0"
            		bat "docker rm -v ${appName} || exit 0"  // Remover o container e os volumes associados

                    // Executar o novo container
                    //bat "docker-compose up -d --build"
                }
            }
        }
    }
    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Houve um erro durante o deploy.'
        }
    }
}






















# Primeira etapa: gerar o jar com man package dentro do container
# A imagem maven jdk esta deprecated, eclipse temurin apresenta vulnerabilidade. Usar amazon corretto
FROM maven:3.9.9-amazoncorretto-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

RUN ls -la /target/Usuario.jar  # Lista o arquivo para verificar se foi criado
# Dar oi ao johnny kkk
# Bubu
#Dar oi ao erick
#Dar beijo no erick
# Segunda etapa: acessar o jar gerado na primeira etapa
#Terceira etapa: bubu
FROM amazoncorretto:21-alpine
# Para acessar a primeira etapa: --from=build
# O nome Usuario.jar vem da tag finalName do pom.xml que adicionei
COPY --from=build target/Usuario.jar app.jar
EXPOSE 8088
CMD ["java", "-jar", "/app.jar"]

miau miau miau miaumiauu


"C:\Program Files\Java\jdk-21\bin\java.exe" -jar jenkins.war