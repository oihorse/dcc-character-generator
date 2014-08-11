package com.horsegoeswest.dcc.client.utils;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

public class EventBusUtil {

	private static EventBusUtil instance =  null;

	final EventBus EVENT_BUS = new SimpleEventBus();
	
	private EventBusUtil() {
		
	}

	public static EventBusUtil getInstance() {
	
		if (instance == null){
			instance = new EventBusUtil();
		}
		
		return instance;
	}
	
}
