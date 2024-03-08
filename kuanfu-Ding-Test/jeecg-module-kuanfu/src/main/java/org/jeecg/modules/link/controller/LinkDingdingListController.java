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
import org.jeecg.modules.link.entity.LinkDingdingList;
import org.jeecg.modules.link.service.ILinkDingdingListService;

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
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@Api(tags="配比出库更新公司编码维护")
@RestController
@RequestMapping("/link/linkDingdingList")
@Slf4j
public class LinkDingdingListController extends JeecgController<LinkDingdingList, ILinkDingdingListService> {
	@Autowired
	private ILinkDingdingListService linkDingdingListService;
	
	/**
	 * 分页列表查询
	 *
	 * @param linkDingdingList
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "配比出库更新公司编码维护-分页列表查询")
	@ApiOperation(value="配比出库更新公司编码维护-分页列表查询", notes="配比出库更新公司编码维护-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LinkDingdingList>> queryPageList(LinkDingdingList linkDingdingList,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<LinkDingdingList> queryWrapper = QueryGenerator.initQueryWrapper(linkDingdingList, req.getParameterMap());
		Page<LinkDingdingList> page = new Page<LinkDingdingList>(pageNo, pageSize);
		IPage<LinkDingdingList> pageList = linkDingdingListService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param linkDingdingList
	 * @return
	 */
	@AutoLog(value = "配比出库更新公司编码维护-添加")
	@ApiOperation(value="配比出库更新公司编码维护-添加", notes="配比出库更新公司编码维护-添加")
	//@RequiresPermissions("link:link_dingding_list:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LinkDingdingList linkDingdingList) {
		return linkDingdingListService.saveLink(linkDingdingList);

	}
	
	/**
	 *  编辑
	 *
	 * @param linkDingdingList
	 * @return
	 */
	@AutoLog(value = "配比出库更新公司编码维护-编辑")
	@ApiOperation(value="配比出库更新公司编码维护-编辑", notes="配比出库更新公司编码维护-编辑")
	//@RequiresPermissions("link:link_dingding_list:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LinkDingdingList linkDingdingList) {
		 linkDingdingListService.updateById(linkDingdingList);
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
	//@RequiresPermissions("link:link_dingding_list:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		linkDingdingListService.removeById(id);
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
	//@RequiresPermissions("link:link_dingding_list:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.linkDingdingListService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<LinkDingdingList> queryById(@RequestParam(name="id",required=true) String id) {
		LinkDingdingList linkDingdingList = linkDingdingListService.getById(id);
		if(linkDingdingList==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(linkDingdingList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param linkDingdingList
    */
    //@RequiresPermissions("link:link_dingding_list:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LinkDingdingList linkDingdingList) {
        return super.exportXls(request, linkDingdingList, LinkDingdingList.class, "钉钉同步公司编码");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("link:link_dingding_list:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 获取上传文件对象
			MultipartFile file = entity.getValue();
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<LinkDingdingList> list = ExcelImportUtil.importExcel(file.getInputStream(), LinkDingdingList.class, params);
				//update-begin-author:taoyan date:20190528 for:批量插入数据
				long start = System.currentTimeMillis();
				//service.saveBatch(list);
				for (LinkDingdingList linkDingdingList : list) {
					linkDingdingListService.saveLink(linkDingdingList);
				}
				//400条 saveBatch消耗时间1592毫秒  循环插入消耗时间1947毫秒
				//1200条  saveBatch消耗时间3687毫秒 循环插入消耗时间5212毫秒
				log.info("消耗时间" + (System.currentTimeMillis() - start) + "毫秒");
				//update-end-author:taoyan date:20190528 for:批量插入数据
				return Result.ok("文件导入成功！数据行数：" + list.size());
			} catch (Exception e) {
				//update-begin-author:taoyan date:20211124 for: 导入数据重复增加提示
				String msg = e.getMessage();
				log.error(msg, e);
				if(msg!=null && msg.indexOf("Duplicate entry")>=0){
					return Result.error("文件导入失败:有重复数据！");
				}else{
					return Result.error("文件导入失败:" + e.getMessage());
				}
				//update-end-author:taoyan date:20211124 for: 导入数据重复增加提示
			} finally {
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return Result.error("文件导入失败！");
		// return super.importExcel(request, response, LinkDingdingList.class);
    }

}
