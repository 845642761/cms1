package org.me.web.server.service;

import java.util.List;

import org.me.plugin.paging.io.QueryPagination;
import org.me.plugin.paging.vo.PageList;
import org.me.web.server.entity.Article;

public interface IArticleService {
	public String insert(Article article);
	public Article getById(String id);
	public void delByIds(List<String> ids);
	public void delById(String id);
	public void update(Article article);
	public List<Article> getList(Article article);
	PageList<Article> listForPageByCategoryId(String categoryId, QueryPagination queryPagination);
}
