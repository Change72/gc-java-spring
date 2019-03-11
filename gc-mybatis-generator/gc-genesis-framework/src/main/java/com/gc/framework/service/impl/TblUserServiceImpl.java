package com.gc.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.framework.mapper.TblUserMapper;
import com.gc.framework.model.TblUser;
import com.gc.framework.model.TblUserCriteria;
import com.gc.framework.model.TblUserCriteria.Criteria;
import com.gc.framework.service.TblUserService;
import com.github.pagehelper.PageHelper;

@Service
public class TblUserServiceImpl implements TblUserService {

	@Autowired
	private TblUserMapper tblUserMapper;

	@Override
	public List<TblUser> select(TblUser tblUser) {
		TblUserCriteria tblUserCriteria = new TblUserCriteria();
		Criteria criteria = tblUserCriteria.createCriteria();
		//
		if (tblUser.getUserId() != null && !tblUser.getUserId().equals("")) {
			criteria.andUserIdEqualTo(tblUser.getUserId());
		}
		//
		if (tblUser.getUserName() != null && !tblUser.getUserName().equals("")) {
			criteria.andUserNameEqualTo(tblUser.getUserName());
		}
		//
		if (tblUser.getUserAge() != null && !tblUser.getUserAge().equals("")) {
			criteria.andUserAgeEqualTo(tblUser.getUserAge());
		}
		//order
		if(tblUser.getSortby()!=null&&tblUser.getOrder()!=null){
			tblUserCriteria.setOrderByClause(tblUser.getSortby()+" "+tblUser.getOrder());
		}
		//pager
		if (tblUser.getPage() != null && tblUser.getRows() != null) {
			PageHelper.startPage(tblUser.getPage(), tblUser.getRows());
		}
		return tblUserMapper.selectByExample(tblUserCriteria);	
	}

	@Override
	public List<TblUser> selectAll() {
		return tblUserMapper.selectByExample(null);
	}

	@Override
	public TblUser selectByPrimaryKey(Integer key) {
		return tblUserMapper.selectByPrimaryKey(key);
	}

	@Override
	public int selectCount(TblUser tblUser) {
		TblUserCriteria tblUserCriteria = new TblUserCriteria();
		Criteria criteria = tblUserCriteria.createCriteria();
		//
		if (tblUser.getUserId() != null && !tblUser.getUserId().equals("")) {
			criteria.andUserIdEqualTo(tblUser.getUserId());
		}
		//
		if (tblUser.getUserName() != null && !tblUser.getUserName().equals("")) {
			criteria.andUserNameEqualTo(tblUser.getUserName());
		}
		//
		if (tblUser.getUserAge() != null && !tblUser.getUserAge().equals("")) {
			criteria.andUserAgeEqualTo(tblUser.getUserAge());
		}
		return tblUserMapper.countByExample(tblUserCriteria);
	}

	@Override
	public List<TblUser> selectByCriteria(TblUser tblUser) {
		TblUserCriteria tblUserCriteria = new TblUserCriteria();
		Criteria criteria = tblUserCriteria.createCriteria();
		//
		if (tblUser.getUserId() != null && !tblUser.getUserId().equals("")) {
			criteria.andUserIdEqualTo(tblUser.getUserId());
		}
		//
		if (tblUser.getUserName() != null && !tblUser.getUserName().equals("")) {
			criteria.andUserNameEqualTo(tblUser.getUserName());
		}
		//
		if (tblUser.getUserAge() != null && !tblUser.getUserAge().equals("")) {
			criteria.andUserAgeEqualTo(tblUser.getUserAge());
		}
		return tblUserMapper.selectByExample(tblUserCriteria);
	}

	@Override
	public int insert(TblUser tblUser) {
		return tblUserMapper.insert(tblUser);
	}

	@Override
	public int update(TblUser tblUser) {
		return tblUserMapper.updateByPrimaryKey(tblUser);
	}

	@Override
	public int updateByPrimaryKeySelective(TblUser tblUser) {
		return tblUserMapper.updateByPrimaryKeySelective(tblUser);
	}

	@Override
	public int deleteByPrimaryKey(Integer key) {
		return tblUserMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int deleteByCriteria(TblUser tblUser) {
		TblUserCriteria tblUserCriteria = new TblUserCriteria();
		Criteria criteria = tblUserCriteria.createCriteria();
		//
		if (tblUser.getUserId() != null && !tblUser.getUserId().equals("")) {
			criteria.andUserIdEqualTo(tblUser.getUserId());
		}
		//
		if (tblUser.getUserName() != null && !tblUser.getUserName().equals("")) {
			criteria.andUserNameEqualTo(tblUser.getUserName());
		}
		//
		if (tblUser.getUserAge() != null && !tblUser.getUserAge().equals("")) {
			criteria.andUserAgeEqualTo(tblUser.getUserAge());
		}
		return tblUserMapper.deleteByExample(tblUserCriteria);
	}

}
