package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.VoucherMapper;
import com.qilinxx.innovatevolume.domain.model.ProviderService;
import com.qilinxx.innovatevolume.domain.model.Voucher;
import com.qilinxx.innovatevolume.service.VoucherService;
import com.qilinxx.innovatevolume.util.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    VoucherMapper voucherMapper;
    @Override
    public List<Voucher> selectAllByProviderId(String id) {
        return voucherMapper.selectAllByProviderId(id);
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
