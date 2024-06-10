package Praktikum3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListMahasiswa18 {

    List<mahasiswa18> mahasiswas = new ArrayList<>();
    
    public void tambah(mahasiswa18... Mahasiswa) {
        mahasiswas.addAll(Arrays.asList(Mahasiswa));
    }

    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    public void update(int index, mahasiswa18 mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampil(){
        mahasiswas.stream().forEach(mhs -> {
            System.out.println(""+ mhs.toString());
        });
    }

    int binarySearch(String nim){
        return Collections.binarySearch(mahasiswas, new mahasiswa18(nim, null, null), new Comparator<mahasiswa18>(){
            public int compare(mahasiswa18 o1, mahasiswa18 o2){
                return o1.nim.compareTo(o2.nim);
            }
        });
        }

    void ascSort() {
        Collections.sort(mahasiswas, new Comparator<mahasiswa18>() {
            @Override
            public int compare(mahasiswa18 o1, mahasiswa18 o2) {
                return o1.nim.compareTo(o2.nim);
            }
        });
    }

    void dscSort() {
        Collections.reverse(mahasiswas);
    }
    public static void main(String[] args) {
        ListMahasiswa18 lm = new ListMahasiswa18();
        mahasiswa18 m = new mahasiswa18("201234", "Noureen", "021xx1");
        mahasiswa18 m1 = new mahasiswa18("201235", "Akhleema", "021xx2");
        mahasiswa18 m2 = new mahasiswa18("201236", "Shannum", "021xx3");
        //menambahkan objek mahasiswa
        lm.tambah(m, m1, m2);
        //menampilkan list mahasiswa
        lm.tampil();
        //update mahasiswa
        lm.update(lm.binarySearch("201235"), new mahasiswa18("201235", "Akhleema Lela", "021xx2"));
        System.out.println("");
        lm.tampil();

        System.out.println("\n----------Data Diurut Secara Ascending Collections--------------");
        lm.ascSort();
        lm.tampil();

        // dsc
        System.out.println("\n----------Data Diurut secara Descending Collections------------");
        lm.dscSort();
        lm.tampil();
    }
}