package com.zly.mapper;

import com.zly.pojo.Store;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface StoreMapper extends MyMapper<Store> {

    @Select("select address,phone_number as phoneNumber,legal_person as legalPerson from store where id = #{id}")
    public Store findStoreById(Integer id);
}