package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.VoucherApplyMapper;
import com.qilinxx.innovatevolume.domain.model.Voucher;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.service.VoucherApplyService;
import com.qilinxx.innovatevolume.service.VoucherService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.vo.VoucherApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoucherApplyServiceImpl implements VoucherApplyService {
    @Autowired
    VoucherApplyMapper voucherApplyMapper;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    ProviderService providerService;
    @Autowired
    VoucherService voucherService;



    @Override
    public String selectVoucherNameById(String applyId) {
        VoucherApply voucherApply = voucherApplyMapper.selectByPrimaryKey(applyId);
        return  voucherService.selectById(voucherApply.getServiceId()).getName();
    }

    @Override
    public List<VoucherApplyVo> selectAllByEnterpriseId(String id) {
        List<VoucherApply> voucherApplyList = voucherApplyMapper.selectAllByEnterpriseId(id);
        List<VoucherApplyVo> voucherApplyVoList = new ArrayList<>();
         for (VoucherApply voucherApply:voucherApplyList){
             voucherApplyVoList.add(copy(voucherApply));
         }
        return voucherApplyVoList;
    }

    private VoucherApplyVo copy(VoucherApply voucherApply) {
        VoucherApplyVo voucherApplyVo = new VoucherApplyVo();
        voucherApplyVo.setId(voucherApply.getId());
        voucherApplyVo.setEnterpriseId(voucherApply.getEnterpriseId());
        voucherApplyVo.setProviderId(voucherApply.getProviderId());
        voucherApplyVo.setServiceId(voucherApply.getServiceId());//表名字段此处修改为券的id
        voucherApplyVo.setEnterpriseName(enterpriseService.selectById(voucherApply.getEnterpriseId()).getName());
        voucherApplyVo.setProviderName(providerService.selectById(voucherApply.getProviderId()).getName());
        voucherApplyVo.setVoucherName(voucherService.selectById(voucherApply.getServiceId()).getName());
        voucherApplyVo.setAppMoney(voucherApply.getAppMoney());
        voucherApplyVo.setUsageDesc(voucherApply.getUsageDesc());
        voucherApplyVo.setAppUsage(voucherApply.getAppUsage());
        voucherApplyVo.setIsUse(voucherApply.getIsUse());
        voucherApplyVo.setCreater(voucherApply.getCreater());
        voucherApplyVo.setCreateTime(voucherApply.getCreateTime());
        voucherApplyVo.setUpdater(voucherApply.getUpdater());

        voucherApplyVo.setUpdateTime(voucherApply.getUpdateTime());
        voucherApplyVo.setRemark(voucherApply.getRemark());
        return  voucherApplyVo;
    }

    @Override
    public void noExamineApply(String id) {
        VoucherApply voucherApply = voucherApplyMapper.selectByPrimaryKey(id);
        voucherApply.setUpdateTime((long) DateKit.getCurrentUnixTime());
        voucherApply.setIsUse("2");
        //providerFile.setUpdater();相应取修改者
        voucherApplyMapper.updateByPrimaryKeySelective(voucherApply);
    }

    @Override
    public void startApply(String id) {
        VoucherApply voucherApply = voucherApplyMapper.selectByPrimaryKey(id);
        voucherApply.setUpdateTime((long) DateKit.getCurrentUnixTime());
        voucherApply.setIsUse("1");
        //providerFile.setUpdater();相应取修改者
        voucherApplyMapper.updateByPrimaryKeySelective(voucherApply);
    }

    @Override
    public List<VoucherApplyVo> selectAllVoByIsUseNo() {
        List<VoucherApply> voucherApplyList = voucherApplyMapper.selectAllByIsUseNo();
        List<VoucherApplyVo> voucherApplyVoList = new ArrayList<>();
        for (VoucherApply voucherApply:voucherApplyList){
            voucherApplyVoList.add(copy(voucherApply));
        }
        return voucherApplyVoList;
    }

    @Override
    public VoucherApplyVo selectVobyId(String id) {
        VoucherApply voucherApply = voucherApplyMapper.selectByPrimaryKey(id);
        return copy(voucherApply);
    }

    @Override
    public VoucherApply selectById(String applyId) {
        return voucherApplyMapper.selectByPrimaryKey(applyId);
    }

    @Override
    public void examineApply(String id) {
        VoucherApply voucherApply = voucherApplyMapper.selectByPrimaryKey(id);
        voucherApply.setUpdateTime((long) DateKit.getCurrentUnixTime());
        voucherApply.setIsUse("0");
        //providerFile.setUpdater();相应取修改者
        voucherApplyMapper.updateByPrimaryKeySelective(voucherApply);
    }

    @Override
    public void update(VoucherApply voucherApply) {
        voucherApply.setIsUse("0");
        //voucherApply.setUpdater();//相对应
        voucherApply.setUpdateTime((long) DateKit.getCurrentUnixTime());
        voucherApplyMapper.updateByPrimaryKeySelective(voucherApply);
    }


}
