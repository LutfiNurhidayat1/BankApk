import java.util.Scanner;

public class Akun {
    private static int countA = 1;
    private static int countN = 1;
    private String idNasabah;
    private String idAdmin;
    private String usernameNasabah;
    private String usernameAdmin;
    private String emailAdmin;
    private String email;
    private String password;
    private String passwordAdmin;
    private double totalSaldo;
    private String catatanTransaksi;



    public Akun(String username, String email, String password) {
        this.idAdmin = "A" + countA++; 
        this.idNasabah = "N" + countN++;
        this.usernameAdmin = username;
        this.usernameNasabah = username;
        this.emailAdmin = email;
        this.email = email;
        this.password = password;
        this.passwordAdmin = password;
        this.totalSaldo = 0;
        this.catatanTransaksi = "";
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public String getUsername() {
        return usernameNasabah;
    }

    public String getEmail() {
        return email;
    }

    public double getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(double totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

    public String getCatatanTransaksi() {
        return catatanTransaksi;
    }

    public void setCatatanTransaksi(String catatanTransaksi) {
        this.catatanTransaksi = catatanTransaksi;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        if (inputPassword.equals(password)) {
            System.out.println("Login berhasil.");
        } else {
            System.out.println("Password salah. Login gagal.");
            System.exit(0);  // Keluar dari program jika login gagal
        }
        scanner.close();
    }

    public void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        if (inputPassword.equals(passwordAdmin)) {
            System.out.println("Login berhasil.");
        } else {
            System.out.println("Password salah. Login gagal.");
            System.exit(0);  // Keluar dari program jika login gagal
        }
        scanner.close();
    }

    public void tampilkanStrukTransaksiNasabah() {
        System.out.println("Struk Transaksi:");
        System.out.println("Username: " + usernameNasabah);
        System.out.println("ID Nasabah: " + idNasabah);
        System.out.println("Jenis Transaksi: " + catatanTransaksi);
        System.out.println("Jumlah Transaksi: " + getTotalSaldo());
        System.out.println("Total Saldo: " + totalSaldo);
        System.out.println("Terima kasih atas transaksi Anda.");
    }
}
