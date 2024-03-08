package org.jeecg.modules.link.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.link.entity.LinkPeibiList;
import org.jeecg.modules.link.service.ILinkPeibiListService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 配比出库更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@Api(tags="配比出库更新公司编码维护")
@RestController
@RequestMapping("/link/linkPeibiList")
@Slf4j
public class LinkPeibiListController extends JeecgController<LinkPeibiList, ILinkPeibiListService> {
	@Autowired
	private ILinkPeibiListService linkPeibiListService;
	
	/**
	 * 分页列表查询
	 *
	 * @param linkPeibiList
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "配比出库更新公司编码维护-分页列表查询")
	@ApiOperation(value="配比出库更新公司编码维护-分页列表查询", notes="配比出库更新公司编码维护-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LinkPeibiList>> queryPageList(LinkPeibiList linkPeibiList,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<LinkPeibiList> queryWrapper = QueryGenerator.initQueryWrapper(linkPeibiList, req.getParameterMap());
		Page<LinkPeibiList> page = new Page<LinkPeibiList>(pageNo, pageSize);
		IPage<LinkPeibiList> pageList = linkPeibiListService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param linkPeibiList
	 * @return
	 */
	@AutoLog(value = "配比出库更新公司编码维护-添加")
	@ApiOperation(value="配比出库更新公司编码维护-添加", notes="配比出库更新公司编码维护-添加")
	//@RequiresPermissions("link:link_peibi_list:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LinkPeibiList linkPeibiList) {
		return  linkPeibiListService.saveLink(linkPeibiList);
	}
	
	/**
	 *  编辑
	 *
	 * @param linkPeibiList
	 * @return
	 */
	@AutoLog(value = "配比出库更新公司编码维护-编辑")
	@ApiOperation(value="配比出库更新公司编码维护-编辑", notes="配比出库更新公司编码维护-编辑")
	//@RequiresPermissions("link:link_peibi_list:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LinkPeibiList linkPeibiList) {
		linkPeibiListService.updateById(linkPeibiList);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "配比出库更新公司编码维护-通过id删除")
	@ApiOperation(value="配比出库更新公司编码维护-通过id删除", notes="配比出库更新公司编码维护-通过id删除")
	//@RequiresPermissions("link:link_peibi_list:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		linkPeibiListService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "配比出库更新公司编码维护-批量删除")
	@ApiOperation(value="配比出库更新公司编码维护-批量删除", notes="配比出库更新公司编码维护-批量删除")
	//@RequiresPermissions("link:link_peibi_list:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.linkPeibiListService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "配比出库更新公司编码维护-通过id查询")
	@ApiOperation(value="配比出库更新公司编码维护-通过id查询", notes="配比出库更新公司编码维护-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LinkPeibiList> queryById(@RequestParam(name="id",required=true) String id) {
		LinkPeibiList linkPeibiList = linkPeibiListService.getById(id);
		if(linkPeibiList==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(linkPeibiList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param linkPeibiList
    */
    //@RequiresPermissions("link:link_peibi_list:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LinkPeibiList linkPeibiList) {
        return super.exportXls(request, linkPeibiList, LinkPeibiList.class, "配比出库更新公司编码维护");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("link:link_peibi_list:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LinkPeibiList.class);
    }

}
