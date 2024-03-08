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
import org.jeecg.modules.link.entity.DingtalkUserInfo;
import org.jeecg.modules.link.mapper.PkTranslateCodeMapper;
import org.jeecg.modules.link.service.IDingtalkUserInfoService;

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
 * @Description: 钉钉用户信息维护
 * @Author: jeecg-boot
 * @Date:   2024-02-29
 * @Version: V1.0
 */
@Api(tags="钉钉用户信息维护")
@RestController
@RequestMapping("/link/dingtalkUserInfo")
@Slf4j
public class DingtalkUserInfoController extends JeecgController<DingtalkUserInfo, IDingtalkUserInfoService> {
	@Autowired
	private IDingtalkUserInfoService dingtalkUserInfoService;
	@Autowired
	private PkTranslateCodeMapper pkTranslateCodeMapper;
	
	/**
	 * 分页列表查询
	 *
	 * @param dingtalkUserInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "钉钉用户信息维护-分页列表查询")
	@ApiOperation(value="钉钉用户信息维护-分页列表查询", notes="钉钉用户信息维护-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<DingtalkUserInfo>> queryPageList(DingtalkUserInfo dingtalkUserInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<DingtalkUserInfo> queryWrapper = QueryGenerator.initQueryWrapper(dingtalkUserInfo, req.getParameterMap());
		Page<DingtalkUserInfo> page = new Page<DingtalkUserInfo>(pageNo, pageSize);
		IPage<DingtalkUserInfo> pageList = dingtalkUserInfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param dingtalkUserInfo
	 * @return
	 */
	@AutoLog(value = "钉钉用户信息维护-添加")
	@ApiOperation(value="钉钉用户信息维护-添加", notes="钉钉用户信息维护-添加")
	//@RequiresPermissions("link:dingtalk_user_info:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody DingtalkUserInfo dingtalkUserInfo) {
		String zhanghaoxinxi = pkTranslateCodeMapper.zhanghaoxinxi(dingtalkUserInfo.getU8cPhone());
		//zhanghaoxinxi如果为空或null，说明没有查到数据
		if (zhanghaoxinxi == null || zhanghaoxinxi.equals("")) {
			return Result.error("请检查手机号是否正确！");
		}
		dingtalkUserInfo.setU8cUserPk(zhanghaoxinxi);
		String s = pkTranslateCodeMapper.zhanghaoxinxiName(dingtalkUserInfo.getU8cPhone());
		if (s == null || s.equals("")) {
			return Result.error("请检查手机号是否正确！");
		}
		dingtalkUserInfo.setU8cUserCode(s);
		dingtalkUserInfoService.save(dingtalkUserInfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param dingtalkUserInfo
	 * @return
	 */
	@AutoLog(value = "钉钉用户信息维护-编辑")
	@ApiOperation(value="钉钉用户信息维护-编辑", notes="钉钉用户信息维护-编辑")
	//@RequiresPermissions("link:dingtalk_user_info:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody DingtalkUserInfo dingtalkUserInfo) {
		dingtalkUserInfoService.updateById(dingtalkUserInfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "钉钉用户信息维护-通过id删除")
	@ApiOperation(value="钉钉用户信息维护-通过id删除", notes="钉钉用户信息维护-通过id删除")
	//@RequiresPermissions("link:dingtalk_user_info:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		dingtalkUserInfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "钉钉用户信息维护-批量删除")
	@ApiOperation(value="钉钉用户信息维护-批量删除", notes="钉钉用户信息维护-批量删除")
	//@RequiresPermissions("link:dingtalk_user_info:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.dingtalkUserInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "钉钉用户信息维护-通过id查询")
	@ApiOperation(value="钉钉用户信息维护-通过id查询", notes="钉钉用户信息维护-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<DingtalkUserInfo> queryById(@RequestParam(name="id",required=true) String id) {
		DingtalkUserInfo dingtalkUserInfo = dingtalkUserInfoService.getById(id);
		if(dingtalkUserInfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(dingtalkUserInfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param dingtalkUserInfo
    */
    //@RequiresPermissions("link:dingtalk_user_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, DingtalkUserInfo dingtalkUserInfo) {
        return super.exportXls(request, dingtalkUserInfo, DingtalkUserInfo.class, "钉钉用户信息维护");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("link:dingtalk_user_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, DingtalkUserInfo.class);
    }

}
