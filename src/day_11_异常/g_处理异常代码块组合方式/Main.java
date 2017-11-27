package day_11_异常.g_处理异常代码块组合方式;

public class Main {

////异常的针对性处理方式
//
//    //1, 没有资源需要释放，仅仅是处理异常
//    try{
//    }
//    catch(){
//    }
//    //2, 一个try多个catch。一般对应的是被调用的函数抛出多个异常情况，分别处理
//        try{
//    }
//    catch(){
//    }
//    catch(){
//    }
//    catch(){
//    }
//    //注意：多catch时，如果catch中的异常存在父类，父类的catch一定要放在子类的下面，否则编译失败
//
//    //3,不一定要处理异常，但是有资源需要释放
//    try{
//    }
//    finally{
//    }
//    //例子
//    viod show() throws Exception{
//        try{
//            throw new Exception();
//        }
//        catch (Exception e){
//            throw e;
//        }
//        finally {
//        }
//    }
}
