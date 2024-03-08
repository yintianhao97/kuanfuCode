package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.PoOrderB;
import org.jeecg.modules.link.mapper.PoOrderBMapper;
import org.jeecg.modules.link.service.IPoOrderBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 采购订单表体
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@Service
public class PoOrderBServiceImpl extends ServiceImpl<PoOrderBMapper, PoOrderB> implements IPoOrderBService {
    @Autowired
    private PoOrderBMapper poOrderBMapper;
    @Override
    public List<PoOrderB> selectByCorderId(String corderid) {
        return poOrderBMapper.selectByCorderId(corderid);
    }
}
