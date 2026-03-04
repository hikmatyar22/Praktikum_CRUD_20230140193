# Dokumentasi API Praktikum 1

Dokumentasi ini berisi daftar endpoint untuk manajemen data User pada proyek Praktikum 1.

## Base URL
`http://localhost:8080`

---

## 1. Tambah User (Add User)
Digunakan untuk menambahkan data user baru ke dalam sistem.

- **URL:** `/api/users`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: application/json`

### Request Body
```json
{
  "name": "Hikmatyar",
  "age": 20
}
```

### Response Body (201 Created)
```json
{
  "status": "success",
  "data": {
    "age": 20,
    "id": "8013c6c6-8d8f-4192-9863-ca0663d2c2e3",
    "name": "Hikmatyar"
  }
}
```

---

## 2. Ambil Semua User (Get All Users)
Digunakan untuk mendapatkan daftar seluruh user yang terdaftar.

- **URL:** `/api/users`
- **Method:** `GET`

### Response Body (200 OK)
```json
{
  "status": "success",
  "data": [
    {
      "id": "6b21ee37-3aaa-4137-8df8-428c046c42b6",
      "name": "Alghifary",
      "age": 0
    },
    {
      "id": "8013c6c6-8d8f-4192-9863-ca0663d2c2e3",
      "name": "Hikmatyar Alghifary",
      "age": 20
    }
  ]
}
```

---

## 3. Ambil User Berdasarkan ID (Get User By ID)
Digunakan untuk mendapatkan detail data user tertentu menggunakan ID.

- **URL:** `/api/users/{id}` 
- (`/api/users/8013c6c6-8d8f-4192-9863-ca0663d2c2e3`)
- **Method:** `GET`

### Response Body (200 OK)
```json
{
  "status": "success",
  "data": {
    "id": "8013c6c6-8d8f-4192-9863-ca0663d2c2e3",
    "name": "Hikmatyar Alghifary",
    "age": 0
  }
}
```

---

## 4. Update User
Digunakan untuk memperbarui data user yang sudah ada berdasarkan ID.

- **URL:** `/api/users/{id}`
- (`/api/users/8013c6c6-8d8f-4192-9863-ca0663d2c2e3`)
- **Method:** `PUT`
- **Headers:**
  - `Content-Type: application/json`

### Request Body
```json
{
  "name": "Hikmatyar Alghifary",
  "age": 20
}
```

### Response Body (200 OK)
```json
{
  "status": "success",
  "data": {
    "age": 20,
    "id": "8013c6c6-8d8f-4192-9863-ca0663d2c2e3",
    "name": "Hikmatyar Alghifary"
  }
}
```

---

## 5. Hapus User (Delete User)
Digunakan untuk menghapus data user berdasarkan ID.

- **URL:** `/api/users/{id}`
- `/api/users/6b21ee37-3aaa-4137-8df8-428c046c42b6`
- **Method:** `DELETE`

### Response Body (200 OK)
```json
{
  "status": "success delete user with id 6b21ee37-3aaa-4137-8df8-428c046c42b6"
}
```
