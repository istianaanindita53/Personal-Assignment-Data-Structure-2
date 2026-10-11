public class LinkedList {
    NodeBuku head;
    int size;

    public LinkedList() {
        this.head = null;
        size = 0;
    }

    public void add(String kodeBuku, String judul, String penulis) {
        NodeBuku newNode = new NodeBuku(kodeBuku, judul, penulis);

        if (this.head == null) {
            this.head = newNode;
        } else {
            NodeBuku currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }

        size++;
        System.out.println("Data berhasil ditambahkan!");
        System.out.println();
    }

    // Pada permintaan soal hanya meminta menghapus buku terakhir,
    // sehingga tidak perlu menghapus buku index ke-X
    public void removeLastBook() {
        if (this.head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
        } else {
            // Kondisi jika hanya ada satu node
            if (this.head.next == null) {
                System.out.println(this.head.toString());

                this.head = null;
                this.size--;

                System.out.println("Data buku berhasil dihapus!");
            } else {
                // Kondisi jika terdapat lebih dari satu node
                NodeBuku currentNode = this.head;

                // Berhenti pada node sebelum node terakhir
                while (currentNode.next.next != null) {
                    currentNode = currentNode.next;
                }

                // Menampilkan data buku yang akan dihapus
                System.out.println(currentNode.next.toString());

                // Menghapus node terakhir
                currentNode.next = null;
                this.size--;

                System.out.println("Data buku berhasil dihapus!");
            }
        }
        System.out.println();
    }

    public void find(String searchKode) {
        NodeBuku buku = this.head;

        if (buku == null) {
            System.out.println("Buku tidak ditemukan.");
        } else {
            boolean flag = false;
            // Membuat flag/penanda apabila ada Kode yang ditemukan,
            // agar menghindari kode dibawah while dieksekusi
            while (buku.next != null) {
                if (buku.kodeBuku.equals(searchKode)) {
                    System.out.println(buku.toString());
                    System.out.println("Data buku berhasil ditemukan!");
                    flag = true;
                    break;
                }
                buku = buku.next;
            }

            // apabila tidak ada kode yang ditemukan hingga last Node, maka flag = false
            // melakukan pengecekan node terakhir
            if (!flag) {
                if (buku.kodeBuku.equals(searchKode)) {
                    System.out.println(buku.toString());
                    System.out.println("Data buku berhasil ditemukan!");
                } else {
                    System.out.println("Buku tidak ditemukan.");
                }
            }
        }
        System.out.println();
    }

    public void display() {
        if (this.size == 0) {
            System.out.println("Tidak ada data untuk ditampilkan.");
        } else {
            NodeBuku buku = this.head;
            int count = 0;

            System.out.println("Daftar Buku:");
            while (buku.next != null) {
                System.out.println(buku.toString());
                buku = buku.next;
                count++;
            }
            count++;
            System.out.println(buku.toString());
            System.out.println("Total Buku: " + count);
        }
        System.out.println();
    }
}