## Описание
В период прохождения практики было разработано REST API приложение, которое служит для ловли и обработки клиентских HTTP-запросов. Данное приложение может послужить бэкендом для сервиса регистрации организаций, их офисов и работников.

## Как использовать
Перед использованием необходимо клонировать к себе этот проект и подключить базу данных.

1. Запустить метод main в классе EkatkovaApplication.java
    ![image](https://user-images.githubusercontent.com/77570081/176266667-aa0b228a-6186-41ed-80d5-e384d694aabf.png)
    
2. Перейти в приложение Postman или любой браузер.

    ![image](https://user-images.githubusercontent.com/77570081/176270808-01046407-ebf5-47e0-86da-f3c9c303eadf.png)


3. Выбрать один из запросов и отправить его.

Доступные http-запросы:
*	api/register – регистрация пользователя;

    ![image](https://user-images.githubusercontent.com/77570081/176268102-583cd4ca-de4f-4491-b9f1-b365206f2cdf.png)

*	api/activation?code=… – активация кода;

    ![image](https://user-images.githubusercontent.com/77570081/176268267-fd41ff27-a8b2-450b-9feb-b404e3a4f242.png)

*	api/login – авторизация пользователя;
    
    ![image](https://user-images.githubusercontent.com/77570081/176268420-153a625a-fe70-4c79-9f4c-ca102e6e52df.png) 

*	api/organization/list – получение списка организаций;

    ![image](https://user-images.githubusercontent.com/77570081/176268512-74e8ef51-479a-4de9-88bf-74df1c7a0d2d.png)

*	api/organization/{id} – получение отдельной организации;

    ![image](https://user-images.githubusercontent.com/77570081/176268948-3de89920-d113-410d-bb1a-a31a566d2904.png)

*	api/organization/update – обновление данных организации;

    ![image](https://user-images.githubusercontent.com/77570081/176269012-217c99b9-7da1-45c2-801f-dc9bf4699340.png)

*	api/organization/save – добавленные новой организации;

    ![image](https://user-images.githubusercontent.com/77570081/176269067-ad3a5628-d994-4fc0-adb5-de1418a535d6.png)

*	api/office/list – получение списка офисов;

    ![image](https://user-images.githubusercontent.com/77570081/176269226-0d0229a2-e0aa-463c-9b44-e589476c8ab6.png)

*	api/office/{id} – получение отдельного офиса;

    ![image](https://user-images.githubusercontent.com/77570081/176269300-36abacbd-7ac0-44cd-bfcc-66fe80a69b63.png)

*	api/office/update – обновление данных об офисе;

    ![image](https://user-images.githubusercontent.com/77570081/176269469-51da392f-4e13-4379-ae22-1cb3446700c3.png)

*	api/office/save – добавление нового офиса;

    ![image](https://user-images.githubusercontent.com/77570081/176269559-ac3e3aff-d006-4ade-a8ee-06f8274af307.png)

*	api/user/list – получение списка пользователей;

    ![image](https://user-images.githubusercontent.com/77570081/176269779-c387c963-9296-4c35-9b8c-7b464c318517.png)

*	api/user/{id} – получение отдельного пользователя;

    ![image](https://user-images.githubusercontent.com/77570081/176270096-88721e62-fd14-409a-b093-b9dd93e69b2f.png)

*	api/user/update  – обновление данных пользователя;

    ![image](https://user-images.githubusercontent.com/77570081/176270199-550a2ef7-0144-4882-af55-0adc4bc833dc.png)

*	api/user/save  – добавление нового пользователя;

    ![image](https://user-images.githubusercontent.com/77570081/176270433-eb1698a8-e739-4d8a-b9b8-1f10dc81ae64.png)

*	api/docs – справочник по существующим видом документов, удостоверяющих личность физического лица;

    ![image](https://user-images.githubusercontent.com/77570081/176270485-9b9f2e52-e2f4-417e-94df-7a270e4ea0af.png)

*	api/countries – справочник по странам и их кодам.

    ![image](https://user-images.githubusercontent.com/77570081/176270570-1279915b-9322-471c-b59b-aa475d139d73.png)

В этом заключается вся работа приложения.

## Заключение 
Подобные приложения считаются простым примером бэкенда и в паре с фронтендом могут дать полноценный web-сервис. Разработка фронтенда выходила за рамки практики, все усилия были направлены на изучение разработки и работы REST API-приложений.
