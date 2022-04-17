package com.advgm.service.impl;

import com.advgm.domain.SysUserLog;
import com.advgm.mapper.SysUserLogMapper;
import com.advgm.service.SysUserLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysUserLogServiceImpl extends ServiceImpl<SysUserLogMapper, SysUserLog> implements SysUserLogService {
}
