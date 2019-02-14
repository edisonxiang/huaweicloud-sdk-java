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
public class AddMetricDataItem implements ModelEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 指标数据。
     */
    @JsonProperty("metric")
    private MetricInfo metric;

    /**
     * 数据的有效期，超出该有效期则自动删除该数据，单位秒，最大值604800。
     */
    @JsonProperty("ttl")
    private Integer ttl;

    /**
     * 数据收集时间  UNIX时间戳，单位毫秒。  说明： 因为客户端到服务器端有延时，因此插入数据的时间戳应该在[当前时间-3天+20秒，当前时间+10分钟-20秒]区间内，保证到达服务器时不会因为传输时延造成数据不能插入数据库。
     */
    @JsonProperty("collect_time")
    private Integer collectTime;

    /**
     * 指标数据的值。
     */
    @JsonProperty("value")
    private Double value;

    /**
     * 数据的单位。
     */
    @JsonProperty("unit")
    private String unit;

    /**
     * 数据的类型，只能是\"int\"或\"float\"
     */
    @JsonProperty("type")
    private String type;
}
