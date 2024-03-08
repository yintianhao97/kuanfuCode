package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.FukuanLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 付款单同步
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@DS("EWAY")
public interface FukuanLinkMapper extends BaseMapper<FukuanLink> {

}
