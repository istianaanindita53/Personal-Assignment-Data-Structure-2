public class NodeBuku {
    String kodeBuku;
    String judul;
    String penulis;
    NodeBuku next;

    public NodeBuku(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return "Kode: "+kodeBuku+" | " + "Judul: "+judul+" | " + "Penulis: "+penulis;
    }
}
