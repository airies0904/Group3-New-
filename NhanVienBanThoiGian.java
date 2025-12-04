

public class NhanVienBanThoiGian extends NhanVien {
    private double luongMoiGio;
    private int soGioLam;

    public NhanVienBanThoiGian(String maNV, String hoTen, String phongBan,
                               double luongMoiGio, int soGioLam) {
        super(maNV, hoTen, phongBan, 0);
        this.luongMoiGio = luongMoiGio;
        this.soGioLam = soGioLam;
    }

    @Override
    public double tinhLuong() {
        return luongMoiGio * soGioLam;
    }
}