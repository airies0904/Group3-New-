package baitaptuan8;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        IQuanLySach quanLy = new QuanLySachImpl();
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("===== MENU QUAN LY SACH =====");
            System.out.println("1. Them sach");
            System.out.println("2. Tim sach theo ma");
            System.out.println("3. Xoa sach theo ma");
            System.out.println("4. Hien thi danh sach");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Chon loai (1=GiaoTrinh, 2=TieuThuyet): ");
                    int loai = Integer.parseInt(sc.nextLine());
                    System.out.print("Ma sach: ");
                    String ma = sc.nextLine();
                    System.out.print("Tieu de: ");
                    String td = sc.nextLine();
                    System.out.print("Tac gia: ");
                    String tg = sc.nextLine();
                    System.out.print("Nam XB: ");
                    int nam = Integer.parseInt(sc.nextLine());
                    System.out.print("So luong: ");
                    int sl = Integer.parseInt(sc.nextLine());
                    System.out.print("Gia co ban: ");
                    double gia = Double.parseDouble(sc.nextLine());

                    if (loai == 1) {
                        System.out.print("Mon hoc: ");
                        String mh = sc.nextLine();
                        System.out.print("Cap do: ");
                        String cd = sc.nextLine();
                        quanLy.themSach(new SachGiaoTrinh(ma, td, tg, nam, sl, gia, mh, cd));
                    } else {
                        System.out.print("The loai: ");
                        String tl = sc.nextLine();
                        System.out.print("La series (true/false): ");
                        boolean series = Boolean.parseBoolean(sc.nextLine());
                        quanLy.themSach(new SachTieuThuyet(ma, td, tg, nam, sl, gia, tl, series));
                    }
                    break;

                case 2:
                    System.out.print("Nhap ma sach: ");
                    Sach s = quanLy.timKiemSachTheoMa(sc.nextLine());
                    System.out.println(s != null ? s : "Khong tim thay sach");
                    break;

                case 3:
                    System.out.print("Nhap ma sach can xoa: ");
                    quanLy.xoaSachTheoMa(sc.nextLine());
                    break;

                case 4:
                    quanLy.hienThiDanhSach();
                    break;

                case 5:
                    System.out.println("Tam biet!");
            }
        } while (chon != 5);

        sc.close();
    }
}

