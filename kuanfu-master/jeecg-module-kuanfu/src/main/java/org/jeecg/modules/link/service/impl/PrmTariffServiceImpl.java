package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.PrmTariff;
import org.jeecg.modules.link.mapper.PrmTariffMapper;
import org.jeecg.modules.link.service.IPrmTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 价目表主表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Service
public class PrmTariffServiceImpl extends ServiceImpl<PrmTariffMapper, PrmTariff> implements IPrmTariffService {
    @Autowired
    private PrmTariffMapper prmTariffMapper;
    @Override
    public PrmTariff getBy001(String pkCorp) {
        return prmTariffMapper.getBy001(pkCorp);
    }

    @Override
    public List<PrmTariff> getAll(String pkCorp) {
        return prmTariffMapper.getAll(pkCorp);
    }
}
