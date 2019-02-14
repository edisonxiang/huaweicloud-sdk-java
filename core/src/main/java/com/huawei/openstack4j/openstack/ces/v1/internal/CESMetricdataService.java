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
 * CESMetricdataService
 */
public class CESMetricdataService extends BaseCESService {

    /**
     * 批量查询监控数据
     */
    public GetBatchMetricDataResp batchQueryMetricData(GetBatchMetricDataReq getBatchMetricDataReq) {

        return post(GetBatchMetricDataResp.class, "/batch-query-metric-data").entity(getBatchMetricDataReq).execute();
    }

    /**
     * 添加监控数据
     */
    public ActionResponse createMetricData(List<AddMetricDataItem> addMetricDataItem) {

        return post(ActionResponse.class, "/metric-data").entity(addMetricDataItem).execute();
    }

    /**
     * 查询主机配置数据
     */
    public GetEventDataResp getEventData(String dim0, String dim1, String dim2, Integer from, String namespace, Integer to, String type) {
        checkArgument(!Strings.isNullOrEmpty(dim0), "parameter `dim0` should not be empty");
        checkArgument(null != from, "parameter `from` should not be null");
        checkArgument(!Strings.isNullOrEmpty(namespace), "parameter `namespace` should not be empty");
        checkArgument(null != to, "parameter `to` should not be null");
        checkArgument(!Strings.isNullOrEmpty(type), "parameter `type` should not be empty");

        HashMap<String, Object> parameters = Maps.newHashMap();
        parameters.put("dim0", dim0);
        parameters.put("dim1", dim1);
        parameters.put("dim2", dim2);
        parameters.put("from", from);
        parameters.put("namespace", namespace);
        parameters.put("to", to);
        parameters.put("type", type);

        return get(GetEventDataResp.class, "/event-data").params(parameters).execute();
    }

    /**
     * 查询监控数据
     */
    public MetricData getMetricData(String dim0, String dim1, String dim2, String filter, Integer from, String metricName, String namespace, Integer period, Integer to) {
        checkArgument(!Strings.isNullOrEmpty(dim0), "parameter `dim0` should not be empty");
        checkArgument(!Strings.isNullOrEmpty(filter), "parameter `filter` should not be empty");
        checkArgument(null != from, "parameter `from` should not be null");
        checkArgument(!Strings.isNullOrEmpty(metricName), "parameter `metricName` should not be empty");
        checkArgument(!Strings.isNullOrEmpty(namespace), "parameter `namespace` should not be empty");
        checkArgument(null != period, "parameter `period` should not be null");
        checkArgument(null != to, "parameter `to` should not be null");

        HashMap<String, Object> parameters = Maps.newHashMap();
        parameters.put("dim0", dim0);
        parameters.put("dim1", dim1);
        parameters.put("dim2", dim2);
        parameters.put("filter", filter);
        parameters.put("from", from);
        parameters.put("metricName", metricName);
        parameters.put("namespace", namespace);
        parameters.put("period", period);
        parameters.put("to", to);

        return get(MetricData.class, "/metric-data").params(parameters).execute();
    }
}
