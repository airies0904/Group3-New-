package baitaptuan8;

public class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;

    public SachTieuThuyet(String maSach, String tieuDe, String tacGia,
                          int namXuatBan, int soLuong, double giaCoBan,
                          String theLoai, boolean laSachSeries) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    @Override
    public double tinhGiaBan() {
        return getGiaCoBan() + (laSachSeries ? 15000 : 0);
    }

    @Override
    public String toString() {
        return "Sach Tieu Thuyet {" + super.toString() +
               ", The loai: " + theLoai +
               ", Series: " + (laSachSeries ? "Co" : "Khong") +
               ", Gia ban uoc tinh: " + tinhGiaBan() + " VND }";
    }
}
