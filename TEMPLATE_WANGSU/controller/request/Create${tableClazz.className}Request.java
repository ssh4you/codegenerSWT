<#include "common_var.include"/>
package ${basepackage}.${moduleName}.web.request;
		import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
        import herb.modules.common.mapper.BeanMapper;
        import herb.modules.web.request.BaseRequest;

        import javax.validation.constraints.NotNull;
        import java.util.Date;
        import javax.validation.constraints.*;

/**
 */
public class Create${className}Request extends BaseRequest{
	private static final long serialVersionUID = -1L;


	<#list table.columns as column>
	<#if !(column.pk)>
    private ${column.javaType} ${column.columnNameLower};
    </#if>
	</#list>

    //getter and setter
    <#list table.columns as column>
    <#if !(column.pk)>
    public ${column.javaType} get${column.columnName}() {
        return ${column.columnNameLower};
    }

    public void set${column.columnName}(${column.javaType} ${column.columnNameLower}){
        this.${column.columnNameLower} = ${column.columnNameLower};
    }
    </#if>
    </#list>
    ///////
    public ${className} buildNew() {
        ${className} entity = new ${className}();
        //值拷贝
        BeanMapper.copy(this, entity);
        return entity;
    }
}