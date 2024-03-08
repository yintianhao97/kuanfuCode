package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.ArapDjzb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 付款单副表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@DS("U8C")
public interface ArapDjzbMapper extends BaseMapper<ArapDjzb> {


/*    @Select("\t\t\t\tSELECT DISTINCT\n" +
            "\t\t\t\t\t*\n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\tarap_djzb zb \n" +
            "\t\t\t\tWHERE\n" +
            "\t\t\t\t\t( zb.qcbz = 'N' ) \n" +
            "\t\t\t\t\tAND ( zb.pzglh = 1 ) \n" +
            "\t\t\t\t\tAND ( zb.dwbm = #{corp} ) \n" +
            "\t\t\t\t\tAND ( zb.djlxbm <> 'DR' ) \n" +
            "\t\t\t\t\tAND ( zb.dr = 0 ) \n" +
            "\t\t\t\t\tAND ( zb.djzt = 1 ) \n" +
            "\t\t\t\t\tAND ( zb.hzbz = '-1' ) \n" +
            "\t\t\t\t\tAND ( zb.lybz <> 11 ) \n" +
            "\t\t\t\t\tAND ( ( zb.djlxbm = 'D3' AND ( zb.djrq >= #{qiantian} AND zb.djrq <= #{houtian} ) ) AND zb.djlxbm = 'D3' ) ")
    List<ArapDjzb> getUnsyDoc(String corp,String qiantian, String houtian);*/

    @Select("SELECT DISTINCT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tarap_djzb zb \n" +
            "WHERE\n" +
            "\t( qcbz = 'N' ) \n" +
            "\tAND ( pzglh = 1 ) \n" +
            "\tAND ( dwbm = #{corp} ) \n" +
            "\tAND ( djlxbm <> 'DR' ) \n" +
            "\tAND ( dr = 0 ) \n" +
            "\tAND ( djzt = 1 ) \n" +
            "\tAND ( hzbz = '-1' ) \n" +
            "\tAND ( lybz <> 11 ) \n" +
            "\tAND ( djlxbm = 'D3' AND ( zb.djrq >= #{qiantian} AND zb.djrq <= #{houtian} )) \n" +
            "\tAND (\n" +
            "       SELECT COUNT\n" +
            "          ( 1 ) AS num \n" +
            "            FROM\n" +
            "           EwayU8CLink..fukuan_link A \n" +
            "           WHERE\n" +
            "           A.erpCode = zb.vouchid \n" +
            "           AND ( ISNULL( A.tlastmaketime, '2014-12-03 16:28:11.357' ) = ISNULL( zb.ts, '2014-12-03 16:28:11.357' ) OR A.state != 2 ) ) = 0")
    List<ArapDjzb> getUnsyDoc(String corp,String qiantian, String houtian);

    @Select("SELECT DISTINCT\n" +
            "*\n" +
            "FROM\n" +
            "arap_djzb zb \n" +
            "WHERE\n" +
            "( zb.qcbz = 'N' ) \n" +
            "AND ( zb.pzglh = 1 ) \n" +
            "AND ( zb.djlxbm <> 'DR' ) \n" +
            "AND ( zb.dr = 0 ) \n" +
            "AND ( zb.djzt = 1 ) \n" +
            "AND ( zb.hzbz = '-1' ) \n" +
            "AND ( zb.lybz <> 11 ) \n" +
            "AND (zb.djlxbm = 'D3') \n" +
            "and vouchid = #{id}")
    ArapDjzb selectById(String id);


    @Select("select user_code from sm_user where cuserid in (select lrr from arap_Djzb where vouchid = #{vouchid})")
    String getUserId(String vouchid);


}
