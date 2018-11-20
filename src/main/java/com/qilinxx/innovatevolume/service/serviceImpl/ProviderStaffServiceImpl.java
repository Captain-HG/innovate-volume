package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ProviderStaffMapper;
import com.qilinxx.innovatevolume.domain.model.ProviderFile;
import com.qilinxx.innovatevolume.domain.model.ProviderStaff;
import com.qilinxx.innovatevolume.service.ProviderStaffService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderStaffServiceImpl implements ProviderStaffService {
  @Autowired
    ProviderStaffMapper providerStaffMapper;

    @Override
    public List<ProviderStaff> selectAllByProviderId(String id) {
       return   providerStaffMapper.selectAllByProviderId(id);

    }

    @Override
    public void noExamineStaff(Integer id) {
        ProviderStaff providerStaff = providerStaffMapper.selectByPrimaryKey(id);
        providerStaff.setUpdateTime((long) DateKit.getCurrentUnixTime());
        providerStaff.setIsUse("0");
        //providerFile.setUpdater();相应取修改者
        providerStaffMapper.updateByPrimaryKeySelective(providerStaff);
    }

    @Override
    public void startStaff(Integer id) {
        ProviderStaff providerStaff = providerStaffMapper.selectByPrimaryKey(id);
        providerStaff.setUpdateTime((long) DateKit.getCurrentUnixTime());
        providerStaff.setIsUse("1");
        //providerFile.setUpdater();相应取修改者
        providerStaffMapper.updateByPrimaryKeySelective(providerStaff);
    }

    @Override
    public ProviderStaff selectById(Integer id) {
        return providerStaffMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProviderStaff(ProviderStaff providerStaff) {
        //providerStaff.setUpdater();//相对应
        providerStaff.setUpdateTime((long) DateKit.getCurrentUnixTime());
        providerStaffMapper.updateByPrimaryKeySelective(providerStaff);
    }
}
