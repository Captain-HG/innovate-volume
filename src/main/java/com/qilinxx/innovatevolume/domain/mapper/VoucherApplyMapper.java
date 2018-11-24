package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface VoucherApplyMapper extends Mapper<VoucherApply> {
    /** 根据科技企业的id，查询所有记录*/
    List<VoucherApply> selectAllByEnterpriseId(String id);
}