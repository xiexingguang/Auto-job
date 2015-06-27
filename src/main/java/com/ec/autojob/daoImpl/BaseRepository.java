package com.ec.autojob.daoImpl;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ec.autojob.common.MongoUtil;
import com.ec.autojob.dao.MongCRUDFacade;
import com.ec.autojob.properties.MongoProperties;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * @Package com.ec.longqingping.repository
 * @ClassName BaseRepository
 * @Description
 * @author longqingping
 * @date 2015年4月7日
 *
 */
@Component
public abstract class BaseRepository implements MongCRUDFacade {

    private static Logger formInterLog = LogManager.getLogger("FormInterLog");
    private static Logger errorLog = LogManager.getLogger("errorLog");

    /**
     * mongoclient 类加载时候必须实例化
     */
    private  MongoClient MONGO_CONN;
    /**
     * dataBase 因为子类可能要
     */
    private MongoDatabase dataBase;
    
    @Autowired
    private MongoUtil mongoUtil;
    @Autowired
    private MongoProperties proMongo;
    
    

    /**
     * 默认的数据库名称
     */
    private static final String DEFAULT_DATA_BASE_NAME = "production.mongos.host.dataBase";

  /*  static {
        if (formInterLog.isDebugEnabled()) {
            formInterLog.debug("init the mongoClient...");
        }
        MONGO_CONN = mongoUtil.getConn();
    }*/
    
    @PostConstruct
    public void init(){
    	 if (formInterLog.isDebugEnabled()) {
             formInterLog.debug("init the mongoClient...");
         }
         MONGO_CONN = mongoUtil.getConn();
    }

    /**
     * 子类可以覆盖该方法
     *
     * @return
     */
    protected MongoDatabase getMongoDataBase() {
        if (null == dataBase) {
            dataBase = MONGO_CONN.getDatabase(proMongo.MONGO_DATABASE);
        }
        return dataBase;
    }

    /**
     * 子类能够获得，但无法修改，必须暴露给子类，因为子类需要通过它 获取子类需要的database
     *
     * @return
     */
    public MongoClient getMongoClient() {
        return MONGO_CONN;
    }

    protected String getMongoDADatabase_name() {
        return DEFAULT_DATA_BASE_NAME;
    }

    /**
     * 子类必须实现，获取自己的要操作的表
     *
     * @return
     */
    public abstract MongoCollection<Document> getCollection();

    /**
     * 查找所有数据
     */
    @Override
    public FindIterable<Document> find() {
        try {
            return getCollection().find();
        } catch (Exception e) {
            // throw new
            // RuntimeException("call the method find is fail the exception is===>"+e.toString())
            // ;
            errorLog.error(e.toString());
            throw new RuntimeException("查找所有数据出现异常" + e.toString());
        }
    }

    @Override
    public void insertOne(Document document) {
        try {
            getCollection().insertOne(document);

        } catch (Exception e) {
            errorLog.error(e.toString());
            throw new RuntimeException("插入数据出现异常，异常为" + e.toString());
        }
    }

    @Override
    public DeleteResult deleteOne(Bson filter) {
        try {
            return getCollection().deleteOne(filter);
        } catch (Exception e) {
            errorLog.error(e.toString());
            throw new RuntimeException("删除数据出现异常，异常为" + e.toString());
        }

    }

    @Override
    public DeleteResult deleteMany(Bson filter) {
        try {
            return getCollection().deleteMany(filter);
        } catch (Exception e) {
            errorLog.error(e.toString());
            throw new RuntimeException("删除数据出现异常，异常为" + e.toString());
        }
    }

    @Override
    public void insertMany(List<Document> documents) {
        try {
            getCollection().insertMany(documents);
        } catch (Exception e) {
            errorLog.error(e.toString());
            throw new RuntimeException("插入数据出现异常，异常为" + e.toString());
        }
    }

    @Override
    public FindIterable<Document> findByBson(Bson filter) {
        try {
            return getCollection().find(filter);
        } catch (Exception e) {
            errorLog.error(e.toString());
            throw new RuntimeException("查找数据出现异常" + e.toString());
        }
    }

    @Override
    public UpdateResult updateOne(Bson filter, Bson update) {
        try {
            return getCollection().updateOne(filter, update);
        } catch (Exception e) {
            errorLog.error(e.toString());
            throw new RuntimeException("更新数据失败，异常为" + e.toString());
        }
    }

    @Override
    public UpdateResult updateMany(Bson filter, Bson update) {
        try {
            return getCollection().updateMany(filter, update);
        } catch (Exception e) {
            errorLog.error(e.toString());
            throw new RuntimeException("更新数据失败，异常为" + e.toString());
        }
    }

}
