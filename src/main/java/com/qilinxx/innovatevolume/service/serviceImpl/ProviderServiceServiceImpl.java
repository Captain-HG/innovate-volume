package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ProviderServiceMapper;
import com.qilinxx.innovatevolume.domain.model.ProviderService;
import com.qilinxx.innovatevolume.domain.model.ProviderStaff;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.service.ProviderServiceService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProviderServiceServiceImpl implements ProviderServiceService {
    @Autowired
    ProviderServiceMapper providerServiceMapper;

    @Override
    public List<ProviderService> selectAllByProviderId(String id) {
        return providerServiceMapper.selectAllByProviderId(id);
    }
    @Override
    public void insertProviderService(ProviderService providerService) {
        providerServiceMapper.insertSelective(providerService);
    }

    @Override
    public void deleteProviderService(String id) {
        providerServiceMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Map<String, String> voucherApplyListToProviderServiceMap(List<VoucherApply> voucherApplyList) {
        Map<String,String> providerServiceMap =new HashMap<>();
        for (VoucherApply v:voucherApplyList){
            if(!providerServiceMap.containsKey(v.getServiceId())){
                providerServiceMap.put(v.getServiceId(),providerServiceMapper.selectByPrimaryKey(v.getServiceId()).getName());
            }
        }
        return providerServiceMap;
    }


    @Override
    public void noExamineService(String id) {
        ProviderService providerSer = providerServiceMapper.selectByPrimaryKey(id);
        providerSer.setUpdateTime((long) DateKit.getCurrentUnixTime());
        providerSer.setIsUse("0");
        //providerFile.setUpdater();相应取修改者
        providerServiceMapper.updateByPrimaryKeySelective(providerSer);
    }

    @Override
    public void startService(String id) {
        ProviderService providerSer = providerServiceMapper.selectByPrimaryKey(id);
        providerSer.setUpdateTime((long) DateKit.getCurrentUnixTime());
        providerSer.setIsUse("1");
        //providerFile.setUpdater();相应取修改者
        providerServiceMapper.updateByPrimaryKeySelective(providerSer);
    }

    @Override
    public ProviderService selectById(String id) {
        return providerServiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProviderService(ProviderService providerService) {
        //providerStaff.setUpdater();//相对应
        providerService.setUpdateTime((long) DateKit.getCurrentUnixTime());
        providerService.setIsUse("0");
        providerServiceMapper.updateByPrimaryKeySelective(providerService);
    }
}
