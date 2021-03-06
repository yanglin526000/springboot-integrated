package com.yang.springbootintegrated.service.common.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yang.springbootintegrated.repository.common.BaseRepository;
import com.yang.springbootintegrated.service.common.BaseHibernateService;
import com.yang.springbootintegrated.utils.ConstantUtil;
import com.yang.springbootintegrated.utils.ParamUtil;

/**
 * <p>
 * 描述: 公共业务层接口实现
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:35
 * </p>
 * 
 * @param <T> 标签
 * @author yanglin
 */
@Service
public class BaseHibernateServiceImpl<T> implements BaseHibernateService<T> {

    @Autowired
    BaseRepository<T> baseRepository;

    @Transactional
    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Transactional
    @Override
    public T delete(T t) {
        ParamUtil.putField(t, "isDelete", ConstantUtil.IS_DELETE);
        return baseRepository.save(t);
    }

    @Override
    public T info(T t) {
        return baseRepository.info(t);
    }

    @Override
    public Map<String, Object> list(T t, Pageable pageable) {
        return baseRepository.list(t, pageable);
    }

    @Override
    public Map<String, Object> listAccurate(T t, Pageable pageable) {
        return baseRepository.listAccurate(t, pageable);
    }

    @Override
    public Map<String, Object> listAccurate(T t) {
        Pageable pageable = PageRequest.of(Integer.parseInt(ConstantUtil.DEFAULT_PAGE_INDEX),
                Integer.parseInt(ConstantUtil.DEFAULT_PAGE_SIZE));
        return listAccurate(t, pageable);
    }
}
