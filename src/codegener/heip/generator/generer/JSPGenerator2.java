package heip.generator.generer;

import freemarker.template.Template;
import heip.generator.entity.TableClazz;
import heip.generator.template.TemplateProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成JSP
 * @author HSWHM
 *
 */
public class JSPGenerator2 extends AbstractGenerator{

	public JSPGenerator2(String moduleName){
		gg.put("moduleName",moduleName);
	}

	private  String singleMain = TemplateProvider.getJSPTemplateDirPath()+"/singleTable/v2";
	private  String twoGrid = TemplateProvider.getJSPTemplateDirPath()+"/singleTable/v2";
	
	private  String singleTree=TemplateProvider.getJSPTemplateDirPath()+"/singleTable/tree";

	public void generatorSingle(TableClazz entityClazz) throws Exception{
		Map map = new HashMap();
		map.put("tableClazz",entityClazz);
		//map.put("entityCnName", entityCnName);
		generator.generateByMap(map,singleMain);
	}
	
	public void generSingleTree(TableClazz entityClazz) throws Exception{
		Map map = new HashMap();
		map.put("tableClazz",entityClazz);
		generator.generateByMap(map,singleTree);	
	}
	
	public void generatorGrid(TableClazz entityClazz) throws Exception{
		Map map = new HashMap();
		map.put("tableClazz",entityClazz);
		generator.generateByMap(map,twoGrid);
	}
	

	/*public void generateJsp4Two(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
		int i=0;
		for(EntityClazz subClass: entityClazz.subClazzes){
			subClazzes[i] = new JavaClass(subClass.clazz);
			subClazzes[i].setFkProperty(subClass.fkProperty);
			i++;
		}
		Map map = new HashMap();
		map.put("subClazzes", subClazzes);
		map.put("clazz",new JavaClass(mainClazz));
		map.put("entityCnName", entityCnName);
		generator.generateByMap(map,temMain);
		
		for(EntityClazz subClass: entityClazz.subClazzes){
			map = new HashMap();
			map.put("clazz",new JavaClass(subClass.clazz));
			map.put("mainClazzId", subClass.fkProperty);
			map.put("fatherClazz",new JavaClass(subClass.fatherClazz.clazz));
			map.put("entityCnName", subClass.entityCnName);
			generator.generateByMap(map, temSub);
		}
	}
	
	public void generateThree(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		Map map = new HashMap();
		*//**
		 * 生成主表的bs
		 *//*
		
		JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
		int i=0;
		for(EntityClazz subClass: entityClazz.subClazzes){
			subClazzes[i] = new JavaClass(subClass.clazz);
			subClazzes[i].setFkProperty(subClass.fkProperty);
			i++;
		}
		map.put("subClazzes", subClazzes);
		map.put("clazz",new JavaClass(mainClazz));
		map.put("entityCnName", entityCnName);
		*//**
		 * 生成主表的Action
		 *//*
		generator.generateByMap(map,threeMain);
		for(EntityClazz subMain: entityClazz.subClazzes){
			map = new HashMap();
			map.put("clazz",new JavaClass(subMain.clazz));
			map.put("mainClazzId", subMain.fkProperty);
			map.put("fatherClazz",new JavaClass(subMain.fatherClazz.clazz));
			map.put("entityCnName", subMain.entityCnName);
			
			subClazzes = new JavaClass[subMain.subClazzes.size()];
			i=0;
			for(EntityClazz subClass: subMain.subClazzes){
				subClazzes[i] = new JavaClass(subClass.clazz);
				subClazzes[i].setFkProperty(subClass.fkProperty);
				i++;
			}
			map.put("subClazzes", subClazzes);
			
			generator.generateByMap(map,threeSubMain);
		}
	}*/
}