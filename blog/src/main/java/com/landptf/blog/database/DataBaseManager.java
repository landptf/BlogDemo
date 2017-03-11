package com.landptf.blog.database;

import com.landptf.blog.BlogApplication;
import com.landptf.blog.database.gen.DaoMaster;
import com.landptf.blog.database.gen.DaoSession;

/**
 * Created by landptf on 2017/3/11.
 * Data Manager
 */
public class DataBaseManager {

    private static DataBaseManager instance;

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper devOpenHelper;

    private DataBaseManager(){
        devOpenHelper = new DaoMaster.DevOpenHelper(BlogApplication.getContext(), "landptf", null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DataBaseManager getInstance(){
        if (instance == null) {
            synchronized (DataBaseManager.class) {
                if (instance == null) {
                    instance = new DataBaseManager();
                }
            }
        }
        return instance;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    /**
     * 关闭数据连接
     */
    public void close() {
        if (devOpenHelper != null) {
            devOpenHelper.close();
        }
    }
}
