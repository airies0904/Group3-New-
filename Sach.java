package thtuan6;
public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private double giaBan;

    // Hàm tạo đầy đủ tham số
    public Sach(String maSach, String tenSach, String tacGia, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.giaBan = giaBan;
    }

    // Getter và Setter
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Mã sách: " + maSach +
               ", Tên sách: " + tenSach +
               ", Tác giả: " + tacGia +
               ", Giá bán: " + giaBan;
    }
}
