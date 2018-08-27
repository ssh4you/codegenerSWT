<#include "common_var.include"/> 
package ${basepackage}.${moduleName}.dao.mapper;

import ${basepackage}.${moduleName}.entity.${className};
import herb.modules.repository.mybatis.CommonMapper;
import herb.modules.repository.mybatis.annotation.MyBatisRepository;
/**
*
*${entityCnName}Dao
*
*/
@MyBatisRepository
public interface ${className}Mapper extends CommonMapper<${className}>{
	
}