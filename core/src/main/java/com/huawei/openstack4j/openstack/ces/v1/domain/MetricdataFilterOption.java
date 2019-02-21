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
 * 查询监控数据
 */
public class MetricdataFilterOption {
    
    private Map<String, Object> queryParams = Maps.newHashMap();

    private MetricdataFilterOption() {
    }

    private MetricdataFilterOption add(String param, Object value) {
        if (value != null)
            this.queryParams.put(param, value);
        return this;
    }

    public static MetricdataFilterOption create() {
        return new MetricdataFilterOption();
    }

    public Map<String, Object> getOptions() {
        return queryParams;
    }

    public MetricdataFilterOption dim0(String dim0) {
        return add("dim.0", dim0);
    }

    public MetricdataFilterOption dim1(String dim1) {
        return add("dim.1", dim1);
    }

    public MetricdataFilterOption dim2(String dim2) {
        return add("dim.2", dim2);
    }

    public MetricdataFilterOption filter(String filter) {
        return add("filter", filter);
    }

    public MetricdataFilterOption from(Integer from) {
        return add("from", from);
    }

    public MetricdataFilterOption metricName(String metricName) {
        return add("metric_name", metricName);
    }

    public MetricdataFilterOption namespace(String namespace) {
        return add("namespace", namespace);
    }

    public MetricdataFilterOption period(Integer period) {
        return add("period", period);
    }

    public MetricdataFilterOption to(Integer to) {
        return add("to", to);
    }
}
