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
        checkArgument(!Strings.isNullOrEmpty(createAlarmReq.getAlarmName()), "parameter `alarmName` should not be empty");
        checkArgument(null != createAlarmReq.getMetric(), "parameter `metric` should not be null");
        checkArgument(null != createAlarmReq.getMetric().getDimensions(), "parameter `dimensions` should not be null");
        for(int i=0; i<createAlarmReq.getMetric().getDimensions().size(); i++) {
            checkArgument(null != createAlarmReq.getMetric().getDimensions().get(i), "parameter `MetricsDimension` should not be null");
        }
        checkArgument(!Strings.isNullOrEmpty(createAlarmReq.getMetric().getMetricName()), "parameter `metricName` should not be empty");
        checkArgument(!Strings.isNullOrEmpty(createAlarmReq.getMetric().getNamespace()), "parameter `namespace` should not be empty");
        checkArgument(null != createAlarmReq.getCondition(), "parameter `condition` should not be null");
        checkArgument(!Strings.isNullOrEmpty(createAlarmReq.getCondition().getComparisonOperator()), "parameter `comparisonOperator` should not be empty");
        checkArgument(null != createAlarmReq.getCondition().getCount(), "parameter `count` should not be null");
        checkArgument(!Strings.isNullOrEmpty(createAlarmReq.getCondition().getFilter()), "parameter `filter` should not be empty");
        checkArgument(null != createAlarmReq.getCondition().getPeriod(), "parameter `period` should not be null");
        checkArgument(null != createAlarmReq.getCondition().getValue(), "parameter `value` should not be null");

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
    public ActionResponse update(String alarmId, ModifyAlarmActionReq modifyAlarmActionReq) {
        checkArgument(!Strings.isNullOrEmpty(alarmId), "parameter `alarmId` should not be empty");

        checkArgument(null != modifyAlarmActionReq, "parameter `modifyAlarmActionReq` should not be null");
        checkArgument(null != modifyAlarmActionReq.getAlarmEnabled(), "parameter `alarmEnabled` should not be null");

        return put(ActionResponse.class, "/alarms" + "/" + alarmId + "/action").entity(modifyAlarmActionReq).execute();
    }
}
