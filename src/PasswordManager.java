import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, String>> sifreKayitlari = new HashMap<>();

        while (true) {
            menuGoster();
            int secim = scanner.nextInt();
            scanner.nextLine();

            if (secim == 1) {
                sifreEkle(scanner, sifreKayitlari);
            } else if (secim == 2) {
                sifreGoster(scanner, sifreKayitlari);
            } else if (secim == 3) {
                System.out.println("Uygulama kapatiliyor...");
                break;
            } else {
                System.out.println("Gecersiz secim yaptiniz.");
            }
        }

        scanner.close();
    }

    public static void menuGoster() {
        System.out.println("\n=== SIFRE YONETICI UYGULAMASI ===");
        System.out.println("1 - Sifre Ekle");
        System.out.println("2 - Sifre Goster");
        System.out.println("3 - Cikis");
        System.out.print("Seciminizi yapiniz: ");
    }

    public static void sifreEkle(Scanner scanner, Map<String, Map<String, String>> sifreKayitlari) {
        System.out.print("Hesap adi giriniz: ");
        String hesapAdi = scanner.nextLine().toLowerCase();

        System.out.print("Kullanici adi giriniz: ");
        String kullaniciAdi = scanner.nextLine().toLowerCase();

        System.out.print("Sifre giriniz: ");
        String sifre = scanner.nextLine();

        Map<String, String> bilgiler = new HashMap<>();
        bilgiler.put("kullaniciAdi", kullaniciAdi);
        bilgiler.put("sifre", sifre);

        sifreKayitlari.put(hesapAdi, bilgiler);

        System.out.println("Sifre kaydi basariyla eklendi.");
    }

    public static void sifreGoster(Scanner scanner, Map<String, Map<String, String>> sifreKayitlari) {
        System.out.print("Hesap adi giriniz: ");
        String hesapAdi = scanner.nextLine().toLowerCase();

        if (sifreKayitlari.containsKey(hesapAdi)) {
            Map<String, String> bilgiler = sifreKayitlari.get(hesapAdi);

            System.out.println("Kullanici Adi: " + bilgiler.get("kullaniciAdi"));
            System.out.println("Sifre: " + bilgiler.get("sifre"));
        } else {
            System.out.println("Kayit bulunamadi.");
        }
    }
}