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
package com.huawei.openstack4j.api.types;

public enum ServiceType {

	//@off
	CES("CES","ces"),

	UNKNOWN("NA", "NA")
	;
	//@on

	private final String serviceName;
	private final String type;

	ServiceType(String serviceName, String type) {
		this.serviceName = serviceName;
		this.type = type;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public String getType() {
		return this.type;
	}

	public static ServiceType forName(String name) {
		for (ServiceType s : ServiceType.values())
		{
			if (s.getServiceName().equalsIgnoreCase(name))
			    return s;
			if (s.name().equalsIgnoreCase(name))
				return s;
			if (s.type.equalsIgnoreCase(name))
				return s;
		}
		return ServiceType.UNKNOWN;
	}
}
