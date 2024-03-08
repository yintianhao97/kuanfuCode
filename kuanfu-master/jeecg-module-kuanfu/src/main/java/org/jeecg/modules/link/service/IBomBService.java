package org.jeecg.modules.link.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.link.entity.BdInvmandoc;
import org.jeecg.modules.link.entity.BomB;
import org.jeecg.modules.link.mapper.BdInvmandocMapper;
import org.jeecg.modules.link.mapper.BomBMapper;

import java.util.List;

public interface IBomBService extends IService<BomB> {
    List<BomB> selectBywlbmidAndgcbmV2(String wlbmid, String gcbm);
}
