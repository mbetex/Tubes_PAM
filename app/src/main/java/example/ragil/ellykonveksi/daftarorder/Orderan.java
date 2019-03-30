package example.ragil.ellykonveksi.daftarorder;

import android.os.Parcel;
import android.os.Parcelable;

public class Orderan implements Parcelable {
    private String nama,asalSekolah,kelas,tglNgukur,bayaran,noHP,keterangan;

    public Orderan() {

    }




    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTglNgukur() {
        return tglNgukur;
    }

    public void setTglNgukur(String tglNgukur) {
        this.tglNgukur = tglNgukur;
    }

    public String getBayaran() {
        return bayaran;
    }

    public void setBayaran(String bayaran) {
        this.bayaran = bayaran;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.asalSekolah);
        dest.writeString(this.kelas);
        dest.writeString(this.tglNgukur);
        dest.writeString(this.bayaran);
        dest.writeString(this.noHP);
        dest.writeString(this.keterangan);
    }

    protected Orderan(Parcel in) {
        this.nama = in.readString();
        this.asalSekolah = in.readString();
        this.kelas = in.readString();
        this.tglNgukur = in.readString();
        this.bayaran = in.readString();
        this.noHP = in.readString();
        this.keterangan = in.readString();
    }

    public static final Parcelable.Creator<Orderan> CREATOR = new Parcelable.Creator<Orderan>() {
        @Override
        public Orderan createFromParcel(Parcel source) {
            return new Orderan(source);
        }

        @Override
        public Orderan[] newArray(int size) {
            return new Orderan[size];
        }
    };
}
