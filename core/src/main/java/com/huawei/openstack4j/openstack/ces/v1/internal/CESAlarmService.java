 /*******************************************************************************
 * 	Copyright 2018 Huawei Technologies Co.,Ltd.
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

import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;

import com.huawei.openstack4j.openstack.ces.v1.domain.*;

/**
 * CESAlarmService
 */
public class CESAlarmService extends BaseCESService {

    /**
     * 创建告警规则
     */
    public CreateOneAlarmResp createOneAlarm(CreateAlarmReq createAlarmReq) {

        return post(CreateOneAlarmResp.class, "/alarms").entity(createAlarmReq).execute();
    }

    /**
     * 删除告警规则
     */
    public ActionResponse deleteOneAlarm(String alarmId, ) {
        checkArgument(!Strings.isNullOrEmpty(alarmId), "parameter `alarmId` should not be empty");

        return ToActionResponseFunction.INSTANCE
                .apply(delete(Void.class, "/alarms" + "/alarmId"))
                        .executeWithResponse());
    }

    /**
     * 查询告警规则列表
     */
    public GetAlarmsResp getAlarms(Integer limit, String order, String start, ) {

        return get(GetAlarmsResp, "/alarms").execute();
    }

    /**
     * 查询单条告警规则信息
     */
    public GetSingleMetricAlarm getSingleAlarm(String alarmId, ) {
        checkArgument(!Strings.isNullOrEmpty(alarmId), "parameter `alarmId` should not be empty");

        return get(GetSingleMetricAlarm, "/alarms" + "/alarmId").execute();
    }

    /**
     * 启停告警规则
     */
    public String modifyAlarmAction(String alarmId, ModifyAlarmActionReq modifyAlarmActionReq) {
        checkArgument(!Strings.isNullOrEmpty(alarmId), "parameter `alarmId` should not be empty");
        checkArgument(null != modifyAlarmActionReq, "parameter `modifyAlarmActionReq` should not be null");

        return put(String.class, "/alarms" + "/alarmId" + "/action").entity(modifyAlarmActionReq).execute();
    }
}
