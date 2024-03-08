package org.jeecg.modules.link.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.BomB;

import java.util.List;

@DS("U8C")
public interface BomBMapper extends BaseMapper<BomB> {


    @Select("select bomb.pk_corp,\n" +
            "       bomb.gcbm,\n" +
            "       bomb.pk_bom_bid,\n" +
            "       bomb.pk_bomid,\n" +
            "       bomb.hh,\n" +
            "       bomb.zxbmid,\n" +
            "       bomb.sl,\n" +
            "       invb.invcode,\n" +
            "       invb.invname,\n" +
            "       bom.version,\n" +
            "       bomb.pk_produce,\n" +
            "       bom.wlbmid\n" +
            "from bd_bom bom\n" +
            "         left outer join bd_measdoc measpf on bom.jldwid = measpf.pk_measdoc,\n" +
            "     bd_bom_b bomb\n" +
            "         left outer join bd_measdoc measf on bomb.jldwid = measf.pk_measdoc,\n" +
            "     bd_invbasdoc invh,\n" +
            "     bd_invbasdoc invb,\n" +
            "     bd_measdoc meash,\n" +
            "     bd_measdoc measb,\n" +
            "     bd_produce proh,\n" +
            "     bd_produce prob\n" +
            "where bom.pk_bomid = bomb.pk_bomid\n" +
            "  and bom.wlbmid = invh.pk_invbasdoc\n" +
            "  and invh.pk_measdoc = meash.pk_measdoc\n" +
            "  and bomb.zxbmid = invb.pk_invbasdoc\n" +
            "  and invb.pk_measdoc = measb.pk_measdoc\n" +
            "  and invh.pk_invbasdoc = proh.pk_invbasdoc\n" +
            "  and invb.pk_invbasdoc = prob.pk_invbasdoc\n" +
            "  and proh.pk_calbody = bom.gcbm\n" +
            "  and prob.pk_calbody = bom.gcbm\n" +
            "  and bom.wlbmid = #{wlbmid}          --存货pk\n" +
            "  and bom.gcbm = #{gcbm}           --工厂pk\n" +
            "  and bom.bblx = 0 \n" +
            "  and bom.sfmr = 'Y'\n" +
            "order by invh.invcode, bom.sfmr desc, bom.version desc, invb.invcode\n")
    List<BomB> selectBywlbmidAndgcbm(String wlbmid, String gcbm,String sDate,String eDate);


    @Select("          select bomb.pk_corp,\n" +
            "                 bomb.gcbm,\n" +
            "                 bomb.pk_bom_bid,\n" +
            "                 bomb.pk_bomid,\n" +
            "                 bomb.hh,\n" +
            "                 bomb.zxbmid,\n" +
            "                 bomb.sl,\n" +
            "                 invb.invcode,\n" +
            "                 invb.invname,\n" +
            "                 bomb.pk_produce\n" +
            "          from bd_bom_b bomb,\n" +
            "               bd_invbasdoc invb\n" +
            "          where bomb.zxbmid = invb.pk_invbasdoc\n" +
            "            and pk_bomid in (select TOP 1 pk_bomid\n" +
            "                             from bd_bom\n" +
            "                             where wlbmid = #{wlbmid}\n" +
            "                               and gcbm = #{gcbm}\n" +
            "                             ORDER BY ts DESC)")
    List<BomB> selectBywlbmidAndgcbmV2(String wlbmid, String gcbm);

}
