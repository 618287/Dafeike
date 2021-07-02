package com.bjpowernode.crm.settings.service;


import com.bjpowernode.crm.settings.domain.TblDicType;

import java.util.List;

/**
 * 杨树贤
 * 2021/6/9
 */
public interface DicTypeService {
    //查询全部字典值
    List<TblDicType> selectAllDicTypeService();

    //增加字典值
    int
    insertDicTypeService(TblDicType type);

    //修改字典值
    int updateDicTypeService(TblDicType type);

    //批量删除
    int deleteDicTypeService(String[] code);

    //根据编码查询字典值
    TblDicType selectDicTypeIdService(String code);
}
