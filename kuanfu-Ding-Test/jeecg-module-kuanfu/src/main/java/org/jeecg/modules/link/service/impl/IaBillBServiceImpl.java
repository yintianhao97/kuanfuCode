package org.jeecg.modules.link.service.impl;

import org.jeecg.modules.link.entity.IaBillB;
import org.jeecg.modules.link.mapper.IaBillBMapper;
import org.jeecg.modules.link.service.IIaBillBService;
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
public class IaBillBServiceImpl extends ServiceImpl<IaBillBMapper, IaBillB> implements IIaBillBService {
    @Autowired
    private IaBillBMapper iaBillBMapper;
    @Override
    public List<IaBillB> selectByCinvbasid(String pkCorp, String cinvbasid, String strDate, String endData) {
        return iaBillBMapper.selectByCinvbasid(pkCorp, cinvbasid, strDate, endData);
    }
}
