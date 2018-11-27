package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseMapper;
import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.EnterpriseExample;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Enterprise> voucherApplyListToEnterpriseMap(List<VoucherApply> voucherApplyList) {
        Map<String,Enterprise> enterpriseMap=new HashMap<>();
        for (VoucherApply v:voucherApplyList) {
            if(!enterpriseMap.containsKey(v.getEnterpriseId())){
                enterpriseMap.put(v.getEnterpriseId(),enterpriseMapper.selectByPrimaryKey(v.getEnterpriseId()));
            }
        }
        return enterpriseMap;
    }

    @Override
    public Map<String, Enterprise> contractListToEnterpriseMap(List<Contract> contractList) {
        Map<String,Enterprise> enterpriseMap=new HashMap<>();
        for(Contract c:contractList){
            if(!enterpriseMap.containsKey(c.getEnterpriseId())){
                enterpriseMap.put(c.getEnterpriseId(),enterpriseMapper.selectByPrimaryKey(c.getEnterpriseId()));
            }
        }
        return enterpriseMap;
    }
}
