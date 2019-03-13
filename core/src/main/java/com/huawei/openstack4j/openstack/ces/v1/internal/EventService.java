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
 * EventService
 */
public class EventService extends BaseCESService {

    /**
     * 上报事件
     */
    public List<Event> create(List<EventItem> eventItems) {

        checkArgument(null != eventItems, "parameter `eventItems` should not be null");
        for(int i=0; i<eventItems.size(); i++) {
            checkArgument(null != eventItems.get(i), "parameter `EventItem` should not be null");
            checkArgument(!Strings.isNullOrEmpty(eventItems.get(i).getEventName()), "parameter `eventName` should not be empty");
            checkArgument(null != eventItems.get(i).getTime(), "parameter `time` should not be null");
            checkArgument(null != eventItems.get(i).getDetail(), "parameter `detail` should not be null");
        }

        return post(Event.Events.class, "/events").entity(eventItems).execute().getList();
    }
}
