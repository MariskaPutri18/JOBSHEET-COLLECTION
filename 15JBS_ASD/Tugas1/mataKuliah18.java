package Tugas1;

public class mataKuliah18 {
    String kodeMk, namaMk;
    int sks;

    public mataKuliah18(String kodeMk, String namaMk, int sks) {
        this.kodeMk = kodeMk;
        this.namaMk = namaMk;
        this.sks = sks;
    }

    public String toString() {
        return String.format("%s\t%-40s%s", kodeMk, namaMk, sks);
    }
}
