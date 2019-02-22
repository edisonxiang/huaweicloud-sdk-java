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
    public Metricdatas list() {

        return post(Metricdatas.class, "/batch-query-metric-data").execute();
    }

    /**
     * 批量查询监控数据
     */
    public Metricdatas list(GetBatchMetricDataReq getBatchMetricDataReq) {

        return post(Metricdatas.class, "/batch-query-metric-data").entity(getBatchMetricDataReq).execute();
    }

    /**
     * 添加监控数据
     */
    public ActionResponse create(List<AddMetricDataItem> addMetricDataItem) {
        checkArgument(null != addMetricDataItem, "parameter `addMetricDataItem` should not be null");

        return post(ActionResponse.class, "/metric-data").entity(addMetricDataItem).execute();
    }

    /**
     * 查询主机配置数据
     */
    public EventData getEventData(EventDataFilterOption option) {
        checkArgument(null != option, "parameter `option` should not be null");
        Map<String, Object> parameters = option.getOptions();
        checkArgument(!Strings.isNullOrEmpty(parameters.get("dim0").toString()), "parameter `dim0` should not be empty");
        checkArgument(null != parameters.get("from"), "parameter `from` should not be null");
        checkArgument(!Strings.isNullOrEmpty(parameters.get("namespace").toString()), "parameter `namespace` should not be empty");
        checkArgument(null != parameters.get("to"), "parameter `to` should not be null");
        checkArgument(!Strings.isNullOrEmpty(parameters.get("type").toString()), "parameter `type` should not be empty");

        return get(EventData.class, "/event-data").params(parameters).execute();
    }

    /**
     * 查询监控数据
     */
    public Metricdata get(MetricdataFilterOption option) {
        checkArgument(null != option, "parameter `option` should not be null");
        Map<String, Object> parameters = option.getOptions();
        checkArgument(!Strings.isNullOrEmpty(parameters.get("dim0").toString()), "parameter `dim0` should not be empty");
        checkArgument(!Strings.isNullOrEmpty(parameters.get("filter").toString()), "parameter `filter` should not be empty");
        checkArgument(null != parameters.get("from"), "parameter `from` should not be null");
        checkArgument(!Strings.isNullOrEmpty(parameters.get("metricName").toString()), "parameter `metricName` should not be empty");
        checkArgument(!Strings.isNullOrEmpty(parameters.get("namespace").toString()), "parameter `namespace` should not be empty");
        checkArgument(null != parameters.get("period"), "parameter `period` should not be null");
        checkArgument(null != parameters.get("to"), "parameter `to` should not be null");

        return get(Metricdata.class, "/metric-data").params(parameters).execute();
    }
}
