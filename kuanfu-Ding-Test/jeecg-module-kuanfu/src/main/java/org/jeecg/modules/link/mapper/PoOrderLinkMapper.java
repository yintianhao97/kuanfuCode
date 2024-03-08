package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.PoOrderLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 采购订单同步记录
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@DS("EWAY")
public interface PoOrderLinkMapper extends BaseMapper<PoOrderLink> {

}
