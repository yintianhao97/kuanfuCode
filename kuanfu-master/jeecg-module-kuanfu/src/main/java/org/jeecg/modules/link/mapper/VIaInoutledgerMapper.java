package org.jeecg.modules.link.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.IaBillB;
import org.jeecg.modules.link.entity.VIaInoutledger;

import java.util.List;

@DS("U8C")
public interface VIaInoutledgerMapper extends BaseMapper<VIaInoutledger> {
    @InterceptorIgnore(tenantLine = "true")
    @Select("select distinct *\n" +
            "      from v_ia_inoutledger v\n" +
            "      where  (v.pk_corp = #{pkCorp})\n" +
            "        and (v.pk_corp = #{pkCorp} and v.cbilltypecode = 'I3' and v.dbilldate >= #{sDate} and\n" +
            "             v.dbilldate <= #{eData}) and cbill_bid NOT in (select number from [EwayU8CLink]..sync_doc)")
    List<VIaInoutledger> selectByPkCode(String pkCorp,String sDate,String eData);
}
