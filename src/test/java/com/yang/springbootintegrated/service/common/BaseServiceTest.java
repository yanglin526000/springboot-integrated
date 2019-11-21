package com.yang.springbootintegrated.service.common;

import java.lang.reflect.ParameterizedType;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.yang.springbootintegrated.SpringbootIntegratedApplicationTests;
import com.yang.springbootintegrated.utils.ConstantUtil;
import com.yang.springbootintegrated.utils.ParamUtil;

import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 描述: 公共测试类
 * </p>
 * <p>
 * 创建时间: 2019-11-21 10:33
 * </p>
 * 
 * @param <T> 标签
 * 
 * @author yanglin
 */
public abstract class BaseServiceTest<T> extends SpringbootIntegratedApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BaseService<T> baseService;

    /**
     * <p>
     * 描述: 通用增删改查测试方法
     * </p>
     * <p>
     * 创建时间: 2019-11-21 10:32
     * </p>
     * <p>
     * 更新时间: 2019-11-21 10:32
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @throws IllegalAccessException 非法访问异常
     * @throws InstantiationException 实例化异常
     * 
     * @author yanglin
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    @Transactional
    @Rollback
    public void common() throws InstantiationException, IllegalAccessException {
        // 新增和修改
        T dNew = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                .newInstance();
        String modelName = dNew.getClass().getAnnotation(ApiModel.class).value();
        logger.info("测试公共日志");
        ParamUtil.randomObject(dNew);
        T dNewd = baseService.save(dNew);
        Assert.notNull(dNewd, "测试新增和修改");
        logger.info(modelName + "模块-新增和修改-测试通过");
        // 查询
        T dSelect = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]).newInstance();
        Pageable pageable = PageRequest.of(Integer.parseInt(ConstantUtil.DEFAULT_PAGE_INDEX),
                Integer.parseInt(ConstantUtil.DEFAULT_PAGE_SIZE));
        Assert.notNull(baseService.list(dSelect, pageable), "测试模糊查询");
        Assert.notNull(baseService.listAccurate(dSelect, pageable), "测试精确查询");
        Assert.notNull(baseService.info(dNewd), "测试根据id查询");
        logger.info(modelName + "模块-查询-测试通过");
        // 假删除
        T dDeleted = baseService.delete(dNewd);
        Assert.notNull(dDeleted, "测试假删除");
        logger.info(modelName + "模块-删除-测试通过");
    }
}
