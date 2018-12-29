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
public class EventItemDetail implements ModelEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 事件内容，最大长度4096。
     */
    @JsonProperty("content")
    private String content;
    /**
     * 所属分组。  资源分组对应的ID，必须传存在的分组ID。
     */
    @JsonProperty("group_id")
    private String groupId;
    /**
     * 资源ID，支持字母、数字_ -：，最大长度128。
     */
    @JsonProperty("resource_id")
    private String resourceId;
    /**
     * 资源名称，支持字母 中文 数字_ -. ，最大长度128。
     */
    @JsonProperty("resource_name")
    private String resourceName;
    /**
     * 事件状态。  枚举类型：normal\\warning\\incident
     */
    @JsonProperty("event_state")
    private EventStateEnum eventState;
    /**
     * 事件级别。  枚举类型：Critical, Major, Minor, Info
     */
    @JsonProperty("event_level")
    private EventLevelEnum eventLevel;
    /**
     * 事件用户。  支持字母 数字_ -/空格 ，最大长度64。
     */
    @JsonProperty("event_user")
    private String eventUser;
}
