package Tuan6;
import java.time.LocalDate;

public class KHnuocngoai extends KhachHang {
	private String quocTich;
	public KHnuocngoai(String maKH, String hoTen, LocalDate ngayLapHD, double soKW, double donGia, String quocTich) {
		super(maKH, hoTen, ngayLapHD, soKW, donGia);
		this.quocTich = quocTich;
	}
	public String GetQuocTich() { return quocTich;}
	@Override
	public double thanhTien() {return soKW*donGia;}
}