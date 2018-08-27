package heip.generator.generatorplus;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class HeipGeneratorFacade extends GeneratorFacade {
	
	 @Override
	 public void generateByTable(String tableName,String templateRootDir) throws Exception {
	    	new ProcessUtils().processByTable(tableName,templateRootDir,false);
	 }
	 
	 /*@Override
	 private Generator getGenerator(String templateRootDir) {
	    g.setTemplateRootDir(new File(templateRootDir).getAbsoluteFile());
	    return g;
	}*/
	 
	
}
