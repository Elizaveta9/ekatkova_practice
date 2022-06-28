## Описание
В период прохождения практики было разработано REST API приложение, которое служит для ловли и обработки клиентских HTTP-запросов. Данное приложение может послужить бэкендом для сервиса регистрации организаций, их офисов и работников.

## Как использовать
Перед использованием необходимо клонировать к себе этот проект и подключить базу данных.

1. Запустить метод main в классе EkatkovaApplication.java
    ![image](https://user-images.githubusercontent.com/77570081/176266667-aa0b228a-6186-41ed-80d5-e384d694aabf.png)
    
2. Перейти в приложение Postman или любой браузер.

3. Выбрать один из запросов и отправить его.

Доступные http-запросы:
*	api/register – регистрация пользователя;
*	api/activation?code=… – активация кода;
*	api/login – авторизация пользователя;
*	api/organization/list – получение списка организаций;
*	api/organization/{id} – получение отдельной организации;
*	api/organization/update – обновление данных организации;
*	api/organization/save – добавленные новой организации;
*	api/office/list – получение списка офисов;
*	api/office/{id} – получение отдельного офиса;
*	api/office/update – обновление данных об офисе;
*	api/office/save – добавление нового офиса;
*	api/user/list – получение списка пользователей;
*	api/user/{id} – получение отдельного пользователя;
*	api/user/update  – обновление данных пользователя;
*	api/user/save  – добавление нового пользователя;
*	api/docs – справочник по существующим видом документов, удостоверяющих личность физического лица;
*	api/countries – справочник по странам и их кодов.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
