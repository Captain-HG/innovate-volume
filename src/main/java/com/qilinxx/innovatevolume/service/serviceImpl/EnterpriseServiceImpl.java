package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseMapper;
import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.EnterpriseExample;
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
    public Enterprise selectEnterpriseByCode(String code) {
        EnterpriseExample enterpriseExample=new EnterpriseExample();
        enterpriseExample.createCriteria().andCodeEqualTo(code);
        return enterpriseMapper.selectByExample(enterpriseExample).get(0);
    }
    @Override
    public Enterprise updateEnterpriseInfo(Enterprise enterprise) {
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return enterpriseMapper.selectByPrimaryKey(enterprise.getId());
    }
}
