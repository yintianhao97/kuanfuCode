package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.IaBillB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 存货档案
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
@DS("U8C")
public interface IaBillBMapper extends BaseMapper<IaBillB> {
    @Select("select cinvbasid, cinventoryid, nprice\n" +
            "from ia_bill_b,\n" +
            "     (select distinct v.cbillid\n" +
            "      from v_ia_inoutledger v\n" +
            "      where (v.pk_corp = #{pkCorp})\n" +
            "        and (v.pk_corp = #{pkCorp} and v.cbilltypecode = 'I3' and v.dbilldate >= #{strDate} and\n" +
            "             v.dbilldate <= #{endData})) hh\n" +
            "where hh.cbillid = ia_bill_b.cbillid and ia_bill_b.cinvbasid = #{cinvbasid}")
    List<IaBillB> selectByCinvbasid(String pkCorp,String cinvbasid,String strDate,String endData);
}
