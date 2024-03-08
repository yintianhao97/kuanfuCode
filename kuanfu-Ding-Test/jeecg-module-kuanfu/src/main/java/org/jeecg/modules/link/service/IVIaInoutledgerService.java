package org.jeecg.modules.link.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.link.entity.VIaInoutledger;

import java.util.List;

public interface IVIaInoutledgerService extends IService<VIaInoutledger> {
    List<VIaInoutledger> selectByPkCode(String pkCorp, String sDate, String eData);
}
