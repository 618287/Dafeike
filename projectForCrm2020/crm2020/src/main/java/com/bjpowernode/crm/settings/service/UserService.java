package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/3
 */

public interface UserService {
    List<User> selectUS();

    User selectVerify(Map<String, Object> map);
}
