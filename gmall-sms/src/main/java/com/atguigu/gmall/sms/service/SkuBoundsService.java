package com.atguigu.gmall.sms.service;

import com.atguigu.gmall.sms.vo.ItemSaleVo;
import com.atguigu.gmall.sms.vo.SkuSaleVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.sms.entity.SkuBoundsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author langD
 * @email langD@atguigu.com
 * @date 2020-09-22 08:33:09
 */
public interface SkuBoundsService extends IService<SkuBoundsEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    void savesales(SkuSaleVo skuSaleVo);

    List<ItemSaleVo> queryItemSalesBySkuId(Long skuId);
}

