package org.me.web.system.article.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.exception.ParamExecption;
import org.me.core.exception.ServiceExecption;
import org.me.plugin.paging.core.Pagination;
import org.me.plugin.paging.io.QueryPagination;
import org.me.plugin.paging.vo.PageList;
import org.me.plugin.util.ObjectUtil;
import org.me.plugin.util.UuidUtil;
import org.me.web.system.article.dao.IArticleDao;
import org.me.web.system.article.entity.Article;
import org.me.web.system.article.service.IArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class ArticleService implements IArticleService {
	private Logger logger = Logger.getLogger(ArticleService.class);

	@Resource
	private IArticleDao articleDao;
	
	@Override
	public String insert(Article article) {
		String id = UuidUtil.getUUID(); 
		article.setStrId(id);
		try {
			articleDao.insert(article);
		} catch (Exception e) {
			logger.error("articleService insert error : ", e);
			throw new ServiceExecption("articleService insert error : ", e);
		}
		return id;
	}

	@Override
	public Article getById(String id) {
		if(!StringUtils.hasText(id)){
			logger.error("articleService getById error : id is null");
			throw new ParamExecption("articleService getById error : id is null");
		}
		
		Article article = null;
		try {
			article = articleDao.getById(id);
		} catch (Exception e) {
			logger.error("articleService getById error : ", e);
			throw new ServiceExecption("articleService getById error : ", e);
		}
		return article;
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

	@Override
	public void delById(String id) {
		if(!StringUtils.hasText(id)){
			return;
		}
		try {
			articleDao.delById(id);
		} catch (Exception e) {
			logger.error("articleService delById error : ", e);
			throw new ServiceExecption("articleService delById error : ", e);
		}
	}

	@Override
	public void update(Article article) {
		try {
			articleDao.update(article);
		} catch (Exception e) {
			logger.error("articleService update error : ", e);
			throw new ServiceExecption("articleService update error : ", e);
		}
	}

	@Override
	public List<Article> getList(Article article) {
		List<Article> list = null;
		try {
			list = articleDao.getList(article);
		} catch (Exception e) {
			logger.error("articleService getList error : ", e);
			throw new ServiceExecption("articleService getList error : ", e);
		}
		return list;
	}

	@Override
	public PageList<Article> listForPageByCategoryId(String categoryId, QueryPagination queryPagination) {
		PageList<Article> pageList = new PageList<>();
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("strCategoryId", categoryId);
			map.putAll(ObjectUtil.objectToMapIgnoreStatic(categoryId));
			map.putAll(ObjectUtil.objectToMapIgnoreStatic(queryPagination));
			pageList.setList(articleDao.getListByMap(map));
			
			Pagination pagination = pageList.getPagination();
			pagination.setNumPerPage(queryPagination.getNumPerPage());
			pagination.setStartIndex(queryPagination.getStartIndex());
			pagination.setTotalRows(articleDao.getListSizeByMap(map));
		} catch (Exception e) {
			logger.error("articleService listForPageByCategoryId error : ", e);
			throw new ServiceExecption("articleService listForPageByCategoryId error : ", e);
		}
		return pageList;
	}
}
