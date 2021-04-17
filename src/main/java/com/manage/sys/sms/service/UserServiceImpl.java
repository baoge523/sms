package com.manage.sys.sms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.sys.sms.api.entity.UserEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IUserService;
import com.manage.sys.sms.dao.IUserMapper;
import com.manage.sys.sms.execption.CodeException;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public int insert(UserEntity user) {

        UserEntity dbUser = getUserByUsername(user.getCode());
        if (dbUser != null) {
            log.error("account = [{}] already exists",user.getCode());
            throw new CodeException(HttpStatus.FORBIDDEN,"账号已经存在");
        }
        enrichUserInfo(user);
        return userMapper.insert(user);
    }

    private void enrichUserInfo(UserEntity user) {
        user.setManager(false);
    }

    @Override
    public void update(UserEntity user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Set<Integer> ids) {
        userMapper.delete(ids);
    }


    @Override
    public UserEntity getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    /**
     * 这些需要分页--需要条件查询
     * @return
     */
    @Override
    public Pair<List<UserEntity>,Long> list(QueryParam param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<UserEntity> userEntities = userMapper.list(param);
        PageInfo info = new PageInfo(userEntities);
        return new Pair<>(userEntities,info.getTotal());
    }
}
