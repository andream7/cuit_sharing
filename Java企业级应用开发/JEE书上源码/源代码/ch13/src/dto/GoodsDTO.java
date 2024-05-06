package dto;
public class GoodsDTO {
	private int id;
	private String gname;
	private double goprice;
	private double grprice;
	private int gstore;
	private String gpicture;//商品上传后的路径
	private int goodstype_id;//类型Id
	private String typename;//类型名称
	
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGoprice() {
		return goprice;
	}
	public void setGoprice(double goprice) {
		this.goprice = goprice;
	}
	public double getGrprice() {
		return grprice;
	}
	public void setGrprice(double grprice) {
		this.grprice = grprice;
	}
	public int getGstore() {
		return gstore;
	}
	public void setGstore(int gstore) {
		this.gstore = gstore;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodstype_id() {
		return goodstype_id;
	}
	public void setGoodstype_id(int goodstype_id) {
		this.goodstype_id = goodstype_id;
	}
}
