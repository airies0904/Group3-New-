

public class Luong {
    private String maNhanVien;
    private double luongThucNhan;

    public Luong(String maNV, double luongThucNhan) {
        this.maNhanVien = maNV;
        this.luongThucNhan = luongThucNhan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public double getLuongThucNhan() {
        return luongThucNhan;
    }
}