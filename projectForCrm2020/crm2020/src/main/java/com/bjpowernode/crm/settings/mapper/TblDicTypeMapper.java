package com.bjpowernode.crm.settings.mapper;


import com.bjpowernode.crm.settings.domain.TblDicType;
import com.bjpowernode.crm.settings.domain.TblDicTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblDicTypeMapper {
    int countByExample(TblDicTypeExample example);

    int deleteByExample(TblDicTypeExample example);

    int deleteByPrimaryKey(String code);

    int insert(TblDicType record);

    int insertSelective(TblDicType record);

    List<TblDicType> selectByExample(TblDicTypeExample example);

    TblDicType selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") TblDicType record, @Param("example") TblDicTypeExample example);

    int updateByExample(@Param("record") TblDicType record, @Param("example") TblDicTypeExample example);

    int updateByPrimaryKeySelective(TblDicType record);

    int updateByPrimaryKey(TblDicType record);

    //查询全部字典值
    List<TblDicType> selectAllDicType();

    //增加字典值
    int
    insertDicType(TblDicType type);

    //修改字典值
    int updateDicType(TblDicType type);

    //批量删除
    int deleteDicType(String[] code);

    //根据编码查询字典值
    TblDicType selectDicTypeId(String code);
}