package service;
import java.util.List;
import java.util.Map;
import dao.AdminDao;
import dto.AdminDTO;
import dto.GoodsDTO;
import dto.NoticeDTO;
public class AdminService {
	AdminDao ad = new AdminDao();
	/**
	 * @discription 管理员登录判定
	 */
	public boolean adminLogin(AdminDTO adt){
		return ad.adminLogin(adt);
	}
	/**
	 * @discription 查询所有商品
	 */
	public List<Map<String, Object>> selectGoods(){
		return ad.selectGoods();
	}
	public List<Map<String, Object>> selectAllGoodsByPage(int startIndex, int perPageSize){
		return ad.selectAllGoodsByPage(startIndex, perPageSize);
	}
	/**
	 * @discription 获得商品类型列表
	 */
	public  List<Map<String, Object>> getGoodsType(){
		return ad.getGoodsType();
	}
	/**
	 * 添加类型
	 */
	public boolean addType(String typename) {
		return ad.addType(typename);
	}
	/**
	 * @discription 获得关联类型列表
	 */
	public  List<Map<String, Object>> getReType(String id){
		return ad.getReType(id);
	}
	/**
	 * 删除类型
	 */
	public String deleteType(String id) {
		if(getReType(id).size() > 0) {
			return "有子记录，无法删除！3秒钟返回";
		}else {
			ad.deleteType(id);
			return "删除成功！3秒钟返回";
		}
	}
	/**
	 * @discription 添加商品
	 */
	public boolean addGoods(GoodsDTO gd){
		return ad.addGoods(gd);
	}
	/**
	 *  @discription 查询一个商品
	 */
	public List<Map<String, Object>> selectAGoods(String gno){
		return ad.selectAGoods(gno);
	}
	/**
	 * @discription 修改商品
	 */
	public boolean updateGoods(GoodsDTO gd){
		return ad.updateGoods(gd);
	}
	/**
	 * @discription 删除商品
	 */
	public String deleteAgoods(String gno){
		if(!ad.isDelete(gno)){//有子记录不能删除
			return "nodelete";
		}else{
			ad.deleteAgoods(gno);
			return "ok";
		}
	}
	/**
	 * @discription 删除多个商品
	 */
	public String deleteManygoods(String gnos[]){
		int count = 0;
		for(int i = 0; i < gnos.length; i++){
			if(!ad.isDelete(gnos[i])){
				break;
			}else{
				count++;
			}
		}
		//没有子记录
		if(count == gnos.length){
			for(int i = 0; i < gnos.length; i++){
				ad.deleteAgoods(gnos[i]);
			}
			return "ok";
		}else{//有子记录
			return "nodelete";
		}
	}
	/**
	 * @discription 条件查询
	 */
	public List<Map<String, Object>> conditionSelectGoods(String gname, String typeid){
		return ad.conditionSelectGoods(gname, typeid);
	}
	/**
	 * @discription 分页条件查询
	 */
	public List<Map<String, Object>> conditionSelectGoodsByPage(String gname, String typeid, int startIndex, int perPageSize){
		return ad.conditionSelectGoodsByPage(gname, typeid, startIndex, perPageSize);
	}
	/**
	 * @discription 查询公告
	 */
	public  List<Map<String, Object>> selectNotice(){
		return ad.selectNotice();
	}
	/**
	 * @discription 添加公告
	 */
	public boolean addNotice(NoticeDTO nd){
		return ad.addNotice(nd);
	}
	/**
	 * @discription 查询一个公告 
	 */
	public  List<Map<String, Object>> selectAnotice(String nid){
		return ad.selectAnotice(nid);
	}
	/**
	 * @discription 删除一个公告 
	 */
	public boolean deleteAnotice(String nid){
		return ad.deleteAnotice(nid);
	}
	/**
	 *  @discription 查询用户
	 */
	public List<Map<String, Object>> selectUsers(){
		return ad.selectUsers();
	}
	/**
	 * @discription 删除用户
	 */
	public String deleteUser(String bid){
		if(!ad.isDeleteUser(bid)){
			return "nodelete";
		}else{
			ad.deleteUser(bid);
			return "ok";
		}
	}
	/**
	 *  @discription 查询用户
	 */
	public List<Map<String, Object>> selectOrders(){
		return ad.selectOrders();
	}
	/**
	 *  @discription 删除订单
	 */
	public boolean deleteOrder(String ordersn){
		if(ad.deleteOrderdetail(ordersn)){
			if(ad.deleteOrderbasetable(ordersn)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
