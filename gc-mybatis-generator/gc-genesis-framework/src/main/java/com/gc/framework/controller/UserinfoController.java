package com.gc.framework.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gc.framework.model.Userinfo;
import com.gc.framework.service.UserinfoService;
import com.gc.base.BaseController;
import com.gc.base.PageBean;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("userinfo")
public class UserinfoController extends BaseController{

	private Logger log = LoggerFactory.getLogger(UserinfoController.class);

	@Autowired
	private UserinfoService userinfoService;

	@ApiOperation(value = "获取Userinfo信息", notes = "获取Userinfo信息")
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Userinfo> getAll() {
		return userinfoService.selectAll();
	}

	@ApiOperation(value = "获取一个Userinfo信息", notes = "获取一个Userinfo信息")
	@ApiParam(name = "key", value = "UserinfoID", required = true)
	@RequestMapping(value = "getByKey/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Userinfo getByKey(@PathVariable Integer key) {
		return userinfoService.selectByPrimaryKey(key);
	}

	@ApiOperation(value = "查询Userinfo信息", notes = "查询Userinfo信息")
	@RequestMapping(value = "getByConditionPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public PageBean<Userinfo> getByConditionPage(@ApiParam(value = "Userinfo信息", required = false) @RequestBody Userinfo userinfo) {
		List<Userinfo> userinfoList = userinfoService.select(userinfo);
		PageBean<Userinfo> pageBean = new PageBean<Userinfo>(userinfoList);
		return pageBean;
	}

	@ApiOperation(value = "添加Userinfo信息", notes = "添加Userinfo信息")
	@RequestMapping(value = "inster", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap inster(@ApiParam(value = "Userinfo信息", required = false) @RequestBody Userinfo userinfo) {
		ModelMap result = new ModelMap();
		try {
			userinfoService.insert(userinfo);
			result.put("key", userinfo.getId());
		} catch (Exception e) {
			log.error("添加失败", e);
			result.put("error", "添加失败");
		}
		return result;
	}

	@ApiOperation(value = "更新Userinfo信息", notes = "更新Userinfo信息")
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap update(@ApiParam(value = "Userinfo信息", required = false) @RequestBody Userinfo userinfo) {
		ModelMap result = new ModelMap();
		try {
			userinfoService.update(userinfo);
		} catch (Exception e) {
			log.error("更新失败", e);
			result.put("error", "更新失败");
		}
		return result;
	}

	@ApiOperation(value = "更新Userinfo选择信息", notes = "更新Userinfo选择信息")
	@RequestMapping(value = "updateSelective", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap updateByPrimaryKeySelective(@ApiParam(value = "Userinfo信息", required = false) @RequestBody Userinfo userinfo) {
		ModelMap result = new ModelMap();
		try {
			userinfoService.updateByPrimaryKeySelective(userinfo);
		} catch (Exception e) {
			log.error("更新失败", e);
			result.put("error", "更新失败");
		}
		return result;
	}

	@ApiOperation(value = "删除一个Userinfo信息", notes = "删除一个Userinfo信息")
	@ApiParam(name = "key", value = "UserinfoID", required = true)
	@RequestMapping(value = "deleteByKey/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap deleteByKey(@PathVariable Integer key) {
		ModelMap result = new ModelMap();
		try {
			userinfoService.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("删除失败", e);
			result.put("error", "删除失败");
		}
		return result;
	}

	@ApiOperation(value = "删除Userinfo信息", notes = "删除Userinfo信息")
	@RequestMapping(value = "deleteByCriteria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap deleteByCriteria(@ApiParam(value = "Userinfo信息", required = false) @RequestBody Userinfo userinfo) {
		ModelMap result = new ModelMap();
		try {
			userinfoService.deleteByCriteria(userinfo);
		} catch (Exception e) {
			log.error("删除失败", e);
			result.put("error", "删除失败");
		}
		return result;
	}

	@ApiOperation(value = "获取Userinfo数量", notes = "获取Userinfo数量")
	@RequestMapping(value = "selectCount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int selectCount(@ApiParam(value = "Userinfo信息", required = false) @RequestBody Userinfo userinfo) {
		return userinfoService.selectCount(userinfo);
	}
}
