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
 * @Description: 付款单副表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Data
@TableName("arap_djzb")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="arap_djzb对象", description="付款单副表")
public class ArapDjzb {
    
	/**bbje*/
	@Excel(name = "bbje", width = 15)
    @ApiModelProperty(value = "bbje")
	private java.math.BigDecimal bbje;
	/**budgetcheck*/
	@Excel(name = "budgetcheck", width = 15)
    @ApiModelProperty(value = "budgetcheck")
	private java.lang.String budgetcheck;
	/**ddhbbm*/
	@Excel(name = "ddhbbm", width = 15)
    @ApiModelProperty(value = "ddhbbm")
	private java.lang.String ddhbbm;
	/**deinvdate*/
	@Excel(name = "deinvdate", width = 15)
    @ApiModelProperty(value = "deinvdate")
	private java.lang.String deinvdate;
	/**djbh*/
	@Excel(name = "djbh", width = 15)
    @ApiModelProperty(value = "djbh")
	private java.lang.String djbh;
	/**djdl*/
	@Excel(name = "djdl", width = 15)
    @ApiModelProperty(value = "djdl")
	private java.lang.String djdl;
	/**djkjnd*/
	@Excel(name = "djkjnd", width = 15)
    @ApiModelProperty(value = "djkjnd")
	private java.lang.String djkjnd;
	/**djkjqj*/
	@Excel(name = "djkjqj", width = 15)
    @ApiModelProperty(value = "djkjqj")
	private java.lang.String djkjqj;
	/**djlxbm*/
	@Excel(name = "djlxbm", width = 15)
    @ApiModelProperty(value = "djlxbm")
	private java.lang.String djlxbm;
	/**djrq*/
	@Excel(name = "djrq", width = 15)
    @ApiModelProperty(value = "djrq")
	private java.lang.String djrq;
	/**djzt*/
	@Excel(name = "djzt", width = 15)
    @ApiModelProperty(value = "djzt")
	private java.lang.Integer djzt;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**dwbm*/
	@Excel(name = "dwbm", width = 15)
    @ApiModelProperty(value = "dwbm")
	private java.lang.String dwbm;
	/**dyvouchid*/
	@Excel(name = "dyvouchid", width = 15)
    @ApiModelProperty(value = "dyvouchid")
	private java.lang.String dyvouchid;
	/**dzrq*/
	@Excel(name = "dzrq", width = 15)
    @ApiModelProperty(value = "dzrq")
	private java.lang.String dzrq;
	/**effectdate*/
	@Excel(name = "effectdate", width = 15)
    @ApiModelProperty(value = "effectdate")
	private java.lang.String effectdate;
	/**enduser*/
	@Excel(name = "enduser", width = 15)
    @ApiModelProperty(value = "enduser")
	private java.lang.String enduser;
	/**fbje*/
	@Excel(name = "fbje", width = 15)
    @ApiModelProperty(value = "fbje")
	private java.math.BigDecimal fbje;
	/**fcounteractflag*/
	@Excel(name = "fcounteractflag", width = 15)
    @ApiModelProperty(value = "fcounteractflag")
	private java.lang.Integer fcounteractflag;
	/**feinvstatus*/
	@Excel(name = "feinvstatus", width = 15)
    @ApiModelProperty(value = "feinvstatus")
	private java.lang.Integer feinvstatus;
	/**finvoicetype*/
	@Excel(name = "finvoicetype", width = 15)
    @ApiModelProperty(value = "finvoicetype")
	private java.lang.Integer finvoicetype;
	/**fj*/
	@Excel(name = "fj", width = 15)
    @ApiModelProperty(value = "fj")
	private java.lang.Integer fj;
	/**fktjbm*/
	@Excel(name = "fktjbm", width = 15)
    @ApiModelProperty(value = "fktjbm")
	private java.lang.String fktjbm;
	/**hzbz*/
	@Excel(name = "hzbz", width = 15)
    @ApiModelProperty(value = "hzbz")
	private java.lang.String hzbz;
	/**inccontype*/
	@Excel(name = "inccontype", width = 15)
    @ApiModelProperty(value = "inccontype")
	private java.lang.Integer inccontype;
	/**innerEffectDate*/
	@Excel(name = "innerEffectDate", width = 15)
    @ApiModelProperty(value = "innerEffectDate")
	private java.lang.String innerEffectDate;
	/**iprintcount*/
	@Excel(name = "iprintcount", width = 15)
    @ApiModelProperty(value = "iprintcount")
	private java.math.BigDecimal iprintcount;
	/**isjszxzf*/
	@Excel(name = "isjszxzf", width = 15)
    @ApiModelProperty(value = "isjszxzf")
	private java.lang.String isjszxzf;
	/**isnetready*/
	@Excel(name = "isnetready", width = 15)
    @ApiModelProperty(value = "isnetready")
	private java.lang.String isnetready;
	/**isonlinepay*/
	@Excel(name = "isonlinepay", width = 15)
    @ApiModelProperty(value = "isonlinepay")
	private java.lang.String isonlinepay;
	/**ispaid*/
	@Excel(name = "ispaid", width = 15)
    @ApiModelProperty(value = "ispaid")
	private java.lang.String ispaid;
	/**isreded*/
	@Excel(name = "isreded", width = 15)
    @ApiModelProperty(value = "isreded")
	private java.lang.String isreded;
	/**isselectedpay*/
	@Excel(name = "isselectedpay", width = 15)
    @ApiModelProperty(value = "isselectedpay")
	private java.lang.Integer isselectedpay;
	/**jszxzf*/
	@Excel(name = "jszxzf", width = 15)
    @ApiModelProperty(value = "jszxzf")
	private java.lang.Integer jszxzf;
	/**kmbm*/
	@Excel(name = "kmbm", width = 15)
    @ApiModelProperty(value = "kmbm")
	private java.lang.String kmbm;
	/**kskhyh*/
	@Excel(name = "kskhyh", width = 15)
    @ApiModelProperty(value = "kskhyh")
	private java.lang.String kskhyh;
	/**lastshr*/
	@Excel(name = "lastshr", width = 15)
    @ApiModelProperty(value = "lastshr")
	private java.lang.String lastshr;
	/**lasttzr*/
	@Excel(name = "lasttzr", width = 15)
    @ApiModelProperty(value = "lasttzr")
	private java.lang.String lasttzr;
	/**lrr*/
	@Excel(name = "lrr", width = 15)
    @ApiModelProperty(value = "lrr")
	private java.lang.String lrr;
	/**lybz*/
	@Excel(name = "lybz", width = 15)
    @ApiModelProperty(value = "lybz")
	private java.lang.Integer lybz;
	/**officialprintdate*/
	@Excel(name = "officialprintdate", width = 15)
    @ApiModelProperty(value = "officialprintdate")
	private java.lang.String officialprintdate;
	/**officialprintuser*/
	@Excel(name = "officialprintuser", width = 15)
    @ApiModelProperty(value = "officialprintuser")
	private java.lang.String officialprintuser;
	/**outbusitype*/
	@Excel(name = "outbusitype", width = 15)
    @ApiModelProperty(value = "outbusitype")
	private java.lang.String outbusitype;
	/**paydate*/
	@Excel(name = "paydate", width = 15)
    @ApiModelProperty(value = "paydate")
	private java.lang.String paydate;
	/**payman*/
	@Excel(name = "payman", width = 15)
    @ApiModelProperty(value = "payman")
	private java.lang.String payman;
	/**pjJsfs*/
	@Excel(name = "pjJsfs", width = 15)
    @ApiModelProperty(value = "pjJsfs")
	private java.lang.String pjJsfs;
	/**pjNum*/
	@Excel(name = "pjNum", width = 15)
    @ApiModelProperty(value = "pjNum")
	private java.lang.String pjNum;
	/**pjOid*/
	@Excel(name = "pjOid", width = 15)
    @ApiModelProperty(value = "pjOid")
	private java.lang.String pjOid;
	/**prepay*/
	@Excel(name = "prepay", width = 15)
    @ApiModelProperty(value = "prepay")
	private java.lang.String prepay;
	/**pzglh*/
	@Excel(name = "pzglh", width = 15)
    @ApiModelProperty(value = "pzglh")
	private java.lang.Integer pzglh;
	/**qcbz*/
	@Excel(name = "qcbz", width = 15)
    @ApiModelProperty(value = "qcbz")
	private java.lang.String qcbz;
	/**qrr*/
	@Excel(name = "qrr", width = 15)
    @ApiModelProperty(value = "qrr")
	private java.lang.String qrr;
	/**scomment*/
	@Excel(name = "scomment", width = 15)
    @ApiModelProperty(value = "scomment")
	private java.lang.String scomment;
	/**settlenum*/
	@Excel(name = "settlenum", width = 15)
    @ApiModelProperty(value = "settlenum")
	private java.lang.String settlenum;
	/**sfkr*/
	@Excel(name = "sfkr", width = 15)
    @ApiModelProperty(value = "sfkr")
	private java.lang.String sfkr;
	/**shkjnd*/
	@Excel(name = "shkjnd", width = 15)
    @ApiModelProperty(value = "shkjnd")
	private java.lang.String shkjnd;
	/**shkjqj*/
	@Excel(name = "shkjqj", width = 15)
    @ApiModelProperty(value = "shkjqj")
	private java.lang.String shkjqj;
	/**shr*/
	@Excel(name = "shr", width = 15)
    @ApiModelProperty(value = "shr")
	private java.lang.String shr;
	/**shrq*/
	@Excel(name = "shrq", width = 15)
    @ApiModelProperty(value = "shrq")
	private java.lang.String shrq;
	/**shzd*/
	@Excel(name = "shzd", width = 15)
    @ApiModelProperty(value = "shzd")
	private java.lang.Integer shzd;
	/**specflag*/
	@Excel(name = "specflag", width = 15)
    @ApiModelProperty(value = "specflag")
	private java.lang.Integer specflag;
	/**spzt*/
	@Excel(name = "spzt", width = 15)
    @ApiModelProperty(value = "spzt")
	private java.lang.String spzt;
	/**ssbh*/
	@Excel(name = "ssbh", width = 15)
    @ApiModelProperty(value = "ssbh")
	private java.lang.String ssbh;
	/**sscause*/
	@Excel(name = "sscause", width = 15)
    @ApiModelProperty(value = "sscause")
	private java.lang.String sscause;
	/**sxbz*/
	@Excel(name = "sxbz", width = 15)
    @ApiModelProperty(value = "sxbz")
	private java.lang.Integer sxbz;
	/**sxkjnd*/
	@Excel(name = "sxkjnd", width = 15)
    @ApiModelProperty(value = "sxkjnd")
	private java.lang.String sxkjnd;
	/**sxkjqj*/
	@Excel(name = "sxkjqj", width = 15)
    @ApiModelProperty(value = "sxkjqj")
	private java.lang.String sxkjqj;
	/**sxr*/
	@Excel(name = "sxr", width = 15)
    @ApiModelProperty(value = "sxr")
	private java.lang.String sxr;
	/**sxrq*/
	@Excel(name = "sxrq", width = 15)
    @ApiModelProperty(value = "sxrq")
	private java.lang.String sxrq;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**veinvcode*/
	@Excel(name = "veinvcode", width = 15)
    @ApiModelProperty(value = "veinvcode")
	private java.lang.String veinvcode;
	/**veinvfailnote*/
	@Excel(name = "veinvfailnote", width = 15)
    @ApiModelProperty(value = "veinvfailnote")
	private java.lang.String veinvfailnote;
	/**veinvnumber*/
	@Excel(name = "veinvnumber", width = 15)
    @ApiModelProperty(value = "veinvnumber")
	private java.lang.String veinvnumber;
	/**vouchid*/
	@Excel(name = "vouchid", width = 15)
    @ApiModelProperty(value = "vouchid")
	private java.lang.String vouchid;
	/**vredflushcause*/
	@Excel(name = "vredflushcause", width = 15)
    @ApiModelProperty(value = "vredflushcause")
	private java.lang.Integer vredflushcause;
	/**vredletterinfo*/
	@Excel(name = "vredletterinfo", width = 15)
    @ApiModelProperty(value = "vredletterinfo")
	private java.lang.String vredletterinfo;
	/**vsplitrecord*/
	@Excel(name = "vsplitrecord", width = 15)
    @ApiModelProperty(value = "vsplitrecord")
	private java.lang.String vsplitrecord;
	/**vsrceinvcode*/
	@Excel(name = "vsrceinvcode", width = 15)
    @ApiModelProperty(value = "vsrceinvcode")
	private java.lang.String vsrceinvcode;
	/**vsrceinvnumber*/
	@Excel(name = "vsrceinvnumber", width = 15)
    @ApiModelProperty(value = "vsrceinvnumber")
	private java.lang.String vsrceinvnumber;
	/**xslxbm*/
	@Excel(name = "xslxbm", width = 15)
    @ApiModelProperty(value = "xslxbm")
	private java.lang.String xslxbm;
	/**ybje*/
	@Excel(name = "ybje", width = 15)
    @ApiModelProperty(value = "ybje")
	private java.math.BigDecimal ybje;
	/**yhhdNo*/
	@Excel(name = "yhhdNo", width = 15)
    @ApiModelProperty(value = "yhhdNo")
	private java.lang.String yhhdNo;
	/**yhqrkjnd*/
	@Excel(name = "yhqrkjnd", width = 15)
    @ApiModelProperty(value = "yhqrkjnd")
	private java.lang.String yhqrkjnd;
	/**yhqrkjqj*/
	@Excel(name = "yhqrkjqj", width = 15)
    @ApiModelProperty(value = "yhqrkjqj")
	private java.lang.String yhqrkjqj;
	/**yhqrr*/
	@Excel(name = "yhqrr", width = 15)
    @ApiModelProperty(value = "yhqrr")
	private java.lang.String yhqrr;
	/**yhqrrq*/
	@Excel(name = "yhqrrq", width = 15)
    @ApiModelProperty(value = "yhqrrq")
	private java.lang.String yhqrrq;
	/**ywbm*/
	@Excel(name = "ywbm", width = 15)
    @ApiModelProperty(value = "ywbm")
	private java.lang.String ywbm;
	/**zdr*/
	@Excel(name = "zdr", width = 15)
    @ApiModelProperty(value = "zdr")
	private java.lang.String zdr;
	/**zdrq*/
	@Excel(name = "zdrq", width = 15)
    @ApiModelProperty(value = "zdrq")
	private java.lang.String zdrq;
	/**zgyf*/
	@Excel(name = "zgyf", width = 15)
    @ApiModelProperty(value = "zgyf")
	private java.lang.Integer zgyf;
	/**zyx1*/
	@Excel(name = "zyx1", width = 15)
    @ApiModelProperty(value = "zyx1")
	private java.lang.String zyx1;
	/**zyx10*/
	@Excel(name = "zyx10", width = 15)
    @ApiModelProperty(value = "zyx10")
	private java.lang.String zyx10;
	/**zyx11*/
	@Excel(name = "zyx11", width = 15)
    @ApiModelProperty(value = "zyx11")
	private java.lang.String zyx11;
	/**zyx12*/
	@Excel(name = "zyx12", width = 15)
    @ApiModelProperty(value = "zyx12")
	private java.lang.String zyx12;
	/**zyx13*/
	@Excel(name = "zyx13", width = 15)
    @ApiModelProperty(value = "zyx13")
	private java.lang.String zyx13;
	/**zyx14*/
	@Excel(name = "zyx14", width = 15)
    @ApiModelProperty(value = "zyx14")
	private java.lang.String zyx14;
	/**zyx15*/
	@Excel(name = "zyx15", width = 15)
    @ApiModelProperty(value = "zyx15")
	private java.lang.String zyx15;
	/**zyx16*/
	@Excel(name = "zyx16", width = 15)
    @ApiModelProperty(value = "zyx16")
	private java.lang.String zyx16;
	/**zyx17*/
	@Excel(name = "zyx17", width = 15)
    @ApiModelProperty(value = "zyx17")
	private java.lang.String zyx17;
	/**zyx18*/
	@Excel(name = "zyx18", width = 15)
    @ApiModelProperty(value = "zyx18")
	private java.lang.String zyx18;
	/**zyx19*/
	@Excel(name = "zyx19", width = 15)
    @ApiModelProperty(value = "zyx19")
	private java.lang.String zyx19;
	/**zyx2*/
	@Excel(name = "zyx2", width = 15)
    @ApiModelProperty(value = "zyx2")
	private java.lang.String zyx2;
	/**zyx20*/
	@Excel(name = "zyx20", width = 15)
    @ApiModelProperty(value = "zyx20")
	private java.lang.String zyx20;
	/**zyx21*/
	@Excel(name = "zyx21", width = 15)
    @ApiModelProperty(value = "zyx21")
	private java.lang.String zyx21;
	/**zyx22*/
	@Excel(name = "zyx22", width = 15)
    @ApiModelProperty(value = "zyx22")
	private java.lang.String zyx22;
	/**zyx23*/
	@Excel(name = "zyx23", width = 15)
    @ApiModelProperty(value = "zyx23")
	private java.lang.String zyx23;
	/**zyx24*/
	@Excel(name = "zyx24", width = 15)
    @ApiModelProperty(value = "zyx24")
	private java.lang.String zyx24;
	/**zyx25*/
	@Excel(name = "zyx25", width = 15)
    @ApiModelProperty(value = "zyx25")
	private java.lang.String zyx25;
	/**zyx26*/
	@Excel(name = "zyx26", width = 15)
    @ApiModelProperty(value = "zyx26")
	private java.lang.String zyx26;
	/**zyx27*/
	@Excel(name = "zyx27", width = 15)
    @ApiModelProperty(value = "zyx27")
	private java.lang.String zyx27;
	/**zyx28*/
	@Excel(name = "zyx28", width = 15)
    @ApiModelProperty(value = "zyx28")
	private java.lang.String zyx28;
	/**zyx29*/
	@Excel(name = "zyx29", width = 15)
    @ApiModelProperty(value = "zyx29")
	private java.lang.String zyx29;
	/**zyx3*/
	@Excel(name = "zyx3", width = 15)
    @ApiModelProperty(value = "zyx3")
	private java.lang.String zyx3;
	/**zyx30*/
	@Excel(name = "zyx30", width = 15)
    @ApiModelProperty(value = "zyx30")
	private java.lang.String zyx30;
	/**zyx4*/
	@Excel(name = "zyx4", width = 15)
    @ApiModelProperty(value = "zyx4")
	private java.lang.String zyx4;
	/**zyx5*/
	@Excel(name = "zyx5", width = 15)
    @ApiModelProperty(value = "zyx5")
	private java.lang.String zyx5;
	/**zyx6*/
	@Excel(name = "zyx6", width = 15)
    @ApiModelProperty(value = "zyx6")
	private java.lang.String zyx6;
	/**zyx7*/
	@Excel(name = "zyx7", width = 15)
    @ApiModelProperty(value = "zyx7")
	private java.lang.String zyx7;
	/**zyx8*/
	@Excel(name = "zyx8", width = 15)
    @ApiModelProperty(value = "zyx8")
	private java.lang.String zyx8;
	/**zyx9*/
	@Excel(name = "zyx9", width = 15)
    @ApiModelProperty(value = "zyx9")
	private java.lang.String zyx9;
	/**zzzt*/
	@Excel(name = "zzzt", width = 15)
    @ApiModelProperty(value = "zzzt")
	private java.lang.Integer zzzt;
}
