package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.VoucherApplyMapper;
import com.qilinxx.innovatevolume.domain.model.Contract;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.domain.model.VoucherApplyExample;
import com.qilinxx.innovatevolume.service.VoucherApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoucherApplyServiceImpl implements VoucherApplyService {
    @Autowired
    private VoucherApplyMapper voucherApplyMapper;
    @Override
    public void insertVoucherApply(VoucherApply voucherApply) {
        voucherApplyMapper.insert(voucherApply);
    }

    @Override
    public void updateIsUseById(String id, String isUse) {
        VoucherApply voucherApply=new VoucherApply();
        voucherApply.setId(id);
        voucherApply.setIsUse(isUse);
        voucherApplyMapper.updateByPrimaryKeySelective(voucherApply);
    }

    @Override
    public void deleteVoucherApply(String id) {
        voucherApplyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<VoucherApply> selectVoucherApplyByEnterpriseId(String enterpriseId) {
        VoucherApplyExample voucherApplyExample=new VoucherApplyExample();
        voucherApplyExample.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
        voucherApplyExample.setOrderByClause("create_time desc");
        return voucherApplyMapper.selectByExample(voucherApplyExample);
    }

    @Override
    public List<VoucherApply> selectVoucherApplyByProviderId(String providerId) {
        VoucherApplyExample voucherApplyExample=new VoucherApplyExample();
        voucherApplyExample.createCriteria().andProviderIdEqualTo(providerId);
        voucherApplyExample.setOrderByClause("create_time desc");
        return voucherApplyMapper.selectByExample(voucherApplyExample);
    }

    @Override
    public Map<String, VoucherApply> contractListToVoucherApplyMap(List<Contract> contractList) {
        Map<String,VoucherApply> voucherApplyMap=new HashMap<>();
        for (Contract c:contractList) {
            if(!voucherApplyMap.containsKey(c.getApplyId())){
                voucherApplyMap.put(c.getApplyId(),voucherApplyMapper.selectByPrimaryKey(c.getApplyId()));
            }
        }
        return voucherApplyMap;
    }

}
