package heip.generator.generer;

import heip.generator.entity.TableClazz;
import heip.generator.template.TemplateProvider;

import java.util.HashMap;
import java.util.Map;

/**
 *@author HSWHM
 */
public class ActionGenerator2 extends AbstractGenerator {

    /******************************************************/

    public ActionGenerator2(String moduleName) {
        gg.put("moduleName", moduleName);
    }

    private String formWithGridTem = TemplateProvider.getMVCTemplateDirPath()+"/twoTable/grid/main";
    //private static final String twoTemMain = TemplateProvider.getServiceTemplateDirPath()+"/twoTable/temTable/main";
    //private static final String twoTemSub = TemplateProvider.getServiceTemplateDirPath()+"/twoTable/temTable/sub";

    //private static final String threeMain = twoTemMain;
    //private static final String threeSubMain = TemplateProvider.getServiceTemplateDirPath()+"/threeTable/sub";

    /*public void generaSingleAndGrid(TableClazz entityClazz) throws Exception {
        generatorGrid(entityClazz);
    }*/

    public void generatorFormWithGrid(TableClazz entityClazz) throws Exception {
        Map map = new HashMap();
        map.put("tableClazz", entityClazz);
        generator.generateByMap(map, formWithGridTem);
    }

    /*public void generateTem4Two(EntityClazz entityClazz) throws Exception {
        Class mainClazz = entityClazz.clazz;
        String entityCnName = entityClazz.entityCnName;
        Map map = new HashMap();
        *//**
         * 生成主表的bs
         *//*

        JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
        int i = 0;
        for (EntityClazz subClass : entityClazz.subClazzes) {
            subClazzes[i] = new JavaClass(subClass.clazz);
            subClazzes[i].setFkProperty(subClass.fkProperty);
            i++;
        }
        map.put("subClazzes", subClazzes);
        map.put("clazz", new JavaClass(mainClazz));
        map.put("entityCnName", entityCnName);
        *//**
         * 生成主表的Action
         *//*
        generator.generateByMap(map, twoTemMain);
        for (EntityClazz subClass : entityClazz.subClazzes) {
            map = new HashMap();
            map.put("clazz", new JavaClass(subClass.clazz));
            map.put("mainClazzId", subClass.fkProperty);
            map.put("fatherClazz", new JavaClass(subClass.fatherClazz.clazz));
            map.put("entityCnName", subClass.entityCnName);
            generator.generateByMap(map, twoTemSub);
        }
    }*/

    /*public void generateThree(EntityClazz entityClazz) throws Exception {
        Class mainClazz = entityClazz.clazz;
        String entityCnName = entityClazz.entityCnName;
        Map map = new HashMap();
        *//**
         * 生成主表的bs
         *//*

        JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
        int i = 0;
        for (EntityClazz subClass : entityClazz.subClazzes) {
            subClazzes[i] = new JavaClass(subClass.clazz);
            subClazzes[i].setFkProperty(subClass.fkProperty);
            i++;
        }
        map.put("subClazzes", subClazzes);
        map.put("clazz", new JavaClass(mainClazz));
        map.put("entityCnName", entityCnName);
        *//**
         * 生成主表的Action
         *//*
        generator.generateByMap(map, threeMain);
        for (EntityClazz subMain : entityClazz.subClazzes) {
            map = new HashMap();
            map.put("clazz", new JavaClass(subMain.clazz));
            map.put("mainClazzId", subMain.fkProperty);
            map.put("fatherClazz", new JavaClass(subMain.fatherClazz.clazz));
            map.put("entityCnName", subMain.entityCnName);

            subClazzes = new JavaClass[subMain.subClazzes.size()];
            i = 0;
            for (EntityClazz subClass : subMain.subClazzes) {
                subClazzes[i] = new JavaClass(subClass.clazz);
                subClazzes[i].setFkProperty(subClass.fkProperty);
                i++;
            }
            map.put("subClazzes", subClazzes);

            generator.generateByMap(map, threeSubMain);
        }
    }*/
}