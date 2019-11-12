package com.tangp.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		// TODO 判断死不是window 环境
				Environment environment = context.getEnvironment();
				if(environment.getProperty("os.name").contains("linux")) 
					return true;
		return false;
	}

}
