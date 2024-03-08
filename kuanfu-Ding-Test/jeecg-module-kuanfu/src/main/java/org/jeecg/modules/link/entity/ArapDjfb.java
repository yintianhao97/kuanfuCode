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
@TableName("arap_djfb")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="arap_djfb对象", description="付款单副表")
public class ArapDjfb {
    
	/**accountid*/
	@Excel(name = "accountid", width = 15)
    @ApiModelProperty(value = "accountid")
	private java.lang.String accountid;
	/**assetpactno*/
	@Excel(name = "assetpactno", width = 15)
    @ApiModelProperty(value = "assetpactno")
	private java.lang.String assetpactno;
	/**bankRelateNo*/
	@Excel(name = "bankRelateNo", width = 15)
    @ApiModelProperty(value = "bankRelateNo")
	private java.lang.String bankRelateNo;
	/**bankSeqNo*/
	@Excel(name = "bankSeqNo", width = 15)
    @ApiModelProperty(value = "bankSeqNo")
	private java.lang.String bankSeqNo;
	/**bankrollprojet*/
	@Excel(name = "bankrollprojet", width = 15)
    @ApiModelProperty(value = "bankrollprojet")
	private java.lang.String bankrollprojet;
	/**bbhl*/
	@Excel(name = "bbhl", width = 15)
    @ApiModelProperty(value = "bbhl")
	private java.math.BigDecimal bbhl;
	/**bbpjlx*/
	@Excel(name = "bbpjlx", width = 15)
    @ApiModelProperty(value = "bbpjlx")
	private java.math.BigDecimal bbpjlx;
	/**bbtxfy*/
	@Excel(name = "bbtxfy", width = 15)
    @ApiModelProperty(value = "bbtxfy")
	private java.math.BigDecimal bbtxfy;
	/**bbye*/
	@Excel(name = "bbye", width = 15)
    @ApiModelProperty(value = "bbye")
	private java.math.BigDecimal bbye;
	/**bfyhzh*/
	@Excel(name = "bfyhzh", width = 15)
    @ApiModelProperty(value = "bfyhzh")
	private java.lang.String bfyhzh;
	/**billdate*/
	@Excel(name = "billdate", width = 15)
    @ApiModelProperty(value = "billdate")
	private java.lang.String billdate;
	/**bjdwhsdj*/
	@Excel(name = "bjdwhsdj", width = 15)
    @ApiModelProperty(value = "bjdwhsdj")
	private java.math.BigDecimal bjdwhsdj;
	/**bjdwsl*/
	@Excel(name = "bjdwsl", width = 15)
    @ApiModelProperty(value = "bjdwsl")
	private java.math.BigDecimal bjdwsl;
	/**bjdwwsdj*/
	@Excel(name = "bjdwwsdj", width = 15)
    @ApiModelProperty(value = "bjdwwsdj")
	private java.math.BigDecimal bjdwwsdj;
	/**bjjldw*/
	@Excel(name = "bjjldw", width = 15)
    @ApiModelProperty(value = "bjjldw")
	private java.lang.String bjjldw;
	/**blargessflag*/
	@Excel(name = "blargessflag", width = 15)
    @ApiModelProperty(value = "blargessflag")
	private java.lang.String blargessflag;
	/**bzDate*/
	@Excel(name = "bzDate", width = 15)
    @ApiModelProperty(value = "bzDate")
	private java.lang.String bzDate;
	/**bzKjnd*/
	@Excel(name = "bzKjnd", width = 15)
    @ApiModelProperty(value = "bzKjnd")
	private java.lang.String bzKjnd;
	/**bzKjqj*/
	@Excel(name = "bzKjqj", width = 15)
    @ApiModelProperty(value = "bzKjqj")
	private java.lang.String bzKjqj;
	/**bzbm*/
	@Excel(name = "bzbm", width = 15)
    @ApiModelProperty(value = "bzbm")
	private java.lang.String bzbm;
	/**cashitem*/
	@Excel(name = "cashitem", width = 15)
    @ApiModelProperty(value = "cashitem")
	private java.lang.String cashitem;
	/**chbmCl*/
	@Excel(name = "chbmCl", width = 15)
    @ApiModelProperty(value = "chbmCl")
	private java.lang.String chbmCl;
	/**checkflag*/
	@Excel(name = "checkflag", width = 15)
    @ApiModelProperty(value = "checkflag")
	private java.lang.Integer checkflag;
	/**chmc*/
	@Excel(name = "chmc", width = 15)
    @ApiModelProperty(value = "chmc")
	private java.lang.String chmc;
	/**cinventoryid*/
	@Excel(name = "cinventoryid", width = 15)
    @ApiModelProperty(value = "cinventoryid")
	private java.lang.String cinventoryid;
	/**ckbm*/
	@Excel(name = "ckbm", width = 15)
    @ApiModelProperty(value = "ckbm")
	private java.lang.String ckbm;
	/**ckdh*/
	@Excel(name = "ckdh", width = 15)
    @ApiModelProperty(value = "ckdh")
	private java.lang.String ckdh;
	/**ckdid*/
	@Excel(name = "ckdid", width = 15)
    @ApiModelProperty(value = "ckdid")
	private java.lang.String ckdid;
	/**cksqsh*/
	@Excel(name = "cksqsh", width = 15)
    @ApiModelProperty(value = "cksqsh")
	private java.lang.String cksqsh;
	/**clbh*/
	@Excel(name = "clbh", width = 15)
    @ApiModelProperty(value = "clbh")
	private java.lang.String clbh;
	/**commonflag*/
	@Excel(name = "commonflag", width = 15)
    @ApiModelProperty(value = "commonflag")
	private java.lang.String commonflag;
	/**contractno*/
	@Excel(name = "contractno", width = 15)
    @ApiModelProperty(value = "contractno")
	private java.lang.String contractno;
	/**ctzhtlxPk*/
	@Excel(name = "ctzhtlxPk", width = 15)
    @ApiModelProperty(value = "ctzhtlxPk")
	private java.lang.String ctzhtlxPk;
	/**ddh*/
	@Excel(name = "ddh", width = 15)
    @ApiModelProperty(value = "ddh")
	private java.lang.String ddh;
	/**ddhh*/
	@Excel(name = "ddhh", width = 15)
    @ApiModelProperty(value = "ddhh")
	private java.lang.String ddhh;
	/**ddhid*/
	@Excel(name = "ddhid", width = 15)
    @ApiModelProperty(value = "ddhid")
	private java.lang.String ddhid;
	/**ddlx*/
	@Excel(name = "ddlx", width = 15)
    @ApiModelProperty(value = "ddlx")
	private java.lang.String ddlx;
	/**deptid*/
	@Excel(name = "deptid", width = 15)
    @ApiModelProperty(value = "deptid")
	private java.lang.String deptid;
	/**dfbbje*/
	@Excel(name = "dfbbje", width = 15)
    @ApiModelProperty(value = "dfbbje")
	private java.math.BigDecimal dfbbje;
	/**dfbbsj*/
	@Excel(name = "dfbbsj", width = 15)
    @ApiModelProperty(value = "dfbbsj")
	private java.math.BigDecimal dfbbsj;
	/**dfbbwsje*/
	@Excel(name = "dfbbwsje", width = 15)
    @ApiModelProperty(value = "dfbbwsje")
	private java.math.BigDecimal dfbbwsje;
	/**dffbje*/
	@Excel(name = "dffbje", width = 15)
    @ApiModelProperty(value = "dffbje")
	private java.math.BigDecimal dffbje;
	/**dffbsj*/
	@Excel(name = "dffbsj", width = 15)
    @ApiModelProperty(value = "dffbsj")
	private java.math.BigDecimal dffbsj;
	/**dfjs*/
	@Excel(name = "dfjs", width = 15)
    @ApiModelProperty(value = "dfjs")
	private java.math.BigDecimal dfjs;
	/**dfshl*/
	@Excel(name = "dfshl", width = 15)
    @ApiModelProperty(value = "dfshl")
	private java.math.BigDecimal dfshl;
	/**dfybje*/
	@Excel(name = "dfybje", width = 15)
    @ApiModelProperty(value = "dfybje")
	private java.math.BigDecimal dfybje;
	/**dfybsj*/
	@Excel(name = "dfybsj", width = 15)
    @ApiModelProperty(value = "dfybsj")
	private java.math.BigDecimal dfybsj;
	/**dfybwsje*/
	@Excel(name = "dfybwsje", width = 15)
    @ApiModelProperty(value = "dfybwsje")
	private java.math.BigDecimal dfybwsje;
	/**dfyhzh*/
	@Excel(name = "dfyhzh", width = 15)
    @ApiModelProperty(value = "dfyhzh")
	private java.lang.String dfyhzh;
	/**discountmny*/
	@Excel(name = "discountmny", width = 15)
    @ApiModelProperty(value = "discountmny")
	private java.math.BigDecimal discountmny;
	/**dj*/
	@Excel(name = "dj", width = 15)
    @ApiModelProperty(value = "dj")
	private java.math.BigDecimal dj;
	/**djbh*/
	@Excel(name = "djbh", width = 15)
    @ApiModelProperty(value = "djbh")
	private java.lang.String djbh;
	/**djdl*/
	@Excel(name = "djdl", width = 15)
    @ApiModelProperty(value = "djdl")
	private java.lang.String djdl;
	/**djlxbm*/
	@Excel(name = "djlxbm", width = 15)
    @ApiModelProperty(value = "djlxbm")
	private java.lang.String djlxbm;
	/**djxtflag*/
	@Excel(name = "djxtflag", width = 15)
    @ApiModelProperty(value = "djxtflag")
	private java.lang.Integer djxtflag;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**dstlsubcs*/
	@Excel(name = "dstlsubcs", width = 15)
    @ApiModelProperty(value = "dstlsubcs")
	private java.lang.String dstlsubcs;
	/**dwbm*/
	@Excel(name = "dwbm", width = 15)
    @ApiModelProperty(value = "dwbm")
	private java.lang.String dwbm;
	/**encode*/
	@Excel(name = "encode", width = 15)
    @ApiModelProperty(value = "encode")
	private java.lang.String encode;
	/**equipmentcode*/
	@Excel(name = "equipmentcode", width = 15)
    @ApiModelProperty(value = "equipmentcode")
	private java.lang.String equipmentcode;
	/**facardbh*/
	@Excel(name = "facardbh", width = 15)
    @ApiModelProperty(value = "facardbh")
	private java.lang.String facardbh;
	/**fbOid*/
	@Excel(name = "fbOid", width = 15)
    @ApiModelProperty(value = "fbOid")
	private java.lang.String fbOid;
	/**fbhl*/
	@Excel(name = "fbhl", width = 15)
    @ApiModelProperty(value = "fbhl")
	private java.math.BigDecimal fbhl;
	/**fbpjlx*/
	@Excel(name = "fbpjlx", width = 15)
    @ApiModelProperty(value = "fbpjlx")
	private java.math.BigDecimal fbpjlx;
	/**fbtxfy*/
	@Excel(name = "fbtxfy", width = 15)
    @ApiModelProperty(value = "fbtxfy")
	private java.math.BigDecimal fbtxfy;
	/**fbye*/
	@Excel(name = "fbye", width = 15)
    @ApiModelProperty(value = "fbye")
	private java.math.BigDecimal fbye;
	/**fjldw*/
	@Excel(name = "fjldw", width = 15)
    @ApiModelProperty(value = "fjldw")
	private java.lang.String fjldw;
	/**fkyhdz*/
	@Excel(name = "fkyhdz", width = 15)
    @ApiModelProperty(value = "fkyhdz")
	private java.lang.String fkyhdz;
	/**fkyhmc*/
	@Excel(name = "fkyhmc", width = 15)
    @ApiModelProperty(value = "fkyhmc")
	private java.lang.String fkyhmc;
	/**flbh*/
	@Excel(name = "flbh", width = 15)
    @ApiModelProperty(value = "flbh")
	private java.lang.Integer flbh;
	/**fph*/
	@Excel(name = "fph", width = 15)
    @ApiModelProperty(value = "fph")
	private java.lang.String fph;
	/**fphid*/
	@Excel(name = "fphid", width = 15)
    @ApiModelProperty(value = "fphid")
	private java.lang.String fphid;
	/**freeitemid*/
	@Excel(name = "freeitemid", width = 15)
    @ApiModelProperty(value = "freeitemid")
	private java.lang.String freeitemid;
	/**fx*/
	@Excel(name = "fx", width = 15)
    @ApiModelProperty(value = "fx")
	private java.lang.Integer fx;
	/**ggxh*/
	@Excel(name = "ggxh", width = 15)
    @ApiModelProperty(value = "ggxh")
	private java.lang.String ggxh;
	/**groupnum*/
	@Excel(name = "groupnum", width = 15)
    @ApiModelProperty(value = "groupnum")
	private java.lang.String groupnum;
	/**hbbm*/
	@Excel(name = "hbbm", width = 15)
    @ApiModelProperty(value = "hbbm")
	private java.lang.String hbbm;
	/**hsdj*/
	@Excel(name = "hsdj", width = 15)
    @ApiModelProperty(value = "hsdj")
	private java.math.BigDecimal hsdj;
	/**hsl*/
	@Excel(name = "hsl", width = 15)
    @ApiModelProperty(value = "hsl")
	private java.math.BigDecimal hsl;
	/**htbh*/
	@Excel(name = "htbh", width = 15)
    @ApiModelProperty(value = "htbh")
	private java.lang.String htbh;
	/**htmc*/
	@Excel(name = "htmc", width = 15)
    @ApiModelProperty(value = "htmc")
	private java.lang.String htmc;
	/**innerorderno*/
	@Excel(name = "innerorderno", width = 15)
    @ApiModelProperty(value = "innerorderno")
	private java.lang.String innerorderno;
	/**issfkxychanged*/
	@Excel(name = "issfkxychanged", width = 15)
    @ApiModelProperty(value = "issfkxychanged")
	private java.lang.String issfkxychanged;
	/**isverifyfinished*/
	@Excel(name = "isverifyfinished", width = 15)
    @ApiModelProperty(value = "isverifyfinished")
	private java.lang.String isverifyfinished;
	/**itemBillPk*/
	@Excel(name = "itemBillPk", width = 15)
    @ApiModelProperty(value = "itemBillPk")
	private java.lang.String itemBillPk;
	/**itemstyle*/
	@Excel(name = "itemstyle", width = 15)
    @ApiModelProperty(value = "itemstyle")
	private java.lang.String itemstyle;
	/**jfbbje*/
	@Excel(name = "jfbbje", width = 15)
    @ApiModelProperty(value = "jfbbje")
	private java.math.BigDecimal jfbbje;
	/**jfbbsj*/
	@Excel(name = "jfbbsj", width = 15)
    @ApiModelProperty(value = "jfbbsj")
	private java.math.BigDecimal jfbbsj;
	/**jffbje*/
	@Excel(name = "jffbje", width = 15)
    @ApiModelProperty(value = "jffbje")
	private java.math.BigDecimal jffbje;
	/**jffbsj*/
	@Excel(name = "jffbsj", width = 15)
    @ApiModelProperty(value = "jffbsj")
	private java.math.BigDecimal jffbsj;
	/**jfjs*/
	@Excel(name = "jfjs", width = 15)
    @ApiModelProperty(value = "jfjs")
	private java.math.BigDecimal jfjs;
	/**jfshl*/
	@Excel(name = "jfshl", width = 15)
    @ApiModelProperty(value = "jfshl")
	private java.math.BigDecimal jfshl;
	/**jfybje*/
	@Excel(name = "jfybje", width = 15)
    @ApiModelProperty(value = "jfybje")
	private java.math.BigDecimal jfybje;
	/**jfybsj*/
	@Excel(name = "jfybsj", width = 15)
    @ApiModelProperty(value = "jfybsj")
	private java.math.BigDecimal jfybsj;
	/**jfybwsje*/
	@Excel(name = "jfybwsje", width = 15)
    @ApiModelProperty(value = "jfybwsje")
	private java.math.BigDecimal jfybwsje;
	/**jfzkfbje*/
	@Excel(name = "jfzkfbje", width = 15)
    @ApiModelProperty(value = "jfzkfbje")
	private java.math.BigDecimal jfzkfbje;
	/**jfzkybje*/
	@Excel(name = "jfzkybje", width = 15)
    @ApiModelProperty(value = "jfzkybje")
	private java.math.BigDecimal jfzkybje;
	/**jobid*/
	@Excel(name = "jobid", width = 15)
    @ApiModelProperty(value = "jobid")
	private java.lang.String jobid;
	/**jobphaseid*/
	@Excel(name = "jobphaseid", width = 15)
    @ApiModelProperty(value = "jobphaseid")
	private java.lang.String jobphaseid;
	/**jsfsbm*/
	@Excel(name = "jsfsbm", width = 15)
    @ApiModelProperty(value = "jsfsbm")
	private java.lang.String jsfsbm;
	/**jshj*/
	@Excel(name = "jshj", width = 15)
    @ApiModelProperty(value = "jshj")
	private java.math.BigDecimal jshj;
	/**kmbm*/
	@Excel(name = "kmbm", width = 15)
    @ApiModelProperty(value = "kmbm")
	private java.lang.String kmbm;
	/**kprq*/
	@Excel(name = "kprq", width = 15)
    @ApiModelProperty(value = "kprq")
	private java.lang.String kprq;
	/**ksbmCl*/
	@Excel(name = "ksbmCl", width = 15)
    @ApiModelProperty(value = "ksbmCl")
	private java.lang.String ksbmCl;
	/**kslb*/
	@Excel(name = "kslb", width = 15)
    @ApiModelProperty(value = "kslb")
	private java.lang.Integer kslb;
	/**kxyt*/
	@Excel(name = "kxyt", width = 15)
    @ApiModelProperty(value = "kxyt")
	private java.lang.String kxyt;
	/**notetype*/
	@Excel(name = "notetype", width = 15)
    @ApiModelProperty(value = "notetype")
	private java.lang.String notetype;
	/**occupationmny*/
	@Excel(name = "occupationmny", width = 15)
    @ApiModelProperty(value = "occupationmny")
	private java.math.BigDecimal occupationmny;
	/**oldFlag*/
	@Excel(name = "oldFlag", width = 15)
    @ApiModelProperty(value = "oldFlag")
	private java.lang.String oldFlag;
	/**oldSysFlag*/
	@Excel(name = "oldSysFlag", width = 15)
    @ApiModelProperty(value = "oldSysFlag")
	private java.lang.String oldSysFlag;
	/**ordercusmandoc*/
	@Excel(name = "ordercusmandoc", width = 15)
    @ApiModelProperty(value = "ordercusmandoc")
	private java.lang.String ordercusmandoc;
	/**othersysflag*/
	@Excel(name = "othersysflag", width = 15)
    @ApiModelProperty(value = "othersysflag")
	private java.lang.String othersysflag;
	/**pausetransact*/
	@Excel(name = "pausetransact", width = 15)
    @ApiModelProperty(value = "pausetransact")
	private java.lang.String pausetransact;
	/**paydate*/
	@Excel(name = "paydate", width = 15)
    @ApiModelProperty(value = "paydate")
	private java.lang.String paydate;
	/**payflag*/
	@Excel(name = "payflag", width = 15)
    @ApiModelProperty(value = "payflag")
	private java.lang.Integer payflag;
	/**payman*/
	@Excel(name = "payman", width = 15)
    @ApiModelProperty(value = "payman")
	private java.lang.String payman;
	/**pch*/
	@Excel(name = "pch", width = 15)
    @ApiModelProperty(value = "pch")
	private java.lang.String pch;
	/**ph*/
	@Excel(name = "ph", width = 15)
    @ApiModelProperty(value = "ph")
	private java.lang.String ph;
	/**pjJsfs*/
	@Excel(name = "pjJsfs", width = 15)
    @ApiModelProperty(value = "pjJsfs")
	private java.lang.String pjJsfs;
	/**pjdirection*/
	@Excel(name = "pjdirection", width = 15)
    @ApiModelProperty(value = "pjdirection")
	private java.lang.String pjdirection;
	/**pjh*/
	@Excel(name = "pjh", width = 15)
    @ApiModelProperty(value = "pjh")
	private java.lang.String pjh;
	/**pkJobobjpha*/
	@Excel(name = "pkJobobjpha", width = 15)
    @ApiModelProperty(value = "pkJobobjpha")
	private java.lang.String pkJobobjpha;
	/**pkTaxclass*/
	@Excel(name = "pkTaxclass", width = 15)
    @ApiModelProperty(value = "pkTaxclass")
	private java.lang.String pkTaxclass;
	/**produceorder*/
	@Excel(name = "produceorder", width = 15)
    @ApiModelProperty(value = "produceorder")
	private java.lang.String produceorder;
	/**productline*/
	@Excel(name = "productline", width = 15)
    @ApiModelProperty(value = "productline")
	private java.lang.String productline;
	/**pzflh*/
	@Excel(name = "pzflh", width = 15)
    @ApiModelProperty(value = "pzflh")
	private java.lang.Integer pzflh;
	/**qxrq*/
	@Excel(name = "qxrq", width = 15)
    @ApiModelProperty(value = "qxrq")
	private java.lang.String qxrq;
	/**sanhu*/
	@Excel(name = "sanhu", width = 15)
    @ApiModelProperty(value = "sanhu")
	private java.lang.String sanhu;
	/**seqnum*/
	@Excel(name = "seqnum", width = 15)
    @ApiModelProperty(value = "seqnum")
	private java.lang.String seqnum;
	/**sfbz*/
	@Excel(name = "sfbz", width = 15)
    @ApiModelProperty(value = "sfbz")
	private java.lang.String sfbz;
	/**sfkxyh*/
	@Excel(name = "sfkxyh", width = 15)
    @ApiModelProperty(value = "sfkxyh")
	private java.lang.String sfkxyh;
	/**shlye*/
	@Excel(name = "shlye", width = 15)
    @ApiModelProperty(value = "shlye")
	private java.math.BigDecimal shlye;
	/**skyhdz*/
	@Excel(name = "skyhdz", width = 15)
    @ApiModelProperty(value = "skyhdz")
	private java.lang.String skyhdz;
	/**skyhmc*/
	@Excel(name = "skyhmc", width = 15)
    @ApiModelProperty(value = "skyhmc")
	private java.lang.String skyhmc;
	/**sl*/
	@Excel(name = "sl", width = 15)
    @ApiModelProperty(value = "sl")
	private java.math.BigDecimal sl;
	/**spzt*/
	@Excel(name = "spzt", width = 15)
    @ApiModelProperty(value = "spzt")
	private java.lang.Integer spzt;
	/**srbz*/
	@Excel(name = "srbz", width = 15)
    @ApiModelProperty(value = "srbz")
	private java.lang.String srbz;
	/**szxmid*/
	@Excel(name = "szxmid", width = 15)
    @ApiModelProperty(value = "szxmid")
	private java.lang.String szxmid;
	/**task*/
	@Excel(name = "task", width = 15)
    @ApiModelProperty(value = "task")
	private java.lang.String task;
	/**taxNum*/
	@Excel(name = "taxNum", width = 15)
    @ApiModelProperty(value = "taxNum")
	private java.lang.String taxNum;
	/**tbbh*/
	@Excel(name = "tbbh", width = 15)
    @ApiModelProperty(value = "tbbh")
	private java.lang.String tbbh;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**txlxBbje*/
	@Excel(name = "txlxBbje", width = 15)
    @ApiModelProperty(value = "txlxBbje")
	private java.math.BigDecimal txlxBbje;
	/**txlxFbje*/
	@Excel(name = "txlxFbje", width = 15)
    @ApiModelProperty(value = "txlxFbje")
	private java.math.BigDecimal txlxFbje;
	/**txlxYbje*/
	@Excel(name = "txlxYbje", width = 15)
    @ApiModelProperty(value = "txlxYbje")
	private java.math.BigDecimal txlxYbje;
	/**undefined1*/
	@Excel(name = "undefined1", width = 15)
    @ApiModelProperty(value = "undefined1")
	private java.lang.String undefined1;
	/**undefined2*/
	@Excel(name = "undefined2", width = 15)
    @ApiModelProperty(value = "undefined2")
	private java.lang.String undefined2;
	/**undefined3*/
	@Excel(name = "undefined3", width = 15)
    @ApiModelProperty(value = "undefined3")
	private java.lang.String undefined3;
	/**undefined4*/
	@Excel(name = "undefined4", width = 15)
    @ApiModelProperty(value = "undefined4")
	private java.lang.String undefined4;
	/**undefined5*/
	@Excel(name = "undefined5", width = 15)
    @ApiModelProperty(value = "undefined5")
	private java.lang.String undefined5;
	/**usedept*/
	@Excel(name = "usedept", width = 15)
    @ApiModelProperty(value = "usedept")
	private java.lang.String usedept;
	/**verifyfinisheddate*/
	@Excel(name = "verifyfinisheddate", width = 15)
    @ApiModelProperty(value = "verifyfinisheddate")
	private java.lang.String verifyfinisheddate;
	/**vouchid*/
	@Excel(name = "vouchid", width = 15)
    @ApiModelProperty(value = "vouchid")
	private java.lang.String vouchid;
	/**wbfbbje*/
	@Excel(name = "wbfbbje", width = 15)
    @ApiModelProperty(value = "wbfbbje")
	private java.math.BigDecimal wbfbbje;
	/**wbffbje*/
	@Excel(name = "wbffbje", width = 15)
    @ApiModelProperty(value = "wbffbje")
	private java.math.BigDecimal wbffbje;
	/**wbfybje*/
	@Excel(name = "wbfybje", width = 15)
    @ApiModelProperty(value = "wbfybje")
	private java.math.BigDecimal wbfybje;
	/**wldx*/
	@Excel(name = "wldx", width = 15)
    @ApiModelProperty(value = "wldx")
	private java.lang.Integer wldx;
	/**xbbm3*/
	@Excel(name = "xbbm3", width = 15)
    @ApiModelProperty(value = "xbbm3")
	private java.lang.String xbbm3;
	/**xgbh*/
	@Excel(name = "xgbh", width = 15)
    @ApiModelProperty(value = "xgbh")
	private java.lang.Integer xgbh;
	/**xm*/
	@Excel(name = "xm", width = 15)
    @ApiModelProperty(value = "xm")
	private java.lang.String xm;
	/**xmbm2*/
	@Excel(name = "xmbm2", width = 15)
    @ApiModelProperty(value = "xmbm2")
	private java.lang.String xmbm2;
	/**xmbm4*/
	@Excel(name = "xmbm4", width = 15)
    @ApiModelProperty(value = "xmbm4")
	private java.lang.String xmbm4;
	/**xmys*/
	@Excel(name = "xmys", width = 15)
    @ApiModelProperty(value = "xmys")
	private java.lang.String xmys;
	/**xyzh*/
	@Excel(name = "xyzh", width = 15)
    @ApiModelProperty(value = "xyzh")
	private java.lang.String xyzh;
	/**ybpjlx*/
	@Excel(name = "ybpjlx", width = 15)
    @ApiModelProperty(value = "ybpjlx")
	private java.math.BigDecimal ybpjlx;
	/**ybtxfy*/
	@Excel(name = "ybtxfy", width = 15)
    @ApiModelProperty(value = "ybtxfy")
	private java.math.BigDecimal ybtxfy;
	/**ybye*/
	@Excel(name = "ybye", width = 15)
    @ApiModelProperty(value = "ybye")
	private java.math.BigDecimal ybye;
	/**ycskrq*/
	@Excel(name = "ycskrq", width = 15)
    @ApiModelProperty(value = "ycskrq")
	private java.lang.String ycskrq;
	/**ysbbye*/
	@Excel(name = "ysbbye", width = 15)
    @ApiModelProperty(value = "ysbbye")
	private java.math.BigDecimal ysbbye;
	/**ysfbye*/
	@Excel(name = "ysfbye", width = 15)
    @ApiModelProperty(value = "ysfbye")
	private java.math.BigDecimal ysfbye;
	/**ysybye*/
	@Excel(name = "ysybye", width = 15)
    @ApiModelProperty(value = "ysybye")
	private java.math.BigDecimal ysybye;
	/**ywbm*/
	@Excel(name = "ywbm", width = 15)
    @ApiModelProperty(value = "ywbm")
	private java.lang.String ywbm;
	/**ywxz*/
	@Excel(name = "ywxz", width = 15)
    @ApiModelProperty(value = "ywxz")
	private java.lang.String ywxz;
	/**ywybm*/
	@Excel(name = "ywybm", width = 15)
    @ApiModelProperty(value = "ywybm")
	private java.lang.String ywybm;
	/**zjldw*/
	@Excel(name = "zjldw", width = 15)
    @ApiModelProperty(value = "zjldw")
	private java.lang.String zjldw;
	/**zkl*/
	@Excel(name = "zkl", width = 15)
    @ApiModelProperty(value = "zkl")
	private java.math.BigDecimal zkl;
	/**zrdeptid*/
	@Excel(name = "zrdeptid", width = 15)
    @ApiModelProperty(value = "zrdeptid")
	private java.lang.String zrdeptid;
	/**zy*/
	@Excel(name = "zy", width = 15)
    @ApiModelProperty(value = "zy")
	private java.lang.String zy;
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
}
