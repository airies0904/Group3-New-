
public class NhanVien {
    
    // Đảm bảo thuộc tính là protected để lớp con có thể truy cập
    protected String maNhanVien;
    protected String hoTen;
    protected String phongBan;
    protected double luongCoBan;

    public NhanVien(String maNV, String hoTen, String phongBan, double luongCoBan) {
        this.maNhanVien = maNV;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
        this.luongCoBan = luongCoBan;
    }

    // Phương thức bắt buộc phải có để sửa lỗi getHoTen()
    public String gethoTen() {
        return this.hoTen;
    }

    // Phương thức tính lương (cần được override ở lớp con)
    public double tinhLuong() {
        // Sửa lỗi cú pháp, đảm bảo có return và dấu chấm phẩy
        return luongCoBan;
    }

    // Bạn cần thêm các getter và setter khác tại đây nếu cần
}