<#include "common_var.include"/>
package ${basepackage}.${moduleName}.service.impl;

import herb.modules.service.domainservice.DomainService;
import herb.modules.service.domainservice.impl.SingleDomainServiceSupport;
import ${basepackage}.${moduleName}.service.${className}Service;
import ${basepackage}.${moduleName}.entity.${className};
import herb.modules.exception.BizException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import java.text.MessageFormat;
/**
*
*
*
*/
@Service
public class ${className}ServiceImpl
        extends SingleDomainServiceSupport<${className}> implements ${className}Service{

}