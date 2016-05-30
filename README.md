# Triangle
Hell Triangle - Challenge

1) Pré-requisito para execução homologação[homol].

   	Apache-maven instalado e configurado.
   	Java versão 1.8 instalado e configurado.
   	Se for subir o projeto no Eclipse deve ser configurado o lombox.
   		a) Download do https://projectlombok.org/download.html.
   		b) Rodar o comando java -jar lombox.jar(nome do jar baixado).
   		c) Especificar a pasta do eclipse e clicar botão install / update.
   	Se for subir no Intelig, instalar o plugin na aba File/Settings
   		a) Plugins.
   		b) lombox botão install.

1) Pré-requisito para execução produção [prod].

   	Mesmo procedimento do passo 1, depois instalar o docker e docker-compose. No link abaixo tem o procedimento.
   	 (https://docs.docker.com/compose/install/).

2) Executar o projeto em produção

    	Dentro do diretório do projeto.
    	mvn clean install.
    	Considerando uma maquina linux.
    	Abrir  um terminal e executar sudo docker-compose up, este comando ira subiu uma vm com o redis.
    	Apos subir vm acima abrir outro terminal e executar SPRING_PROFILES_ACTIVE=prod mvn spring-boot:run

3) Executar o projeto em homologação

    	Dentro do diretório do projeto.
    	mvn clean install.
    	Apos subir vm acima abrir outro terminal e executar SPRING_PROFILES_ACTIVE=homol mvn spring-boot:run
    	Observação: Não esta configurado o redis em homologação.

4) Frameworks.

	Foi usado Spring boot.
	Requisitos não funcionais foi utilizado cache, em homologação em memória e produção redis.

5) Test.

Após subir a maquina (prod ou homol) rodar no terminal o comando abaixo.

curl -X POST "http://localhost:8080/triangle" -H "Content-Type: application/json"  -d ' {"triangle": [[6],[3,5],[9,4,1],[4,6,8,4]] }' | python -mjson.tool

 
6) Soluçao.
A regra do Algoritmo é baseada no posicionamento da primeira linha então percorre todo o array somando os maiores números do posiconamento.

Exemplo :
   6    (posição 0) = 6
  3 5   (posição 1) = 5
 9 7 1  (posição 1) = 7 [Neste caso o número 9 é descartado).
4 6 8 4 (posição 2) = 8 [Neste caso os número 4 são descartados).

7) Validações.
   
   Será aceito somente array que representa um triangulo exemplo:
   
   [x],[x,x],[x,x,x] etc.
