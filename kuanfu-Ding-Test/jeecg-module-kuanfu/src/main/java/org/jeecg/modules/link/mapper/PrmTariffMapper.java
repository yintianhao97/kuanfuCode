package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.PrmTariff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 价目表主表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@DS("U8C")
public interface PrmTariffMapper extends BaseMapper<PrmTariff> {
    @Select("select * from prm_tariff where prm_tariff.dr = 0 and pk_corp = #{pkCorp} and cpricetariffcode = '001'")
    PrmTariff getBy001(String pkCorp);

    @Select("select * from prm_tariff where prm_tariff.dr = 0 and pk_corp = #{pkCorp} ORDER BY cpricetariffcode ")
    List<PrmTariff> getAll(String pkCorp);





}
