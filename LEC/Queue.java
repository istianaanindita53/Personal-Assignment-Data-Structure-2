public class Queue {
    NodePelanggan first;
    NodePelanggan last;
    int size;

    public Queue() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    public void enqueue(String kode, String nama, double total) {
        NodePelanggan newPelanggan = new NodePelanggan(kode, nama, total);

        // apabila data queue masih 0
        if (this.first == null) {
            this.first = newPelanggan;
            this.last = newPelanggan;
        } else {
            this.last.next = newPelanggan;
            this.last = newPelanggan;
        }
        this.size++;
    }

    public NodePelanggan dequeue() {
        if (this.first == null) {
            System.out.println("Antrian kosong.");
            return null;
        }

        NodePelanggan pelangganKeluar = this.first;

        this.first = this.first.next;

        if (this.first == null) {
            this.last = null;
        }

        pelangganKeluar.next = null;
        size--;

        return pelangganKeluar;
    }

    public void display() {
        NodePelanggan current = this.first;

        System.out.println("Daftar Antrian Pelanggan:");

        while (current != null) {
            System.out.println("Nomor Antrian : " + current.kode);
            System.out.println("Nama Pelanggan: " + current.nama);
            System.out.printf("Total Belanja : Rp %,.2f%n", current.total);
            System.out.println("--------------------------------");

            current = current.next;
        }

        System.out.println("Jumlah pelanggan: " + size);
        System.out.println();
    }
}
