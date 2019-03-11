package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gc.sender.WCSClient;

@RestController
@RequestMapping("sixth")
public class WCSController {
	@Autowired
	private WCSClient wCSClient;
	
	@RequestMapping(value = "send", method = RequestMethod.GET)
	public ModelMap helloSender(String par) {
		ModelMap map = new ModelMap();
		wCSClient.send();
		map.put("code", 0);
		map.put("msg", "SUCCESS");
		return map;
	}
}
