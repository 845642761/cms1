package org.me.web.open.controller;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.web.open.core.common.BaseController;
import org.me.web.server.entity.Article;
import org.me.web.server.service.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article/")
public class OArticleController extends BaseController {
	private Logger log = Logger.getLogger(OArticleController.class);
	
	@Resource
	private IArticleService articleService;
	
	@ResponseBody
	@RequestMapping("getArticleByCategoryId")
	public List<Article> getArticleByCategoryId(String categoryId) {
		Article article = new Article();
		article.setnState(0);
		article.setStrCategoryId(categoryId);
		return articleService.getList(article);
	}
}
