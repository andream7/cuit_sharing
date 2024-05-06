package com.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BaseDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * @description ��ӡ��޸ġ�ɾ������
	 * @param String sql����SQL��
	 * @param ���ݲ���������ɾ�ģ�ע�����Object[] arg0Ԫ�صĸ�����˳��һ����String sql�е�ͨ�����
	 * һһ��Ӧ�����SQL�����û��ͨ����봫��null
	 * @return boolean ���³ɹ�����true������false
	 */
	public boolean updateByParam(String sql, Object[] arg0) {
		//SQL�����û��ͨ���
		if(arg0 == null || arg0.length == 0){
			if(jdbcTemplate.update(sql)>0)
				return true;
			else
				return false;
		}
		if(jdbcTemplate.update(sql,arg0)>0)
			return true;
		else
			return false;
	}
	
	/**
	 * @description support select SQL Statement by param
	 * @param String sql����SQL��
	 * @param ���ݲ������в�ѯ��ע�����Object[] arg0Ԫ�صĸ�����˳��һ����String sql
	 * �е�ͨ�����һһ��Ӧ�����SQL�����û��ͨ����봫��null
	 * @return List<Map<String, Object>>: ��ѯ��� 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findByParam(String sql,Object arg0[]){
		if(arg0 == null || arg0.length == 0){
			return jdbcTemplate.query(sql, new IRowMapper());
		}
		return jdbcTemplate.query(sql, new IRowMapper(),arg0);
	}
	/**
	 * 
	 * ���ݿ���������map��key��ͬ
	 *
	 */
	@SuppressWarnings("rawtypes")
	public class IRowMapper implements RowMapper{
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> row = new HashMap<String, Object>();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			for(int i=1,size=rsMetaData.getColumnCount(); i<=size; i++){
				//��ѯ�У����ݱ���ֶ�����ҳ������Ҫһģһ��
				row.put(rsMetaData.getColumnLabel(i).toLowerCase(), rs.getObject(i));
			}
			return row;
		}

	}

}
