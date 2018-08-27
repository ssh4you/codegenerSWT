package heip.generator.entity;

import java.util.ArrayList;
import java.util.List;

import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;
import cn.org.rapid_framework.generator.util.StringHelper;

public class TableClazz {
	
	private String className;//实体名称：BmCodeName
	
	private String tableAlias;//生成的界面中文名称	
	
	private String underCodeName;
	private String firstLowerName;
	
	private String fkColumn;
	
	public void setFkColumn(String fkColumn){
		this.fkColumn = fkColumn;
	}
	
	public String getFkColumn(){
		return this.fkColumn;
	}
	public String getUnderLineName(){
		return this.underCodeName;
	}
	
	public ColumnClazz getFkProperty(){
		for(ColumnClazz col :this.columns){
			if(col.getColumnName().equalsIgnoreCase(this.fkColumn)){
				return col;
			}
		}
		return null;
		//String value = StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(this.fkColumn));
		//value =StringHelper.uncapitalize(value);
		//System.out.println(value);
		//return value;
	}
	
	
	private List<TableClazz> subClazzes = new ArrayList<TableClazz>();
	/**
	 * 表的字段
	 */
	private List<ColumnClazz> columns = new ArrayList<ColumnClazz>();
	
	
	public TableClazz(String tableName){
		Table table = TableFactory.getInstance().getTable(tableName);
		buildTableClazz(table);
	}
	
	private void buildTableClazz(Table table){
		className = table.getClassName();
		tableAlias = table.getTableAlias();
		underCodeName = table.getUnderscoreName();
		firstLowerName = table.getClassNameFirstLower();
		
		
		for(Column col : table.getColumns()){
			ColumnClazz cc = new ColumnClazz(col);
			columns.add(cc);
		}
	}
	
	public ColumnClazz getPkProp(){
		for(ColumnClazz c : getColumns()){
			if(c.isPK()){
				return c;
			}
		}
		return null;
	}
	
	public ColumnClazz getPkProperty(){
		return getPkProp();
	}

	//
	
	//--getter
	public String getClassName() {
		return className;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public String getUnderCodeName() {
		return underCodeName;
	}

	public String getFirstLowerName() {
		return firstLowerName;
	}

	public List<ColumnClazz> getColumns() {
		return columns;
	}
	
	public List<ColumnClazz> getProperties(){
		return columns;
	}
	
	
	public List<TableClazz> getSubClazzes() {
		return subClazzes;
	}

	public void setSubClazzes(List<TableClazz> subClazzes) {
		this.subClazzes = subClazzes;
	}

	//展示
	public  List<ColumnClazz> getQueryCols(){
		return ViewTableUtil.getQueryCols(this);
	}
	
	public  List<ColumnClazz> getTableCols(){
		return ViewTableUtil.getTableCols(this);
	}
	
	public  List<ColumnClazz> getEditCols(){
		return ViewTableUtil.getEditCols(this);
	}
	
	public  List<ColumnClazz> getEditHiddenCols(){
		return ViewTableUtil.getEditHiddenCols(this);
	}	
	
	public static void main(String[] args){
		String name = "bm_code_type";
		String value = StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(name));
		value =StringHelper.uncapitalize(value);
		System.out.println(value);
	}
}