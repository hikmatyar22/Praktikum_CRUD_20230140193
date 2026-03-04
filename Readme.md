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
    "age": 20
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
- Merubah Nama dari Hikmatyar Ke Hikmatyar Alghifary

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
- Menghapus Akun yang memilki id 6b21ee37-3aaa-4137-8df8-428c046c42b6 dengan nama Alghifary

### Response Body (200 OK)
```json
{
  "status": "success delete user with id 6b21ee37-3aaa-4137-8df8-428c046c42b6"
}
```

---

## 6. Penanganan Request Tidak Valid (Invalid Request Handling)
Jika data request tidak sesuai (misal: JSON tidak valid), Spring Boot akan mengembalikan error 400 atau 500 secara default tergantung pada jenis kesalahannya. Secara internal, sistem menggunakan `ValidationUtil` yang melempar `RuntimeException` jika validasi gagal.

- **Method:** `POST` / `PUT`
- **Response Body (Contoh Default)**
```json
{
  "timestamp": "2024-03-04T04:36:27.000+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Validation error",
  "path": "/api/users"
}
```

---

## 7. Penanganan User Tidak Ditemukan (User Not Found)
Jika ID yang dicari tidak ada dalam sistem, `UserService` akan melempar `RuntimeException` dengan pesan "User not found".

- **Method:** `GET` / `PUT` / `DELETE`
- **Response Body (Contoh Default)**
```json
{
  "timestamp": "2024-03-04T04:36:27.000+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "User not found",
  "path": "/api/users/{id}"
}
```

---

## 8. Screenshoot Tampilan Antarmuka Web
<img width="1919" height="970" alt="image" src="https://github.com/user-attachments/assets/27a89ea9-ba4c-4afd-bff0-487275f482fd" />

