package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseMapper;
import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.domain.model.EnterpriseExample;
import com.qilinxx.innovatevolume.domain.model.Provider;
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
    public Enterprise selectById(String id) {
        return enterpriseMapper.selectByPrimaryKey(id);
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
        List<Enterprise> enterpriseList = enterpriseMapper.selectByCode(code);
        if (enterpriseList!=null||enterpriseList.size()>0)
        {
            return "已被注册的商家码";
        }
        return "true";
    }

    @Override
    public void updateEnterprise(Enterprise enterprise) {
      //enterprise.setUpdater();//相对应的设置修改者
        enterprise.setUpdateTime((long) DateKit.getCurrentUnixTime());
        enterprise.setIsUse("0");
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
    }

    @Override
    public List<Enterprise> selectByCode(String code) {
        return enterpriseMapper.selectByCode(code);
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
