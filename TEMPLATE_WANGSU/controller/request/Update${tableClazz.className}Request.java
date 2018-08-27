<#include "common_var.include"/>
		package ${basepackage}.${moduleName}.web.request;
		import java.io.Serializable;
		import java.util.Date;
		import java.math.BigDecimal;
		import herb.modules.common.mapper.BeanMapper;
		import herb.modules.web.request.BaseRequest;
		import javax.validation.constraints.*;

		import javax.validation.constraints.NotNull;
		import java.util.Date;
/**
 * ${table.tableAlias}
 */
public class Update${className}Request extends BaseRequest{
	private static final long serialVersionUID = -1L;

	<#list table.columns as column>
	<#if column.pk>
	@NotNull
    <#else>
	</#if>
	private ${column.javaType} ${column.columnNameLower};
	</#list>

    //getter and setter
    <#list table.columns as column>
    public ${column.javaType} get${column.columnName}() {
        return ${column.columnNameLower};
    }

    public void set${column.columnName}(${column.javaType} ${column.columnNameLower}){
        this.${column.columnNameLower} = ${column.columnNameLower};
    }

    </#list>
    ///////
	public void copyTo(${className} saveEntity) {
		BeanMapper.copy(this, saveEntity);
	}
}