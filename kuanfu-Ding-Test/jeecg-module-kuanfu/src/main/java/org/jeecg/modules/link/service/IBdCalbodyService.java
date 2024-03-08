package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.BdCalbody;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 库存组织 
 * @Author: jeecg-boot
 * @Date:   2024-02-02
 * @Version: V1.0
 */
public interface IBdCalbodyService extends IService<BdCalbody> {
    String selectStorDocPk(String pkCorp,String StorNumber);

    String selectStorNumbet(String danjvPk);

    List<BdCalbody> selectByPkCorp(String pkCorp);
}
