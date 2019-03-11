package com.gc.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.framework.mapper.UserinfoMapper;
import com.gc.framework.model.Userinfo;
import com.gc.framework.model.UserinfoCriteria;
import com.gc.framework.model.UserinfoCriteria.Criteria;
import com.gc.framework.service.UserinfoService;
import com.github.pagehelper.PageHelper;

@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoMapper userinfoMapper;

	@Override
	public List<Userinfo> select(Userinfo userinfo) {
		UserinfoCriteria userinfoCriteria = new UserinfoCriteria();
		Criteria criteria = userinfoCriteria.createCriteria();
		//标识
		if (userinfo.getId() != null && !userinfo.getId().equals("")) {
			criteria.andIdEqualTo(userinfo.getId());
		}
		//用户id
		if (userinfo.getUid() != null && !userinfo.getUid().equals("")) {
			criteria.andUidEqualTo(userinfo.getUid());
		}
		//用户名
		if (userinfo.getUsername() != null && !userinfo.getUsername().equals("")) {
			criteria.andUsernameEqualTo(userinfo.getUsername());
		}
		//用户性别
		if (userinfo.getSex() != null && !userinfo.getSex().equals("")) {
			criteria.andSexEqualTo(userinfo.getSex());
		}
		//用户城市
		if (userinfo.getCity() != null && !userinfo.getCity().equals("")) {
			criteria.andCityEqualTo(userinfo.getCity());
		}
		//创建时间
		if (userinfo.getCreatetime() != null && !userinfo.getCreatetime().equals("")) {
			criteria.andCreatetimeEqualTo(userinfo.getCreatetime());
		}
		//order
		if(userinfo.getSortby()!=null&&userinfo.getOrder()!=null){
			userinfoCriteria.setOrderByClause(userinfo.getSortby()+" "+userinfo.getOrder());
		}
		//pager
		if (userinfo.getPage() != null && userinfo.getRows() != null) {
			PageHelper.startPage(userinfo.getPage(), userinfo.getRows());
		}
		return userinfoMapper.selectByExample(userinfoCriteria);	
	}

	@Override
	public List<Userinfo> selectAll() {
		return userinfoMapper.selectByExample(null);
	}

	@Override
	public Userinfo selectByPrimaryKey(Integer key) {
		return userinfoMapper.selectByPrimaryKey(key);
	}

	@Override
	public int selectCount(Userinfo userinfo) {
		UserinfoCriteria userinfoCriteria = new UserinfoCriteria();
		Criteria criteria = userinfoCriteria.createCriteria();
		//标识
		if (userinfo.getId() != null && !userinfo.getId().equals("")) {
			criteria.andIdEqualTo(userinfo.getId());
		}
		//用户id
		if (userinfo.getUid() != null && !userinfo.getUid().equals("")) {
			criteria.andUidEqualTo(userinfo.getUid());
		}
		//用户名
		if (userinfo.getUsername() != null && !userinfo.getUsername().equals("")) {
			criteria.andUsernameEqualTo(userinfo.getUsername());
		}
		//用户性别
		if (userinfo.getSex() != null && !userinfo.getSex().equals("")) {
			criteria.andSexEqualTo(userinfo.getSex());
		}
		//用户城市
		if (userinfo.getCity() != null && !userinfo.getCity().equals("")) {
			criteria.andCityEqualTo(userinfo.getCity());
		}
		//创建时间
		if (userinfo.getCreatetime() != null && !userinfo.getCreatetime().equals("")) {
			criteria.andCreatetimeEqualTo(userinfo.getCreatetime());
		}
		return userinfoMapper.countByExample(userinfoCriteria);
	}

	@Override
	public List<Userinfo> selectByCriteria(Userinfo userinfo) {
		UserinfoCriteria userinfoCriteria = new UserinfoCriteria();
		Criteria criteria = userinfoCriteria.createCriteria();
		//标识
		if (userinfo.getId() != null && !userinfo.getId().equals("")) {
			criteria.andIdEqualTo(userinfo.getId());
		}
		//用户id
		if (userinfo.getUid() != null && !userinfo.getUid().equals("")) {
			criteria.andUidEqualTo(userinfo.getUid());
		}
		//用户名
		if (userinfo.getUsername() != null && !userinfo.getUsername().equals("")) {
			criteria.andUsernameEqualTo(userinfo.getUsername());
		}
		//用户性别
		if (userinfo.getSex() != null && !userinfo.getSex().equals("")) {
			criteria.andSexEqualTo(userinfo.getSex());
		}
		//用户城市
		if (userinfo.getCity() != null && !userinfo.getCity().equals("")) {
			criteria.andCityEqualTo(userinfo.getCity());
		}
		//创建时间
		if (userinfo.getCreatetime() != null && !userinfo.getCreatetime().equals("")) {
			criteria.andCreatetimeEqualTo(userinfo.getCreatetime());
		}
		return userinfoMapper.selectByExample(userinfoCriteria);
	}

	@Override
	public int insert(Userinfo userinfo) {
		return userinfoMapper.insert(userinfo);
	}

	@Override
	public int update(Userinfo userinfo) {
		return userinfoMapper.updateByPrimaryKey(userinfo);
	}

	@Override
	public int updateByPrimaryKeySelective(Userinfo userinfo) {
		return userinfoMapper.updateByPrimaryKeySelective(userinfo);
	}

	@Override
	public int deleteByPrimaryKey(Integer key) {
		return userinfoMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int deleteByCriteria(Userinfo userinfo) {
		UserinfoCriteria userinfoCriteria = new UserinfoCriteria();
		Criteria criteria = userinfoCriteria.createCriteria();
		//标识
		if (userinfo.getId() != null && !userinfo.getId().equals("")) {
			criteria.andIdEqualTo(userinfo.getId());
		}
		//用户id
		if (userinfo.getUid() != null && !userinfo.getUid().equals("")) {
			criteria.andUidEqualTo(userinfo.getUid());
		}
		//用户名
		if (userinfo.getUsername() != null && !userinfo.getUsername().equals("")) {
			criteria.andUsernameEqualTo(userinfo.getUsername());
		}
		//用户性别
		if (userinfo.getSex() != null && !userinfo.getSex().equals("")) {
			criteria.andSexEqualTo(userinfo.getSex());
		}
		//用户城市
		if (userinfo.getCity() != null && !userinfo.getCity().equals("")) {
			criteria.andCityEqualTo(userinfo.getCity());
		}
		//创建时间
		if (userinfo.getCreatetime() != null && !userinfo.getCreatetime().equals("")) {
			criteria.andCreatetimeEqualTo(userinfo.getCreatetime());
		}
		return userinfoMapper.deleteByExample(userinfoCriteria);
	}

}
