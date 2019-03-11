package com.gc.framework.mapper;

import com.gc.framework.model.TblUser;
import com.gc.framework.model.TblUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserMapper {
    int countByExample(TblUserCriteria example);

    int deleteByExample(TblUserCriteria example);

    int deleteByPrimaryKey(Long userId);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    List<TblUser> selectByExample(TblUserCriteria example);

    TblUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TblUser record, @Param("example") TblUserCriteria example);

    int updateByExample(@Param("record") TblUser record, @Param("example") TblUserCriteria example);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);
}