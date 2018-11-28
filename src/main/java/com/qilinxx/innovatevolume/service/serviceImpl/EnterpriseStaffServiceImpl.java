package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.EnterpriseStaffMapper;
import com.qilinxx.innovatevolume.domain.model.EnterpriseStaff;
import com.qilinxx.innovatevolume.service.EnterpriseStaffService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseStaffServiceImpl implements EnterpriseStaffService {
    @Autowired
    EnterpriseStaffMapper enterpriseStaffMapper;

    @Override
    public List<EnterpriseStaff> selectAllByEnterpriseId(String id) {
        return enterpriseStaffMapper.selectAllByEnterpriseId(id);
    }

    @Override
    public void noExamineStaff(Integer id) {
        EnterpriseStaff enterpriseStaff = enterpriseStaffMapper.selectByPrimaryKey(id);
        enterpriseStaff.setIsUse("0");
        enterpriseStaffMapper.updateByPrimaryKeySelective(enterpriseStaff);
    }

    @Override
    public void startStaff(Integer id) {
        EnterpriseStaff enterpriseStaff = enterpriseStaffMapper.selectByPrimaryKey(id);
        enterpriseStaff.setIsUse("1");
        enterpriseStaffMapper.updateByPrimaryKeySelective(enterpriseStaff);
    }

    @Override
    public EnterpriseStaff selectById(Integer id) {
        return enterpriseStaffMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateEnterpriseStaff(EnterpriseStaff enterpriseStaff) {
      //enterpriseStaff.setUpdater();//相对应设置
      enterpriseStaff.setUpdateTime((long) DateKit.getCurrentUnixTime());
      enterpriseStaff.setIsUse("0");
      enterpriseStaffMapper.updateByPrimaryKeySelective(enterpriseStaff);
    }

    @Override
    public void insertEnterpriseStaff(EnterpriseStaff enterpriseStaff) {
        enterpriseStaffMapper.insert(enterpriseStaff);
    }

    @Override
    public void deleteEnterpriseStaff(String id) {
        enterpriseStaffMapper.deleteByPrimaryKey(Integer.parseInt(id));
    }
}
