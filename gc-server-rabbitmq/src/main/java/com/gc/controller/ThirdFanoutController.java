package com.gc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gc.sender.ThirdFanoutSender;



@RestController
@RequestMapping("third")
public class ThirdFanoutController {

	@Autowired 
	private Queue autoDeleteQueue1;
	
	@Autowired 
	private Queue autoDeleteQueue2;
	
	@Autowired
	private ThirdFanoutSender thirdFanoutSender;
	
	@RequestMapping(value = "send", method = RequestMethod.GET)
	public ModelMap helloSender(String par) {
		ModelMap map = new ModelMap();
		thirdFanoutSender.send();
		map.put("code", 0);
		map.put("msg", "SUCCESS");
		return map;
	}
	
	
	@RequestMapping(value = "names", method = RequestMethod.GET)
	public List<String> queueNames(){
		List<String> names = new ArrayList<String>();
		names.add(autoDeleteQueue1.getName());
		names.add(autoDeleteQueue2.getName());
		return names;
	}
}
