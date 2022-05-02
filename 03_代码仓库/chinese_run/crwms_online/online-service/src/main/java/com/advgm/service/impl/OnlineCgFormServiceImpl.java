package com.advgm.service.impl;

import com.advgm.domain.OnlineCgForm;
import com.advgm.mapper.OnlineCgFormMapper;
import com.advgm.service.OnlineCgFormService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OnlineCgFormServiceImpl implements OnlineCgFormService {

    @Autowired
    private OnlineCgFormMapper onlineCgFormMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<OnlineCgForm> findByPage(Page<OnlineCgForm> page, String tableName, String tableComment) {
        page.setRecords(onlineCgFormMapper.findByPage((page.getCurrent()-1)*page.getSize(),page.getCurrent(),tableName,tableComment));
        return page;
    }
}
