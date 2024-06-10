package Tugas1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class nilaiMain18 {
    String kodeNil;
    double nilai;
    Mahasiswa18 mhs;
    mataKuliah18 mk;

    public nilaiMain18(String kodeNil, double nilai, Mahasiswa18 mhs, mataKuliah18 mk) {
        this.kodeNil = kodeNil;
        this.nilai = nilai;
        this.mhs = mhs;
        this.mk = mk;
    }

    List<Mahasiswa18> mhsA = new ArrayList<>();
    List<mataKuliah18> matkulA = new ArrayList<>();

    public void tambahMhs(Mahasiswa18... mahasiswa) {
        mhsA.addAll(Arrays.asList(mahasiswa));
    }

    public void tambahMatkul(mataKuliah18... matkul) {
        matkulA.addAll(Arrays.asList(matkul));
    }

    public void tampilMhs() {
        mhsA.forEach(mhs -> System.out.println(mhs));
    }

    public void tampilMatkul() {
        matkulA.forEach(mk -> System.out.println(mk));
    }

    int linearSearchMhs(String nim) {
        for (int i = 0; i < mhsA.size(); i++) {
            if (nim.equals(mhsA.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    int linearSearchMatkul(String matkul) {
        for (int i = 0; i < matkulA.size(); i++) {
            if (matkul.equals(matkulA.get(i).kodeMk)) {
                return i;
            }
        }
        return -1;
    }

    Mahasiswa18 cariMhs(String nim) {
        for (Mahasiswa18 mhs : mhsA) {
            if (nim.equals(mhs.nim)) {
                return mhs;
            }
        }
        return null;
    }

    mataKuliah18 cariMatkul(String matkul) {
        for (mataKuliah18 mk : matkulA) {
            if (matkul.equals(mk.kodeMk)) {
                return mk;
            }
        }
        return null;
    }

    public String toString(int idx1, int idx2) {
        Mahasiswa18 mhs = mhsA.get(idx1);
        mataKuliah18 mk = matkulA.get(idx2);
        return mhs.nim + "\t" + mhs.nama + "\t" + mk.namaMk + "\t" + mk.sks + "\t";
    }

    static Comparator<nilaiMain18> CompNilai = (n1, n2) -> Double.compare(n1.nilai, n2.nilai);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
        Scanner sb = new Scanner(System.in);

        List<nilaiMain18> nill = new ArrayList<>();
        nilaiMain18 n = new nilaiMain18("", 0, null, null);

        Mahasiswa18 m1 = new Mahasiswa18("20001", "Thalhah", "021xxx");
        Mahasiswa18 m2 = new Mahasiswa18("20002", "zubair", "021xxx");
        Mahasiswa18 m3 = new Mahasiswa18("20003", "Abdur-Rahman", "021xxx");
        Mahasiswa18 m4 = new Mahasiswa18("20004", "sa'ad", "021xxx");
        Mahasiswa18 m5 = new Mahasiswa18("20005", "Sa'id", "021xxx");
        Mahasiswa18 m6 = new Mahasiswa18("20006", "Ubaidah", "021xxx");

        n.tambahMhs(m1, m2, m3, m4, m5, m6);

        mataKuliah18 mk1 = new mataKuliah18("0001", "Internet of Things", 3);
        mataKuliah18 mk2 = new mataKuliah18("0002", "Algoritma dan Struktur Data", 2);
        mataKuliah18 mk3 = new mataKuliah18("0003", "Algoritma dan Pemrograman", 2);
        mataKuliah18 mk4 = new mataKuliah18("0004", "Praktikum Algoritma dan Struktur Data", 3);
        mataKuliah18 mk5 = new mataKuliah18("0005", "Algoritma dan Struktur Data", 3);

        n.tambahMatkul(mk1, mk2, mk3, mk4, mk5);

        nilaiMain18 n1 = null;
        String nimMhs, mkMhs;

        int menu = 0;
        do {
            System.out.println("+===================================================+");
            System.out.println("+ Sistem Pengelolahan Data Nilai Mahasiswa Semester +");
            System.out.println("+===================================================+");
            System.out.println(" 1. Input Nilai");
            System.out.println(" 2. Tampil Nilai");
            System.out.println(" 3. Mencari Nilai Mahasiswa");
            System.out.println(" 4. Urut Data Nilai");
            System.out.println(" 5. Keluar");
            System.out.println("+==================================================+");
            System.out.print("Pilih\t\t\t\t: ");
            menu = sd.nextInt();
            System.out.println("");

            switch (menu) {
                case 1:
                    System.out.print("Kode\t\t\t\t: ");
                    String kd = sc.nextLine();
                    System.out.print("Nilai\t\t\t\t: ");
                    double nilMhs = sb.nextDouble();
                    System.out.println("");

                    System.out.println("                    Daftar Mahasiswa               ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\t\tNo Telp");
                    n.tampilMhs();
                    System.out.println("---------------------------------------------------");
                    System.out.print("Pilih Mahasiswa by nim\t\t: ");
                    nimMhs = sc.nextLine();
                    Mahasiswa18 mahaSiswas = n.cariMhs(nimMhs);

                    System.out.println("");
                    System.out.println("                    Daftar Mata Kuliah              ");
                    System.out.println("====================================================");
                    System.out.println("Kode\tMata Kuliah\t\t\t\tSKS");
                    n.tampilMatkul();
                    System.out.println("---------------------------------------------------");
                    System.out.print("Pilih Mata Kuliah by Kode\t:");
                    mkMhs = sc.nextLine();
                    mataKuliah18 mataKuliahs = n.cariMatkul(mkMhs);

                    if (mahaSiswas != null && mataKuliahs != null) {
                        n1 = new nilaiMain18(kd, nilMhs, mahaSiswas, mataKuliahs);
                        nill.add(n1);
                    } else {
                        System.out.println("Mahasiswa atau Mata Kuliah tidak ditemukan!");
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("                  Daftar Nilai Mahasiswa           ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    for (nilaiMain18 nm : nill) {
                        if (nm.mhs != null && nm.mk != null) {
                            System.out.println(n.toString(n.linearSearchMhs(nm.mhs.nim),
                                    n.linearSearchMatkul(nm.mk.kodeMk)) + nm.nilai);
                        }
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("                  Daftar Nilai Mahasiswa           ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    int sks = 0;
                    for (nilaiMain18 nm : nill) {
                        if (nm.mhs != null && nm.mk != null) {
                            System.out.println(n.toString(n.linearSearchMhs(nm.mhs.nim),
                                    n.linearSearchMatkul(nm.mk.kodeMk)) + nm.nilai);
                        }
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.print("Masukkan Data Mahasiswa NIM\t\t: ");
                    String input = sc.nextLine();
                    System.out.println("");
                    for (nilaiMain18 nm : nill) {
                        if (nm.mhs != null && nm.mk != null && input.equalsIgnoreCase(nm.mhs.nim)) {
                            sks += nm.mk.sks;
                            System.out.println(n.toString(n.linearSearchMhs(nm.mhs.nim),
                                    n.linearSearchMatkul(nm.mk.kodeMk)) + nm.nilai);
                        }
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.println("Total SKS " + sks + " Telah Diambil");
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("                  Daftar Mahasiswa                 ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    nill.sort(CompNilai);
                    for (nilaiMain18 nm : nill) {
                        if (nm.mhs != null && nm.mk != null) {
                            System.out.println(n.toString(n.linearSearchMhs(nm.mhs.nim),
                                    n.linearSearchMatkul(nm.mk.kodeMk)) + nm.nilai);
                        }
                    }
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("+==================================================+");
                    System.out.println("+                    Terima Kasih                  +");
                    System.out.println("+==================================================+");
                    break;
            }
        } while (menu < 5 && menu > 0);
    }
}
