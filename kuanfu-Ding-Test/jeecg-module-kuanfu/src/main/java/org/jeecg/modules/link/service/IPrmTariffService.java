package org.jeecg.modules.link.service;

import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.PrmTariff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 价目表主表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
public interface IPrmTariffService extends IService<PrmTariff> {
    PrmTariff getBy001(String pkCorp);

    List<PrmTariff> getAll(String pkCorp);
}
