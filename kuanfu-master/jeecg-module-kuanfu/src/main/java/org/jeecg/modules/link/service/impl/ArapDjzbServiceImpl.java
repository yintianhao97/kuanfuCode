package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.ArapDjzb;
import org.jeecg.modules.link.mapper.ArapDjzbMapper;
import org.jeecg.modules.link.service.IArapDjzbService;
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
public class ArapDjzbServiceImpl extends ServiceImpl<ArapDjzbMapper, ArapDjzb> implements IArapDjzbService {
    @Autowired
    private ArapDjzbMapper arapDjzbMapper;
    @Override
    public List<ArapDjzb> getUnsyDoc(String corp, String qiantian, String houtian) {
        return arapDjzbMapper.getUnsyDoc(corp, qiantian, houtian);
    }
}
