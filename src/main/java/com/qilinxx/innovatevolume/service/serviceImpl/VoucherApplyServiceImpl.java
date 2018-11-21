package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.VoucherApplyMapper;
import com.qilinxx.innovatevolume.domain.model.VoucherApply;
import com.qilinxx.innovatevolume.service.VoucherApplyService;
import com.qilinxx.innovatevolume.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherApplyServiceImpl implements VoucherApplyService {
    @Autowired
    VoucherApplyMapper voucherApplyMapper;
    @Autowired
    VoucherService voucherService;
    @Override
    public String selectVoucherNameById(String applyId) {
        VoucherApply voucherApply = voucherApplyMapper.selectByPrimaryKey(applyId);
        return  voucherService.selectById(voucherApply.getProviderId()).getName();
    }
}
