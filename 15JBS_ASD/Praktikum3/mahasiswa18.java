package Praktikum3;
public class mahasiswa18 {
    String nim;
    String nama;
    String notelp;

    public mahasiswa18() {

    }

    public mahasiswa18(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    public String toString() {
        return "mahasiswa{" + "nim= " + nim + ", nama= " + nama + ", notelp= " + notelp + '}';
    }
}