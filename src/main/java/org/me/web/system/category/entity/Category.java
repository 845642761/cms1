package org.me.web.system.category.entity;

import java.util.Date;

import org.me.core.common.base.BaseEntity;
/**
 * 栏目
 * @date 2016年10月10日 15:57:49
 */
public class Category extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String strId;//主键Id
	private String strPid;//父级id
	private String strName;//名称
	private String strDescription;//描述
	private String strLevel;//级别
	private Integer nChild;//子级数: 0:无 (1:有一个子栏目  2：有两个子栏目)
	private Integer nState;//状态:0-正常,-1-禁用
	private Date dtCreateTime;//创建时间:yyyy-mm-dd HH:mm:ss
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrPid() {
		return strPid;
	}
	public void setStrPid(String strPid) {
		this.strPid = strPid;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}
	public String getStrLevel() {
		return strLevel;
	}
	public void setStrLevel(String strLevel) {
		this.strLevel = strLevel;
	}
	public Integer getnChild() {
		return nChild;
	}
	public void setnChild(Integer nChild) {
		this.nChild = nChild;
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
