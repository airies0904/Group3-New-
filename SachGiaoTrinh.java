package baitap7;

public class SachGiaoTrinh extends Sach implements IKiemKe {

    public SachGiaoTrinh(String tieuDe, String tacGia, int namXuatBan, double giaCoBan, int soLuong, String viTriLuuTru) {
        super(tieuDe, tacGia, namXuatBan, giaCoBan, soLuong, viTriLuuTru);
    }

    @Override
    public double tinhGiaBan() {
        int soNam = 2025 - namXuatBan;
        return giaCoBan + soNam * 5000;
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
        return super.toString() + ", Giá bán: " + tinhGiaBan() + " VNĐ";
    }
}
