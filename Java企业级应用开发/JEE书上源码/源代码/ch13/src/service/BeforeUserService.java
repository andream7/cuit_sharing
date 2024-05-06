package service;
import java.util.List;
import java.util.Map;
import dao.BeforeUserDao;
import dto.UserDTO;
public class BeforeUserService {
	BeforeUserDao bd = new BeforeUserDao();
	/**
	 * @discription 获得最新商品列表
	 */
	public List<Map<String, Object>>  getLastedGoods(String typeid){
		return bd.getLastedGoods(typeid);
	}
	/**
	 * @discription 获得销售排行商品
	 */
	public List<Map<String, Object>> getSaleOrder(){
		return bd.getSaleOrder();
	}
	/**
	 * @discription 获得人气排行商品
	 */
	public List<Map<String, Object>> getFocusOrder(){
		return bd.getFocusOrder();
	}
	/**
	 * @discription 获得公告
	 */
	public List<Map<String, Object>> getNotice(){
		return bd.getNotice();
	}
	/**
	 * @discription 注册
	 */
	public boolean register(UserDTO ud){
		return bd.register(ud);
	}
	/**
	 * 查询Email
	 */
	public List<Map<String, Object>> isExit(UserDTO ud){
		return bd.isExit(ud);
	}
	/**
	 * @discription 登录判定
	 */
	public List<Map<String, Object>> isLogin(UserDTO ud){
		return bd.isLogin(ud);
	}
	/**
	 * @discription 关注商品
	 */
	public String focusGoods(String gno, int bid){
		//已关注
		if(bd.isFocus(gno, bid).size() > 0){
			return "focused";
		}else{//未关注
			if(bd.focusGoods(gno, bid)){
				return "focusSuccess";
			}else{
				return "focusFail";
			}
		}
	}
	/**
	 *  @discription 放入购物车
	 */
	public boolean putCart(String gno, int bid, String mknum){
		return bd.putCart(gno, bid, mknum);
	}
	/**
	 * @discription 查询购物车
	 */
	public List<Map<String, Object>> selectCart(int bid){
		return bd.selectCart(bid);
	}
	/**
	 * 修改购物车
	 */
	public boolean updateCart(String shoppingnum,String gno, int bid) {
		return bd.updateCart(shoppingnum, gno, bid);
	}
	/**
	 * @discription 删除购物车
	 */
	public boolean deleteCart(int bid, String gno){
		return bd.deleteCart(bid, gno);
	}
	/**
	 * @discription 提交订单
	 */
	public int orderSubmit(int bid, String amount){
		//往订单表插入记录
		int id = bd.addOrder(bid, amount);
		//往订单详情表插入订单详情
		bd.addOrderDetail(id, bid);
		//清空购物车
		bd.deleteCart(bid, null);
		//更新商品库存
		bd.updateGoodsStore(id);
		return id;
	}
	/**
	 * @discription 订单支付
	 */
	public boolean pay(String ordersn){
		return bd.pay(ordersn);
	}
	/**
	 * @discription 头部搜索框
	 */
	public List<Map<String, Object>> search(String keyword){
		return bd.search(keyword);
	}
	/**
	 * @discription 我的订单
	 */
	public List<Map<String, Object>> myOrder(int bid){
		return bd.myOrder(bid);
	}
	/**
	 * @discription 我的关注
	 */
	public List<Map<String, Object>> myFocus(int bid){
		return bd.myFocus(bid);
	}
	/**
	 * @discription 我的订单详情
	 */
	public List<Map<String, Object>> myOrderDetail(String ordersn){
		return bd.myOrderDetail(ordersn);
	}
}
