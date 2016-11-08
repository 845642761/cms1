package org.me.web.open.controller;

import java.io.Writer;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.me.web.open.core.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/")
public class MainController extends BaseController {
	private Logger log = Logger.getLogger(MainController.class);
	
	@RequestMapping("index")
	public void index(Writer writer) {
		HttpServletResponse response =  getResponse();
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		try {
			writer.write("首页");
			writer.flush();
			writer.close();
		} catch (Exception e) {
			log.error("MainController - index error : ", e);
		}
	}
}
