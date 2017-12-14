package com.sty.aidl.remote.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Steven.T on 2017/12/13/0013.
 */

public class PayService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    //支付宝支付的方法
    public boolean pay(String name, String pwd, int money){

        Log.i("Tag", "验证用户名密码");
        Log.i("Tag", "验证手机是否有病毒");
        Log.i("Tag", "调用C语言，做一些加密处理");
        if("abc".equals(name) && "123".equals(pwd) && money < 5000){
            return true;
        }else{
            return false;
        }
    }

    //定义中间人对象
    private class MyBinder extends IPayService.Stub{
        @Override
        public boolean callPay(String name, String pwd, int money) throws RemoteException {
            return pay(name, pwd, money);
        }
    }
}
