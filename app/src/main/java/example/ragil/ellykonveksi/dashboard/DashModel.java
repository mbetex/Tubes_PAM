package example.ragil.ellykonveksi.dashboard;

public class DashModel {
    private String header;
    int image;

    public DashModel() {

    }

    public DashModel(String header, int image) {
        this.header = header;
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public int getImage() {
        return image;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
