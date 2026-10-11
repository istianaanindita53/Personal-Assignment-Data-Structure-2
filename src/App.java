import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int choose = 0;
        System.out.println("===== PILIH SISTEM =====");
        System.out.println("1. LinkedList");
        System.out.println("2. Queue and Stack");
        System.out.print("Pilih menu: ");
        choose = scan.nextInt();

        if (choose == 1) {
            SistemDataBuku(scan);
        } else {
            SistemKasirToko(scan);
        }
    }

    public static void SistemDataBuku(Scanner scan) {
        LinkedList daftarBuku = new LinkedList();
        int choose = 0;

        do {
            System.out.println("===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih: menu: ");

            if (!scan.hasNextInt()) {
                System.out.println("Pilihan harus berupa angka.");
                scan.nextLine();
                continue;
            }

            choose = scan.nextInt();
            scan.nextLine();

            if (choose <= 0 || choose > 5) {
                System.out.println("Pilihan menu harus berupa angka 1 - 5.");
                continue;
            }

            switch (choose) {
                case 1:
                    int n = daftarBuku.size;
                    if (n < 5) {
                        System.out.printf("Masukkan berapa buku untuk dimasukkan ke dalam List (minimal %d): ",
                                5 - n);
                        n = scan.nextInt();
                        scan.nextLine();
                        if ((n + daftarBuku.size) < 5) {
                            System.out.println("List buku minimal 5 data!");
                            break;
                        }

                        for (int i = 0; i < n; i++) {
                            System.out.printf("Masukkan Data Buku ke-%d\n", i + 1);

                            String kodeBuku;
                            System.out.print("Masukkan Kode Buku: ");
                            kodeBuku = scan.nextLine();

                            // Validasi kode maksimal 5 karakter
                            if (kodeBuku.isEmpty()
                                    || kodeBuku.length() > 5) {
                                System.out.println(
                                        "Kode buku wajib diisi dan maksimal 5 karakter!");
                                break;
                            }

                            System.out.print("Masukkan Judul: ");
                            String judul = scan.nextLine();

                            System.out.print("Masukkan Penulis: ");
                            String penulis = scan.nextLine();

                            if (judul.isEmpty() || penulis.isEmpty()) {
                                System.out.println(
                                        "Judul dan penulis wajib diisi!");
                                break;
                            }
                            daftarBuku.add(kodeBuku, judul, penulis);
                            System.out.println();
                        }
                    } else {
                        String kodeBuku;

                        System.out.print("\nMasukkan Kode Buku: ");
                        kodeBuku = scan.nextLine();

                        // Validasi kode maksimal 5 karakter
                        if (kodeBuku.isEmpty()
                                || kodeBuku.length() > 5) {
                            System.out.println(
                                    "Kode buku wajib diisi dan maksimal 5 karakter!");
                            break;
                        }

                        System.out.print("Masukkan Judul: ");
                        String judul = scan.nextLine();

                        System.out.print("Masukkan Penulis: ");
                        String penulis = scan.nextLine();

                        if (judul.isEmpty() || penulis.isEmpty()) {
                            System.out.println(
                                    "Judul dan penulis wajib diisi!");
                            break;
                        }

                        daftarBuku.add(kodeBuku, judul, penulis);
                        System.out.println();
                    }
                    break;
                case 2:
                    daftarBuku.removeLastBook();
                    break;
                case 3:
                    if (daftarBuku.size == 0) {
                        System.out.println("Tidak ada data untuk dicari.");
                    } else {
                        System.out.print("Masukkan kode buku yang ingin dicari: ");
                        String searchKode = scan.nextLine();
                        daftarBuku.find(searchKode);
                    }
                    break;
                case 4:
                    daftarBuku.display();
                    break;
                default:
                    break;
            }
        } while (choose != 5);

    }

    public static void SistemKasirToko(Scanner scan) {
        Queue queuePelanggan = new Queue();
        Stack stackPelanggan = new Stack();
        int choose = 0;

        do {
            System.out.println("===== SISTEM KASIR TOKO =====");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih: menu: ");

            if (!scan.hasNextInt()) {
                System.out.println("Pilihan harus berupa angka.");
                scan.nextLine();
                continue;
            }

            choose = scan.nextInt();
            scan.nextLine();

            switch (choose) {
                case 1:
                    int n = queuePelanggan.size;
                    if (n < 5) {
                        System.out.printf("Masukkan berapa orang untuk dimasukkan ke dalam antrian (minimal %d): ",
                                5 - n);
                        n = scan.nextInt();
                        scan.nextLine();
                        if ((n + queuePelanggan.size) < 5) {
                            System.out.println("Antrian pelanggan minimal 5 data!");
                            break;
                        }

                        for (int i = 0; i < n; i++) {
                            System.out.printf("Masukkan Data Pelanggan ke-%d\n", i + 1);
                            System.out.print("Masukkan Nomor Antrian: ");
                            String kode = scan.nextLine();

                            System.out.print("Masukkan Nama Pelanggan: ");
                            String nama = scan.nextLine();

                            System.out.print("Masukkan Total Belanja: ");
                            Double total = scan.nextDouble();
                            scan.nextLine();

                            queuePelanggan.enqueue(kode, nama, total);
                            if (i != n - 1) {
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.print("Masukkan Nomor Antrian: ");
                        String kode = scan.nextLine();

                        System.out.print("Masukkan Nama Pelanggan: ");
                        String nama = scan.nextLine();

                        System.out.print("Masukkan Total Belanja: ");
                        Double total = scan.nextDouble();

                        queuePelanggan.enqueue(kode, nama, total);
                    }

                    System.out.println("Data pelanggan ditambahkan ke antrian!");
                    System.out.println();
                    break;

                case 2:
                    NodePelanggan pelanggan = queuePelanggan.dequeue();
                    if (pelanggan != null) {
                        System.out.println("Melayani pelanggan " + pelanggan.kode + " (" + pelanggan.nama + ")");
                        System.out.printf("Total Belanja: Rp%.0f%n", pelanggan.total);
                        stackPelanggan.push(pelanggan.kode, pelanggan.nama, pelanggan.total);
                    }
                    System.out.println();
                    break;

                case 3:
                    queuePelanggan.display();
                    break;

                case 4:
                    stackPelanggan.display();
                    break;

                default:
                    break;
            }
        } while (choose != 5);
    }
}
