package org.me.web.server.service;

import org.me.web.server.entity.CategoryTemplate;

public interface ICategoryTemplateService {
	public String insert(CategoryTemplate ct);
	public int update(CategoryTemplate ct);
	public CategoryTemplate getById(String strCategoryId);
}
