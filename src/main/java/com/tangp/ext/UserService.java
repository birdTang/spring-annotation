package com.tangp.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@EventListener
	public void listener(ApplicationEvent event) {
		System.out.println("UserService 收到的事件："+ event);
	}
}
