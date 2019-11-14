package com.tangp.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	/**
	 * 返回值，就是要导入到容器中的组件全类名
	 * AnnotationMetadata：当前标注@Import类的所有注解信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//不要返回null,否则会抛空指针
		
		return new String[] {"com.tangp.bean.register.Bule","com.tangp.bean..register.Yellow"};
	}

}
