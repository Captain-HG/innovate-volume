package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.VoucherCashMapper;
import com.qilinxx.innovatevolume.domain.model.VoucherCash;
import com.qilinxx.innovatevolume.service.VoucherCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocuherCashServiceImpl  implements VoucherCashService {
     @Autowired
     VoucherCashMapper voucherCashMapper;

    public List<VoucherCash> selectAll() {
        return  voucherCashMapper.selectAll();
    }
}
