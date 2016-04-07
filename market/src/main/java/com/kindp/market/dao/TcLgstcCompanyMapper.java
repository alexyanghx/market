package com.kindp.market.dao;

import com.kindp.market.model.TcLgstcCompany;

public interface TcLgstcCompanyMapper {
    int deleteByPrimaryKey(Long lgstcCompId);

    int insert(TcLgstcCompany record);

    int insertSelective(TcLgstcCompany record);

    TcLgstcCompany selectByPrimaryKey(Long lgstcCompId);

    int updateByPrimaryKeySelective(TcLgstcCompany record);

    int updateByPrimaryKey(TcLgstcCompany record);
}