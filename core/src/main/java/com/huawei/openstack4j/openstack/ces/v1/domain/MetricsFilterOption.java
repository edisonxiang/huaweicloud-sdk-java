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

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询指标列表
 */
public class MetricsFilterOption {
    
    private Map<String, Object> queryParams = Maps.newHashMap();

    private MetricsFilterOption() {
    }

    private MetricsFilterOption add(String param, Object value) {
        if (value != null)
            this.queryParams.put(param, value);
        return this;
    }

    public static MetricsFilterOption create() {
        return new MetricsFilterOption();
    }

    public Map<String, Object> getOptions() {
        return queryParams;
    }

    public MetricsFilterOption dim0(String dim0) {
        return add("dim.0", dim0);
    }

    public MetricsFilterOption dim1(String dim1) {
        return add("dim.1", dim1);
    }

    public MetricsFilterOption dim2(String dim2) {
        return add("dim.2", dim2);
    }

    public MetricsFilterOption limit(Integer limit) {
        return add("limit", limit);
    }

    public MetricsFilterOption metricName(String metricName) {
        return add("metric_name", metricName);
    }

    public MetricsFilterOption namespace(String namespace) {
        return add("namespace", namespace);
    }

    public MetricsFilterOption order(String order) {
        return add("order", order);
    }

    public MetricsFilterOption start(String start) {
        return add("start", start);
    }
}
