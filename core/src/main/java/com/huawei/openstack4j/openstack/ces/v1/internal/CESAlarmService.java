 /*******************************************************************************
 * 	Copyright 2019 Huawei Technologies Co.,Ltd.
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/

package com.huawei.openstack4j.openstack.ces.v1.internal;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import com.huawei.openstack4j.openstack.ces.v1.domain.*;
import com.huawei.openstack4j.model.common.ActionResponse;
import com.huawei.openstack4j.openstack.compute.functions.ToActionResponseFunction;

/**
 * CESAlarmService
 */
public class CESAlarmService extends BaseCESService {

    /**
     * 创建告警规则
     */
    public AlarmResp create(CreateAlarmReq createAlarmReq) {
        checkArgument(null != createAlarmReq, "parameter `createAlarmReq` should not be null");

        return post(AlarmResp.class, "/alarms").entity(createAlarmReq).execute();
    }

    /**
     * 删除告警规则
     */
    public ActionResponse delete(String alarmId) {
        checkArgument(!Strings.isNullOrEmpty(alarmId), "parameter `alarmId` should not be empty");

        return ToActionResponseFunction.INSTANCE
                .apply(delete(Void.class, "/alarms" + "/" + alarmId)
                        .executeWithResponse());
    }

    /**
     * 查询单条告警规则信息
     */
    public Alarm get(String alarmId) {
        checkArgument(!Strings.isNullOrEmpty(alarmId), "parameter `alarmId` should not be empty");

        return get(Alarm.class, "/alarms" + "/" + alarmId).execute();
    }

    /**
     * 查询告警规则列表
     */
    public Alarms list() {

        return get(Alarms.class, "/alarms").execute();
    }

    /**
     * 查询告警规则列表
     */
    public Alarms list(AlarmsFilterOption option) {
        checkArgument(null != option, "parameter `option` should not be null");
        Map<String, Object> parameters = option.getOptions();

        return get(Alarms.class, "/alarms").params(parameters).execute();
    }

    /**
     * 启停告警规则
     */
    public String update(String alarmId, ModifyAlarmActionReq modifyAlarmActionReq) {
        checkArgument(!Strings.isNullOrEmpty(alarmId), "parameter `alarmId` should not be empty");

        return put(String.class, "/alarms" + "/" + alarmId + "/action").entity(modifyAlarmActionReq).execute();
    }
}
