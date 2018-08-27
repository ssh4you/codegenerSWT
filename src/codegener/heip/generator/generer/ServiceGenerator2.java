package heip.generator.generer;

import heip.generator.entity.TableClazz;
import heip.generator.template.TemplateProvider;

import java.util.HashMap;
import java.util.Map;




/**
 * 生成service类
 * @author HSWHM
 *
 */
public class ServiceGenerator2 extends AbstractGenerator{

	public  ServiceGenerator2(String moduleName){
		gg.put("moduleName",moduleName);
	}

	public void generatorSingleBS(TableClazz entityTable) throws Exception{
		generaGrid(entityTable);
	}
	public void generaGrid(TableClazz tableClass) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tableClazz", tableClass);
		generator.generateByMap(map, gridMainTem);
		for(TableClazz subClass: tableClass.getSubClazzes()){
			generaSubGrid(subClass,tableClass);
		}
	}
	public void generaSubGrid(TableClazz subClass,TableClazz fatherClazz) throws Exception{
		Map map = new HashMap();		
		map.put("clazz",subClass);
		map.put("mainClazzId",subClass.getFkProperty().getName());
		map.put("fatherClazz", fatherClazz);
		map.put("entityCnName", subClass.getTableAlias());
		generator.generateByMap(map,gridSubTem);
	}
	private String gridMainTem= TemplateProvider.getServiceTemplateDirPath()+"/twoTable/grid/main";
	private String gridSubTem= TemplateProvider.getServiceTemplateDirPath()+"/twoTable/grid/sub";
	//private String cacheMainTem= "TEMPLATE_1.0/SERVICE_TEMPLATE/twoTable/temTable/main";
	//private String cacheSubTem= "TEMPLATE_1.0/SERVICE_TEMPLATE/twoTable/temTable/sub";
	/*private String threeMain= cacheMainTem;
	private static final String threeSubMain= "TEMPLATE_1.0/SERVICE_TEMPLATE/threeTable/submain";
	private static final String threeSub= "TEMPLATE_1.0/SERVICE_TEMPLATE/threeTable/sub";*/
}