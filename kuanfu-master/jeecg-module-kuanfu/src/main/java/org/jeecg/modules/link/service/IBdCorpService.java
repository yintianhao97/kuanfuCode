package org.jeecg.modules.link.service;

import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.BdCorp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 公司
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
public interface IBdCorpService extends IService<BdCorp> {
    List<BdCorp> getCorpList();

}
