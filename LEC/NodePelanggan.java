public class NodePelanggan {
    String kode;
    String nama;
    double total;
    NodePelanggan next;

    // Membuat node untuk data pelanggan
    public NodePelanggan(String kode, String nama, double total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}
