package baitap7;

public class SachTieuThuyet extends Sach implements IKiemKe {
    private boolean laSachSeries;

    public SachTieuThuyet(String tieuDe, String tacGia, int namXuatBan, double giaCoBan, int soLuong, String viTriLuuTru, boolean laSachSeries) {
        super(tieuDe, tacGia, namXuatBan, giaCoBan, soLuong, viTriLuuTru);
        this.laSachSeries = laSachSeries;
    }

    @Override
    public double tinhGiaBan() {
        return giaCoBan + (laSachSeries ? 15000 : 0);
    }

    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return soLuong >= soLuongToiThieu;
    }

    @Override
    public void capNhatViTri(String viTriMoi) {
        setViTriLuuTru(viTriMoi);
        System.out.println("Đã chuyển sách '" + tieuDe + "' đến khu vực: " + viTriMoi);
    }

    @Override
    public String toString() {
        return super.toString() + ", Là series: " + laSachSeries + ", Giá bán: " + tinhGiaBan() + " VNĐ";
    }
}
