package com.designpattern.creational.simplefactory;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 简单工厂模式代码演示
 * @date 2019/11/11 16:45
 */
public class VideoFactory {

    public static Video getVideo(String type){
        if (type.equalsIgnoreCase("JAVA")){
            return new JavaVideo();
        }else if (type.equalsIgnoreCase("python")){
            return new PythonVideo();
        }else{
            return null;
        }
    }

    public static Video getVideoByClass(Class klass){
        Video video = null;
        try {
            video = (Video) Class.forName(klass.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
}
