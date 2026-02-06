# language: id
Fitur: Pendaftaran Akun ParaBank

  @register @positive
  Skenario: Pendaftaran berhasil dengan data lengkap
    Dengan User berada di halaman pendaftaran ParaBank
    Ketika User memasukkan data diri berikut:
      | namaDepan | namaBelakang | alamat      | kota        | provinsi | kodePos | ssn |
      | Yunan      | Aja          | JL. aja    | Jaktim    | DKI Jakarta | 12345   | 999 |
    Dan User memasukkan username "yunan123456" dan kata sandi "123456"
    Dan User mengonfirmasi kata sandi "123456"
    Dan User klik tombol Daftar
    Maka User harus melihat pesan sukses "Your account was created successfully"

  @register @negative
  Skenario: Pendaftaran gagal karena konfirmasi kata sandi tidak cocok
    Dengan User berada di halaman pendaftaran ParaBank
    Ketika User memasukkan data diri berikut:
      | namaDepan | namaBelakang | alamat      | kota        | provinsi | kodePos | ssn |
      | Yunan      | Aja          | JL. aja    | Jaktim    | DKI Jakarta | 12345   | 999 |
    Dan User memasukkan username "yunan1234" dan kata sandi "passwordsalah"
    Dan User mengonfirmasi kata sandi "PasswordBerbeda"
    Dan User klik tombol Daftar
    Maka User harus melihat pesan kesalahan "Passwords did not match."

  @login @positive
  Skenario: Login dengan akun yang sudah terdaftar
    Dengan User berada di halaman utama ParaBank
    Ketika User memasukkan username "yunan123456" dan kata sandi "123456"
    Dan User klik tombol Log In
    Maka User harus diarahkan ke halaman "Accounts Overview"

  @login @negative
  Skenario: Login gagal dengan sandi yang salah
    Dengan User berada di halaman utama ParaBank
    Ketika User memasukkan username "yunan123" dan kata sandi "passwordsalah!"
    Dan User klik tombol Log In
    Maka User harus melihat pesan kesalahan "The username and password could not be verified."