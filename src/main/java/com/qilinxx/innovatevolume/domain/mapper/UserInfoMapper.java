package com.qilinxx.innovatevolume.domain.mapper;

import com.qilinxx.innovatevolume.domain.model.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
    /**根据code公司编号查询*/
    UserInfo selectByCode(String code);
}