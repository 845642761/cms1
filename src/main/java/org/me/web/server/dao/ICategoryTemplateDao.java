package org.me.web.server.dao;

import org.me.web.server.entity.CategoryTemplate;

public interface ICategoryTemplateDao {
	public int insert(CategoryTemplate ct);
	public int update(CategoryTemplate ct);
	public CategoryTemplate getById(String strCategoryId);
}
