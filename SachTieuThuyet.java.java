package thtuan6;

public class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;

    // Hàm tạo đầy đủ tham số (bao gồm cả thuộc tính lớp cha)
    public SachTieuThuyet(String maSach, String tenSach, String tacGia, double giaBan,
                          String theLoai, boolean laSachSeries) {
        super(maSach, tenSach, tacGia, giaBan); // gọi constructor của lớp cha
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Thể loại: " + theLoai +
               ", Là series: " + (laSachSeries ? "Có" : "Không");
    }
}
