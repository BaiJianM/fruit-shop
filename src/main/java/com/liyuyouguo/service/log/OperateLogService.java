package com.liyuyouguo.service.log;

import com.liyuyouguo.entity.SysOperateLog;
import com.liyuyouguo.config.operatelog.pojo.OperateLogDto;
import com.liyuyouguo.mapper.SysOperateLogMapper;
import com.liyuyouguo.utils.ConvertUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 操作日志存储服务
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OperateLogService {

    private final SysOperateLogMapper logMapper;

    /**
     * 日志存储
     *
     * @param operateLogDto 操作日志对象
     */
    public void createLog(OperateLogDto operateLogDto) {
        ConvertUtils.convert(operateLogDto, SysOperateLog::new).ifPresent(logMapper::insert);
    }
}
