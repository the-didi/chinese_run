package com.advgm.service;

import com.advgm.domain.OnlineCgForm;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface OnlineCgFormService {
    Page<OnlineCgForm> findByPage(Page<OnlineCgForm> page, String tableName, String tableComment);
}
