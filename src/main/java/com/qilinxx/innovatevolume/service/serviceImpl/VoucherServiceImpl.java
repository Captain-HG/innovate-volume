package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.VoucherMapper;
import com.qilinxx.innovatevolume.domain.model.Voucher;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.domain.model.VoucherExample;
import com.qilinxx.innovatevolume.service.VoucherService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    VoucherMapper voucherMapper;
    @Override
    public List<Voucher> selectAllByProviderId(String id) {
        return voucherMapper.selectAllByProviderId(id);
    }

    @Override
    public List<Voucher> selectAll() {
        VoucherExample voucherExample=new VoucherExample();
        voucherExample.createCriteria().andIsUseEqualTo("1");
        voucherExample.setOrderByClause("create_time desc");
        List<Voucher> vouchers = voucherMapper.selectByExample(voucherExample);
        return vouchers;

    }

    @Override
    public void insertVoucher(Voucher voucher) {
        voucherMapper.insert(voucher);
    }

    @Override
    public void deleteVoucher(String id) {
        voucherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Voucher selectVoucherById(String id) {
        return  voucherMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Voucher> selectVoucherByProviderId(String providerId) {
        VoucherExample voucherExample=new VoucherExample();
        voucherExample.createCriteria().andProviderIdEqualTo(providerId);
        return  voucherMapper.selectByExample(voucherExample);
    }

    @Override
    public Map<String, Voucher> voucherApplyListToVoucherMap(List<VoucherApply> voucherApplyList) {
        Map<String,Voucher> voucherMap =new HashMap<>();
        for (VoucherApply v:voucherApplyList) {
            if(!voucherMap.containsKey(v.getServiceId())){
                voucherMap.put(v.getServiceId(),voucherMapper.selectByPrimaryKey(v.getServiceId()));
            }
        }
        return voucherMap;
    }

    @Override
    public void noExamineVoucher(String id) {
        Voucher voucher = voucherMapper.selectByPrimaryKey(id);
        voucher.setUpdateTime((long) DateKit.getCurrentUnixTime());
        voucher.setIsUse("0");
        //providerFile.setUpdater();相应取修改者
        voucherMapper.updateByPrimaryKeySelective(voucher);
    }

    @Override
    public void startVoucher(String id) {
        Voucher voucher = voucherMapper.selectByPrimaryKey(id);
        voucher.setUpdateTime((long) DateKit.getCurrentUnixTime());
        voucher.setIsUse("1");
        //providerFile.setUpdater();相应取修改者
        voucherMapper.updateByPrimaryKeySelective(voucher);
    }

    @Override
    public Voucher selectById(String id) {
      return voucherMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateVoucher(Voucher voucher) {
        //providerStaff.setUpdater();//相对应
        voucher.setUpdateTime((long) DateKit.getCurrentUnixTime());
        voucher.setIsUse("0");
        voucherMapper.updateByPrimaryKeySelective(voucher);
    }
}
