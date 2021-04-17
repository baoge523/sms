package com.manage.sys.sms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.sys.sms.api.entity.ApplyEntity;
import com.manage.sys.sms.api.entity.AuthenticationSession;
import com.manage.sys.sms.api.entity.StallEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.IAuthenticationSessionService;
import com.manage.sys.sms.api.iface.service.IApplyService;
import com.manage.sys.sms.common.SessionIDCacheManage;
import com.manage.sys.sms.dao.IApplyMapper;
import com.manage.sys.sms.dao.IStallMapper;
import com.manage.sys.sms.execption.CodeException;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
@Slf4j
@Service
public class ApplyServiceImpl implements IApplyService {

    @Autowired
    private IApplyMapper applyMapper;

    @Autowired
    private IStallMapper stallMapper;

    @Autowired
    private SessionIDCacheManage sessionManage;


    @Override
    public int insert(ApplyEntity data) {

        ApplyEntity dbEntity = applyMapper.getByUserIdAndStallId(data.getUserId(), data.getStallId());
        if (dbEntity != null) {
            log.warn("not apply replace the same stall");
            throw new CodeException(HttpStatus.FORBIDDEN,"不能重复申请相同的摊位");
        }
        return applyMapper.insert(data);
    }

    /**
     *  修改状态的--和修改处理时间
     * @param data
     */
    @Override
    public void update(ApplyEntity data) {
        applyMapper.update(data);
        if (data.getStatus() == 1) {
            QueryParam param = new QueryParam();
            param.addCondition("stallId",data.getStallId()).addCondition("status",0);
            Pair<List<ApplyEntity>, Long> list = list(param);
            list.getFirst().stream().forEach(apply -> {
                apply.setMessage("不符合条件");
                apply.setStatus(2);
                applyMapper.update(apply);
            });

            handlerStallInfo(data);
        }
    }

    @Override
    public void delete(Set<Integer> ids) {
        applyMapper.delete(ids);
    }

    @Override
    public ApplyEntity getById(Integer id) {
        return applyMapper.getById(id);
    }

    @Override
    public Pair<List<ApplyEntity>, Long> list(QueryParam param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<ApplyEntity> list = applyMapper.list(param);
        PageInfo info = new PageInfo(list);
        return new Pair<>(list,info.getTotal());
    }

    private void handlerStallInfo(ApplyEntity data) {
        StallEntity stall = stallMapper.getById(data.getStallId());
        stall.setStatus(1);
        stall.setUsername(data.getUsername());
        stall.setUserId(data.getUserId());
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MONTH,stall.getDateMonth());
        stall.setExpiration(instance.getTime());
        stallMapper.update(stall);
    }
}
