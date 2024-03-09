package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.BdCorp;
import org.jeecg.modules.link.mapper.BdCorpMapper;
import org.jeecg.modules.link.service.IBdCorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 公司
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@Service
public class BdCorpServiceImpl extends ServiceImpl<BdCorpMapper, BdCorp> implements IBdCorpService {
    @Autowired
    private BdCorpMapper bdCorpMapper;

    @Override
    public List<BdCorp> getCorpList() {
        return bdCorpMapper.getCorpList();
    }
}
