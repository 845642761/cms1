package org.me.web.server.service.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.exception.ParamExecption;
import org.me.core.exception.ServiceExecption;
import org.me.web.server.dao.ICategoryTemplateDao;
import org.me.web.server.entity.CategoryTemplate;
import org.me.web.server.service.ICategoryTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CategoryTemplateService implements ICategoryTemplateService {
	private Logger log = Logger.getLogger(CategoryTemplateService.class);
	@Resource
	private ICategoryTemplateDao categoryTemplateDao;
	
	@Override
	public String insert(CategoryTemplate ct) {
		try {
			categoryTemplateDao.insert(ct);
		} catch (Exception e) {
			log.error("categoryTemplateService-insert error : ", e);
			throw new ServiceExecption("CategoryTemplateService-insert error : ", e);
		}
		return ct.getStrCategoryId();
	}

	@Override
	public int update(CategoryTemplate ct) {
		int i = 0;
		try {
			i = categoryTemplateDao.update(ct);
		} catch (Exception e) {
			log.error("categoryTemplateService-update error : ", e);
			throw new ServiceExecption("CategoryTemplateService-update error : ", e);
		}
		return i;
	}

	@Override
	public CategoryTemplate getById(String strCategoryId) {
		if(!StringUtils.hasText(strCategoryId)){
			log.error("categoryTemplateService getById error : strCategoryId is null");
			throw new ParamExecption("categoryTemplateService getById error : strCategoryId is null");
		}
		CategoryTemplate categoryTemplate = null;
		try {
			categoryTemplate = categoryTemplateDao.getById(strCategoryId);
		} catch (Exception e) {
			log.error("categoryTemplateService-getById error : ", e);
			throw new ServiceExecption("CategoryTemplateService-getById error : ", e);
		}
		return categoryTemplate;
	}
}
