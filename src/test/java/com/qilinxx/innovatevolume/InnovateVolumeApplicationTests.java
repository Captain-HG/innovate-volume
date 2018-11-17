package com.qilinxx.innovatevolume;

import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InnovateVolumeApplicationTests {
@Autowired
    ProviderMapper providerMapper;
@Autowired
    UserInfoMapper userInfoMapper;
    @Test
    public void contextLoads() {
//        List<UserInfo> userInfos = userInfoMapper.selectAll();
//        System.out.println(userInfos.size());
        List<Provider> providers = providerMapper.selectAll();
        System.out.println(providers.size());
    }

}
