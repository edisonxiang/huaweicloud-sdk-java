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
 * 查询告警规则列表
 */
public class AlarmsFilterOption {
    
    private Map<String, Object> queryParams = Maps.newHashMap();

    private AlarmsFilterOption() {
    }

    private AlarmsFilterOption add(String param, Object value) {
        if (value != null)
            this.queryParams.put(param, value);
        return this;
    }

    public static AlarmsFilterOption create() {
        return new AlarmsFilterOption();
    }

    public Map<String, Object> getOptions() {
        return queryParams;
    }

    public AlarmsFilterOption limit(Integer limit) {
        return add("limit", limit);
    }

    public AlarmsFilterOption order(String order) {
        return add("order", order);
    }

    public AlarmsFilterOption start(String start) {
        return add("start", start);
    }
}
