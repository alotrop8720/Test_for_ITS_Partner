Приложение собрано на maven с сервера использованием сервера Apache Tomcat. 
1. War файл в папке target положить на сервер Tomcat в папку webapp. 
2. Запустить Tomcat(bin => startup.bat).
3. !!ОБЯЗАТЕЛЬНО!! положить файл с бд на сервер в папку bin. 
(https://www.maxmind.com/en/geoip2-databases) - скачать с сайта базу данных country. 
Или скачать файл с корневой папки гит файл GeoLite2-Country.mmdb (на сервер в bin).

Приложение содержит две кнопки, на одну создается комната, все примитивно. 
На другую заходим в лист и выбираем любую комнату, зайдет только в ту где указана ваша страна.
В комнате указаны номер комнаты название и страна. На кнопку Turn снизу будет отображаться надпись 
включен свет turn true, выключен turn false.