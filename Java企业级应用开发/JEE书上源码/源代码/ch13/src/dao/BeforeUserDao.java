package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dto.UserDTO;
public class BeforeUserDao  extends BaseDao{
	/**
	 * @discription ���������Ʒ�б�
	 */
	public List<Map<String, Object>>  getLastedGoods(String typeid){
		//��ҳ
		if("0".equals(typeid)){
			String sql = "select * from GOODSTABLE gt,GOODSTYPE gy where gt.goodstype_id = gy.id  order by  gt.id desc limit 15";
			return select(sql, null);
		}else{
			String  sql = "select * from GOODSTABLE gt,GOODSTYPE gy where gt.goodstype_id = gy.id and gt.goodstype_id = ?  order by  gt.id desc  limit 15";
			Object param[] = {typeid};
			return select(sql, param);
		}
	}
	/**
	 * @discription �������������Ʒ
	 */
	public List<Map<String, Object>> getSaleOrder(){
		String sql = "select sum(od.SHOPPINGNUM) shopnumber," +
				" gd.id id, " + 
				" gd.GNAME gname, " + 
				" gd.GOPRICE goprice,  " + 
				" gd.GRPRICE grprice, " + 
				" gd.GPICTURE  gpicture " + 
				" from GOODSTABLE gd   LEFT JOIN ORDERDETAIL  od  ON od.goodstable_id=gd.id" + 
				"  group by  " + 
				"  gd.id, " + 
				"  gd.GNAME, " + 
				"  gd.GOPRICE, " + 
				"  gd.GRPRICE, " + 
				"  gd.GPICTURE " + 
				" order by shopnumber desc limit 10 ";
		return select(sql, null);
	}
	/**
	 * @discription �������������Ʒ
	 */
	public List<Map<String, Object>> getFocusOrder(){
		String sql = " select count(ft.goodstable_id) fn, gt.id id, gt.gname gname, " +
				"  gt.grprice grprice, gt.gpicture gpicture  " +
				"  from GOODSTABLE gt  " +
				"  LEFT JOIN FOCUSTABLE ft  ON ft.goodstable_id=gt.id   " +
				"  group by gt.id, gt.gname, gt.grprice, gt.gpicture " +
				"  order by fn desc limit 10 " ;
		return select(sql, null);
	}
	/**
	 * @discription ��ù���
	 */
	public List<Map<String, Object>> getNotice(){
		String sql = " select * from noticetable order by ntime desc limit 13 ";
		return select(sql, null);
	}
	/**
	 * @discription ע��
	 */
	public boolean register(UserDTO ud){
		String sql = "insert into BUSERTABLE values(null,?,?) ";
		Object param[] = {ud.getBemail(), ud.getBpwd()};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription ��ѯEmail
	 */
	public List<Map<String, Object>> isExit(UserDTO ud){
		String sql = "select * from BUSERTABLE where BEMAIL = ? ";
		Object param[] = {ud.getBemail()};
		return select(sql, param);
	}
	/**
	 * @discription ��¼�ж�
	 */
	public List<Map<String, Object>> isLogin(UserDTO ud){
		String sql = "select * from BUSERTABLE where BEMAIL = ? and BPWD = ? ";
		Object param[] = {ud.getBemail(), ud.getBpwd()};
		return select(sql, param);
	} 
	/**
	 * @discription ��ע��Ʒ
	 */
	public boolean focusGoods(String gno, int bid){
		String sql = "insert into FOCUSTABLE values(null,?,?,now())";
		Object param[] = {gno, bid};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription �鿴�Ƿ��ѹ�ע
	 */
	public List<Map<String, Object>> isFocus(String gno, int bid){
		String sql = "select * from FOCUSTABLE where goodstable_id = ? and busertable_id = ? ";
		Object param[] = {gno, bid};
		return select(sql, param);
	}
	/**
	 *  @discription ���빺�ﳵ
	 */
	public boolean putCart(String gno, int bid, String mknum){
		String sql1 = "select * from carttable where busertable_id=? and goodstable_id=? ";
		Object param1[] = {bid, gno};
		String sql2 = "update carttable set shoppingnum=shoppingnum+? where  busertable_id=? and goodstable_id=?";
		Object param2[] = {mknum, bid, gno};
		String sql3 = "insert into carttable values(null,?,?,?)";
		Object param3[] = {bid, gno, mknum};
		//���ﳵ���Ѵ���
		if(select(sql1, param1).size() > 0){
			return upadateByParams(sql2, param2);
		}else{//���ﳵ�в�����
			return upadateByParams(sql3, param3);
		}
	}
	/**
	 * �޸Ĺ��ﳵ
	 */
	public boolean updateCart(String shoppingnum,String gno, int bid){
		String sql2 = "update carttable set shoppingnum=? where  busertable_id=? and goodstable_id=?";
		Object param2[] = {shoppingnum, bid, gno};
		return upadateByParams(sql2, param2);
	}
	/**
	 * @discription ��ѯ���ﳵ
	 */
	public List<Map<String, Object>> selectCart(int bid){
		String sql = " select gt.id, gt.gname, gt.gpicture, gt.grprice, ct.shoppingnum, ct.shoppingnum*gt.grprice smallsum " +
				" from GOODSTABLE gt, CARTTABLE ct where gt.id=ct.goodstable_id and ct.busertable_id=? ";
		Object param[] = {bid};
		return select(sql, param);
	}
	/**
	 * @discription ɾ�����ﳵ
	 */
	public boolean deleteCart(int bid, String gno){
		String sql1 = "delete from CARTTABLE where busertable_id=?";
		Object param1[] = {bid};
		String sql2 = "delete from CARTTABLE where busertable_id=? and goodstable_id=?";
		Object param2[] = {bid, gno};
		if(gno == null){
			//��չ��ﳵ
			return upadateByParams(sql1, param1);
		}else{
			//ɾ��һ����Ʒ
			return upadateByParams(sql2, param2);
		}
	}
	/**
	 * @discription ������������¼
	 */
	public int addOrder(int bid, String amount){
		String sql = "insert into ORDERBASETABLE values(null,?,?,?,now())";
		Object param[] = {bid, amount, "0"};//0����û��֧��
		String sql1 = " select LAST_INSERT_ID() from ORDERBASETABLE ";
		return getLastId(sql, sql1, param);
	}
	/**
	 * @discription ����������������¼
	 */
	public boolean addOrderDetail(int ordersn,int bid){
		String sql = "insert into ORDERDETAIL (orderbasetable_id, goodstable_id, SHOPPINGNUM) select " + ordersn + ", goodstable_id, SHOPPINGNUM from CARTTABLE where busertable_id = ?  ";
		Object param[] = {bid};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription ������Ʒ���
	 */
	public boolean updateGoodsStore(int ordersn){
		boolean b=false;
		Connection con = getConnection();
		PreparedStatement ps=null;
		Connection con1=getConnection();
		PreparedStatement ps1=null;
		ResultSet rs=null;
		try {
			ps1=con1.prepareStatement("select shoppingnum, goodstable_id from orderdetail where orderbasetable_id=?");
			ps1.setInt(1, ordersn);
			rs=ps1.executeQuery();
			ps=con.prepareStatement("update GOODSTABLE set GSTORE=GSTORE-? where id=? ");
			//��������
			while(rs.next()){
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, rs.getString(2));
				ps.addBatch();
			}
			int n[]=ps.executeBatch();
			if(n[0]>0)
				b=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs,ps1,con1);
			close(null,ps,con);
		}
		return b;
	}
	/**
	 * @discription ����֧��
	 */
	public boolean pay(String ordersn){
		String sql = "update ORDERBASETABLE set STATUS=1 where id = ?";
		Object param[] = {ordersn};
		return upadateByParams(sql, param);
	}
	/**
	 * @discription ͷ��������
	 */
	public List<Map<String, Object>> search(String keyword){
		String sql = "select * from GOODSTABLE where GNAME like ? ";
		Object param[] = {"%" + keyword + "%"};
		return select(sql, param);
	}
	/**
	 * @discription �ҵĶ���
	 */
	public List<Map<String, Object>> myOrder(int bid){
		String sql = " select id, amount, busertable_id, status, orderdate  from ORDERBASETABLE where busertable_id = ? ";
		Object param[] = {bid};
		return select(sql, param);
	}
	/**
	 * @discription �ҵĹ�ע
	 */
	public List<Map<String, Object>> myFocus(int bid){
		String sql = " select gt.id, gt.gname, gt.goprice, gt.grprice, gt.gpicture from FOCUSTABLE ft, GOODSTABLE gt " +
				" where ft.goodstable_id=gt.id and  ft.busertable_id = ? ";
		Object param[] = {bid};
		return select(sql, param);
	}
	/**
	 * @discription �ҵĶ�������
	 */
	public List<Map<String, Object>> myOrderDetail(String ordersn){
		String sql =" select gt.id, gt.gname, gt.goprice, gt.grprice, gt.gpicture, odt.shoppingnum from  GOODSTABLE gt, ORDERDETAIL odt " +
				" where  odt.orderbasetable_id = ? and gt.id=odt.goodstable_id ";
		Object param[] = {ordersn};
		return select(sql, param);
	}
}
