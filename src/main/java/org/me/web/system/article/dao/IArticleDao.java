package org.me.web.system.article.dao;

import java.util.List;
import java.util.Map;
import org.me.web.system.article.entity.Article;

public interface IArticleDao {
	public int insert(Article article);
	public int delById(String id);
	public Article getById(String id);
	public int update(Article article);
	public List<Article> getList(Article article);
	public int getListSize(Article article);//查询列表大小
	public List<Article> getListByMap(Map<String, Object> map);
	public int getListSizeByMap(Map<String, Object> map);
}
