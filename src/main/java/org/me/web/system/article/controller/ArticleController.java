package org.me.web.system.article.controller;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.me.core.common.Result;
import org.me.core.common.ResultUtil;
import org.me.core.exception.ViewExecption;
import org.me.plugin.paging.io.QueryPagination;
import org.me.plugin.paging.vo.PageList;
import org.me.web.core.common.base.BaseController;
import org.me.web.system.article.entity.Article;
import org.me.web.system.article.service.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/system/article/")
public class ArticleController extends BaseController {
	private Logger log = Logger.getLogger(ArticleController.class);
	@Resource
	private IArticleService articleService;
	
	@RequiresPermissions("article:query")
	@RequestMapping("list")
	public ModelAndView list() {
		return new ModelAndView("/system/article/list");
	}
	
	@RequiresPermissions("article:query")
	@RequestMapping("getListByCategoryId")
	public ModelAndView getListByCategoryId(String strCategoryId, QueryPagination queryPagination) {
		ModelAndView mav = new ModelAndView("/system/article/articleList");
		PageList<Article> articleList = articleService.listForPageByCategoryId(strCategoryId, queryPagination);
		mav.addObject("articleList", articleList);
		setPagination(articleList.getPagination());
		return mav;
	}
	
	@RequiresPermissions("article:detail")
	@RequestMapping("toDetail")
	public ModelAndView toDetail(String strId) {
		ModelAndView mav = new ModelAndView("/system/article/articleEdit");
		try {
			Article article = articleService.getById(strId);
			mav.addObject("article", article);
		} catch (Exception e) {
			log.error("articleController toDetail error : ",e);
			throw new ViewExecption("articleController toDetail error", e);
		}
		return mav;
	}
	
	@RequiresPermissions("article:saveOrUpdate")
	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public Result saveOrUpdate(Article article) {
		Result resoult = ResultUtil.buildSuccessResoult();
		String id = article.getStrId();
		try {
			if(!StringUtils.hasText(id)){
				articleService.insert(article);
			}else {
				articleService.update(article);
			}
		} catch (Exception e) {
			log.error("articleController saveOrUpdate error : ",e);
			resoult = ResultUtil.buildErrorResoult("修改失败");
		}
		return resoult;
	}
}
