# survey-form-backend
As part of this assignment we have created a rest microservice which is responsible for persisting suvey information to MySQL database hosted in AWS RDS.
Rest microservice is based on Spring Boot running in embedded tomcat. Maven is being used as the build tool.
Application URL: https://ec2-3-222-240-66.compute-1.amazonaws.com/api/details
Jenkins URL: http://34.228.87.20:8080/job/SurveyFormBackend/

CRUD OPERATIONS
1) Get /api/details/all -> This particular REST endpoint is used for displaying all the surveys which have been recorded till date.
POSTMAN Response:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/7324e76b-bf68-4d6f-b9fc-da9c90d4bb4f)

Database:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/1992a3f8-a9fd-416d-8057-a8a3c947573b)

2) Get /api/details?firstName=Dev-vrat&lastName=Pandey
POSTMAN Response:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/b050ce3c-45e6-494d-967d-352360759b3f)

Database:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/349aaaf6-9c6f-4159-8f83-b3424ddf81a2)

3) POST /api/details
POSTMAN Response
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/5685a2c0-0ac3-406c-aece-f12062053395)

Database: New entry is created in database
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/4d4f2ee8-8ea6-4ebb-a0f1-f0a15aa40df6)

4) PUT /api/details/:id -> id is the id that is created in database in our case it is an automatically incremented number.
POSTMAN Response
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/3746461c-4328-4fa3-92ce-616d78f28a67)

Database: Name has been updated
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/7f1be447-d7df-4618-b9db-c2094a393926)

If the id to be updated is not present in database
POSTMAN Response:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/6514b5fc-e33c-4af9-930a-3d02aa8d55e7)


5) DELETE /api/details/:id -> id is the id that is created in database in our case it is an automatically incremented number
POSTMAN Response
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/22d995a0-b331-468a-a968-ccb41edbd2b3)

Database: Survey has been deleted
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/7033dccc-a7dd-4958-aeea-1a2a7684d130)

If the id to be deleted is not present in the database
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/01309eca-1989-453b-b927-9444914feb32)

# Kubernetes Configuration
1) All the kubernetes related resources are present inside kubernetes/ directory in the github project.
2) configmap.yaml has the application configuration related information. In our case we have stored database URI.
3) deployment.yml is used for spinning up the application pods. The number of pods for application are defined in the replicas. Kuberentes will always be maintaining those many application instances in order to avoid any downtime.
4) ingress.yaml is an entrypoint of the application. It accepts the incoming rest message and passes it down to service.
5) secrets.yaml contains all the sensitive information that are required by the application in our case we are storing username and password.

Ingress:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/f8a5064b-5ffe-45b4-8cb2-ef22f57c9279)

Deployment:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/63e3a820-bdf3-424c-914a-8429f3d32fc5)

Service:
![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/68a74ee0-2c7a-45d0-a514-e0448f887e9a)

# Jenkins Configuration
For creating the standalone jar for the spring boot application using maven we can use command: mvn clean package -DskipTests=true
1) Jenkins file have different stages present for building the application and then deploying it to kubernetes environment.
2) We can trigger the jenkins job manually by using build now option.

![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/017a64ae-d166-4aa4-8d99-3101307d7f2a)

![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/149cb45d-e643-4853-a997-7fde25e5e6a6)


# Bonus Section
URL: https://ec2-3-222-240-66.compute-1.amazonaws.com/helloworld
1) In Bonus section We have created a docker image using nginx as base image.
2) Using the Dockerfile inside bonus/kubernetes/Dockerfile we will be creating a hello world docker image which is nothing but an HTML page displaying Hello World.
3) ingress.yaml -> This is used for making a communication with the outside world. Whatever traffic that comes to ingress gets sent to the service which at last goes to the pods.
4) service.yaml -> This is used for exposing the application pods to outside world. We can access the application using service as well but we will have to use IP of it.
5) deployment.yaml -> This has the information regarding the image to be deployed to the kubernetes cluster and also how many pods we want to create for the application. Deployment basically makes the application with no downtime because of its RollingUpdate strategy.

![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/4d47438a-9c4b-4062-9407-5cf77cb4b3bc)

![image](https://github.com/dev-founder-titan/survey-form-backend/assets/79055244/1d0fc4bf-7114-48ee-a047-b71442273b12)
