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
	 * @discription ����Ա��¼�ж�
	 */
	public boolean adminLogin(AdminDTO adt){
		return ad.adminLogin(adt);
	}
	/**
	 * @discription ��ѯ������Ʒ
	 */
	public List<Map<String, Object>> selectGoods(){
		return ad.selectGoods();
	}
	public List<Map<String, Object>> selectAllGoodsByPage(int startIndex, int perPageSize){
		return ad.selectAllGoodsByPage(startIndex, perPageSize);
	}
	/**
	 * @discription �����Ʒ�����б�
	 */
	public  List<Map<String, Object>> getGoodsType(){
		return ad.getGoodsType();
	}
	/**
	 * �������
	 */
	public boolean addType(String typename) {
		return ad.addType(typename);
	}
	/**
	 * @discription ��ù��������б�
	 */
	public  List<Map<String, Object>> getReType(String id){
		return ad.getReType(id);
	}
	/**
	 * ɾ������
	 */
	public String deleteType(String id) {
		if(getReType(id).size() > 0) {
			return "���Ӽ�¼���޷�ɾ����3���ӷ���";
		}else {
			ad.deleteType(id);
			return "ɾ���ɹ���3���ӷ���";
		}
	}
	/**
	 * @discription �����Ʒ
	 */
	public boolean addGoods(GoodsDTO gd){
		return ad.addGoods(gd);
	}
	/**
	 *  @discription ��ѯһ����Ʒ
	 */
	public List<Map<String, Object>> selectAGoods(String gno){
		return ad.selectAGoods(gno);
	}
	/**
	 * @discription �޸���Ʒ
	 */
	public boolean updateGoods(GoodsDTO gd){
		return ad.updateGoods(gd);
	}
	/**
	 * @discription ɾ����Ʒ
	 */
	public String deleteAgoods(String gno){
		if(!ad.isDelete(gno)){//���Ӽ�¼����ɾ��
			return "nodelete";
		}else{
			ad.deleteAgoods(gno);
			return "ok";
		}
	}
	/**
	 * @discription ɾ�������Ʒ
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
		//û���Ӽ�¼
		if(count == gnos.length){
			for(int i = 0; i < gnos.length; i++){
				ad.deleteAgoods(gnos[i]);
			}
			return "ok";
		}else{//���Ӽ�¼
			return "nodelete";
		}
	}
	/**
	 * @discription ������ѯ
	 */
	public List<Map<String, Object>> conditionSelectGoods(String gname, String typeid){
		return ad.conditionSelectGoods(gname, typeid);
	}
	/**
	 * @discription ��ҳ������ѯ
	 */
	public List<Map<String, Object>> conditionSelectGoodsByPage(String gname, String typeid, int startIndex, int perPageSize){
		return ad.conditionSelectGoodsByPage(gname, typeid, startIndex, perPageSize);
	}
	/**
	 * @discription ��ѯ����
	 */
	public  List<Map<String, Object>> selectNotice(){
		return ad.selectNotice();
	}
	/**
	 * @discription ��ӹ���
	 */
	public boolean addNotice(NoticeDTO nd){
		return ad.addNotice(nd);
	}
	/**
	 * @discription ��ѯһ������ 
	 */
	public  List<Map<String, Object>> selectAnotice(String nid){
		return ad.selectAnotice(nid);
	}
	/**
	 * @discription ɾ��һ������ 
	 */
	public boolean deleteAnotice(String nid){
		return ad.deleteAnotice(nid);
	}
	/**
	 *  @discription ��ѯ�û�
	 */
	public List<Map<String, Object>> selectUsers(){
		return ad.selectUsers();
	}
	/**
	 * @discription ɾ���û�
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
	 *  @discription ��ѯ�û�
	 */
	public List<Map<String, Object>> selectOrders(){
		return ad.selectOrders();
	}
	/**
	 *  @discription ɾ������
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
