1. Необходимо клонированить или скачать приложение

2. В Терминале указать путь к директории где сохранено приложение testApplication затем:
  a) mvn package
  б) java -jar target/testApplication-0.0.1-SNAPSHOT.jar
ИЛИ
  В IDE открыть приложение как новый проект и запустить TestApplication.java как SpringBoot приложение

Приложение будет заущено на http://localhost:8080

GET запрос на получение списка всех объектов Student:
  curl --location 'http://localhost:8080/student/allStudents'

POST запрос на добавление нового объекта Student:
  curl --location 'http://localhost:8080/student/addNewStudent' \
  --header 'Content-Type: application/json' \
  --data '{
      "name":"ivan",
      "surname":"Ivanov",
      "patronymic":"Ivanovich",
      "group": "philosophy",
      "rate": 4
  }'

PATCH запрос на изменение объекта Student:
  curl --location --request PATCH 'http://localhost:8080/student/alterStudent/ivan' \
  --header 'Content-Type: application/json' \
  --data '{
      "surname":"Petrov"
  }'

DELETE запрос на удаление объекта Student:
  curl --location --request DELETE 'http://localhost:8080/student/deleteStudent/ivan'



