package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.ArapDjfb;
import org.jeecg.modules.link.mapper.ArapDjfbMapper;
import org.jeecg.modules.link.service.IArapDjfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 付款单副表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Service
public class ArapDjfbServiceImpl extends ServiceImpl<ArapDjfbMapper, ArapDjfb> implements IArapDjfbService {
    @Autowired
    private ArapDjfbMapper arapDjfbMapper;
    @Override
    public List<ArapDjfb> getByVouchid(String vouchid) {
        return arapDjfbMapper.getByVouchid(vouchid);
    }
}
