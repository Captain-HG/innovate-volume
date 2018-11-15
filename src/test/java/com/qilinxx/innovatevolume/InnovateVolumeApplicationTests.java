package com.qilinxx.innovatevolume;

import com.qilinxx.innovatevolume.domain.model.Enterprise;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InnovateVolumeApplicationTests {
    @Autowired
    private EnterpriseService enterpriseService;
    @Test
    public void selectEnterpriseByCode() {
        Enterprise enterprise = enterpriseService.selectEnterpriseByCode("111111111");
        System.out.println(enterprise.getName());
    }

}
