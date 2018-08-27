package heip.generator.entity;


public class ValidateRule {
	
	public static enum ValidateType{
		REQUIRED("必输"),
		LENGTH("字符长度"),
		INTEGER("整数"),
		DECIMAL("小数");
		private String name;
		private ValidateType(String name){
			this.name= name;
		}
		public String getName(){
			return name;
		}
	}
	
	private ValidateType type;
	
	public ValidateRule(ValidateType type){
		this.type = type;
	}
	
	private String minSize;
	private String maxSize;
	private String min;
	private String max;
	
	
	
	public String toHtml(){
		StringBuffer result = new StringBuffer();
		switch (type) {
		case REQUIRED:
			result.append("required");
			break;
		case LENGTH:
			if(null!=minSize){
				result.append("minSize[").append(this.minSize).append("]");
				if(null!=maxSize)result.append(",");
			}
			if(null!=maxSize)result.append("maxSize[").append(this.maxSize).append("]");
			///result.append("custom[onlyLetNumSpec]");
			break;
		case INTEGER:
			result.append("custom[integer]");
			if(null!=min)result.append(",min[").append(min).append("]");
			if(null!=max)result.append(",max[").append(max).append("]");
		case DECIMAL:
			result.append("custom[number]");
			if(null!=min)result.append(",min[").append(min).append("]");
			if(null!=max)result.append(",max[").append(max).append("]");
		default:
			break;
		}
		
		return result.toString();
	}




	
	
	//getter or setter	

	public String getMinSize() {
		return minSize;
	}




	public void setMinSize(String minSize) {
		this.minSize = minSize;
	}




	public String getMaxSize() {
		return maxSize;
	}




	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}




	public String getMin() {
		return min;
	}




	public void setMin(String min) {
		this.min = min;
	}




	public String getMax() {
		return max;
	}




	public void setMax(String max) {
		this.max = max;
	}






	public ValidateType getType() {
		return type;
	}
	
	
}