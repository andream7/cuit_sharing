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
	 * @description 添加、修改、删除操作
	 * @param String sql代表SQL文
	 * @param 根据参数进行增删改，注意参数Object[] arg0元素的个数和顺序一定与String sql中的通配符？
	 * 一一对应，如果SQL语句中没有通配符请传递null
	 * @return boolean 更新成功返回true，否则false
	 */
	public boolean updateByParam(String sql, Object[] arg0) {
		//SQL语句中没有通配符
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
	 * @param String sql代表SQL文
	 * @param 根据参数进行查询，注意参数Object[] arg0元素的个数和顺序一定与String sql
	 * 中的通配符？一一对应，如果SQL语句中没有通配符请传递null
	 * @return List<Map<String, Object>>: 查询结果 
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
	 * 数据库表的列名与map的key相同
	 *
	 */
	@SuppressWarnings("rawtypes")
	public class IRowMapper implements RowMapper{
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> row = new HashMap<String, Object>();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			for(int i=1,size=rsMetaData.getColumnCount(); i<=size; i++){
				//查询中，数据表的字段名和页面里面要一模一样
				row.put(rsMetaData.getColumnLabel(i).toLowerCase(), rs.getObject(i));
			}
			return row;
		}

	}

}
