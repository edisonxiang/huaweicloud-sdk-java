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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.openstack.common.ListResult;

import java.util.List;

/**
 * 
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAlarmReq implements ModelEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 告警名称，只能包含0-9/a-z/A-Z/_/-或汉字。
     */
    @JsonProperty("alarm_name")
    private String alarmName;

    /**
     * 
     */
    @JsonProperty("alarm_description")
    private String alarmDescription;

    /**
     * 告警指标。
     */
    @JsonProperty("metric")
    private MetricInfoExt metric;

    /**
     * 告警触发条件。
     */
    @JsonProperty("condition")
    private Condition condition;

    /**
     * 是否启用该条告警，默认为true。
     */
    @JsonProperty("alarm_enabled")
    private Boolean alarmEnabled;

    /**
     * 是否启用该条告警触发的动作，默认为true。注：若alarm_action_enabled为true，对应的alarm_actions、ok_actions至少有一个不能为空。若alarm_actions、ok_actions同时存在时，notificationList值保持一致。
     */
    @JsonProperty("alarm_action_enabled")
    private Boolean alarmActionEnabled;

    /**
     * 告警级别，默认为2，级别为1、2、3、4。分别对应紧急、重要、次要、提示。
     */
    @JsonProperty("alarm_level")
    private Integer alarmLevel;

    /**
    * 告警类型。仅针对事件告警的参数，枚举类型：EVENT.SYS或者EVENT.CUSTOM
    */
    public enum AlarmTypeEnum {
        SYS("EVENT.SYS"),
        CUSTOM("EVENT.CUSTOM");

        private final String value;

        private AlarmTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static AlarmTypeEnum value(String v) {
            if (v == null || v.isEmpty()) return null;
            for (AlarmTypeEnum t : AlarmTypeEnum.values()) {
                if (String.valueOf(t.value).equals(v)) {
                    return t;
                }
            }
            return null;
        }
    }

    /**
     * 告警类型。仅针对事件告警的参数，枚举类型：EVENT.SYS或者EVENT.CUSTOM
     */
    @JsonProperty("alarm_type")
    private AlarmTypeEnum alarmType;

    /**
     * 告警触发的动作。 结构样例如下： { \"type\": \"notification\",\"notificationList\": [\"urn:smn:southchina:68438a86d98e427e907e0097b7e35d47:sd\"] } type取值：notification：通知。 autoscaling：弹性伸缩。
     */
    @JsonProperty("alarm_actions")
    private List<AlarmActions> alarmActions;

    /**
     * 数据不足触发的动作（该参数已废弃，建议无需配置）。
     */
    @JsonProperty("insufficientdata_actions")
    private List<AlarmActions> insufficientdataActions;

    /**
     * 告警恢复触发的动作
     */
    @JsonProperty("ok_actions")
    private List<AlarmActions> okActions;
}
