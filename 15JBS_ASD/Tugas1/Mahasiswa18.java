package Tugas1;

public class Mahasiswa18 {
   String nim, nama, noTelp;

    public Mahasiswa18() {

    }
    public Mahasiswa18(String nim, String nama, String noTelp) {
        this.nim = nim;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public String toString() {
        return String.format("%s\t%-15s\t%s", nim, nama, noTelp);
    }
}


