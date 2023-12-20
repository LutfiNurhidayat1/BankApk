import java.util.Scanner;

public class AplikasiPerbankan {
    public static void main(String[] args) {
    tampilanAwal();
    }   
        public static void tampilanAwal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di Aplikasi Perbankan");
        System.out.println("Pilih masuk sebagai Admin/Nasabah atau Keluar");
        System.out.println("1.Admin");
        System.out.println("2.Nasabah");
        System.out.println("3.keluar");
        System.out.print("Masukan pilihan(1/2/3): ");
        String jenisUser = scanner.nextLine();

        if (jenisUser.equals("1")) {
            // Input untuk Admin
            System.out.print("Masukkan username Admin: ");
            String usernameAdmin = scanner.nextLine();
            System.out.print("Masukkan email Admin: ");
            String emailAdmin = scanner.nextLine();
            System.out.print("Masukkan password Admin: ");
            String passwordAdmin = scanner.nextLine();

            Akun admin = new Akun(usernameAdmin, emailAdmin, passwordAdmin);
            DataBase.setAdminPassword(passwordAdmin);
            DataBase.tambahAkunAdmin(admin);

            System.out.println("Akun Admin berhasil dibuat dengan ID: " + admin.getIdAdmin());

            System.out.print("Apakah Anda ingin login sebagai Admin? (ya/tidak): ");
            String inginLogin = scanner.nextLine().toLowerCase();

            if (inginLogin.equals("ya")) {
                System.out.print("Masukkan ID admin: ");
                String idAdmin = scanner.nextLine();

                Akun adminLogin = DataBase.getAkunAdminById(idAdmin);

                if (adminLogin != null) {
                    adminLogin.login();

                    // Menampilkan opsi transaksi Nasabah untuk Admin
                    admin.tampilkanStrukTransaksiNasabah();

                } else {
                    System.out.println("Admin tidak ditemukan.");
                }
            }
        } else if (jenisUser.equals("2")) {
            // Input untuk Nasabah
            System.out.print("Masukkan username Nasabah: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan email Nasabah: ");
            String email = scanner.nextLine();
            System.out.print("Masukkan password Nasabah: ");
            String password = scanner.nextLine();

            Akun nasabah = new Akun(username, email, password);
            DataBase.tambahAkun(nasabah);

            System.out.println("Akun Nasabah berhasil dibuat dengan ID: " + nasabah.getIdNasabah());

            // Login sebagai Nasabah
            System.out.print("Apakah Anda ingin login sebagai Nasabah? (ya/tidak): ");
            String pilihanLogin = scanner.nextLine().toLowerCase();

            if (pilihanLogin.equals("ya")) {
                System.out.print("Masukkan ID Nasabah: ");
                String idNasabah = scanner.nextLine();

                Akun nasabahLogin = DataBase.getAkunById(idNasabah);

                if (nasabahLogin != null) {
                    nasabahLogin.login();

                    // Menampilkan opsi transaksi Nasabah
                    tampilkanMenuTransaksi(nasabahLogin);

                    // Menampilkan struk transaksi
                    nasabahLogin.tampilkanStrukTransaksiNasabah();
                } else {
                    System.out.println("Nasabah tidak ditemukan.");
                }
            }
        } else if (jenisUser.equals("3")) {
            System.exit(0);
        } else {
            System.out.println("Jenis pengguna tidak valid.");
        }

        scanner.close();

    }
    public static void tampilkanMenuTransaksi(Akun nasabah) {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("\nMenu Transaksi:");
            System.out.println("1. Setoran");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Transfer");
            System.out.println("4. Top-up e-money");
            System.out.println("5. Keluar");
    
            System.out.print("Pilih transaksi (1-5): ");
            int pilihan;
    
            // Check if the next token is an integer
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } else {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine(); // Consume the invalid input
                continue; // Restart the loop
            }
    
            switch (pilihan) {
                    case 1:
                        Transaksi.setoran(nasabah);
                        break;
                    case 2:
                        Transaksi.tarikTunai(nasabah);
                        break;
                    case 3:
                        Transaksi.transfer(nasabah);
                        break;
                    case 4:
                        Transaksi.topUpEmoney(nasabah);
                        break;
                    case 5:
                        
                        nasabah.tampilkanStrukTransaksiNasabah();

                        // Opsi untuk kembali melanjutkan transaksi atau keluar
                        System.out.print("Apakah Anda ingin kembali melanjutkan transaksi? (ya/tidak): ");
                        String pilihanKembali = scanner.nextLine().toLowerCase();

                        if (pilihanKembali.equals("tidak")) {
                            System.out.println("Terimakasih, semoga harimu diberkahi.");
                            scanner.close();
                            AplikasiPerbankan.tampilanAwal();
                            break;
                        }
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
    

