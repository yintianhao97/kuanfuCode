package org.jeecg.modules.link.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BomB {

    /**pk_corp*/
    @Excel(name = "pk_corp", width = 15)
    @ApiModelProperty(value = "pk_corp")
    private java.lang.String pkCorp;


    /**gcbm*/
    @Excel(name = "gcbm", width = 15)
    @ApiModelProperty(value = "gcbm")
    private java.lang.String gcbm;

    /**pk_bom_bid*/
    @Excel(name = "pk_bom_bid", width = 15)
    @ApiModelProperty(value = "pk_bom_bid")
    private java.lang.String pkBomBid;

    /**pk_bomid*/
    @Excel(name = "pk_bomid", width = 15)
    @ApiModelProperty(value = "pk_bomid")
    private java.lang.String pkBomid;

    /**hh*/
    @Excel(name = "hh", width = 15)
    @ApiModelProperty(value = "hh")
    private java.lang.String hh;


    /**zxbmid*/
    @Excel(name = "zxbmid", width = 15)
    @ApiModelProperty(value = "zxbmid")
    private java.lang.String zxbmid;


    /**sl*/
    @Excel(name = "sl", width = 15)
    @ApiModelProperty(value = "sl")
    private BigDecimal sl;


    /**invcode*/
    @Excel(name = "invcode", width = 15)
    @ApiModelProperty(value = "invcode")
    private java.lang.String invcode;


    /**invname*/
    @Excel(name = "invname", width = 15)
    @ApiModelProperty(value = "invname")
    private java.lang.String invname;

    /**version*/
    @Excel(name = "version", width = 15)
    @ApiModelProperty(value = "version")
    private java.lang.String version;

    /**pk_produce*/
    @Excel(name = "pk_produce", width = 15)
    @ApiModelProperty(value = "pk_produce")
    private java.lang.String pkProduce;

    /**wlbmid*/
    @Excel(name = "wlbmid", width = 15)
    @ApiModelProperty(value = "wlbmid")
    private java.lang.String wlbmid;

}
