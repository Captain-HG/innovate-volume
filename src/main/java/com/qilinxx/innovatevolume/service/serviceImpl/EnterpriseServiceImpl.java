package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseMapper;
import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
     @Autowired
    EnterpriseMapper enterpriseMapper;
    @Override
    public List<Enterprise> selectAll() {
        return enterpriseMapper.selectAll();
    }

    @Override
    public Enterprise selectById(String id) {
        return enterpriseMapper.selectByPrimaryKey(id);
    }
}
