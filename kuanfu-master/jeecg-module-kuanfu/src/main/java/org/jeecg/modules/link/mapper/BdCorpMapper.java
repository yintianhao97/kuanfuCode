package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.BdCorp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 公司
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@DS("U8C")
public interface BdCorpMapper extends BaseMapper<BdCorp> {

    @Select("SELECT * FROM bd_corp WHERE isseal = 'N' and pk_corp = #{code}")
    BdCorp getCoprByPk(String codePk);

    @Select("SELECT * FROM bd_corp WHERE isseal = 'N' and unitcode = #{code}")
    BdCorp getCoprByCode(String code);

    @Select("select * from bd_corp where LEN(unitcode) = 7 and dr = 0 and ishasaccount = 'Y' and isseal = 'N' ")
    List<BdCorp> getCorpList();

}
