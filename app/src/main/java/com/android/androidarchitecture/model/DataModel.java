package com.android.androidarchitecture.model;

import com.android.androidarchitecture.model.BaseModel;

/**
 * FileName: DataModel
 * Author: YuXin
 * Date: 2018/7/30 17:14
 * Describe: ${Describe}
 */
public class DataModel {

    public static BaseModel request(String token) {

        // 声明一个空的BaseModel
        BaseModel model = null;

        try {
            // 利用反射机制获得对应的Model对象的以引用
            model = (BaseModel) Class.forName(token).newInstance();

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }
}
