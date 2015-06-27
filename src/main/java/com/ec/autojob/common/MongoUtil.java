package com.ec.autojob.common;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ec.autojob.properties.MongoProperties;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
/**
 * 
 * ClassName: MongoUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年6月25日 下午8:57:16 <br/>
 *
 * @author xxg
 * @version 
 * @since JDK 1.7
 */
@Component
public class MongoUtil {

    private static MongoClient MONG_CLIENT = null;
    private static Logger formInterLog = LogManager.getLogger("FormInterLog");
    private static Logger errorLog = LogManager.getLogger("errorLog");
    private final static String UN_USE = "false";
    @Autowired
    private   MongoProperties proMongo;
    @Autowired
    public MongodbConfig confgi;
    public  MongoClient getConn() {
        init();
        return MONG_CLIENT;
    }
    
    @PostConstruct
    private  void init() {

        if (formInterLog.isDebugEnabled()) {
            formInterLog.debug("init is begin....");
        }

       //  String hosts = PropertiesUtil.getProString(HOST_ADDRESSES);
        String hosts = proMongo.MONGOS_HOSTS;
        if (null == hosts || hosts.length() == 0) {
            errorLog.error("The host_address is not found ,please check!!");
            throw new RuntimeException("The host_address is not found ,please check!!");
        }
        String[] hostStrings = hosts.trim().split(",");
        final List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        for (String h : hostStrings) {
            String host = h.substring(0, h.indexOf(":"));
            String port = h.substring(h.indexOf(":") + 1);
            if (formInterLog.isDebugEnabled()) {
                formInterLog.debug("connect host is =====>[" + host + ":" + port + "]");
            }
            ServerAddress address = new ServerAddress(host, Integer.parseInt(port));
            addresses.add(address);
        }// end for

        try {
            MONG_CLIENT = this.getInstance(addresses);
        } catch (UnknownHostException e) {
            errorLog.error(e.toString());
            throw new RuntimeException("Fail to get the mongoClient,the exception is" + e.toString());
        }

        formInterLog.debug("the end of init.....");
    }

    /**
     * <li>Get the mongoclient instance</li> <li></li>
     *
     * @param addresses
     *            if address == null, the default host is:localost,the port is
     *            :27017
     * @return
     * @throws UnknownHostException
     */

    public  MongoClient getInstance(final List<ServerAddress> addresses) throws UnknownHostException {
      //  String isUserDefault = PropertiesUtil.getProString(MongodbConfig.DEFAULT_CONFIG);
    	String isUserDefault = proMongo.MONOG_CONFIGOPTION;
        if (null == MONG_CLIENT) {
            if (addresses == null) {
                return new MongoClient();
            }
            if (isUserDefault.equals(UN_USE)) { // 使用mongodclient默认配置的options
                return new MongoClient(addresses);
            } else {
                MongoClientOptions options = confgi.getClientOptions();
                if (formInterLog.isDebugEnabled()) {
                    formInterLog.debug("默认自定义的配置文件为==》" + options.toString());
                }
                return new MongoClient(addresses, options); // 否则使用自定义配置文具
            }
        }
        return MONG_CLIENT;
    }
  
    /*private MongoUtil(){
    	
    }
    */
    /**
     * 
     */
    
    /*private final static  Object o = new Object();
    public static MongoUtil getMongoUtilInstance(){
    	  synchronized (o) {
			  if()
		}
    }*/
    
}
