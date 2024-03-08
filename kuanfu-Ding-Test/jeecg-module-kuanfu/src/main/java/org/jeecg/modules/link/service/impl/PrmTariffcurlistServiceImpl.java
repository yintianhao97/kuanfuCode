package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.PrmTariffcurlist;
import org.jeecg.modules.link.mapper.PrmTariffcurlistMapper;
import org.jeecg.modules.link.service.IPrmTariffcurlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 价目表辅表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Service
public class PrmTariffcurlistServiceImpl extends ServiceImpl<PrmTariffcurlistMapper, PrmTariffcurlist> implements IPrmTariffcurlistService {
    @Autowired
    private PrmTariffcurlistMapper prmTariffcurlistMapper;

    @Override
    public PrmTariffcurlist selectByCinv(String cpricetariffid, String cinvbasdocid) {
        return prmTariffcurlistMapper.selectByCinv(cpricetariffid, cinvbasdocid);
    }

    @Override
    public int updateByCinv(String cpricetariffid, String cinvbasdocid, String nprice0) {
        return prmTariffcurlistMapper.updateByCinv(cpricetariffid, cinvbasdocid, nprice0);
    }
}
