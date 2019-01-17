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
public class GetBatchMetricDataReq implements ModelEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 指标数据。数组长度最大10
     */
    @JsonProperty("metrics")
    private List<MinMetric> metrics;

    /**
     * 查询数据起始时间，UNIX时间戳，单位毫秒。建议from的值相对于当前时间向前偏移至少1个周期。由于聚合运算的过程是将一个聚合周期范围内的数据点聚合到周期起始边界上，如果将from和to的范围设置在聚合周期内，会因为聚合未完成而造成查询数据为空，所以建议from参数相对于当前时间向前偏移至少1个周期。以5分钟聚合周期为例：假设当前时间点为10:35，10:30~10:35之间的原始数据会被聚合到10:30这个点上，所以查询5分钟数据点时from参数应为10:30或之前。  说明： 云监控会根据所选择的聚合粒度向前取整from参数。
     */
    @JsonProperty("from")
    private Integer from;

    /**
     * 查询数据截止时间UNIX时间戳，单位毫秒。from必须小于to。
     */
    @JsonProperty("to")
    private Integer to;

    /**
     * 监控数据粒度。  取值范围：  \"1\"，原始数据 \"300\"，5分钟粒度 \"1200\"，20分钟粒度 \"3600\"，1小时粒度 \"14400\"，4小时粒度 \"86400\"，1天粒度
     */
    @JsonProperty("period")
    private String period;

    /**
     * 数据聚合方式。  支持的值为max, min, average, sum, variance。  filter参数的值不会影响原始数据（period为1）的查询结果。
     */
    @JsonProperty("filter")
    private String filter;
}
