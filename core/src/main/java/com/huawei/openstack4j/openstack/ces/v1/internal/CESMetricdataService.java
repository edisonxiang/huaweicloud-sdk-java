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

package com.huawei.openstack4j.openstack.ces.v1.internal;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;

import com.huawei.openstack4j.openstack.ces.v1.domain.*;

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
     * 查询主机配置数据
     */
    public GetEventDataResp getEventData(String dim0, String dim1, String dim2, Integer from, String namespace, Integer to, String type, ) {
        checkArgument(!Strings.isNullOrEmpty(dim0), "parameter `dim0` should not be empty");
        checkArgument(null != from, "parameter `from` should not be null");
        checkArgument(!Strings.isNullOrEmpty(namespace), "parameter `namespace` should not be empty");
        checkArgument(null != to, "parameter `to` should not be null");
        checkArgument(!Strings.isNullOrEmpty(type), "parameter `type` should not be empty");

        return get(GetEventDataResp, "/event-data").execute();
    }

    /**
     * 查询监控数据
     */
    public MetricData getMetricData(String dim0, String dim1, String dim2, String filter, Integer from, String metricName, String namespace, Integer period, Integer to, ) {
        checkArgument(!Strings.isNullOrEmpty(dim0), "parameter `dim0` should not be empty");
        checkArgument(!Strings.isNullOrEmpty(filter), "parameter `filter` should not be empty");
        checkArgument(null != from, "parameter `from` should not be null");
        checkArgument(!Strings.isNullOrEmpty(metricName), "parameter `metricName` should not be empty");
        checkArgument(!Strings.isNullOrEmpty(namespace), "parameter `namespace` should not be empty");
        checkArgument(null != period, "parameter `period` should not be null");
        checkArgument(null != to, "parameter `to` should not be null");

        return get(MetricData, "/metric-data").execute();
    }

    /**
     * 添加监控数据
     */
    public void postMetricData(List<AddMetricDataItem> addMetricDataItem) {

        return post(.class, "/metric-data").entity(addMetricDataItem).execute();
    }
}
