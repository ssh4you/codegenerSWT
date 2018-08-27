package heip.generator.generer;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import heip.generator.generatorplus.HeipGeneratorFacade;

public abstract class AbstractGenerator {

    protected HeipGeneratorFacade generator = new HeipGeneratorFacade();
    protected GeneratorFacade.GeneratorContext gg = new GeneratorFacade.GeneratorContext();

    //打开
    protected static void open() throws Exception {
        Runtime.getRuntime().exec("cmd.exe /c start "
                + GeneratorProperties.getRequiredProperty("outRoot"));
    }


    /**
     * 设置环境变量
     *
     * @param key
     * @param value
     */
    public void setContextPrpperty(String key, Object value) {
        gg.put(key, value);
    }
}