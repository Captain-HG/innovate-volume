package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.Voucher;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface VoucherMapper extends Mapper<Voucher>{
     /** 根据提供商id，查询他的所有券*/
    List<Voucher> selectAllByProviderId(String id);
}