import org.w3c.dom.Node;

public class Stack {
    NodePelanggan top;

    // Constructor untuk membuat stack kosong
    public Stack() {
        this.top = null;
    }

    // Menyimpan transaksi baru di posisi teratas stack
    public void push(String kode, String nama, double total) {
        NodePelanggan newPelanggan = new NodePelanggan(kode, nama, total);

        newPelanggan.next = top;
        top = newPelanggan;

        System.out.println("Transaksi disimpan ke riwayat.");
    }

    // Menampilkan riwayat transaksi dari terbaru ke terlama
    public void display() {
        if (this.top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        NodePelanggan current = this.top;
        int nomor = 1;

        System.out.println("\n=== RIWAYAT TRANSAKSI ===");

        while (current != null) {
            System.out.printf(
                    "%d. Kode: %s | Nama: %s | Total Belanja: Rp%.0f%n",
                    nomor,
                    current.kode,
                    current.nama,
                    current.total);

            current = current.next;
            nomor++;
        }
        System.out.println();
    }
}
