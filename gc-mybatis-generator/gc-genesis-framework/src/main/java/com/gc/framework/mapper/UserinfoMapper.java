package com.gc.framework.mapper;

import com.gc.framework.model.Userinfo;
import com.gc.framework.model.UserinfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    int countByExample(UserinfoCriteria example);

    int deleteByExample(UserinfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExample(UserinfoCriteria example);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoCriteria example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoCriteria example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}