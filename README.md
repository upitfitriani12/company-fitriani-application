# Company Fitriani Application

#### Description
Aplikasi Pengecekan Produk ini dibuat untuk membantu pengecekan produk kadaluwarsa oleh Karyawan (Employee) 
pada perusahaan Fitriani. perusahaan Fitriani merupakan perusahaan makanan instan dengan berbagai pilihan produk. 
Dengan aplikasi ini, karyawan dapat dengan mudah menemukan produk yang sudah kadaluwarsa maupun yang belum.
Fitur-fitur yang tersedia pada Product dalam aplikasi ini meliputi Create produk, 
Get nonExpired untuk pengecekan produk kadaluwarsa, sedangkan untuk Get expired untuk 
pengecekan daftar produk yang sudah kadaluwarsa, lalu terdapat Update produk, GetAll Products, 
Get Product By ID dan Delete untuk Menghapus produk.
Aplikasi ini dirancang untuk meningkatkan efisiensi dan kualitas manajemen produk di perusahaan Fitriani 
melalui pembuatan API dengan fitur-fitur yang user-friendly dan efektif.


## API Spec Product and Employee :

# Product

#### Create Product

Request :

- Method : POST
- Endpoint : `/products`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json
{
  "name":"Seblak Komplit",
  "price":25000,
  "expiryDate": "2025-10-01",
  "expired":false
}
```

Response :
```json
{
  "message": "Product created successfully",
  "data": {
    "id": 8,
    "name": "Seblak Komplit",
    "price": 25000,
    "expiryDate": "2025-10-01",
    "expired": false
  },
  "paging": null
}
```

#### Get Employee

Request :

- Method : GET
- Endpoint : `/products`

Response :
```json
{
  "message": "All Product Successfully Displayed",
  "data": [
    {
      "id": 1,
      "name": "Seblak Rasa Original",
      "price": 25000,
      "expiryDate": "2023-12-01",
      "expired": true
    },
    {
      "id": 2,
      "name": "Seblak Rasa Bakso",
      "price": 30000,
      "expiryDate": "2024-12-12",
      "expired": false
    },
    {
      "id": 3,
      "name": "Tteokbokki Spicy",
      "price": 50000,
      "expiryDate": "2024-12-12",
      "expired": false
    },
    {
      "id": 4,
      "name": "Baso Aci Original",
      "price": 15000,
      "expiryDate": "2023-12-12",
      "expired": true
    },
    {
      "id": 5,
      "name": "Bakso Tulang Rangu",
      "price": 15000,
      "expiryDate": "2025-10-08",
      "expired": false
    },
    {
      "id": 8,
      "name": "Seblak Komplit",
      "price": 25000,
      "expiryDate": "2025-10-01",
      "expired": false
    }
  ],
  "paging": {
    "count": 6,
    "totalPage": 1,
    "page": 1,
    "size": 6
  }
}
```

### Get Non Expired Product

Request :
- Method : GET
- Endpoint `/products/nonExpired`

Response :
```json
{
  "message": "Products that are not Expired are successfully found",
  "data": [
    {
      "id": 2,
      "name": "Seblak Rasa Bakso",
      "price": 30000,
      "expiryDate": "2024-12-12",
      "expired": false
    },
    {
      "id": 3,
      "name": "Tteokbokki Spicy",
      "price": 50000,
      "expiryDate": "2024-12-12",
      "expired": false
    },
    {
      "id": 5,
      "name": "Bakso Tulang Rangu",
      "price": 15000,
      "expiryDate": "2025-10-08",
      "expired": false
    },
    {
      "id": 8,
      "name": "Seblak Komplit",
      "price": 25000,
      "expiryDate": "2025-10-01",
      "expired": false
    }
  ],
  "paging": {
    "count": 4,
    "totalPage": 1,
    "page": 1,
    "size": 4
  }
}
```

### Get Expired Product

Request :
- Method : GET
- Endpoint `/products/expired`

Response :
```json
{
    "message": "Expired Products Successfully Found ",
    "data": [
        {
            "id": 1,
            "name": "Seblak Rasa Original",
            "price": 25000,
            "expiryDate": "2023-12-01",
            "expired": true
        },
        {
            "id": 4,
            "name": "Baso Aci Original",
            "price": 15000,
            "expiryDate": "2023-12-12",
            "expired": true
        }
    ],
    "paging": {
        "count": 2,
        "totalPage": 1,
        "page": 1,
        "size": 2
    }
}
```

#### Get By ID Product
Request :

- Method : GET
- Endpoint : `/products/{id}`

Response :
```json
{
    "message": "Product ID successfully found",
    "data": {
        "id": 4,
        "name": "Baso Aci Original",
        "price": 15000,
        "expiryDate": "2023-12-12",
        "expired": true
    },
    "paging": null
}
```

#### Update Product

Request :

- Method : PUT
- Endpoint : `/products/{id}`
- Body :

```json
{
  "id": 4,
  "name": "Baso Aci Original",
  "price": 15000,
  "expiryDate": "2025-10-10",
  "expired": false
}
```

Response :
```json
{
  "message": "Product updated successfully",
  "data": {
    "id": 4,
    "name": "Baso Aci Original",
    "price": 15000,
    "expiryDate": "2025-10-10",
    "expired": false
  },
  "paging": null
}
```

### Delete Product

Request :

- Method : DELETE
- Endpoint : `/products/{id}`

Response :

```json
{
  "message": "Product deleted successfully",
  "data": null,
  "paging": null
}
```


# Employee 

#### Create Employee

Request :

- Method : POST
- Endpoint : `/employees`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json
{
  "name":"string",
  "position":"string"
}
```

Response :
```json
{
  "message": "Employee created successfully",
  "data": {
    "id": "string",
    "name": "string",
    "position": "string"
  },
  "paging": null
}
```

#### Get Employee

Request :

- Method : GET
- Endpoint : `/employees`

Response :
```json
{
  "message": "All Employees Successfully Displayed",
  "data": [
    {
      "id": "string",
      "name": "string",
      "position": "string"
    },
    {
      "id": "string",
      "name": "string",
      "position": "string"
    }
  ],
  "paging": {
    "count": 2,
    "totalPage": 1,
    "page": 1,
    "size": 2
  }
}
```

### GetById Employee

Request :
- Method : GET
- Endpoint `/employees/{id}`

Response :
```json
{
    "message": "Employee ID successfully found",
    "data": {
        "id": "string",
        "name": "string",
        "position": "string"
    },
    "paging": null
}
```


#### Update Employee

Request :

- Method : PUT
- Endpoint : `/employees/{id}`
- Body :

```json
{
  "name": "string",
  "position": "string"
}
```

Response :
```json
{
    "message": "Employee updated successfully",
    "data": {
        "id": "string",
        "name": "string",
        "position": "string"
    },
    "paging": null
}
```

### Delete Employee

Request :

- Method : DELETE
- Endpoint : `/employees/{id}`

Response :

```json
{
    "message": "Employee deleted successfully",
    "data": null,
    "paging": null
}
```
