### Возврат ответа REST сервиса с помощью ResponseEntity<?>

(Проект с методикой возврата __ResponseEntity__ и обработкой ошибок см. в [https://github.com/cherepakhin/response_entity](https://github.com/cherepakhin/response_entity))

Основное в [SimpleObjRestController.java](https://github.com/cherepakhin/response_entity/blob/main/src/main/java/ru/perm/v/simple/SimpleObjRestController.java)
Возвращается ResponseEntity<?>. Некрасиво (т.к. __?__), но проблему решает.


Тестирование REST с помощью:

1. __@WebMvcTest__ SimpleObjRestControllerMvcTest
2. __@SpringBootTest__ SimpleObjRestControllerSpringBootTest

