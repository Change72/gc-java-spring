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

import com.gc.framework.model.TblUser;
import com.gc.framework.service.TblUserService;
import com.gc.base.BaseController;
import com.gc.base.PageBean;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("tblUser")
public class TblUserController extends BaseController{

	private Logger log = LoggerFactory.getLogger(TblUserController.class);

	@Autowired
	private TblUserService tblUserService;

	@ApiOperation(value = "获取TblUser信息", notes = "获取TblUser信息")
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TblUser> getAll() {
		return tblUserService.selectAll();
	}

	@ApiOperation(value = "获取一个TblUser信息", notes = "获取一个TblUser信息")
	@ApiParam(name = "key", value = "TblUserID", required = true)
	@RequestMapping(value = "getByKey/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TblUser getByKey(@PathVariable Integer key) {
		return tblUserService.selectByPrimaryKey(key);
	}

	@ApiOperation(value = "查询TblUser信息", notes = "查询TblUser信息")
	@RequestMapping(value = "getByConditionPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public PageBean<TblUser> getByConditionPage(@ApiParam(value = "TblUser信息", required = false) @RequestBody TblUser tblUser) {
		List<TblUser> tblUserList = tblUserService.select(tblUser);
		PageBean<TblUser> pageBean = new PageBean<TblUser>(tblUserList);
		return pageBean;
	}

	@ApiOperation(value = "添加TblUser信息", notes = "添加TblUser信息")
	@RequestMapping(value = "inster", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap inster(@ApiParam(value = "TblUser信息", required = false) @RequestBody TblUser tblUser) {
		ModelMap result = new ModelMap();
		try {
			tblUserService.insert(tblUser);
			result.put("key", tblUser.getId());
		} catch (Exception e) {
			log.error("添加失败", e);
			result.put("error", "添加失败");
		}
		return result;
	}

	@ApiOperation(value = "更新TblUser信息", notes = "更新TblUser信息")
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap update(@ApiParam(value = "TblUser信息", required = false) @RequestBody TblUser tblUser) {
		ModelMap result = new ModelMap();
		try {
			tblUserService.update(tblUser);
		} catch (Exception e) {
			log.error("更新失败", e);
			result.put("error", "更新失败");
		}
		return result;
	}

	@ApiOperation(value = "更新TblUser选择信息", notes = "更新TblUser选择信息")
	@RequestMapping(value = "updateSelective", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap updateByPrimaryKeySelective(@ApiParam(value = "TblUser信息", required = false) @RequestBody TblUser tblUser) {
		ModelMap result = new ModelMap();
		try {
			tblUserService.updateByPrimaryKeySelective(tblUser);
		} catch (Exception e) {
			log.error("更新失败", e);
			result.put("error", "更新失败");
		}
		return result;
	}

	@ApiOperation(value = "删除一个TblUser信息", notes = "删除一个TblUser信息")
	@ApiParam(name = "key", value = "TblUserID", required = true)
	@RequestMapping(value = "deleteByKey/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap deleteByKey(@PathVariable Integer key) {
		ModelMap result = new ModelMap();
		try {
			tblUserService.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("删除失败", e);
			result.put("error", "删除失败");
		}
		return result;
	}

	@ApiOperation(value = "删除TblUser信息", notes = "删除TblUser信息")
	@RequestMapping(value = "deleteByCriteria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap deleteByCriteria(@ApiParam(value = "TblUser信息", required = false) @RequestBody TblUser tblUser) {
		ModelMap result = new ModelMap();
		try {
			tblUserService.deleteByCriteria(tblUser);
		} catch (Exception e) {
			log.error("删除失败", e);
			result.put("error", "删除失败");
		}
		return result;
	}

	@ApiOperation(value = "获取TblUser数量", notes = "获取TblUser数量")
	@RequestMapping(value = "selectCount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int selectCount(@ApiParam(value = "TblUser信息", required = false) @RequestBody TblUser tblUser) {
		return tblUserService.selectCount(tblUser);
	}
}
