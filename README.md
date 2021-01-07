# Tecso Cuentas Corrientes

REST API para realizar abm de Personas Fisicas, Jurídicas, Cuentas Corrientes y Movimientos

## Servidor activo en Heroku

    https://tecso-cuentas-corrientes.herokuapp.com/api/v1

## Web activa en Firebase

    https://tecso-cuentas-corrientes.web.app/


## REST API

Los endpoints para cada petición están detallados en las siguientes tablas, y con ejemplos en su respectivo hipervinculo.

# Endpoints
## [Persona Juridica](#Peticiones-Personas-Juridicas)
| Descripción | Método | Endpoint |
| ------------- | ------------- | ------------- |
| [Obtener Personas Jurídicas](#Obtener-Personas-Jurídicas) | GET | /api/v1/persona-juridica |
| [Obtener Personas Jurídica por ID ](#Obtener-Persona-Jurídica-por-ID) | GET | /api/v1/persona-juridica/{id} |
| [Crear Persona Jurídica ](#Crear-Persona-Jurídica) | POST | /api/v1/persona-juridica |
| [Editar Persona Jurídica ](#Editar-Persona-Jurídica) | PUT | /api/v1/persona-juridica/{id} |
| [Eliminar Persona Jurídica ](#Eliminar-Persona-Jurídica) | DELETE | /api/v1/persona-juridica/{id} |

## [Persona Física](#Peticiones-Personas-Físicas)
| Descripción | Método | Endpoint |
| ------------- | ------------- | ------------- |
| [Obtener Personas Físicas](#Obtener-Personas-Físicas) | GET | /api/v1/persona-fisica |
| [Obtener Persona Física por ID ](#Obtener-Persona-Física-por-ID) | GET | /api/v1/persona-fisica/{id} |
| [Crear Persona Física ](#Crear-Persona-Física) | POST | /api/v1/persona-fisica |
| [Editar Persona Física ](#Editar-Persona-Física) | PUT | /api/v1/persona-fisica/{id} |
| [Eliminar Persona Física ](#Eliminar-Persona-Física) | DELETE | /api/v1/persona-fisica/{id} |

## [Cuenta Corriente](#Peticiones-Cuentas)
| Descripción | Método | Endpoint |
| ------------- | ------------- | ------------- |
| [Obtener Cuentas ](#Obtener-Cuentas) | GET | /api/v1/account |
| [Obtener Cuenta por ID ](#Get-Cuenta-por-ID) | GET | /api/v1/account/{id} |
| [Crear Cuenta ](#Crear-Cuenta) | POST | /api/v1/account |
| [Editar Cuenta ](#Editar-Cuenta) | PUT | /api/v1/account/{id} |
| [Eliminar Cuenta ](#Eliminar-Cuenta) | DELETE | /api/v1/account/{id} |


## [Movimientos](#Peticiones-Movimientos)
| Descripción | Método | Endpoint |
| ------------- | ------------- | ------------- |
| [Obtener Movimientos por ID de Cuenta ](#Obtener-Movimientos-por-ID-de-Cuenta) | GET | /api/v1/movement/{id} |
| [Crear Movimiento ](#Crear-Movimiento) | POST | /api/v1/movement |


# Peticiones Personas Juridicas 

## Obtener Personas Jurídicas

### Request

`GET /api/v1/persona-juridica`

### Response

    [
         {
            "id": 2,
            "businessName": "Kiosco Jardin",
            "fundationYear": 2005,
            "rut": 404040
        },
        {
            "id": 8,
            "businessName": "Enveses Carolo",
            "fundationYear": 2021,
            "rut": 303030
        }
    ]

## Obtener Persona Jurídica por ID

### Request

`GET /api/v1/persona-juridica/8`

### Response

    {
        "id": 8,
        "businessName": "Enveses Carolo",
        "fundationYear": 2021,
        "rut": 303030
    }

## Crear Persona Jurídica

### Request

`POST /api/v1/persona-juridica`

### Body
    {
        "businessName": "Óptica Senes",
        "fundationYear": 2010,
        "rut": 38579707
    }

### Response

    {
        "id": 11,
        "businessName": "Óptica Senes",
        "fundationYear": 2010,
        "rut": 38579707
    }

## Editar Persona Jurídica

### Request

`PUT /api/v1/persona-juridica/11`

### Body
    {
        "businessName": "Óptica Familia Senes",
    }

### Response

    {
        "id": 11,
        "businessName": "Óptica Familia Senes",
        "fundationYear": 2010,
        "rut": 38579707
    }

## Eliminar Persona Jurídica

### Request

`DELETE /api/v1/persona-juridica/8`

### Response

    {
        "id": 11,
        "businessName": "Óptica Familia Senes",
        "fundationYear": 2010,
        "rut": 38579707
    }


# Peticiones Personas Físicas 

## Obtener Personas Físicas

### Request

`GET /api/v1/persona-fisica`

### Response

    [
        {
            "id": 1,
            "firstName": "Nico",
            "lastName": "Espina",
            "cc": "222222222",
            "rut": 40404
        },
        {
            "id": 2,
            "firstName": "Martin",
            "lastName": "Lopez",
            "cc": "1111111111",
            "rut": 4040422
        }
    ]

## Obtener Persona Física por ID

### Request

`GET /api/v1/persona-fisica/1`

### Response

    {
        "id": 1,
        "firstName": "Nico",
        "lastName": "Espina",
        "cc": "222222222",
        "rut": 40404
    }

## Crear Persona Física

### Request

`POST /api/v1/persona-fisica`

### Body

    {
        "firstName": "Denise",
        "lastName": "Perez",
        "cc": "333333333",
        "rut": 256985
    }

### Response

    {
        "id": 3,
        "firstName": "Denise",
        "lastName": "Perez",
        "cc": "333333333",
        "rut": 256985
    }

## Editar Persona Física

### Request

`PUT /api/v1/persona-fisica/3`

### Body
    {
        "firstName": "Micaela",
    }

### Response

    {
        "id": 3,
        "firstName": "Micaela",
        "lastName": "Perez",
        "cc": "333333333",
        "rut": 256985
    }

## Eliminar Persona Física

### Request

`DELETE /api/v1/persona-fisica/3`

### Response

    {
        "id": 3,
        "firstName": "Micaela",
        "lastName": "Perez",
        "cc": "333333333",
        "rut": 256985
    }


# Peticiones Cuentas 

## Obtener Cuentas

### Request

`GET /api/v1/account`

### Response

    [
        {
            "id": 2,
            "accountNumber": 123123,
            "currency": "USD",
            "balance": 15.03
        },
        {
            "id": 3,
            "accountNumber": 33333,
            "currency": "USD",
            "balance": 99995.0
        },
        {
            "id": 4,
            "accountNumber": 3857,
            "currency": "USD",
            "balance": 500.0
        }
    ]

## Obtener Cuenta por ID

### Request

`GET /api/v1/account/2`

### Response

    {
        "id": 2,
        "accountNumber": 123123,
        "currency": "USD",
        "balance": 15.03
    }

## Crear Cuenta

### Request

`POST /api/v1/account`

### Body

    {
        "accountNumber": 555555,
        "currency": "USD",
        "balance": 500
    }

### Response

    {
        "id": 12,
        "accountNumber": 555555,
        "currency": "USD",
        "balance": 500.0
    }

## Editar Cuenta

### Request

`PUT /api/v1/account/12`

### Body
    {
        "accountNumber": 555555,
        "currency": "USD",
        "balance": 500.0
    }

### Response

    {
        "id": 12,
        "accountNumber": 555555,
        "currency": "USD",
        "balance": 500.0
    }

## Eliminar Cuenta

### Request

`DELETE /api/v1/account/12`

### Response

    {
        "id": 12,
        "accountNumber": 555555,
        "currency": "USD",
        "balance": 500.0
    }


# Peticiones Movimientos

## Obtener Movimientos por ID de Cuenta

### Request

`GET /api/v1/movement/2`

### Response

    [
        {
            "id": 4,
            "date": "2021-01-03",
            "movementType": "USD",
            "amount": 5.4,
            "originAccountNumber": 123123,
            "destinationAccountNumber": 33333,
            "description": "Expensas"
        },
        {
            "id": 7,
            "date": "2021-01-03",
            "movementType": "USD",
            "amount": 5.0,
            "originAccountNumber": 123123,
            "destinationAccountNumber": 33333,
            "description": "Otros"
        },
        {
            "id": 5,
            "date": "2021-01-03",
            "movementType": "USD",
            "amount": 5.4,
            "originAccountNumber": 123123,
            "destinationAccountNumber": 33333,
            "description": "Otros"
        }
    ]

## Crear Movimiento

### Request

`POST /api/v1/movement`

### Body

     {
        "movementType": "USD",
        "amount": 100,
        "originAccountNumber": 33333,
        "destinationAccountNumber": 3857,
        "description": "Universidad"
    }

### Response

    {
        "id": 13,
        "date": "2021-01-07",
        "movementType": "USD",
        "amount": 100.0,
        "originAccountNumber": 33333,
        "destinationAccountNumber": 3857,
        "description": "Universidad"
    }
