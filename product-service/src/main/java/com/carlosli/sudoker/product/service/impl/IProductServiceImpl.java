package com.carlosli.sudoker.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carlosli.sudoker.product.mapper.ProductMapper;
import com.carlosli.sudoker.product.pojo.Product;
import com.carlosli.sudoker.product.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */
@Service
public class IProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
