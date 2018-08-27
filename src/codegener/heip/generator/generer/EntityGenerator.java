package heip.generator.generer;

import heip.generator.entity.EntityTable;
import heip.generator.template.TemplateProvider;

/**
 * 实体生成
 * @author aguu
 *
 *
 */
public class EntityGenerator extends AbstractGenerator{
    /**模板信息*/
    private static String poTem = TemplateProvider.getJpaTemplateDirPath();
    private static String voTem = TemplateProvider.getDtoTemplateDirPath(false);
    private static String subVoTem = TemplateProvider.getDtoTemplateDirPath(true);

    public enum GenerationType{
		UUID,
		IDENTITY,
		SEQUENCE,
        AUTO
    }
	
	/*
	public static void main(String[] args) throws Exception{
		EulerGenerator eg = new EulerGenerator();
		eg.execute();
		open();}

	public void execute() throws Exception{
		//EntityTable ss = new EntityTable("tc_pick_notice_place_dtl", "notice_detail_id");
		//EntityTable sub1 = new EntityTable("tc_pick_notice_dtl", "notice_id",ss);
		EntityTable mainTable = new EntityTable("BM_CODE_TYPE");
		
		generatorPO(new EntityTable[]{mainTable},true);
		generatorVO(new EntityTable[]{mainTable},true);
		
		//generatorPO(new EntityTable[]{sub1,ss},false);
		//generatorVO(new EntityTable[]{sub1,ss},true);
	
	}*/

	/*public EntityGenerator(){
		gg.put("moduleName",moduleName);
	}*/
	public EntityGenerator(String moduleName){
		gg.put("moduleName",moduleName);
	}
	
	
	/**
	 * 生成PO
	 * @param
	 * @param tables
	 * @throws Exception
	 */
	public void generatorPO(EntityTable[] tables,GenerationType idType) throws Exception{
        idType = idType == null? GenerationType.AUTO:idType;
        gg.put("generationType",idType.toString());
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();
            generator.generateByTable(mainTableName,poTem);
			/*if(sequence){
				generator.generateByTable(mainTableName,poTem);
			}else{
				generator.generateByTable(mainTableName,subPoTem);
			}*/
		}
	}
	
	public void generatorVO(EntityTable[] tables,boolean isTem) throws Exception{
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();
			if(isTem){
				String foreignKey = table.getFkColumn();
				gg.put("foreignKey", foreignKey);
				generator.generateByTable(mainTableName,subVoTem);
			}else{
				generator.generateByTable(mainTableName,voTem);
			}
		}
	}
	
}