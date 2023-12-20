import java.util.Scanner;

public class Transaksi {

    private static Scanner scanner = new Scanner(System.in);

    public static void setoran(Akun akun) {
        System.out.print("Masukkan jumlah setoran: ");
        double jumlah = scanner.nextDouble();
        if (jumlah > 0) {
            akun.setTotalSaldo(akun.getTotalSaldo() + jumlah);
            akun.setCatatanTransaksi("Setoran: +" + jumlah);
            System.out.println("Setoran berhasil. Saldo saat ini: " + akun.getTotalSaldo());
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0.");
        }
    }

    public static void tarikTunai(Akun akun) {
        System.out.print("Masukkan jumlah tarik tunai: ");
        double jumlah = scanner.nextDouble();
        if (jumlah > 0 && jumlah <= akun.getTotalSaldo()) {
            akun.setTotalSaldo(akun.getTotalSaldo() - jumlah);
            akun.setCatatanTransaksi("Tarik Tunai: -" + jumlah);
            System.out.println("Tarik tunai berhasil. Saldo saat ini: " + akun.getTotalSaldo());
        } else {
            System.out.println("Jumlah tarik tunai tidak valid atau saldo tidak mencukupi.");
        }
    }

    public static void transfer(Akun akun) {
        System.out.print("Masukkan No.Rek tujuan: ");
        String noRek = scanner.next();

        System.out.print("Masukkan jumlah transfer: ");
        double jumlah = scanner.nextDouble();

        scanner.nextLine();

        double biayaAdmin = 2500.0;
        if (jumlah > 0 && (jumlah + biayaAdmin) <= akun.getTotalSaldo()) {
            akun.setTotalSaldo(akun.getTotalSaldo() - (jumlah + biayaAdmin));
            akun.setCatatanTransaksi("Transfer: -" + jumlah);
            System.out.println("Transfer berhasil sebesar: " + jumlah);
            System.out.println("Biaya admin: " + biayaAdmin);
            System.out.println("No.Rek tujuan: " + noRek);
            System.out.println("Sisa saldo: " + akun.getTotalSaldo());
        } else {
            System.out.println("Jumlah transfer tidak valid atau saldo tidak mencukupi.");
        }
    }

    public static void topUpEmoney(Akun akun) {
        double biayaAdmin = 1000.0;

        System.out.print("Masukkan jumlah top-up e-money: ");
        double jumlah = scanner.nextDouble();

        if (jumlah > 0 && (jumlah + biayaAdmin) <= akun.getTotalSaldo()) {
            akun.setTotalSaldo(akun.getTotalSaldo() - (jumlah + biayaAdmin));
            akun.setCatatanTransaksi("Top-up e-money: -" + (jumlah + biayaAdmin));
            System.out.println("Top-up e-money berhasil. Saldo saat ini: " + akun.getTotalSaldo());
        } else {
            System.out.println("Jumlah top-up e-money tidak valid atau saldo tidak mencukupi.");
        }
    }
}
