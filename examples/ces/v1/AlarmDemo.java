package ces.v1;

import java.util.ArrayList;
import java.util.List;

import com.huawei.openstack4j.api.OSClient.OSClientV3;
import com.huawei.openstack4j.api.types.ServiceType;
import com.huawei.openstack4j.core.transport.Config;

import com.huawei.openstack4j.model.common.ActionResponse;
import com.huawei.openstack4j.model.common.Identifier;
import com.huawei.openstack4j.openstack.OSFactory;
import com.huawei.openstack4j.openstack.ces.v1.domain.Condition;
import com.huawei.openstack4j.openstack.ces.v1.domain.CreateAlarmReq;
import com.huawei.openstack4j.openstack.ces.v1.domain.CreateOneAlarmResp;
import com.huawei.openstack4j.openstack.ces.v1.domain.GetAllMetricAlarms;
import com.huawei.openstack4j.openstack.ces.v1.domain.GetSingleMetricAlarm;
import com.huawei.openstack4j.openstack.ces.v1.domain.MetricInfoExt;
import com.huawei.openstack4j.openstack.ces.v1.domain.MetricAlarms;
import com.huawei.openstack4j.openstack.ces.v1.domain.MetricsDimension;
import com.huawei.openstack4j.openstack.ces.v1.domain.ModifyAlarmActionReq;
import com.huawei.openstack4j.openstack.identity.internal.OverridableEndpointURLResolver;

public class AlarmDemo {
        public static void main(String[] args) {

                OSFactory.enableHttpLoggingFilter(true);

                String authUrl = "******"; //endpoint Url
                String user = "******"; //username
                String password = "******"; //password
                String projectId = "******"; //projectId
                String userDomainId = "******"; //domainId
                    			
                // Using credentials for authentication
                OverridableEndpointURLResolver endpointResolver = new OverridableEndpointURLResolver();
    			endpointResolver.addOverrideEndpoint(ServiceType.CES,
    					"******");		

                //create connection
                Config config = Config.newConfig()
                		.withEndpointURLResolver(endpointResolver)
                		.withLanguage("zh-cn")
                		.withSSLVerificationDisabled();
                // initial client
                OSClientV3 os = OSFactory.builderV3()
                        .withConfig(config)
                        .endpoint(authUrl)
                        .credentials(user, password, Identifier.byId(userDomainId))
                        .scopeToDomain(Identifier.byId(userDomainId))
                        .scopeToProject(Identifier.byId(projectId))
                        .authenticate();
                
                /*{
                	  "alarm_name": "alarm-xiang",
                	  "alarm_description": "alarm test for xiang",
                	  "metric": {
                	    "namespace": "SYS.ECS",
                	    "metric_name": "cpu_util",
                	    "dimensions": [{
                	      "name": "instance_id",
                	      "value": "2b8bd8bb-45aa-4324-88a8-ffa1d9d5b1cd"
                	    }
                	    ]
                	  },
                	  "condition": {
                	    "period": 1,
                	    "filter": "average",
                	    "comparison_operator": ">=",
                	    "value": 80,
                	    "unit": "%",
                	    "count": 3
                	  },
                	  "alarm_enabled": true,
                	  "alarm_action_enabled": false,
                	  "alarm_level": 2
                }*/
                // Create Alarm
                Condition condition = Condition.builder()
                		.period(1)
                		.filter("average")
                		.comparisonOperator(">=")
                		.value(80)
                		.unit("%")
                		.count(3)
                		.build();  
                
                List<MetricsDimension> dimensions = new ArrayList<MetricsDimension>();
                MetricsDimension dimension = MetricsDimension.builder()
                		.name("instance_id")
                		.value("2b8bd8bb-45aa-4324-88a8-ffa1d9d5b1cd")
                		.build();
                dimensions.add(dimension);
                
                MetricInfoExt metric = MetricInfoExt.builder()
                		.namespace("SYS.ECS")
                		.metricName("cpu_util")
                		.dimensions(dimensions)
                		.build(); 
                		                
                CreateAlarmReq createAlarmReq = CreateAlarmReq.builder()
                		.alarmName("alarm-xiang")
                		.alarmDescription("alarm test for xiang")
                		.metric(metric)
                		.condition(condition)
                		.alarmActionEnabled(true)
                		.alarmActionEnabled(false)
                		.alarmLevel(2)
                		.build();
                
                CreateOneAlarmResp alarmResp = os.ces().alarm().createOneAlarm(createAlarmReq);
                String alarmId = "";
                if (null != alarmResp) {
                	alarmId =  alarmResp.getAlarmId();
                    System.out.println("create alarm success, AlarmId = " + alarmId);
                } else {
                    System.out.println("create alarm failed");
                }
                
                // Get Alarm
                GetSingleMetricAlarm getResp = os.ces().alarm().getSingleAlarm(alarmId);
                if (null != getResp) {
                		List<MetricAlarms> metricAlarms = getResp.getMetricAlarms();
                        System.out.println("get alarm success, metricAlarms size: " + metricAlarms.size());
                        for (int i=0 ; i< metricAlarms.size(); i++) {
                            	MetricAlarms ma = metricAlarms.get(i);
                            	System.out.println("metricAlarms index: " + i + " name: " + ma.getAlarmName());
                        }
                } else {
                        System.out.println("get alarm failed");
                }
                
                // List Alarm
                GetAllMetricAlarms listResp = os.ces().alarm().listAlarm(4, null, null);
                if (null != listResp) {
                    System.out.println("list alarm success, metadata count: " + listResp.getMetaData().getCount());
	            } else {
	                System.out.println("list alarm failed");
	            }
                
                
                /*{
                	  "alarm_enabled": false
                }*/
                // Stop Alarm
                ModifyAlarmActionReq modifyAlarmActionReq = ModifyAlarmActionReq.builder()
                		.alarmEnabled(false)
                		.build();
                
                String modifyAlarmResp = os.ces().alarm().modifyAlarmAction(alarmId, modifyAlarmActionReq);
                System.out.println("modify alarm action result: " + modifyAlarmResp);
                
                //Delete Alarm
                ActionResponse rep = os.ces().alarm().deleteOneAlarm(alarmId);
        		if (rep.isSuccess()) {
        			System.out.println("delete alarm success");
        		} else {
        			System.out.println("delete alarm failed");
        		}
        }
}
