<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${moduleName}.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ${table.tableAlias}
 */
@Entity
@Table(name = "${table.sqlName}")
public class ${className} implements Serializable{
	private static final long serialVersionUID = -1L;
    //空构造函数
    public ${className}(){}


	<#list table.columns as column>
	<#if column.pk>
	/**
	 * ID 主键
	 */
	@Id
    <#if generationType == "AUTO">
    @GeneratedValue(generator = "JDBC")
    <#elseif generationType == "UUID" >
	@GeneratedValue(generator = "UUID")
	</#if>
	<#else>
	/** ${column.columnAlias}*/
	</#if>
	@Column(name = "${column.sqlName}")
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
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		<#list table.columns as column>
		<#if !column.sqlName?starts_with("DEFINE")>
			<#if !table.compositeId>
			.append("${column.columnName}",get${column.columnName}())
			</#if>
		</#if>
		</#list>
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		<#list table.pkColumns as column>
			<#if !table.compositeId>
			.append(get${column.columnName}())
			</#if>
		</#list>
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof ${className} == false) return false;
		if(this == obj) return true;
		${className} other = (${className})obj;
		return new EqualsBuilder()
			<#list table.pkColumns as column>
				<#if !table.compositeId>
			.append(get${column.columnName}(),other.get${column.columnName}())
				</#if>
			</#list>
			.isEquals();
	}
}