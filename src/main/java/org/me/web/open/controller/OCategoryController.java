package org.me.web.open.controller;

import java.util.List;
import javax.annotation.Resource;
import org.me.web.open.core.common.BaseController;
import org.me.web.server.entity.Category;
import org.me.web.server.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category/")
public class OCategoryController extends BaseController {
	@Resource
	private ICategoryService categoryService;
	
	/**
	 * 根据父id获取Category
	 * @param strPid
	 * @return List<Category>
	 * @date 2016年11月7日 11:31:22
	 */
	@RequestMapping("getCategoryByPid")
	@ResponseBody
	public List<Category> getCategoryByPid(String strPid){
		Category category = new Category();
		category.setnState(0);
		category.setStrPid(strPid);
		return categoryService.getList(category);
	}
}
