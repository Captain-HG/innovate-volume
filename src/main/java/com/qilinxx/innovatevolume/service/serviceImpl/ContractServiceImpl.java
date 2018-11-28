package com.qilinxx.innovatevolume.service.serviceImpl;

import com.qilinxx.innovatevolume.domain.mapper.ContractMapper;
import com.qilinxx.innovatevolume.domain.mapper.EnterpriseMapper;
import com.qilinxx.innovatevolume.domain.model.*;
import com.qilinxx.innovatevolume.service.ContractService;
import com.qilinxx.innovatevolume.service.EnterpriseService;
import com.qilinxx.innovatevolume.service.ProviderService;
import com.qilinxx.innovatevolume.service.VoucherApplyService;
import com.qilinxx.innovatevolume.util.DateKit;
import com.qilinxx.innovatevolume.util.UUID;
import com.qilinxx.innovatevolume.vo.ContractVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
     @Autowired
    ContractMapper contractMapper;
     @Autowired
    EnterpriseService enterpriseService;
     @Autowired
    ProviderService providerService;
     @Autowired
     VoucherApplyService applyService;
    @Override
    public List<Contract> selectAll() {
        return contractMapper.selectAll();
    }

    @Override
    public List<ContractVo> selectAllByProviderId(String id) {
       List<Contract> contractList= contractMapper.selectAllByProviderId(id);
     System.out.println("list大小"+contractList.size());
        List<ContractVo> contractVoList = new ArrayList<>();
        for (Contract c:contractList){
            System.out.println(c.toString());
            contractVoList.add(copy(c));

        }
        return contractVoList;
    }

    @Override
    public void startContract(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        contract.setUpdateTime((long) DateKit.getCurrentUnixTime());
        contract.setIsUse("1");
        //providerFile.setUpdater();相应取修改者
        contractMapper.updateByPrimaryKeySelective(contract);
    }

    @Override
    public void noExamineContract(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        contract.setUpdateTime((long) DateKit.getCurrentUnixTime());
        contract.setIsUse("0");
        //providerFile.setUpdater();相应取修改者
        contractMapper.updateByPrimaryKeySelective(contract);
    }

    @Override
    public List<ContractVo> selectAllByEnterpriseId(String id) {
       List<Contract> contractList =contractMapper.selectAllByEnterpriseId(id);
        System.out.println("list大小"+contractList.size());
        List<ContractVo> contractVoList = new ArrayList<>();
        for (Contract c:contractList){
            System.out.println(c.toString());
            contractVoList.add(copy(c));

        }
        return contractVoList;
    }

    @Override
    public List<ContractVo> selectAllVo() {
        List<Contract> contractList = contractMapper.selectAll();
        List<ContractVo> contractVoList = new ArrayList<>();
        for (Contract c:contractList){
            contractVoList.add(copy(c));
        }
        return contractVoList;
    }

    @Override
    public Contract selectById(String id) {
        return contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateContract(Contract contract) {
        //contract.setUpdater();//相应的设置更新者
        contract.setUpdateTime((long) DateKit.getCurrentUnixTime());
        contract.setIsUse("0");
        contractMapper.updateByPrimaryKeySelective(contract);
    }

    @Override
    public ContractVo selectVoById(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        return copy(contract);
    }

    @Override
    public void insert(Contract contract) {
        contract.setId(UUID.UU32());
        contract.setIsUse("0");
        contract.setCreateTime((long) DateKit.getCurrentUnixTime());
        //测试
        contract.setCreater("lzc");//相对应设置
        contractMapper.insert(contract);
        //合同增加过后要设置申请记录的isUse为1
         applyService.startApply(contract.getApplyId());

    }

    private ContractVo copy(Contract contract){
        ContractVo contractVo = new ContractVo();
        Enterprise enterprise =enterpriseService.selectById(contract.getEnterpriseId());
        System.out.println(enterprise.toString());
        contractVo.setId(contract.getId());
        contractVo.setEnterpriseName(enterpriseService.selectById(contract.getEnterpriseId()).getName());
        contractVo.setProviderName(providerService.selectById(contract.getProviderId()).getName());
        contractVo.setVoucherName(applyService.selectVoucherNameById(contract.getApplyId()));
        contractVo.setEnterpriseId(contract.getEnterpriseId());
        contractVo.setProviderId(contract.getProviderId());
        contractVo.setApplyId(contract.getApplyId());
        contractVo.setMoney(contract.getMoney());
        contractVo.setName(contract.getName());
        contractVo.setPath(contract.getPath());
        contractVo.setVoumoney(contract.getVoumoney());
        contractVo.setStartDate(contract.getStartDate());
        contractVo.setSignDate(contract.getSignDate());
        contractVo.setCreater(contract.getCreater());
        contractVo.setCreateTime(contract.getCreateTime());
        contractVo.setIsUse(contract.getIsUse());
        contractVo.setUpdater(contract.getUpdater());
        contractVo.setUpdateTime(contract.getUpdateTime());
        contractVo.setRemark(contract.getRemark());
        return contractVo;
    }

    @Override
    public List<Contract> selectContractByProviderId(String providerId) {
        ContractExample contractExample=new ContractExample();
        contractExample.createCriteria().andProviderIdEqualTo(providerId);
        return contractMapper.selectByExample(contractExample);
    }

    @Override
    public List<Contract> selectContractByEnterpriseId(String enterpriseId) {
        ContractExample contractExample=new ContractExample();
        contractExample.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
        contractExample.setOrderByClause("create_time desc");
        return contractMapper.selectByExample(contractExample);
    }

}
