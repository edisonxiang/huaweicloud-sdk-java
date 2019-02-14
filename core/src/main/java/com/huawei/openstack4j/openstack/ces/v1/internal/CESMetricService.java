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
 * CESMetricService
 */
public class CESMetricService extends BaseCESService {

    /**
     * 查询已关注指标
     */
    @Deprecated
    public FavoriteMetricsResponse getFavoriteMetrics() {

        return get(FavoriteMetricsResponse.class, "/favorite-metrics").execute();
    }

    /**
     * 查询指标列表
     */
    public MetricList listMetric(String dim0, String dim1, String dim2, Integer limit, String metricName, String namespace, String order, String start) {

        HashMap<String, Object> parameters = Maps.newHashMap();
        parameters.put("dim0", dim0);
        parameters.put("dim1", dim1);
        parameters.put("dim2", dim2);
        parameters.put("limit", limit);
        parameters.put("metricName", metricName);
        parameters.put("namespace", namespace);
        parameters.put("order", order);
        parameters.put("start", start);

        return get(MetricList.class, "/metrics").params(parameters).execute();
    }
}
