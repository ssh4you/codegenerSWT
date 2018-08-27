package heip.generator.template;

import cn.org.rapid_framework.generator.GeneratorProperties;

import java.io.File;

/**
 * @author aguu sunyanzi125@sohu.com
 * @Title:
 * @Description:
 * @date 2014/8/30 14:38
 */
public class TemplateProvider {

    private static final String fileSeparator = File.separator;

    public static String getRootTemplate(){
        return GeneratorProperties.getProperty("templateRootDir","TEMPLATE");
    }

    //
    public String getRealTemPath(String tem){
        return getTemplateFileRootPath()+tem;
    }
    /**
     * 模板文件跟目录位置
     */
    private String templateFileRootPath ="" ;


    public void setTemplateFileRootPath(String path){
        this.templateFileRootPath = path;
    }


    protected String getTemplateFileRootPath() {
        return templateFileRootPath;
    }
    /**
     * 取得实体的地址
     * isSub 是否是子表
     * @return
     */
    public static String getJpaTemplateDirPath(){
        String dir = "po";
        return getRootTemplate()+fileSeparator+"ENTITY_TEMPLATE"+fileSeparator+dir;
    }

    /**
     * 取得VO的地址
     * isSub 是否是子表
     * @return
     */
    public static String getDtoTemplateDirPath(boolean isSub){
        String dir = isSub?"subVo":"vo";
        return getRootTemplate()+fileSeparator+"ENTITY_TEMPLATE"+fileSeparator+dir;
    }


    public static String getDAOTemplateDirPath(){
        return getRootTemplate()+fileSeparator+"DAO_TEMPLATE";
    }

    public static String getServiceTemplateDirPath(){
        return getRootTemplate()+fileSeparator+"SERVICE_TEMPLATE";
    }

    public static String getMVCTemplateDirPath(){
        return getRootTemplate()+fileSeparator+"ACTION_TEMPLATE";
    }

    public static String getJSPTemplateDirPath(){
        return getRootTemplate()+fileSeparator+"JSP_TEMPLATE";
    }

}
