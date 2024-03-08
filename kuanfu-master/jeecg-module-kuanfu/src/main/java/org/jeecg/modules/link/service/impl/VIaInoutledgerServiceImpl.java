package org.jeecg.modules.link.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.link.entity.VIaInoutledger;
import org.jeecg.modules.link.mapper.VIaInoutledgerMapper;
import org.jeecg.modules.link.service.IVIaInoutledgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VIaInoutledgerServiceImpl extends ServiceImpl<VIaInoutledgerMapper, VIaInoutledger> implements IVIaInoutledgerService {
    @Autowired
    private VIaInoutledgerMapper vIaInoutledgerMapper;
    @Override
    public List<VIaInoutledger> selectByPkCode(String pkCorp, String sDate, String eData) {
        return vIaInoutledgerMapper.selectByPkCode(pkCorp, sDate, eData);
    }
}
