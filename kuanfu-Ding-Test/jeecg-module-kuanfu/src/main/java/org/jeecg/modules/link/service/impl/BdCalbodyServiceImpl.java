package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.BdCalbody;
import org.jeecg.modules.link.mapper.BdCalbodyMapper;
import org.jeecg.modules.link.service.IBdCalbodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 库存组织 
 * @Author: jeecg-boot
 * @Date:   2024-02-02
 * @Version: V1.0
 */
@Service
public class BdCalbodyServiceImpl extends ServiceImpl<BdCalbodyMapper, BdCalbody> implements IBdCalbodyService {
    @Autowired
    private BdCalbodyMapper bdCalbodyMapper;
    @Override
    public String selectStorDocPk(String pkCorp, String StorNumber) {
        return bdCalbodyMapper.selectStorDocPk(pkCorp, StorNumber);
    }

    @Override
    public String selectStorNumbet(String danjvPk) {
        return bdCalbodyMapper.selectStorNumbet(danjvPk);
    }

    @Override
    public List<BdCalbody> selectByPkCorp(String pkCorp) {
        return bdCalbodyMapper.selectByPkCorp(pkCorp);
    }
}
