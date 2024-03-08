package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.PoOrderB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 采购订单表体
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@DS("U8C")
public interface PoOrderBMapper extends BaseMapper<PoOrderB> {

    @Select("select * FROM po_order_b\n" +
            "WHERE\n" +
            "\t( dr = 0 )  and (iisactive <> 3) and iisactive = 0 and corderid = #{corderid}")
    List<PoOrderB> selectByCorderId(String corderid);

}
