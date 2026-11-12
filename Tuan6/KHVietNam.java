package Tuan6;
import java.time.LocalDate;
public class KHVietNam extends KhachHang{
	private String doiTuong;
	private double dinhMuc;
	public KHVietNam(String maKH, String hoTen, LocalDate ngayLapHD, double soKW, double donGia, String doiTuong,
			double dinhMuc) {
		super(maKH, hoTen, ngayLapHD, soKW, donGia);
		this.doiTuong = doiTuong;
		this.dinhMuc = dinhMuc;
	}
	public String getDoiTuong() { return doiTuong;}
	@Override
	public double thanhTien() {
		return soKW <= dinhMuc ? soKW*donGia : dinhMuc*donGia+(soKW-dinhMuc)*donGia*2.5;
	}
	
}