package com.csii.util;

import java.io.Serializable;

/**
 * @date：2017年6月22日
 * @time：上午9:30:27
 * @purpose：
 * @address：
 * @auth：Bob.jiang
 */
public class SingletonClass implements Serializable {

    private static volatile SingletonClass sSoleInstance;

    //private constructor.
    private SingletonClass(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClass getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            synchronized (SingletonClass.class) {
                if (sSoleInstance == null) sSoleInstance = new SingletonClass();
            }
        }

        return sSoleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected SingletonClass readResolve() {
        return getInstance();
    }

    public static class Singleton{      
        private Singleton(){      
            
        }      
        private static class SingletonContainer{ 
        	
            private static Singleton instance = new Singleton();      
        }      
        public static Singleton getInstance(){      
            return SingletonContainer.instance;      
        }      
    }
}
