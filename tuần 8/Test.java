import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        // 1. Khai báo đối tượng quản lý theo kiểu Interface
        IQuanLySach quanLy = new QuanLySachImpl();
        Scanner scanner = new Scanner(System.in);

        // 2. Thực thi: Tạo và thêm các đối tượng Sách mẫu
        System.out.println("Dang khoi tao du lieu mau...");
        SachGiaoTrinh gt1 = new SachGiaoTrinh("SGT01", "Lap trinh Java 1", "Khang 1", 2021, 50, 120000, "A1", "CNTT", "Dai hoc");
        SachGiaoTrinh gt2 = new SachGiaoTrinh("SGT02", "Toan Cao Cap A1", "Binh 2", 2022, 100, 90000, "A2", "Toan hoc", "Dai hoc");
        SachGiaoTrinh gt3 = new SachGiaoTrinh("SGT03", "Lap trinh Java 2", "Khang 3", 2023, 50, 120000, "A1", "CNTT", "Dai hoc");
        SachGiaoTrinh gt4 = new SachGiaoTrinh("SGT04", "Toan Cao Cap A2", "Binh 4", 2024, 100, 90000, "A2", "Toan hoc", "Dai hoc");
        SachGiaoTrinh gt5 = new SachGiaoTrinh("SGT05", "Lap trinh Java 3", "Khang 5", 2025, 50, 120000, "A1", "CNTT", "Dai hoc");
        SachGiaoTrinh gt6 = new SachGiaoTrinh("SGT06", "Toan Cao Cap A3", "Binh 6", 2025, 100, 90000, "A2", "Toan hoc", "Dai hoc");

        SachTieuThuyet tt1 = new SachTieuThuyet("STT01", "Nha Gia Kim 1", "Paulo Coelho", 2015, 200, 75000, "B1", "Phieu luu", false);
        SachTieuThuyet tt2 = new SachTieuThuyet("STT02", "Harry Potter Tap 1", "J.K. Rowling", 2000, 150, 150000, "B2", "Fantasy", true);
        SachTieuThuyet tt3 = new SachTieuThuyet("STT03", "Nha Gia Kim 2", "Paulo Coelho", 2017, 200, 75000, "B1", "Phieu luu", false);
        SachTieuThuyet tt4 = new SachTieuThuyet("STT04", "Harry Potter Tap 2", "J.K. Rowling", 2005, 150, 150000, "B2", "Fantasy", true);        
        
        quanLy.themSach(gt1,gt2,gt3,gt4,gt5,gt6,tt1,tt2,tt3,tt4);
        System.out.println("Thu vien hien co " + quanLy.size() + " sach.");

        // 3. Tạo menu cho chương trình quản lí sách
        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU QUAN LY THU VIEN SACH ---");
            System.out.println("1. Hien thi toan bo danh sach sach");
            System.out.println("2. Them mot sach moi");
            System.out.println("3. Xoa sach (theo Ma sach)");
            System.out.println("4. Tim kiem sach (theo Tieu de)");
            System.out.println("5. Kiem tra ton kho (theo Ma sach)");
            System.out.println("6. Cap nhat vi tri (theo Ma sach)");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Vui long chon chuc nang: ");

            int luaChon = -1; // defensive programming
            try {
                // Đọc toàn bộ dòng và chuyển đổi sang số
                // scanner.nextLine(): một kỹ thuật lập trình tốt để tránh một lỗi phổ biến trong Java 
                // gọi là "trôi lệnh" (dangling newline).
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) { // Sự cố định dạng số
                System.out.println("Loi: Vui long nhap mot SO hop le.");
                continue; // Quay lại vòng lặp
            }

            switch (luaChon) {
                case 1:
                    System.out.println("\n[Chuc nang 1: Hien thi danh sach]");
                    quanLy.hienThiDanhSach();
                    break;
                case 2:
                    System.out.println("\n[Chuc nang 2: Them sach moi]");
                    themSachMoi(quanLy, scanner);
                    break;
                case 3:
                    System.out.println("\n[Chuc nang 3: Xoa sach]");
                    System.out.print("Nhap Ma sach can xoa: ");
                    String maXoa = scanner.nextLine();
                    if (quanLy.xoaSach(maXoa)) {
                        System.out.println("Da xoa sach thanh cong.");
                    } else {
                        System.out.println("Xoa that bai. Khong tim thay ma sach '" + maXoa + "'.");
                    }
                    break;
                case 4:
                    System.out.println("\n[Chuc nang 4: Tim kiem sach]");
                    System.out.print("Nhap Tieu de (hoac mot phan tieu de) can tim: ");
                    String tenTim = scanner.nextLine();
                    List<Sach> ketQua = quanLy.timKiemSach(tenTim);
                    
                    if (ketQua.isEmpty()) {
                        System.out.println("Khong tim thay sach nao khop voi '" + tenTim + "'.");
                    } else {
                        System.out.println("--- KET QUA TIM KIEM ---");
                        for (Sach s : ketQua) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n[Chuc nang 5: Kiem tra ton kho (IKiemKe)]");
                    kiemTraTonKho(quanLy, scanner);
                    break;
                case 6:
                    System.out.println("\n[Chuc nang 6: Cap nhat vi tri (IKiemKe)]");
                    capNhatViTri(quanLy, scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Da thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 0 den 6.");
            }
        }
        scanner.close();
    }

    /*
        - Luồng thực thi (execution flow) của chương trình.
        - Khi có lỗi xảy ra bên trong khối try, chương trình sẽ chạy như sau:

            Ngay tại thời điểm xảy ra lỗi, toàn bộ phần còn lại của khối try sẽ bị DỪNG LẠI và BỎ QUA.

            Thay vào đó, chương trình sẽ NHẢY xuống các khối catch bên dưới để tìm một "người xử lý" phù hợp.
     */
    /*
     * Phương thức trợ giúp để xử lý logic thêm sách mới (Chức năng 2)
     */
    private static void themSachMoi(IQuanLySach quanLy, Scanner scanner) {
        try {
            System.out.println("Chon loai sach muon them:");
            System.out.println("1. Sach Giao Trinh");
            System.out.println("2. Sach Tieu Thuyet");
            System.out.print("Lua chon cua ban (chon 1 hoac 2): ");
            
            String loaiSach = scanner.nextLine();
            String maSach;

            if (loaiSach.equals("1")) {
                System.out.print("Nhap Ma Sach Giao Trinh (vi du: SGTxx): ");
                maSach = scanner.nextLine();
            } else if (loaiSach.equals("2")) {
                System.out.print("Nhap Ma Sach Tieu Thuyet (vi du: STTxx): ");
                maSach = scanner.nextLine();
            } else {
                System.out.println("Lua chon khong hop le. Huy them sach.");
                return;
            }

            if (quanLy.timKiemtheomasach(maSach) != null) {
                 System.out.println("Loi: Ma sach '" + maSach + "' nay da ton tai. Huy them sach.");
                 return;
            }
            
            System.out.print("Nhap Tieu De: ");
            String tieuDe = scanner.nextLine();
            System.out.print("Nhap Tac Gia: ");
            String tacGia = scanner.nextLine();
            System.out.print("Nhap Nam Xuat Ban: ");
            int namXuatBan = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap So Luong: ");
            int soLuong = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap Gia Co Ban: ");
            double giaCoBan = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhap Vi Tri (vi du: A4, B3...): ");
            String viTri = scanner.nextLine();

            Sach sachMoi;
            
            if (loaiSach.equals("1")) {
                // Sach Giao Trinh
                System.out.print("Nhap Mon Hoc: ");
                String monHoc = scanner.nextLine();
                System.out.print("Nhap Cap Do (vi du: Dai hoc, Cap 3): ");
                String capDo = scanner.nextLine();
                
                sachMoi = new SachGiaoTrinh(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, viTri, monHoc, capDo);
                
            } else {
                // Sach Tieu Thuyet (loaiSach.equals("2"))
                System.out.print("Nhap The Loai (vi du: Gia tuong, Tinh cam): ");
                String theLoai = scanner.nextLine();
                System.out.print("Co phai sach Series (true/false): ");
                boolean laSachSeries = Boolean.parseBoolean(scanner.nextLine());

                sachMoi = new SachTieuThuyet(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, viTri, theLoai, laSachSeries);
            }
            
            if (quanLy.themSach(sachMoi)) {
                System.out.println("Them sach moi thanh cong!");
                System.out.println(sachMoi); // In ra thông tin sách vừa thêm
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Loi nhap lieu: Nam xuat ban, So luong, Gia co ban phai la SO.");
        } catch (Exception e) {
            System.out.println("Da co loi xay ra: " + e.getMessage());
        }
    }

    /*
     * Phương thức trợ giúp để xử lý logic kiểm tra tồn kho (Chức năng 5)
    */
    private static void kiemTraTonKho(IQuanLySach quanLy, Scanner scanner) {
        System.out.print("Nhap Ma sach de kiem tra ton kho: ");
        String maKiemTra = scanner.nextLine();
        
        Sach sachKiemTra = quanLy.timKiemtheomasach(maKiemTra); 
        
        if (sachKiemTra != null) {
            try {
                System.out.print("Nhap so luong ton kho toi thieu can kiem tra: ");
                int minSoLuong = Integer.parseInt(scanner.nextLine());
                
                // Goi phuong thuc tu interface IKiemKe (da duoc Sach implements)
                if (sachKiemTra.kiemTraTonKho(minSoLuong)) {
                    System.out.println("-> KET QUA: Sach '" + sachKiemTra.getTieuDe() + "' CON DU hang.");
                    System.out.println("(Ton kho: " + sachKiemTra.getSoLuong() + ", Yeu cau: " + minSoLuong + ")");
                } else {
                    System.out.println("-> KET QUA: Sach '" + sachKiemTra.getTieuDe() + "' KHONG DU hang.");
                    System.out.println("(Ton kho: " + sachKiemTra.getSoLuong() + ", Yeu cau: " + minSoLuong + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: So luong toi thieu phai la mot con so.");
            }
        } else {
            System.out.println("Loi: Khong tim thay sach voi ma '" + maKiemTra + "'.");
        }
    }

    /**
     * Phương thức trợ giúp để xử lý logic cập nhật vị trí (Chức năng 6)
     */
    private static void capNhatViTri(IQuanLySach quanLy, Scanner scanner) {
        System.out.print("Nhap Ma sach de cap nhat vi tri: ");
        String maCapNhat = scanner.nextLine();

        Sach sachCapNhat = quanLy.timKiemtheomasach(maCapNhat);
        if (sachCapNhat != null) {
            System.out.println("Vi tri hien tai cua sach '" + sachCapNhat.getTieuDe() + "' la: " + sachCapNhat.getviTri());
            System.out.print("Nhap vi tri moi (vi du: A3, B5...): ");
            String viTriMoi = scanner.nextLine();
            
            // Goi phuong thuc tu interface IKiemKe
            sachCapNhat.capNhatViTri(viTriMoi);
            // (Phương thức này đã tự in ra thông báo cập nhật)
            System.out.println("Vi tri da duoc cap nhat trong he thong.");

        } else {
            System.out.println("Loi: Khong tim thay sach voi ma '" + maCapNhat + "'.");
        }
    }
}