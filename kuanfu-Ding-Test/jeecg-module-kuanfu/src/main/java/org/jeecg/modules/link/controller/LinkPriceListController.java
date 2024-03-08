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
import org.jeecg.modules.link.entity.LinkPriceList;
import org.jeecg.modules.link.service.ILinkPriceListService;

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
 * @Description: 价目表更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@Api(tags="价目表更新公司编码维护")
@RestController
@RequestMapping("/link/linkPriceList")
@Slf4j
public class LinkPriceListController extends JeecgController<LinkPriceList, ILinkPriceListService> {
	@Autowired
	private ILinkPriceListService linkPriceListService;
	
	/**
	 * 分页列表查询
	 *
	 * @param linkPriceList
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "价目表更新公司编码维护-分页列表查询")
	@ApiOperation(value="价目表更新公司编码维护-分页列表查询", notes="价目表更新公司编码维护-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LinkPriceList>> queryPageList(LinkPriceList linkPriceList,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<LinkPriceList> queryWrapper = QueryGenerator.initQueryWrapper(linkPriceList, req.getParameterMap());
		Page<LinkPriceList> page = new Page<LinkPriceList>(pageNo, pageSize);
		IPage<LinkPriceList> pageList = linkPriceListService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param linkPriceList
	 * @return
	 */
	@AutoLog(value = "价目表更新公司编码维护-添加")
	@ApiOperation(value="价目表更新公司编码维护-添加", notes="价目表更新公司编码维护-添加")
	//@RequiresPermissions("link:link_price_list:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LinkPriceList linkPriceList) {
		return linkPriceListService.saveLink(linkPriceList);
	}
	
	/**
	 *  编辑
	 *
	 * @param linkPriceList
	 * @return
	 */
	@AutoLog(value = "价目表更新公司编码维护-编辑")
	@ApiOperation(value="价目表更新公司编码维护-编辑", notes="价目表更新公司编码维护-编辑")
	//@RequiresPermissions("link:link_price_list:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LinkPriceList linkPriceList) {
		linkPriceListService.updateById(linkPriceList);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "价目表更新公司编码维护-通过id删除")
	@ApiOperation(value="价目表更新公司编码维护-通过id删除", notes="价目表更新公司编码维护-通过id删除")
	//@RequiresPermissions("link:link_price_list:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		linkPriceListService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "价目表更新公司编码维护-批量删除")
	@ApiOperation(value="价目表更新公司编码维护-批量删除", notes="价目表更新公司编码维护-批量删除")
	//@RequiresPermissions("link:link_price_list:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.linkPriceListService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "价目表更新公司编码维护-通过id查询")
	@ApiOperation(value="价目表更新公司编码维护-通过id查询", notes="价目表更新公司编码维护-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LinkPriceList> queryById(@RequestParam(name="id",required=true) String id) {
		LinkPriceList linkPriceList = linkPriceListService.getById(id);
		if(linkPriceList==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(linkPriceList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param linkPriceList
    */
    //@RequiresPermissions("link:link_price_list:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LinkPriceList linkPriceList) {
        return super.exportXls(request, linkPriceList, LinkPriceList.class, "价目表更新公司编码维护");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("link:link_price_list:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LinkPriceList.class);
    }

}
