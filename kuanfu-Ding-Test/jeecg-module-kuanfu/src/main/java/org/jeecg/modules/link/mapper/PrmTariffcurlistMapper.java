package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jeecg.modules.link.entity.PrmTariffcurlist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 价目表辅表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@DS("U8C")
public interface PrmTariffcurlistMapper extends BaseMapper<PrmTariffcurlist> {

    @Select("select * from prm_tariffcurlist where prm_tariffcurlist.dr = 0 and cpricetariffid = #{cpricetariffid} and cinvbasdocid = #{cinvbasdocid} and ccurrencyid in (SELECT pk_currtype FROM bd_currtype WHERE isnull ( dr , 0 ) = 0 and currtypecode = 'CNY')")
    PrmTariffcurlist selectByCinv(String cpricetariffid,String cinvbasdocid);


    @Update("UPDATE prm_tariffcurlist set nprice0 = #{nprice0}  where prm_tariffcurlist.dr = 0 and cpricetariffid = #{cpricetariffid} and cinvbasdocid = #{cinvbasdocid} and ccurrencyid in (SELECT pk_currtype FROM bd_currtype WHERE isnull ( dr , 0 ) = 0 and currtypecode = 'CNY')")
    int updateByCinv(String cpricetariffid,String cinvbasdocid,String nprice0);

}
