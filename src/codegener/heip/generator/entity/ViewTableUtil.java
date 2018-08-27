package heip.generator.entity;

import java.util.ArrayList;
import java.util.List;

public class ViewTableUtil {
	/**
	 * 取得查询界面的信息
	 * @param table
	 * @return
	 */
	public static List<ColumnClazz> getQueryCols(TableClazz table){
		ArrayList<ColumnClazz> cols = new ArrayList<ColumnClazz>();
		for(ColumnClazz c : table.getColumns()){
			if(c.isQueryCol()){
				cols.add(c);
			}
		}
		return cols;
	}
	
	public static List<ColumnClazz> getTableCols(TableClazz table){
		ArrayList<ColumnClazz> cols = new ArrayList<ColumnClazz>();
		for(ColumnClazz c : table.getColumns()){
			if(c.isTableCol()){
				cols.add(c);
			}
		}
		return cols;
	}
	
	public static List<ColumnClazz> getEditCols(TableClazz table){
		ArrayList<ColumnClazz> cols = new ArrayList<ColumnClazz>();
		for(ColumnClazz c : table.getColumns()){
			if(c.isEditCol()){
				cols.add(c);
			}
		}
		return cols;
	}
	public static List<ColumnClazz> getEditHiddenCols(TableClazz table){
		ArrayList<ColumnClazz> cols = new ArrayList<ColumnClazz>();
		for(ColumnClazz c : table.getColumns()){
			if(c.isHiddenEditCol()){
				cols.add(c);
			}
		}
		return cols;
	}	
}