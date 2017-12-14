package com.sty.aidl.remote.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 远程服务
 * Created by Steven.T on 2017/12/13/0013.
 */

public class RemoteService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    //在服务中定义一个方法
    public void testMethod(){
        Log.i("Tag", "我是远程服务里面的方法");
    }

    public class MyBinder extends IMyService.Stub{
        @Override
        public void callTestMethod() throws RemoteException {
            testMethod();
        }
    }
}
