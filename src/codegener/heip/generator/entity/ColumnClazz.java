package heip.generator.entity;

import heip.generator.entity.PropEditor.EditType;
import heip.generator.entity.ValidateRule.ValidateType;

import java.util.ArrayList;
import java.util.List;

import cn.org.rapid_framework.generator.provider.db.table.model.Column;

public class ColumnClazz {

	private String columnName;//sqlname birth_day
	//private String propName="";//属性名：birthDay
	private String name;
	//private String propCnName="";//字段备注:加班类型,1:正常,0：不正常；如这种会截取“，”第一个
	private String cnName;
	private int strLength;//字符长度 
	private String remarks="";//备注，数据库字段备注
	
	private boolean isPK ;
	private String javaType;//数据类型
	
	public ColumnClazz(Column col) {
		this.remarks = col.getColumnAlias();
		this.columnName = col.getSqlName();
		this.name = col.getColumnNameFirstLower();
		setPropCnName(this.remarks);
		this.isPK = col.isPk();
		//
		this.javaType = col.getSimpleJavaType();
		this.strLength = col.getSize();
		col.getAsType();
	}
	
	/**
	 * 中文名称阶段
	 * @param remarks
	 */
	public void  setPropCnName(String remarks){
		if(remarks!=null&&!"".equals(remarks.trim())){
			this.cnName = remarks.trim().split(",")[0];
		}
	}
	
	public String getCnName(){
		return cnName;
	}
	
	
	/**
	 * 例如gradeId --> gradeName 
	 * @return
	 */
	public String getIdLabel(){
		int i = this.name.lastIndexOf("Id");
		if(i==-1)i=this.name.lastIndexOf("Name");
		if(i==-1){
			return this.name;
		}
		String result = this.name.substring(0,i);
		return result;
		
	}	
	//查询页面信息
	private boolean isQueryCol;
	private boolean isTableCol;
	
	//编辑页面信息
	private boolean isEditCol;
	private boolean isHiddenEditCol;
	
	//编辑规则
	private PropEditor editor = new PropEditor(EditType.TEXTINPUT);
	public void setPropEditor(PropEditor edi){
		this.editor = edi;
	}
	
	public PropEditor getEditor(){
		return this.editor==null?new PropEditor(EditType.TEXTINPUT):this.editor;
	}
	
	
	//校验规则
	private List<ValidateRule> rules = new ArrayList<ValidateRule>();
	
	public void addValidateRule(ValidateRule rule){
		this.rules.add(rule);
	}

	public void clearRule(){
		this.rules.clear();
	}
	
	public String getRuleHtml(){
		StringBuffer result = new StringBuffer();
		if(this.rules.size()>0){
			result.append("validate[");
			for(int i =0;i<rules.size();i++){
				ValidateRule rule =rules.get(i);
				if(i>0)result.append(",");
				result.append(rule.toHtml());
			}
			result.append("]");
		}
		System.out.println(result.toString());
		return result.toString();
	}
	
	//--------getter and setter -------------
	
	public String getPropName() {
		return name;
	}


	public int getStrLength() {
		return strLength;
	}

	
	public String getRemarks() {
		return remarks;
	}

	public String getPropCnName() {
		return this.cnName;
	}

	public boolean isQueryCol() {
		return isQueryCol;
	}

	public void setQueryCol(boolean isQueryCol) {
		this.isQueryCol = isQueryCol;
	}

	public boolean isTableCol() {
		return isTableCol;
	}

	public void setTableCol(boolean isTableCol) {
		this.isTableCol = isTableCol;
	}

	public boolean isEditCol() {
		return isEditCol;
	}

	public void setEditCol(boolean isEditCol) {
		this.isEditCol = isEditCol;
	}

	public boolean isHiddenEditCol() {
		return isHiddenEditCol;
	}

	public void setHiddenEditCol(boolean isHiddenEditCol) {
		this.isHiddenEditCol = isHiddenEditCol;
	}

	public void setPropName(String propName) {
		this.name = propName;
	}

	public void setStrLength(int strLength) {
		this.strLength = strLength;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isPK() {
		return isPK;
	}

	public void setPK(boolean isPK) {
		this.isPK = isPK;
	}

	public boolean isEditRequired(){
		for(ValidateRule rule : this.rules){
			if(rule.getType()==ValidateType.REQUIRED){
				return true;
			}
		}
		return false;
	}
	
	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumnName() {
		return columnName;
	}
		
}