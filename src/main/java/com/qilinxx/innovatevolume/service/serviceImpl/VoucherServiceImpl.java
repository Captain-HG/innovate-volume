package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.VoucherMapper;
import com.qilinxx.innovatevolume.domain.model.Voucher;
import com.qilinxx.innovatevolume.domain.model.VoucherExample;
import com.qilinxx.innovatevolume.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherMapper voucherMapper;
    @Override
    public List<Voucher> selectAll() {
        VoucherExample voucherExample=new VoucherExample();
        voucherExample.createCriteria().andIsUseEqualTo("1");
        List<Voucher> vouchers = voucherMapper.selectByExample(voucherExample);
        return vouchers;

    }
}
