package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gc.sender.SecWorkersSender;

@RestController
@RequestMapping("sec")
public class SecWorkerController {
	
	@Autowired
	private SecWorkersSender secWorkersSender;
	
	@RequestMapping(value = "send", method = RequestMethod.GET)
	public ModelMap helloSender(String par) {
		ModelMap map = new ModelMap();
		secWorkersSender.send();
		map.put("code", 0);
		map.put("msg", "SUCCESS");
		return map;
	}

}
