package baitap7;

public abstract class Sach {
    protected String tieuDe;
    protected String tacGia;
    protected int namXuatBan;
    protected double giaCoBan;
    protected int soLuong;
    protected String viTriLuuTru;

    // Constructor
    public Sach(String tieuDe, String tacGia, int namXuatBan, double giaCoBan, int soLuong, String viTriLuuTru) {
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.giaCoBan = giaCoBan;
        this.soLuong = soLuong;
        this.viTriLuuTru = viTriLuuTru;
    }

    // Getter/Setter
    public String getTieuDe() { return tieuDe; }
    public double getGiaCoBan() { return giaCoBan; }
    public int getSoLuong() { return soLuong; }
    public void setViTriLuuTru(String viTriLuuTru) { this.viTriLuuTru = viTriLuuTru; }

    // Phương thức trừu tượng
    public abstract double tinhGiaBan();

    @Override
    public String toString() {
        return "Tiêu đề: " + tieuDe +
               ", Tác giả: " + tacGia +
               ", Năm XB: " + namXuatBan +
               ", Giá cơ bản: " + giaCoBan + " VNĐ";
    }
}
