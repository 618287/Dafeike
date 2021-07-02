package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.domain.TblDicType;
import com.bjpowernode.crm.settings.mapper.TblDicTypeMapper;
import com.bjpowernode.crm.settings.service.DicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/9
 */
@Service
public class DicTypeServiceimpl implements DicTypeService {
    @Autowired
    private TblDicTypeMapper tblDicTypeMapper;


    @Override
    public List<TblDicType> selectAllDicTypeService() {
        return tblDicTypeMapper.selectAllDicType();
    }

    @Override
    public int insertDicTypeService(TblDicType type) {
        return tblDicTypeMapper.insertDicType(type);
    }

    @Override
    public int updateDicTypeService(TblDicType type) {
        return tblDicTypeMapper.updateDicType(type);
    }

    @Override
    public int deleteDicTypeService(String[] code) {
        return tblDicTypeMapper.deleteDicType(code);
    }

    @Override
    public TblDicType selectDicTypeIdService(String code) {
        return tblDicTypeMapper.selectDicTypeId(code);
    }
}
