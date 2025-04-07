# PRUEBA ITX

### Descripción

En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:

### PRICES

| BRAND_ID |     START_DATE          |        END_DATE           | PRICE_LIST | PRODUCT_ID | PRIORITY |  PRICE  | CURR |
|----------|-------------------------|---------------------------|-------------|------------|----------|---------|------|
|    1     | 2020-06-14-00.00.00     | 2020-12-31-23.59.59      |      1      |   35455    |     0    |  35.50  | EUR  |
|    1     | 2020-06-14-15.00.00     | 2020-06-14-18.30.00      |      2      |   35455    |     1    |  25.45  | EUR  |
|    1     | 2020-06-15-00.00.00     | 2020-06-15-11.00.00      |      3      |   35455    |     1    |  30.50  | EUR  |
|    1     | 2020-06-15-16.00.00     | 2020-12-31-23.59.59      |      4      |   35455    |     1    |  38.95  | EUR  |



Campos:

- BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).

- START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
- PRICE_LIST: Identificador de la tarifa de precios aplicable.
- PRODUCT_ID: Identificador código de producto.
- PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
- PRICE: precio final de venta.
- CURR: iso de la moneda.

Se pide:

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:

-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)


Se valorará:

Diseño y construcción del servicio.

Calidad de Código.

Resultados correctos en los test.
## Instalación

### Prerequisitos
* Java 17
* Maven 3.6.3
* OpenAPI 

### Build
```sh
mvn clean install
```
### Execute
```sh   
mvn spring-boot:run
```

### Posibles Errores
 En el caso de que haya un error en la compilacion o generacion de dependencias 
 
 se debe probar ha hacer un 'Reload From disk' en el IDE, y en Maven un 'Reload project',
 
 despues de esto volver a ejecutar el comando 
```sh   
'mvn clean install'. 
```
 Esto se debe a que el IDE no reconoce/carga correctamente las dependencias generadas por el plugin de OpenAPI.

## Usos

### [Swagger]
```url
http://localhost:8080/swagger-ui.html
```
### [H2DBC]
```url
http://localhost:8080/h2-console
```


### Obtener un producto (Postman)
```json lines
{
 "info": {
  "_postman_id": "80168e01-6c8b-4019-a3b1-cae24c7b2c12",
  "name": "GET PRICES ITX",
  "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
 },
 "item": [
  {
   "name": "Test 1",
   "request": {
    "method": "GET",
    "header": [
     {
      "key": "applicationDate",
      "value": "2020-12-31T23:59:59",
      "type": "default",
      "disabled": true
     },
     {
      "key": "productId",
      "value": "35455",
      "type": "default",
      "disabled": true
     },
     {
      "key": "brandId",
      "value": "1",
      "type": "default",
      "disabled": true
     }
    ],
    "url": {
     "raw": "localhost:8080/prices?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1",
     "host": [
      "localhost"
     ],
     "port": "8080",
     "path": [
      "prices"
     ],
     "query": [
      {
       "key": "applicationDate",
       "value": "2020-06-14T10:00:00"
      },
      {
       "key": "productId",
       "value": "35455"
      },
      {
       "key": "brandId",
       "value": "1"
      }
     ]
    }
   },
   "response": []
  },
  {
   "name": "Test 2",
   "request": {
    "method": "GET",
    "header": [
     {
      "key": "applicationDate",
      "value": "2020-12-31T23:59:59",
      "type": "default",
      "disabled": true
     },
     {
      "key": "productId",
      "value": "35455",
      "type": "default",
      "disabled": true
     },
     {
      "key": "brandId",
      "value": "1",
      "type": "default",
      "disabled": true
     }
    ],
    "url": {
     "raw": "localhost:8080/prices?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1",
     "host": [
      "localhost"
     ],
     "port": "8080",
     "path": [
      "prices"
     ],
     "query": [
      {
       "key": "applicationDate",
       "value": "2020-06-14T16:00:00"
      },
      {
       "key": "productId",
       "value": "35455"
      },
      {
       "key": "brandId",
       "value": "1"
      }
     ]
    }
   },
   "response": []
  },
  {
   "name": "Test 3",
   "request": {
    "method": "GET",
    "header": [
     {
      "key": "applicationDate",
      "value": "2020-12-31T23:59:59",
      "type": "default",
      "disabled": true
     },
     {
      "key": "productId",
      "value": "35455",
      "type": "default",
      "disabled": true
     },
     {
      "key": "brandId",
      "value": "1",
      "type": "default",
      "disabled": true
     }
    ],
    "url": {
     "raw": "localhost:8080/prices?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1",
     "host": [
      "localhost"
     ],
     "port": "8080",
     "path": [
      "prices"
     ],
     "query": [
      {
       "key": "applicationDate",
       "value": "2020-06-14T21:00:00"
      },
      {
       "key": "productId",
       "value": "35455"
      },
      {
       "key": "brandId",
       "value": "1"
      }
     ]
    }
   },
   "response": []
  },
  {
   "name": "Test 4",
   "request": {
    "method": "GET",
    "header": [
     {
      "key": "applicationDate",
      "value": "2020-12-31T23:59:59",
      "type": "default",
      "disabled": true
     },
     {
      "key": "productId",
      "value": "35455",
      "type": "default",
      "disabled": true
     },
     {
      "key": "brandId",
      "value": "1",
      "type": "default",
      "disabled": true
     }
    ],
    "url": {
     "raw": "localhost:8080/prices?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1",
     "host": [
      "localhost"
     ],
     "port": "8080",
     "path": [
      "prices"
     ],
     "query": [
      {
       "key": "applicationDate",
       "value": "2020-06-15T10:00:00"
      },
      {
       "key": "productId",
       "value": "35455"
      },
      {
       "key": "brandId",
       "value": "1"
      }
     ]
    }
   },
   "response": []
  },
  {
   "name": "Test 5",
   "request": {
    "method": "GET",
    "header": [
     {
      "key": "applicationDate",
      "value": "2020-12-31T23:59:59",
      "type": "default",
      "disabled": true
     },
     {
      "key": "productId",
      "value": "35455",
      "type": "default",
      "disabled": true
     },
     {
      "key": "brandId",
      "value": "1",
      "type": "default",
      "disabled": true
     }
    ],
    "url": {
     "raw": "localhost:8080/prices?applicationDate=2020-06-16T21:00:00&productId=35455&brandId=1",
     "host": [
      "localhost"
     ],
     "port": "8080",
     "path": [
      "prices"
     ],
     "query": [
      {
       "key": "applicationDate",
       "value": "2020-06-16T21:00:00"
      },
      {
       "key": "productId",
       "value": "35455"
      },
      {
       "key": "brandId",
       "value": "1"
      }
     ]
    }
   },
   "response": []
  }
 ]
}
```

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)
[Swagger]: <http://localhost:8080/swagger-ui.html>
[H2DBC]: <http://localhost:8080/h2-console>
