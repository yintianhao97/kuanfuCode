package org.jeecg.modules.link.service;

import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.PrmTariffcurlist;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 价目表辅表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
public interface IPrmTariffcurlistService extends IService<PrmTariffcurlist> {
    PrmTariffcurlist selectByCinv(String cpricetariffid,String cinvbasdocid);

    int updateByCinv(String cpricetariffid,String cinvbasdocid,String nprice0);
}
