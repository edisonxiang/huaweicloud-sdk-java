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
public class EventDataInfo implements ModelEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 事件类型，例如instance_host_info。
     */
    @JsonProperty("type")
    private String type;

    /**
     * 事件上报时间。
     */
    @JsonProperty("timestamp")
    private Integer timestamp;

    /**
     * 主机配置信息。
     */
    @JsonProperty("value")
    private String value;
}
