
public class NhanVienToanThoiGian extends NhanVien {
    private double thuong;
    private int soGioLamThem;
    public NhanVienToanThoiGian(String maNV, String hoTen, String phongBan, double luongCB,
                                double thuong, int soGioLamThem) {
        super(maNV, hoTen, phongBan, luongCB);
        this.thuong = thuong;
        this.soGioLamThem = soGioLamThem;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + thuong + soGioLamThem * 50000;
    }
}