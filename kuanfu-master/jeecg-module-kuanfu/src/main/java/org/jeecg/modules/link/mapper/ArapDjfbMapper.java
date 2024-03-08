package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.ArapDjfb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 付款单副表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@DS("U8C")
public interface ArapDjfbMapper extends BaseMapper<ArapDjfb> {
    /**
     * 根据主表ID获得付款单副表
     * @param vouchid
     */
    @Select("select * from arap_djfb where dr = 0 and xgbh = - 1 and vouchid = #{vouchid}")
    List<ArapDjfb> getByVouchid(String vouchid);
}
