package com.qc.online.diagnosis.service;

import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/22 15:55
 */
public interface PermissionService {

    Set<String> findPermissionByUserid(Long id);
}
