package heip.generator.main;

import heip.generator.entity.TableClazz;
import heip.generator.generer.AbstractGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aguu sunyanzi125@sohu.com
 * @Title:
 * @Description:
 * @date 2014/10/5 23:25
 */
public class WangsuGenerator extends AbstractGenerator {

    /**
     * 模板信息
     */
    private static String ENTITY_TEM = "TEMPLATE_WANGSU/entity";
    private static String DAO_TEM = "TEMPLATE_WANGSU/dao";
    private static String SERVICE_TEM = "TEMPLATE_WANGSU/service";
    private static String CONTROLLER_TEM = "TEMPLATE_WANGSU/web";


    public static void main(String[] args) throws Exception {
        //需要手动修改的变量 com.cnc.cbss后面的包名
        String moduleName = "param";
        WangsuGenerator eg = new WangsuGenerator(moduleName);
        //
        Map<String, GenerationType> tableMap = new HashMap<String, GenerationType>();
        tableMap.put("FIRST_PANAL_GOODS", GenerationType.UUID);
        //tableMap.put("SWIPER_DETAIL", GenerationType.UUID);







        eg.generatorEntity(tableMap);
        eg.generatorDao(tableMap);
        eg.generatorService(tableMap);
        open();
    }

    public WangsuGenerator(String moduleName) {
        gg.put("moduleName", moduleName);
    }

    /**
     * 生成PO
     *
     * @param
     * @param
     * @throws Exception
     */
    public void generatorEntityAndDao(Map<String, GenerationType> tableMap) throws Exception {

        for (Map.Entry<String, GenerationType> entry : tableMap.entrySet()) {
            String tableName = entry.getKey();
            GenerationType generationType = entry.getValue();

            gg.put("generationType", generationType.toString());
            generator.generateByTable(tableName, ENTITY_TEM);


            TableClazz tableClazz = new TableClazz(tableName);
            Map map = new HashMap();
            map.put("tableClazz", tableClazz);
            generator.generateByMap(map, DAO_TEM);
        }
    }

    public void generatorEntity(Map<String, GenerationType> tableMap) throws Exception {

        for (Map.Entry<String, GenerationType> entry : tableMap.entrySet()) {
            String tableName = entry.getKey();
            GenerationType generationType = entry.getValue();

            gg.put("generationType", generationType.toString());
            generator.generateByTable(tableName, ENTITY_TEM);

        }
    }

    public void generatorDao(Map<String, GenerationType> tableMap) throws Exception {

        for (Map.Entry<String, GenerationType> entry : tableMap.entrySet()) {
            String tableName = entry.getKey();

            TableClazz tableClazz = new TableClazz(tableName);
            Map map = new HashMap();
            map.put("tableClazz", tableClazz);
            generator.generateByMap(map, DAO_TEM);
        }
    }

    public void generatorService(Map<String, GenerationType> tableMap) throws Exception {

        for (Map.Entry<String, GenerationType> entry : tableMap.entrySet()) {
            String tableName = entry.getKey();
            TableClazz tableClazz = new TableClazz(tableName);
            Map map = new HashMap();
            map.put("tableClazz", tableClazz);
            generator.generateByMap(map, SERVICE_TEM);
        }
    }

    public void generatorController(Map<String, GenerationType> tableMap) throws Exception {

        for (Map.Entry<String, GenerationType> entry : tableMap.entrySet()) {
            String tableName = entry.getKey();
            TableClazz tableClazz = new TableClazz(tableName);
            Map map = new HashMap();
            map.put("tableClazz", tableClazz);
            generator.generateByMap(map, CONTROLLER_TEM);
        }
    }

    private enum GenerationType {
        AUTO,//自动递增
        UUID//UUID
    }
}

