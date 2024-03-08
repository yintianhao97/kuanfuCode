package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.PoOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 采购订单主表
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@DS("U8C")
public interface PoOrderMapper extends BaseMapper<PoOrder> {

    @Select("SELECT * FROM po_order \n" +
            "WHERE\n" +
            "\t( dr = 0 ) \n" +
            "\tAND forderstatus IN ( 0, 4, 2, 3, 5 ) \n" +
            "\tAND ( ( dorderdate >= #{startDate} ) AND ( dorderdate <= #{endDate} ) ) \n" +
            "\tAND pk_corp = #{corp}\n" +
            "ORDER BY\n" +
            "\tvordercode")
    List<PoOrder> selectUnsync(String corp,String startDate,String endDate);
    @Select("SELECT * FROM po_order WHERE corderid = #{id}")
    PoOrder selectById(String id);
    @Select("SELECT DISTINCT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tpo_order B\n" +
            "WHERE\n" +
            "\t( dr = 0 ) \n" +
            "\tAND pk_corp = #{corp} \n" +
            "\tAND ( forderstatus IN ( 0, 4 ) ) \n" +
            "\tAND ( ( dorderdate >= #{startDate} ) AND ( dorderdate <= #{endDate} ) ) \n" +
            "\tAND (\n" +
            "\tSELECT COUNT\n" +
            "\t\t( 1 ) AS num \n" +
            "\tFROM\n" +
            "\t\tEwayU8CLink..po_order_link A \n" +
            "\tWHERE\n" +
            "\t\tA.erpCode = B.corderid \n" +
            "\tAND ( ISNULL( A.tlastmaketime, '2014-12-03 16:28:11.357' ) = ISNULL( B.tlastmaketime, '2014-12-03 16:28:11.357' ) OR A.state != 2 ) \n" +
            "\t) = 0")
    List<PoOrder> dingSync(String corp,String startDate,String endDate);

    @Select("select user_code from sm_user where cuserid in (select coperator from po_order where corderid = #{orderId})")
    String getUserCode(String orderId);

}
