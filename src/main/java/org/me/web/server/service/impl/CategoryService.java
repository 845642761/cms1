package org.me.web.server.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.exception.ParamExecption;
import org.me.core.exception.ServiceExecption;
import org.me.plugin.util.ObjectUtil;
import org.me.plugin.util.UuidUtil;
import org.me.web.server.dao.ICategoryDao;
import org.me.web.server.entity.Category;
import org.me.web.server.service.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class CategoryService implements ICategoryService {
private Logger log = Logger.getLogger(CategoryService.class);
	
	@Resource
	private ICategoryDao categoryDao;

	@Transactional
	@Override
	public String insert(Category category) {
		Category parent = null;
		if(StringUtils.hasText(category.getStrPid())){
			parent = categoryDao.getById(category.getStrPid());
			if(parent.getnChild() > 0){
				String maxLevel = categoryDao.getMaxLevel(parent.getStrLevel() + "-", parent.getStrLevel().length() + 4);
				if(StringUtils.hasLength(maxLevel)){
					maxLevel = maxLevel.substring(maxLevel.length() -3, maxLevel.length());
					category.setStrLevel(parent.getStrLevel() + "-" + String.format("%03d",(Integer.parseInt(maxLevel)+1)));
				}else {
					category.setStrLevel(parent.getStrLevel() + "-001");
				}
			}else {
				category.setStrLevel(parent.getStrLevel() + "-001");
			}
		}else {
			log.error("insert category error : strPid is null;");
			throw new ServiceExecption("insert category error : strPid is null;");
		}

		String deptId = UuidUtil.getUUID();
		category.setStrId(deptId);
		category.setnChild(0);
		category.setDtCreateTime(new Date());
		try {
			categoryDao.insert(category);
			//更新父栏目
			if(parent != null){
				parent.setnChild(parent.getnChild() + 1);
				categoryDao.update(parent);	
			}
		} catch (Exception e) {
			log.error("insert category error : ", e);
			throw new ServiceExecption("insert category error");
		}
		return deptId;
	}

	@Override
	public Category getById(String id) {
		if(!StringUtils.hasText(id)){
			log.error("category id is null");
			throw new ParamExecption("get category error : category id is null");
		}
		Category category = null;
		
		try {
			category = categoryDao.getById(id);
		} catch (Exception e) {
			log.error("get category error : ", e);
			throw new ServiceExecption("get category error : id is " + id);
		}
		return category;
	}

	@Transactional
	@Override
	public void delByIds(List<String> ids) {
		if(ids == null)
			return;
		for (String id : ids) {
			delById(id);
		}
	}

	@Transactional
	@Override
	public void delById(String id) {
		if(!StringUtils.hasText(id)){
			return;
		}
		
		try {
			Category category = categoryDao.getById(id);
			if(!"0".equals(category.getStrPid())){
				categoryDao.delByLevel(category.getStrLevel());
				
				Category parent = categoryDao.getById(category.getStrPid());
				if(parent.getnChild() > 0){
					parent.setnChild(parent.getnChild() - 1);
					categoryDao.update(parent);
				}
			}else {
				categoryDao.delById(id);
			}
		} catch (Exception e) {
			log.error("delete category error : ", e);
			throw new ServiceExecption("delete category error : id is " + id);
		}
	}

	@Override
	public void update(Category category) {
		try {
			categoryDao.update(category);
		} catch (Exception e) {
			log.error("update category error : ", e);
			throw new ServiceExecption("update category error : id is " + category.getStrId());
		}
	}

	@Override
	public List<Category> getList(Category category) {
		List<Category> categorys = null;
		try {
			categorys = categoryDao.getListByMap(ObjectUtil.objectToMapIgnoreStatic(category));
		} catch (Exception e) {
			log.error("get category error : ", e);
			throw new ServiceExecption("get category list error");
		}
		return categorys;
	}
}
