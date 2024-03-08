package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.BdInvmandoc;
import org.jeecg.modules.link.mapper.BdInvmandocMapper;
import org.jeecg.modules.link.service.IBdInvmandocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 存货档案
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
@Service
public class BdInvmandocServiceImpl extends ServiceImpl<BdInvmandocMapper, BdInvmandoc> implements IBdInvmandocService {
    @Autowired
    private BdInvmandocMapper bdInvmandocMapper;
    @Override
    public List<BdInvmandoc> selectByPkCorp(String pkCorp) {
        return bdInvmandocMapper.selectByPkCorp(pkCorp);
    }
}
