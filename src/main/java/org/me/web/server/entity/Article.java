package org.me.web.server.entity;

import java.util.Date;

import org.me.core.common.base.BaseEntity;

public class Article extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String strId;//主键Id
	private String strCategoryId;//栏目id
	private String strTitle;//标题
	private String strAuthor;//作者
	private String strDescription;//描述
	private String tContent;//内容
	private Integer nState;//状态:0-正常,-1-禁用
	private Date dtCreateTime;//创建时间:yyyy-mm-dd HH:mm:ss
	
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrCategoryId() {
		return strCategoryId;
	}
	public void setStrCategoryId(String strCategoryId) {
		this.strCategoryId = strCategoryId;
	}
	public String getStrTitle() {
		return strTitle;
	}
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}
	public String getStrAuthor() {
		return strAuthor;
	}
	public void setStrAuthor(String strAuthor) {
		this.strAuthor = strAuthor;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}
	public String gettContent() {
		return tContent;
	}
	public void settContent(String tContent) {
		this.tContent = tContent;
	}
	public Integer getnState() {
		return nState;
	}
	public void setnState(Integer nState) {
		this.nState = nState;
	}
	public Date getDtCreateTime() {
		return dtCreateTime;
	}
	public void setDtCreateTime(Date dtCreateTime) {
		this.dtCreateTime = dtCreateTime;
	}
}
