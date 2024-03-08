package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.PoOrder;
import org.jeecg.modules.link.mapper.PoOrderMapper;
import org.jeecg.modules.link.service.IPoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.xml.ws.Action;
import java.util.List;

/**
 * @Description: 采购订单主表
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@Service
public class PoOrderServiceImpl extends ServiceImpl<PoOrderMapper, PoOrder> implements IPoOrderService {
    @Autowired
    private PoOrderMapper poOrderMapper;
    @Override
    public List<PoOrder> selectUnsync(String corp, String startDate, String endDate) {
        return poOrderMapper.selectUnsync(corp,startDate,endDate);
    }

    @Override
    public List<PoOrder> dingSync(String corp, String startDate, String endDate) {
        return poOrderMapper.dingSync(corp,startDate,endDate);
    }
}
