Sample Project for demo purposes:

Introduction:

The gs_rest project suffices as a sample project for usage in CI.
The project focusses on CI tooling which is present in the cloud (jenkins, sonar, nexus).

Why CI?

Example demo preperation: Unexpected error running mvn -Pci -Dembedded verify
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:2.1.5.RELEASE:start (pre-integration-test) on project itest: Could not contact Spring Boot application: Failed to retrieve RMIServer stub: javax.naming.CommunicationException [Root exception is java.rmi.ConnectIOException: error during JRMP connection establishment; nested exception is: 
[ERROR] 	java.io.EOFException]

Azure setup (vm's) 
- jenkins, nexus (admin, Te@*****)
- sonar (admin, ad***)

SCM
- github 

Project Contains:
- Maven multi-module (hateoas, itest)
- Integrationtest (sample report from workspace)
- sonar report
- Jenkinsfile (still on jenkins -> gitops)
- mutation testing
- Feature togglz (demo locally)
-- working with multiple teams (timing) + multiple branches/versions


 
Nice to have (see trello):
- sonar (feature test)
- sonar (SonarQube Stash (BitBucket) plugin)
- togglz with date
- feign client -> @EnableEurekaServer

Commands:
- mvn -Pci -Dembedded verify

- mvn sonar:sonar \
  -Dsonar.host.url=http://sonarvm.westeurope.cloudapp.azure.com \
  -Dsonar.login=7edc597c6bbff50f9ae0aa1558e9dd3ab206dfde

Demo jenkins pipeline for sonar check  
https://jenkinssec01.northeurope.cloudapp.azure.com/job/demo%20jenkins2sonar%20pipeline  
  
- mvn org.pitest:pitest-maven:mutationCoverage