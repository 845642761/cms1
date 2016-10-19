package org.me.web.system.category.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.me.web.system.category.entity.Category;

public interface ICategoryDao {
	public int insert(Category category);
	public int delById(String id);
	public Category getById(String id);
	public int update(Category category);
	public List<Category> getList(Category category);
	public int getListSize(Category category);//查询列表大小
	public int delByLevel(String level);//根据级别删除
	public String getMaxLevel(@Param("strLevel") String strLevel, @Param("length") int length);//根据当前级别中最大数
}
