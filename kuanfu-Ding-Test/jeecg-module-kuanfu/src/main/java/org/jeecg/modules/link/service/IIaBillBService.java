package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.IaBillB;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 存货档案
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
public interface IIaBillBService extends IService<IaBillB> {
    List<IaBillB> selectByCinvbasid(String pkCorp, String cinvbasid, String strDate, String endData);
}
