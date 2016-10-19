package org.me.web.system.category.service;

import java.util.List;
import org.me.web.system.category.entity.Category;

public interface ICategoryService {
	public String insert(Category category);
	public Category getById(String id);
	public void delByIds(List<String> ids);
	public void delById(String id);
	public void update(Category category);
	public List<Category> getList(Category category);
}
