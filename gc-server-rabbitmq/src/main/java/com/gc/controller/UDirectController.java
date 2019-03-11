package com.gc.controller;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gc.receiver.UTestReceiver;
import com.gc.sender.UDirectSender;

@RestController
@RequestMapping("fourth")
public class UDirectController {
	@Autowired
	private UDirectSender uDirectSender;
	
	@Autowired
	private UTestReceiver uTestReceiver;
	
	@RequestMapping(value = "send", method = RequestMethod.GET)
	public ModelMap helloSender(String par) throws IOException, TimeoutException {
		ModelMap map = new ModelMap();
		uDirectSender.send();
		map.put("code", 0);
		map.put("msg", "SUCCESS");
		uTestReceiver.secondReceiver();
		return map;
	}
}
