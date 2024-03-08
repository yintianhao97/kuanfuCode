package org.jeecg.modules.link.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 采购订单主表
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@Data
@TableName("po_order")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="po_order对象", description="采购订单主表")
public class PoOrder {
    
	/**bcooptoso*/
	@Excel(name = "bcooptoso", width = 15)
    @ApiModelProperty(value = "bcooptoso")
	private java.lang.String bcooptoso;
	/**bislatest*/
	@Excel(name = "bislatest", width = 15)
    @ApiModelProperty(value = "bislatest")
	private java.lang.String bislatest;
	/**bisreplenish*/
	@Excel(name = "bisreplenish", width = 15)
    @ApiModelProperty(value = "bisreplenish")
	private java.lang.String bisreplenish;
	/**bpubtoec*/
	@Excel(name = "bpubtoec", width = 15)
    @ApiModelProperty(value = "bpubtoec")
	private java.lang.String bpubtoec;
	/**breturn*/
	@Excel(name = "breturn", width = 15)
    @ApiModelProperty(value = "breturn")
	private java.lang.String breturn;
	/**bsocooptome*/
	@Excel(name = "bsocooptome", width = 15)
    @ApiModelProperty(value = "bsocooptome")
	private java.lang.String bsocooptome;
	/**caccountbankid*/
	@Excel(name = "caccountbankid", width = 15)
    @ApiModelProperty(value = "caccountbankid")
	private java.lang.String caccountbankid;
	/**caccountyear*/
	@Excel(name = "caccountyear", width = 15)
    @ApiModelProperty(value = "caccountyear")
	private java.lang.String caccountyear;
	/**cauditpsn*/
	@Excel(name = "cauditpsn", width = 15)
    @ApiModelProperty(value = "cauditpsn")
	private java.lang.String cauditpsn;
	/**cbiztype*/
	@Excel(name = "cbiztype", width = 15)
    @ApiModelProperty(value = "cbiztype")
	private java.lang.String cbiztype;
	/**ccontracttextpath*/
	@Excel(name = "ccontracttextpath", width = 15)
    @ApiModelProperty(value = "ccontracttextpath")
	private java.lang.String ccontracttextpath;
	/**cdeliveraddress*/
	@Excel(name = "cdeliveraddress", width = 15)
    @ApiModelProperty(value = "cdeliveraddress")
	private java.lang.String cdeliveraddress;
	/**cdeptid*/
	@Excel(name = "cdeptid", width = 15)
    @ApiModelProperty(value = "cdeptid")
	private java.lang.String cdeptid;
	/**cemployeeid*/
	@Excel(name = "cemployeeid", width = 15)
    @ApiModelProperty(value = "cemployeeid")
	private java.lang.String cemployeeid;
	/**cfreecustid*/
	@Excel(name = "cfreecustid", width = 15)
    @ApiModelProperty(value = "cfreecustid")
	private java.lang.String cfreecustid;
	/**cgiveinvoicevendor*/
	@Excel(name = "cgiveinvoicevendor", width = 15)
    @ApiModelProperty(value = "cgiveinvoicevendor")
	private java.lang.String cgiveinvoicevendor;
	/**coperator*/
	@Excel(name = "coperator", width = 15)
    @ApiModelProperty(value = "coperator")
	private java.lang.String coperator;
	/**corderid*/
	@Excel(name = "corderid", width = 15)
    @ApiModelProperty(value = "corderid")
	private java.lang.String corderid;
	/**cpubpsn*/
	@Excel(name = "cpubpsn", width = 15)
    @ApiModelProperty(value = "cpubpsn")
	private java.lang.String cpubpsn;
	/**cpurorganization*/
	@Excel(name = "cpurorganization", width = 15)
    @ApiModelProperty(value = "cpurorganization")
	private java.lang.String cpurorganization;
	/**creciever*/
	@Excel(name = "creciever", width = 15)
    @ApiModelProperty(value = "creciever")
	private java.lang.String creciever;
	/**cresppsn*/
	@Excel(name = "cresppsn", width = 15)
    @ApiModelProperty(value = "cresppsn")
	private java.lang.String cresppsn;
	/**crevisepsn*/
	@Excel(name = "crevisepsn", width = 15)
    @ApiModelProperty(value = "crevisepsn")
	private java.lang.String crevisepsn;
	/**ctermprotocolid*/
	@Excel(name = "ctermprotocolid", width = 15)
    @ApiModelProperty(value = "ctermprotocolid")
	private java.lang.String ctermprotocolid;
	/**ctransmodeid*/
	@Excel(name = "ctransmodeid", width = 15)
    @ApiModelProperty(value = "ctransmodeid")
	private java.lang.String ctransmodeid;
	/**cunfreeze*/
	@Excel(name = "cunfreeze", width = 15)
    @ApiModelProperty(value = "cunfreeze")
	private java.lang.String cunfreeze;
	/**cvendorbaseid*/
	@Excel(name = "cvendorbaseid", width = 15)
    @ApiModelProperty(value = "cvendorbaseid")
	private java.lang.String cvendorbaseid;
	/**cvendormangid*/
	@Excel(name = "cvendormangid", width = 15)
    @ApiModelProperty(value = "cvendormangid")
	private java.lang.String cvendormangid;
	/**dauditdate*/
	@Excel(name = "dauditdate", width = 15)
    @ApiModelProperty(value = "dauditdate")
	private java.lang.String dauditdate;
	/**dorderdate*/
	@Excel(name = "dorderdate", width = 15)
    @ApiModelProperty(value = "dorderdate")
	private java.lang.String dorderdate;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**drevisiondate*/
	@Excel(name = "drevisiondate", width = 15)
    @ApiModelProperty(value = "drevisiondate")
	private java.lang.String drevisiondate;
	/**forderstatus*/
	@Excel(name = "forderstatus", width = 15)
    @ApiModelProperty(value = "forderstatus")
	private java.lang.Integer forderstatus;
	/**iprintcount*/
	@Excel(name = "iprintcount", width = 15)
    @ApiModelProperty(value = "iprintcount")
	private java.lang.Integer iprintcount;
	/**irespstatus*/
	@Excel(name = "irespstatus", width = 15)
    @ApiModelProperty(value = "irespstatus")
	private java.lang.Integer irespstatus;
	/**nprepaymaxmny*/
	@Excel(name = "nprepaymaxmny", width = 15)
    @ApiModelProperty(value = "nprepaymaxmny")
	private java.math.BigDecimal nprepaymaxmny;
	/**nprepaymny*/
	@Excel(name = "nprepaymny", width = 15)
    @ApiModelProperty(value = "nprepaymny")
	private java.math.BigDecimal nprepaymny;
	/**ntotalmny*/
	@Excel(name = "ntotalmny", width = 15)
    @ApiModelProperty(value = "ntotalmny")
	private java.math.BigDecimal ntotalmny;
	/**ntotalnum*/
	@Excel(name = "ntotalnum", width = 15)
    @ApiModelProperty(value = "ntotalnum")
	private java.math.BigDecimal ntotalnum;
	/**nversion*/
	@Excel(name = "nversion", width = 15)
    @ApiModelProperty(value = "nversion")
	private java.lang.Integer nversion;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**pkDefdoc1*/
	@Excel(name = "pkDefdoc1", width = 15)
    @ApiModelProperty(value = "pkDefdoc1")
	private java.lang.String pkDefdoc1;
	/**pkDefdoc10*/
	@Excel(name = "pkDefdoc10", width = 15)
    @ApiModelProperty(value = "pkDefdoc10")
	private java.lang.String pkDefdoc10;
	/**pkDefdoc11*/
	@Excel(name = "pkDefdoc11", width = 15)
    @ApiModelProperty(value = "pkDefdoc11")
	private java.lang.String pkDefdoc11;
	/**pkDefdoc12*/
	@Excel(name = "pkDefdoc12", width = 15)
    @ApiModelProperty(value = "pkDefdoc12")
	private java.lang.String pkDefdoc12;
	/**pkDefdoc13*/
	@Excel(name = "pkDefdoc13", width = 15)
    @ApiModelProperty(value = "pkDefdoc13")
	private java.lang.String pkDefdoc13;
	/**pkDefdoc14*/
	@Excel(name = "pkDefdoc14", width = 15)
    @ApiModelProperty(value = "pkDefdoc14")
	private java.lang.String pkDefdoc14;
	/**pkDefdoc15*/
	@Excel(name = "pkDefdoc15", width = 15)
    @ApiModelProperty(value = "pkDefdoc15")
	private java.lang.String pkDefdoc15;
	/**pkDefdoc16*/
	@Excel(name = "pkDefdoc16", width = 15)
    @ApiModelProperty(value = "pkDefdoc16")
	private java.lang.String pkDefdoc16;
	/**pkDefdoc17*/
	@Excel(name = "pkDefdoc17", width = 15)
    @ApiModelProperty(value = "pkDefdoc17")
	private java.lang.String pkDefdoc17;
	/**pkDefdoc18*/
	@Excel(name = "pkDefdoc18", width = 15)
    @ApiModelProperty(value = "pkDefdoc18")
	private java.lang.String pkDefdoc18;
	/**pkDefdoc19*/
	@Excel(name = "pkDefdoc19", width = 15)
    @ApiModelProperty(value = "pkDefdoc19")
	private java.lang.String pkDefdoc19;
	/**pkDefdoc2*/
	@Excel(name = "pkDefdoc2", width = 15)
    @ApiModelProperty(value = "pkDefdoc2")
	private java.lang.String pkDefdoc2;
	/**pkDefdoc20*/
	@Excel(name = "pkDefdoc20", width = 15)
    @ApiModelProperty(value = "pkDefdoc20")
	private java.lang.String pkDefdoc20;
	/**pkDefdoc3*/
	@Excel(name = "pkDefdoc3", width = 15)
    @ApiModelProperty(value = "pkDefdoc3")
	private java.lang.String pkDefdoc3;
	/**pkDefdoc4*/
	@Excel(name = "pkDefdoc4", width = 15)
    @ApiModelProperty(value = "pkDefdoc4")
	private java.lang.String pkDefdoc4;
	/**pkDefdoc5*/
	@Excel(name = "pkDefdoc5", width = 15)
    @ApiModelProperty(value = "pkDefdoc5")
	private java.lang.String pkDefdoc5;
	/**pkDefdoc6*/
	@Excel(name = "pkDefdoc6", width = 15)
    @ApiModelProperty(value = "pkDefdoc6")
	private java.lang.String pkDefdoc6;
	/**pkDefdoc7*/
	@Excel(name = "pkDefdoc7", width = 15)
    @ApiModelProperty(value = "pkDefdoc7")
	private java.lang.String pkDefdoc7;
	/**pkDefdoc8*/
	@Excel(name = "pkDefdoc8", width = 15)
    @ApiModelProperty(value = "pkDefdoc8")
	private java.lang.String pkDefdoc8;
	/**pkDefdoc9*/
	@Excel(name = "pkDefdoc9", width = 15)
    @ApiModelProperty(value = "pkDefdoc9")
	private java.lang.String pkDefdoc9;
	/**taudittime*/
	@Excel(name = "taudittime", width = 15)
    @ApiModelProperty(value = "taudittime")
	private java.lang.String taudittime;
	/**tlastmaketime*/
	@Excel(name = "tlastmaketime", width = 15)
    @ApiModelProperty(value = "tlastmaketime")
	private java.lang.String tlastmaketime;
	/**tmaketime*/
	@Excel(name = "tmaketime", width = 15)
    @ApiModelProperty(value = "tmaketime")
	private java.lang.String tmaketime;
	/**tpubtime*/
	@Excel(name = "tpubtime", width = 15)
    @ApiModelProperty(value = "tpubtime")
	private java.lang.String tpubtime;
	/**tresptime*/
	@Excel(name = "tresptime", width = 15)
    @ApiModelProperty(value = "tresptime")
	private java.lang.String tresptime;
	/**trevisiontime*/
	@Excel(name = "trevisiontime", width = 15)
    @ApiModelProperty(value = "trevisiontime")
	private java.lang.String trevisiontime;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**vcoopordercode*/
	@Excel(name = "vcoopordercode", width = 15)
    @ApiModelProperty(value = "vcoopordercode")
	private java.lang.String vcoopordercode;
	/**vdef1*/
	@Excel(name = "vdef1", width = 15)
    @ApiModelProperty(value = "vdef1")
	private java.lang.String vdef1;
	/**vdef10*/
	@Excel(name = "vdef10", width = 15)
    @ApiModelProperty(value = "vdef10")
	private java.lang.String vdef10;
	/**vdef11*/
	@Excel(name = "vdef11", width = 15)
    @ApiModelProperty(value = "vdef11")
	private java.lang.String vdef11;
	/**vdef12*/
	@Excel(name = "vdef12", width = 15)
    @ApiModelProperty(value = "vdef12")
	private java.lang.String vdef12;
	/**vdef13*/
	@Excel(name = "vdef13", width = 15)
    @ApiModelProperty(value = "vdef13")
	private java.lang.String vdef13;
	/**vdef14*/
	@Excel(name = "vdef14", width = 15)
    @ApiModelProperty(value = "vdef14")
	private java.lang.String vdef14;
	/**vdef15*/
	@Excel(name = "vdef15", width = 15)
    @ApiModelProperty(value = "vdef15")
	private java.lang.String vdef15;
	/**vdef16*/
	@Excel(name = "vdef16", width = 15)
    @ApiModelProperty(value = "vdef16")
	private java.lang.String vdef16;
	/**vdef17*/
	@Excel(name = "vdef17", width = 15)
    @ApiModelProperty(value = "vdef17")
	private java.lang.String vdef17;
	/**vdef18*/
	@Excel(name = "vdef18", width = 15)
    @ApiModelProperty(value = "vdef18")
	private java.lang.String vdef18;
	/**vdef19*/
	@Excel(name = "vdef19", width = 15)
    @ApiModelProperty(value = "vdef19")
	private java.lang.String vdef19;
	/**vdef2*/
	@Excel(name = "vdef2", width = 15)
    @ApiModelProperty(value = "vdef2")
	private java.lang.String vdef2;
	/**vdef20*/
	@Excel(name = "vdef20", width = 15)
    @ApiModelProperty(value = "vdef20")
	private java.lang.String vdef20;
	/**vdef3*/
	@Excel(name = "vdef3", width = 15)
    @ApiModelProperty(value = "vdef3")
	private java.lang.String vdef3;
	/**vdef4*/
	@Excel(name = "vdef4", width = 15)
    @ApiModelProperty(value = "vdef4")
	private java.lang.String vdef4;
	/**vdef5*/
	@Excel(name = "vdef5", width = 15)
    @ApiModelProperty(value = "vdef5")
	private java.lang.String vdef5;
	/**vdef6*/
	@Excel(name = "vdef6", width = 15)
    @ApiModelProperty(value = "vdef6")
	private java.lang.String vdef6;
	/**vdef7*/
	@Excel(name = "vdef7", width = 15)
    @ApiModelProperty(value = "vdef7")
	private java.lang.String vdef7;
	/**vdef8*/
	@Excel(name = "vdef8", width = 15)
    @ApiModelProperty(value = "vdef8")
	private java.lang.String vdef8;
	/**vdef9*/
	@Excel(name = "vdef9", width = 15)
    @ApiModelProperty(value = "vdef9")
	private java.lang.String vdef9;
	/**vmemo*/
	@Excel(name = "vmemo", width = 15)
    @ApiModelProperty(value = "vmemo")
	private java.lang.String vmemo;
	/**vordercode*/
	@Excel(name = "vordercode", width = 15)
    @ApiModelProperty(value = "vordercode")
	private java.lang.String vordercode;
	/**vrefusrsn*/
	@Excel(name = "vrefusrsn", width = 15)
    @ApiModelProperty(value = "vrefusrsn")
	private java.lang.String vrefusrsn;
}
