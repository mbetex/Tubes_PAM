package example.ragil.ellykonveksi.daftarpegawai;

public class Karyawan {
    private String nama,no_hp;
    private int foto;

    public Karyawan() {
    }

    public Karyawan(String nama, String no_hp, int foto) {
        this.nama = nama;
        this.no_hp = no_hp;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
