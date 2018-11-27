package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseMapper;
import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.EnterpriseExample;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.util.DateKit;
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

    @Override
    public String examineEnterprise(String id) {
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        enterprise.setIsUse("0");
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return null;
    }

    @Override
    public String startEnterprise(String id) {
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        enterprise.setIsUse("1");
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return null;
    }

    @Override
    public String noExamineEnterprise(String id) {
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        enterprise.setIsUse("2");
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        return null;
    }

    @Override
    public String ifCodeUse(String code) {
        return null;
    }

    @Override
    public void updateEnterprise(Enterprise enterprise) {
      //enterprise.setUpdater();//相对应的设置修改者
        enterprise.setUpdateTime((long) DateKit.getCurrentUnixTime());
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
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
