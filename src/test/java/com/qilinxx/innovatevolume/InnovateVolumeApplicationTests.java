package com.qilinxx.innovatevolume;

import com.qilinxx.innovatevolume.domain.mapper.ProviderFileMapper;
import com.qilinxx.innovatevolume.domain.mapper.ProviderMapper;
import com.qilinxx.innovatevolume.domain.mapper.UserInfoMapper;
import com.qilinxx.innovatevolume.domain.model.Provider;
import com.qilinxx.innovatevolume.domain.model.ProviderFile;
import com.qilinxx.innovatevolume.domain.model.UserInfo;
import com.qilinxx.innovatevolume.vo.ContractVo;
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
@Autowired
    ProviderFileMapper providerFileMapper;
    @Test
    public void contextLoads() {
//        List<UserInfo> userInfos = userInfoMapper.selectAll();
//        System.out.println(userInfos.size());
        List<Provider> providers = providerMapper.selectAll();
        System.out.println(providers.size());
    }
      @Test
    public void test01(){
        Integer id=1;
          ProviderFile providerFile = providerFileMapper.selectByPrimaryKey(id);
          System.out.println(providerFile);
      }
}
