package service;
import java.util.List;
import java.util.Map;
import dao.BeforeUserDao;
import dto.UserDTO;
public class BeforeUserService {
	BeforeUserDao bd = new BeforeUserDao();
	/**
	 * @discription ���������Ʒ�б�
	 */
	public List<Map<String, Object>>  getLastedGoods(String typeid){
		return bd.getLastedGoods(typeid);
	}
	/**
	 * @discription �������������Ʒ
	 */
	public List<Map<String, Object>> getSaleOrder(){
		return bd.getSaleOrder();
	}
	/**
	 * @discription �������������Ʒ
	 */
	public List<Map<String, Object>> getFocusOrder(){
		return bd.getFocusOrder();
	}
	/**
	 * @discription ��ù���
	 */
	public List<Map<String, Object>> getNotice(){
		return bd.getNotice();
	}
	/**
	 * @discription ע��
	 */
	public boolean register(UserDTO ud){
		return bd.register(ud);
	}
	/**
	 * ��ѯEmail
	 */
	public List<Map<String, Object>> isExit(UserDTO ud){
		return bd.isExit(ud);
	}
	/**
	 * @discription ��¼�ж�
	 */
	public List<Map<String, Object>> isLogin(UserDTO ud){
		return bd.isLogin(ud);
	}
	/**
	 * @discription ��ע��Ʒ
	 */
	public String focusGoods(String gno, int bid){
		//�ѹ�ע
		if(bd.isFocus(gno, bid).size() > 0){
			return "focused";
		}else{//δ��ע
			if(bd.focusGoods(gno, bid)){
				return "focusSuccess";
			}else{
				return "focusFail";
			}
		}
	}
	/**
	 *  @discription ���빺�ﳵ
	 */
	public boolean putCart(String gno, int bid, String mknum){
		return bd.putCart(gno, bid, mknum);
	}
	/**
	 * @discription ��ѯ���ﳵ
	 */
	public List<Map<String, Object>> selectCart(int bid){
		return bd.selectCart(bid);
	}
	/**
	 * �޸Ĺ��ﳵ
	 */
	public boolean updateCart(String shoppingnum,String gno, int bid) {
		return bd.updateCart(shoppingnum, gno, bid);
	}
	/**
	 * @discription ɾ�����ﳵ
	 */
	public boolean deleteCart(int bid, String gno){
		return bd.deleteCart(bid, gno);
	}
	/**
	 * @discription �ύ����
	 */
	public int orderSubmit(int bid, String amount){
		//������������¼
		int id = bd.addOrder(bid, amount);
		//�������������붩������
		bd.addOrderDetail(id, bid);
		//��չ��ﳵ
		bd.deleteCart(bid, null);
		//������Ʒ���
		bd.updateGoodsStore(id);
		return id;
	}
	/**
	 * @discription ����֧��
	 */
	public boolean pay(String ordersn){
		return bd.pay(ordersn);
	}
	/**
	 * @discription ͷ��������
	 */
	public List<Map<String, Object>> search(String keyword){
		return bd.search(keyword);
	}
	/**
	 * @discription �ҵĶ���
	 */
	public List<Map<String, Object>> myOrder(int bid){
		return bd.myOrder(bid);
	}
	/**
	 * @discription �ҵĹ�ע
	 */
	public List<Map<String, Object>> myFocus(int bid){
		return bd.myFocus(bid);
	}
	/**
	 * @discription �ҵĶ�������
	 */
	public List<Map<String, Object>> myOrderDetail(String ordersn){
		return bd.myOrderDetail(ordersn);
	}
}
