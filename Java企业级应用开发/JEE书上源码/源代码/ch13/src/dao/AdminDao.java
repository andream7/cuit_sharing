package dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import dto.AdminDTO;
import dto.GoodsDTO;
import dto.NoticeDTO;
public class AdminDao extends BaseDao{
	/**
	 * @discription ����Ա��¼�ж�
	 */
	public boolean adminLogin(AdminDTO adt){
		String sql = "select * from AUSERTABLE where ANAME = ? and APWD = ?";
		Object param[] = {adt.getAname(), adt.getApwd()};
		List<Map<String, Object>> list = select(sql, param);
		if(list.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �������
	 */
	public boolean addType(String typename){
		String sql = "insert into goodstype values(null,?)";
		Object param[] = {typename};
		return upadateByParams(sql, param);
	}
	/**
	 * ��ù�������
	 */
	public List<Map<String, Object>> getReType(String id){
		String sql = "select * from GOODSTABLE where goodstype_id = ?";
		Object param[] = {id};
		return select(sql, param);
	}
	/**
	 * @discription ��ѯ������Ʒ
	 */
	public List<Map<String, Object>> selectGoods(){
		String sql = "select * from GOODSTABLE gt,GOODSTYPE gy where gt.goodstype_id = gy.id ";
		Object param[] = null;
		return select(sql, param);
	}
	/**
	 * @discription ��ҳ��ѯ��Ʒ
	 */
	public List<Map<String, Object>> selectAllGoodsByPage(int startIndex, int perPageSize){
		String sql = "select * from GOODSTABLE gt,GOODSTYPE gy where gt.goodstype_id = gy.id order by gt.id limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}
	/**
	 * @discription �����Ʒ�����б�
	 */
	public  List<Map<String, Object>> getGoodsType(){
		String sql = "select * from GOODSTYPE";
		Object param[] = null;
		return select(sql, param);
	}
	/**
	 * ɾ������
	 */
	public boolean deleteType(String id) {
		String sql = "delete  from GOODSTYPE where id = ? ";
		Object param[] = {id};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription �����Ʒ
	 */
	public boolean addGoods(GoodsDTO gd){
		String sql = "insert into GOODSTABLE values(null,?,?,?,?,?,?)";
		Object param[] = {
				gd.getGname(),
				gd.getGoprice(),
				gd.getGrprice(),
				gd.getGstore(),
				gd.getGpicture(),
				gd.getGoodstype_id()
			};
		return upadateByParams(sql, param);
	}
	/**
	 *  @discription ��ѯһ����Ʒ
	 */
	public List<Map<String, Object>> selectAGoods(String gno){
		String sql = "select * from GOODSTABLE gt,GOODSTYPE gy where gt.goodstype_id = gy.id and gt.id = ?";
		Object param[] = {gno};
		return select(sql, param);
	}
	/**
	 * @discription �޸���Ʒ
	 */
	public boolean updateGoods(GoodsDTO gd){
		String sql = "update GOODSTABLE set GNAME = ?, GOPRICE = ?, GRPRICE = ?, GSTORE = ?, GPICTURE = ?, goodstype_id = ? where id = ?";
		Object param[] = {
				gd.getGname(),
				gd.getGoprice(),
				gd.getGrprice(),
				gd.getGstore(),
				gd.getGpicture(),
				gd.getGoodstype_id(),
				gd.getId()
				};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription ɾ����Ʒ
	 */
	public boolean deleteAgoods(String gno){
		String sql = "delete  from GOODSTABLE where id = ? ";
		Object param[] = {gno};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription ������ѯ
	 */
	public List<Map<String, Object>> conditionSelectGoods(String gname, String typeid){
		StringBuffer sql = new StringBuffer("select * from GOODSTABLE gt,GOODSTYPE gy where gt.goodstype_id = gy.id and 1 = 1 ");
		ArrayList<String> param = new ArrayList<String>();
		//������Ʒ�������
		if(null != gname && gname.trim().length() > 0){
			sql.append(" and GNAME like ? ");
			param.add("%" + gname + "%");
		}
		//ѡ����Ʒ���͵����
		if(!"all".equals(typeid)){
			sql.append(" and gt.goodstype_id = ? ");
			param.add(typeid);
		}
		return select(sql.toString(), param.toArray());
	}
	/**
	 * @discription ��ҳ������ѯ
	 */
	public List<Map<String, Object>> conditionSelectGoodsByPage(String gname, String typeid, int startIndex, int perPageSize){
		StringBuffer sql = new StringBuffer("select * from GOODSTABLE gt,GOODSTYPE gy where gt.goodstype_id = gy.id and 1 = 1 ");
		ArrayList<Object> param = new ArrayList<Object>();
		//������Ʒ�������
		if(null != gname && gname.trim().length() > 0){
			sql.append(" and GNAME like ? ");
			param.add("%" + gname + "%");
		}
		//ѡ����Ʒ���͵����
		if(!"all".equals(typeid)){
			sql.append(" and gt.goodstype_id = ? ");
			param.add(typeid);
		}
		param.add(startIndex);
		param.add(perPageSize);
		sql.append(" limit ?, ? "); 
		return select(sql.toString(), param.toArray());
	}
	/**
	 * @discription ��ѯ����
	 */
	public  List<Map<String, Object>> selectNotice(){
		String sql = "select id, NTITLE, NCONTENT,  NTIME from NOTICETABLE";
		return select(sql, null);
	}
	/**
	 * @discription ��ӹ���
	 */
	public boolean addNotice(NoticeDTO nd){
		String sql = "insert into NOTICETABLE values(null,?,?,SYSDATE)";
		Object param[] = {
				nd.getNtitle(),
				nd.getNcontent()
		};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription ��ѯһ������ 
	 */
	public  List<Map<String, Object>> selectAnotice(String nid){
		String sql = "select ID, NTITLE, NCONTENT, NTIME from NOTICETABLE where ID = ?";
		Object param[] = {nid};
		return select(sql, param);
	}
	/**
	 * @discription ɾ��һ������ 
	 */
	public boolean deleteAnotice(String nid){
		String sql = "delete from NOTICETABLE where ID = ?";
		Object param[] = {nid};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription ɾ����Ʒʱ���ж����޹���
	 */
	public  boolean isDelete(String gno){
		String sql1 = "select * from CARTTABLE where goodstable_id=?";
		String sql2 = "select * from FOCUSTABLE where goodstable_id=?";
		String sql3 = "select * from ORDERDETAIL where goodstable_id=?";
		Object param[] = {gno};
		//���Ӽ�¼
		if(select(sql1, param).size() > 0 ||
				select(sql2, param).size() > 0 ||
				select(sql3, param).size() > 0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 *  @discription ��ѯ�û�
	 */
	public List<Map<String, Object>> selectUsers(){
		String sql = "select * from BUSERTABLE ";
		return select(sql, null);
	}
	/**
	 * @discription ɾ���û�ʱ���ж����޹���
	 */
	public  boolean isDeleteUser(String bid){
		String sql1 = "select * from CARTTABLE where busertable_id=?";
		String sql2 = "select * from FOCUSTABLE where busertable_id=?";
		String sql3 = "select * from ORDERBASETABLE where busertable_id=?";
		Object param[] = {bid};
		//���Ӽ�¼
		if(select(sql1, param).size() > 0 ||
				select(sql2, param).size() > 0 ||
				select(sql3, param).size() > 0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * @discription ɾ���û�
	 */
	public boolean deleteUser(String bid){
		String sql = "delete from BUSERTABLE where BID=?";
		Object param[] = {bid};
		return upadateByParams(sql, param);
	}
	/**
	 *  @discription ��ѯ�û�
	 */
	public List<Map<String, Object>> selectOrders(){
		String sql = "select ot.id, ot.AMOUNT, ot.STATUS, "
				+ "  ORDERDATE, bt.BEMAIL, ot.busertable_id "
				+ " from ORDERBASETABLE ot, BUSERTABLE bt where ot.busertable_id=bt.id ";
		return select(sql, null);
	}
	/**
	 *  @discription ɾ��������ϸ
	 */
	public boolean deleteOrderdetail(String ordersn){
		String sql = "delete from ORDERDETAIL where orderbasetable_id=?";
		Object param[] = {ordersn};
		return upadateByParams(sql, param);
	}
	/**
	 *  @discription ɾ������
	 */
	public boolean deleteOrderbasetable(String ordersn){
		String sql = "delete from ORDERBASETABLE where id=?";
		Object param[] = {ordersn};
		return upadateByParams(sql, param);
	}
}
