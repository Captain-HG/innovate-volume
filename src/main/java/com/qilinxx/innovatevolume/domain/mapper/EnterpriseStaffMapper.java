package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.EnterpriseStaff;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface EnterpriseStaffMapper extends Mapper<EnterpriseStaff> {
    /** 根据科技企业id，查询所有人员*/
    List<EnterpriseStaff> selectAllByEnterpriseId(String id);
}