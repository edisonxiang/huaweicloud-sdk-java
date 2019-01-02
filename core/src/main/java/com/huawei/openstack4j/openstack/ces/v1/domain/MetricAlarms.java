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

package com.huawei.openstack4j.openstack.ces.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;

/**
 * 
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetricAlarms implements ModelEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 告警名称。
     */
    @JsonProperty("alarm_name")
    private String alarmName;
    /**
     * 告警描述。
     */
    @JsonProperty("alarm_description")
    private String alarmDescription;
    /**
     * 告警指标。
     */
    @JsonProperty("metric")
    private Metric metric;
    /**
     * 告警触发条件。
     */
    @JsonProperty("condition")
    private Condition condition;
    /**
     * 是否启用该条告警。
     */
    @JsonProperty("alarm_enabled")
    private Boolean alarmEnabled;
    /**
     * 告警级别，默认为2，级别为1、2、3、4。分别对应紧急、重要、次要、提示。
     */
    @JsonProperty("alarm_level")
    private Integer alarmLevel;
    /**
     * 是否启用该条告警触发的动作。
     */
    @JsonProperty("alarm_action_enabled")
    private Boolean alarmActionEnabled;
    /**
     * 告警触发的动作。  结构如下：  {  \"type\": \"notification\", \"notificationList\": [\"urn:smn:southchina:68438a86d98e427e907e0097b7e35d47:sd\"]  }  type取值： notification：通知。 autoscaling：弹性伸缩。 notificationList：告警状态发生变化时，被通知对象的列表。
     */
    @JsonProperty("alarm_actions")
    private List<AlarmActions> alarmActions;
    /**
     * 告警恢复触发的动作。  结构如下：  {  \"type\": \"notification\", \"notificationList\": [\"urn:smn:southchina:68438a86d98e427e907e0097b7e35d47:sd\"]  }  type取值：  notification：通知。  notificationList：告警状态发生变化时，被通知对象的列表。
     */
    @JsonProperty("ok_actions")
    private List<OkActions> okActions;
    /**
     * 告警规则的ID。
     */
    @JsonProperty("alarm_id")
    private String alarmId;
    /**
     * 告警状态变更的时间，UNIX时间戳，单位毫秒。
     */
    @JsonProperty("update_time")
    private Integer updateTime;
    /**
     * 告警状态，取值说明：  ok，正常 alarm，告警 insufficient_data，数据不足
     */
    @JsonProperty("alarm_state")
    private String alarmState;
}
