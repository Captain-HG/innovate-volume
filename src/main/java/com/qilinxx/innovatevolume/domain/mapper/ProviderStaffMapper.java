package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.ProviderStaff;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProviderStaffMapper extends Mapper<ProviderStaff>{
    /** 根据商家id查询对象*/
    List<ProviderStaff> selectAllByProviderId(String id);
}