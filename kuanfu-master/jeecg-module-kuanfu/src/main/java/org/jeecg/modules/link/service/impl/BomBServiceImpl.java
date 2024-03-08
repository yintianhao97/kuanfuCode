package org.jeecg.modules.link.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.link.entity.BomB;
import org.jeecg.modules.link.mapper.BomBMapper;
import org.jeecg.modules.link.service.IBomBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BomBServiceImpl extends ServiceImpl<BomBMapper, BomB> implements IBomBService {

    @Autowired
    private BomBMapper bomBMapper;
    @Override
    public List<BomB> selectBywlbmidAndgcbmV2(String wlbmid, String gcbm) {
        return bomBMapper.selectBywlbmidAndgcbmV2(wlbmid, gcbm);
    }
}
