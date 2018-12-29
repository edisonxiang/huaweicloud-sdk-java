/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
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
/******************************************************************************* 	                                                                                 
 *  Huawei has modified this source file.
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
 * *******************************************************************************/
package com.huawei.openstack4j.openstack.provider;

import java.util.Map;

import com.google.common.collect.Maps;
import com.huawei.openstack4j.api.APIProvider;

import com.huawei.openstack4j.openstack.ces.v1.internal.CESService;
import com.huawei.openstack4j.openstack.ces.v1.internal.CESEventService;
import com.huawei.openstack4j.openstack.ces.v1.internal.CESAlarmService;
import com.huawei.openstack4j.openstack.ces.v1.internal.CESMetricService;
import com.huawei.openstack4j.openstack.ces.v1.internal.CESMetricdataService;
import com.huawei.openstack4j.openstack.ces.v1.internal.CESQuotaService;


/**
 * Simple API Provider which keeps internally Maps interface implementations as singletons
 *
 * @author Jeremy Unruh
 */
public class DefaultAPIProvider implements APIProvider {

	private static final Map<Class<?>, Class<?>> bindings = Maps.newHashMap();
	private static final Map<Class<?>, Object> instances = Maps.newConcurrentMap();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize() {

		// ces
		bind(com.huawei.openstack4j.openstack.ces.v1.internal.CESService.class, com.huawei.openstack4j.openstack.ces.v1.internal.CESService.class);
		bind(com.huawei.openstack4j.openstack.ces.v1.internal.CESEventService.class, com.huawei.openstack4j.openstack.ces.v1.internal.CESEventService.class);
		bind(com.huawei.openstack4j.openstack.ces.v1.internal.CESAlarmService.class, com.huawei.openstack4j.openstack.ces.v1.internal.CESAlarmService.class);
		bind(com.huawei.openstack4j.openstack.ces.v1.internal.CESMetricService.class, com.huawei.openstack4j.openstack.ces.v1.internal.CESMetricService.class);
		bind(com.huawei.openstack4j.openstack.ces.v1.internal.CESMetricdataService.class, com.huawei.openstack4j.openstack.ces.v1.internal.CESMetricdataService.class);
		bind(com.huawei.openstack4j.openstack.ces.v1.internal.CESQuotaService.class, com.huawei.openstack4j.openstack.ces.v1.internal.CESQuotaService.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> api) {
		if (instances.containsKey(api))
			return (T) instances.get(api);

		if (bindings.containsKey(api)) {
			try {
				T impl = (T) bindings.get(api).newInstance();
				instances.put(api, impl);
				return impl;
			} catch (Exception e) {
				throw new ApiNotFoundException("API Not found for: " + api.getName(), e);
			}
		}
		throw new ApiNotFoundException("API Not found for: " + api.getName());
	}

	private void bind(Class<?> api, Class<?> impl) {
		bindings.put(api, impl);
	}
}
