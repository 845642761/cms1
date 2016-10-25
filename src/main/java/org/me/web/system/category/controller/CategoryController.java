package org.me.web.system.category.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.me.core.common.Result;
import org.me.core.common.ResultUtil;
import org.me.core.exception.ViewExecption;
import org.me.plugin.ztree.dto.ZtreeDTO;
import org.me.web.core.common.base.BaseController;
import org.me.web.system.category.entity.Category;
import org.me.web.system.category.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/system/category/")
public class CategoryController extends BaseController  {
	private Logger log = Logger.getLogger(CategoryController.class);
	@Resource
	private ICategoryService categoryService;
	
	@RequiresPermissions("category:query")
	@RequestMapping("list")
	public ModelAndView list() {
		return new ModelAndView("/system/category/categoryList");
	}
	
	/**
	 * 根据父id获取子节点（加载栏目树）
	 * @date: 2016年10月10日 16:16:27
	 */
	@RequiresPermissions("category:query")
	@RequestMapping("getCategoryByPid")
	@ResponseBody
	public List<ZtreeDTO> getCategoryByPid(String id) {
		List<ZtreeDTO> categorys = null;
		if(!StringUtils.hasText(id))
			id = "0";
		try {
			Category category = new Category();
			category.setStrPid(id);
			category.setnState(0);
			categorys = toZtree(categoryService.getList(category));
		} catch (Exception e) {
			log.error("get category list error : ",e);
			throw new ViewExecption("get category list error");
		}
		return categorys;
	}
	
	/**
	 * 栏目列表
	 * @date: 2016年8月18日 17:06:27
	 */
	@RequiresPermissions("category:query")
	@RequestMapping("listCategory")
	@ResponseBody
	public List<ZtreeDTO> listCategory() {
		List<ZtreeDTO> categorys = null;
		try {
			Category category = new Category();
			category.setnState(0);
			categorys = toZtree(categoryService.getList(category));
		} catch (Exception e) {
			log.error("get category list error : ",e);
			throw new ViewExecption("get category list error");
		}
		return categorys;
	}
	
	/**
	 * 查看详情
	 * @date: 2016年10月10日 16:23:48
	 */
	@RequiresPermissions("category:detail")
	@RequestMapping("toDetail")
	public ModelAndView toDetail(String id) {
		ModelAndView mav = new ModelAndView("/system/category/categoryEdit");
		try {
			Category category = categoryService.getById(id);
			mav.addObject("category", category);
		} catch (Exception e) {
			log.error("get category error : ",e);
			throw new ViewExecption("get category error");
		}
		return mav;
	}
	
	/**
	 * 添加或保存
	 * @date: 2016年10月10日 16:25:10
	 */
	@RequiresPermissions("category:saveOrUpdate")
	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public Result saveOrUpdate(Category category) {
		Result resoult = ResultUtil.buildSuccessResoult();
		String id = category.getStrId();
		try {
			if(!StringUtils.hasText(id)){
				categoryService.insert(category);
			}else {
				categoryService.update(category);
			}
		} catch (Exception e) {
			log.error("saveOrUpdate category error : ",e);
			resoult = ResultUtil.buildErrorResoult("修改失败");
		}
		return resoult;
	}
	
	@RequiresPermissions("category:del")
	@RequestMapping("delById")
	@ResponseBody
	public Result delById(String id) {
		Result resoult = ResultUtil.buildSuccessResoult();
		if(!StringUtils.hasText(id)){
			return ResultUtil.buildErrorResoult("请选择删除"); 
		}
		try {
			categoryService.delById(id);
		} catch (Exception e) {
			log.error("delete category error : ",e);
			resoult = ResultUtil.buildErrorResoult("删除失败");
		}
		return resoult;
	}
	
	@RequiresPermissions("category:add")
	@RequestMapping("add")
	public ModelAndView add(String strPid) {
		ModelAndView mav = new ModelAndView("/system/category/categoryAdd");
		mav.addObject("strPid", strPid);
		return mav;
	}
	
	/**
	 * 转为ztree数据
	 * @date: 2016年10月10日 16:21:42
	 */
	private List<ZtreeDTO> toZtree(List<Category> list) {
		List<ZtreeDTO> ztrees = new ArrayList<>();
		for (Category category : list) {
			ZtreeDTO ztree = new ZtreeDTO();
			ztree.setId(category.getStrId());
			ztree.setpId(category.getStrPid());
			ztree.setName(category.getStrName());
			int hasChild = category.getnChild();
			if(hasChild > 0){
				ztree.setIsParent(true);
			}
			ztrees.add(ztree);
		}
		return ztrees;
	}
}
