# MercadoLibre

Prueba tecnica desarrollada para MercadoLibre, Consiste en crear una aplicación móvil para android con el con la funcionalidad de buscar productos en el api publica de MercadoLibre.


## Arquitectura Utilizada

![final-architecture](https://user-images.githubusercontent.com/11649506/123676269-54909980-d809-11eb-9385-436333f8c74e.png)

* La aplicación utiliza una arquitectura limpia basada en MVVM y patrones de repositorio. Los principios de la arquitectura implementada siguen la [Guía para la arquitectura de aplicaciones] recomendada por Google (https://developer.android.com/jetpack/docs/guide).

* La aplicación está escrita en Kotlin.
* Android Jetpack se utiliza marco para la arquitectura que incluye ViewModel, LiveData, Lifecycles, Room and Data Binding
* La aplicación realiza solicitudes HTTP de red a través de Retrofit, OkHttp y GSON. Los datos cargados se guardan en Romm db basada en SQL, que sirve como fuente única de información y admite el modo sin conexion.
* Kotlin Coroutines administra subprocesos en segundo plano con código simplificado y reduce la necesidad de devoluciones de llamada.
* Dagger 2 se usa para la inyección de dependencias.
* soporte para landscape
* pruebas unitarias
