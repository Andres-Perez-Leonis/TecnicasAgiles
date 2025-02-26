# Aplicación inicial Spring Boot

Aplicación básica usando Spring Boot y plantillas Thymeleaf.

## Requisitos

Necesitas tener instalado en tu sistema:

- Java 8

## Ejecución

Puedes ejecutar la aplicación usando el _goal_ `run` del _plugin_ Maven
de Spring Boot:

```
$ ./mvnw spring-boot:run
```   

También puedes generar un `jar` y ejecutarlo:

```
$ ./mvnw package
$ java -jar target/demoapp-0.0.1-SNAPSHOT.jar
```

Una vez lanzada la aplicación puedes abrir un navegador y probar los distintos _controllers_:

- [http://localhost:8080](http://localhost:8080)
- [http://localhost:8080/saludo/Pepito](http://localhost:8080/saludo/Pepito)
- [http://localhost:8080/saludoplantilla/Pepito](http://localhost:8080/saludoplantilla/Pepito)
- [http://localhost:8080/saludoform](http://localhost:8080/saludoform)

Enlace del repositorio de Docker:

- https://hub.docker.com/repository/docker/andresperezleonis/exercise1/general

Enlace del repositorio de Github:

- https://github.com/Andres-Perez-Leonis/TecnicasAgiles

## Nuevas Funcionalidades

Se han agregado dos nuevas funcionalidades a la aplicación:

- **Comprobador de Palíndromos:** Permite ingresar una palabra y verificar si es un palíndromo.
- **Detector de Anagramas:** Permite ingresar dos palabras y comprobar si son anagramas entre sí.

Los nuevos _endpoints_ disponibles son:

- [http://localhost:8080/palindromo](http://localhost:8080/palindromo) (formulario para comprobar palíndromos)
- [http://localhost:8080/anagrama](http://localhost:8080/anagrama) (formulario para comprobar anagramas)

## Pruebas Unitarias

Se han modificado los tres ficheros de test para incluir pruebas unitarias y de integración para las nuevas funcionalidades:

- **`MockMvcTest.java`**: Se han añadido pruebas para comprobar que los nuevos _controllers_ funcionan correctamente.
- **`MockServiceTest.java`**: Se han agregado _mocks_ para probar las respuestas del servicio de palíndromos y anagramas.
- **`ServiceTest.java`**: Se han implementado pruebas unitarias para verificar la lógica de los servicios de palíndromos y anagramas.

Para ejecutar las pruebas unitarias:

```
$ mvn test
```

