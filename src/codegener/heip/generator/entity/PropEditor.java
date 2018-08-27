package heip.generator.entity;

public class PropEditor {
	public static enum EditType{
		TEXTINPUT("文本框","textinput"),
		SELECT("下拉列表","select"),
		TEXTAREA("备注文本框","textarea"),
		DIALOG("弹出框","dialog"),
		DATE("日期选择","date"),
		DATE_TIME("日期时间(到分)","datetime");
		
		private String name;
		private String code;
		private EditType(String name,String code){
			this.name= name;
			this.code = code;
		}
		public String getName(){
			return this.name;
		}
		public String getCode(){
			return this.code;
		}
	}
	private EditType editType;
	
	public PropEditor(EditType type){
		this.editType= type;
	}

	public EditType getEditType() {
		return editType;
	}

	public void setEditType(EditType editType) {
		this.editType = editType;
	}
	public String getEditTypeCode(){
		return this.editType.getCode();
	}
}