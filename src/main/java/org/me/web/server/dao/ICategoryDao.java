package org.me.web.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.me.web.server.entity.Category;

public interface ICategoryDao {
	public int insert(Category category);
	public int delById(String id);
	public Category getById(String id);
	public int update(Category category);
	public List<Category> getListByMap(Map<String, Object> map);
	public int getListSizeByMap(Map<String, Object> map);//查询列表大小
	public int delByLevel(String level);//根据级别删除
	public String getMaxLevel(@Param("strLevel") String strLevel, @Param("length") int length);//根据当前级别中最大数
}
