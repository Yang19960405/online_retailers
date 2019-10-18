package com.yang.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeExchangeUtil {
    /** 对象类型转换
     * @param obj  源对象
     * @param cla  目标对象类型
     * @param <T>  泛型
     * @return     目标对象
     * @throws Exception
     */
    public static  <T> T convertClass(Object obj,Class<T> cla) {
        Map<String,Object> maps = new HashMap<String,Object>();
        T  dataBean = null;
        try {
            if(null==obj) {
                return null;
            }
            Class<?> cls = obj.getClass();
            dataBean = cla.newInstance();
            Field[] fields = cls.getDeclaredFields();
            Field[] beanFields = cla.getDeclaredFields();
            //通过get方法拿到源对象的属性值
            for(Field field : fields){
                //去掉public static final 的字段
                if (field.getModifiers() == 26) continue;
                String fieldName = field.getName();
                String strGet = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
                Method methodGet = cls.getDeclaredMethod(strGet);
                Object object = methodGet.invoke(obj);
                maps.put(fieldName,object==null?"":object);
            }
            //通过set方法给目标对象赋值
            for(Field field:beanFields){
                if (field.getModifiers() == 26) continue;
                field.setAccessible(true);
                String fieldName = field.getName();
                Class<?> fieldType = field.getType();
                String fieldValue = maps.get(fieldName)==null?null:maps.get(fieldName).toString();
                if(fieldValue!=null){
                    try {
                        if(String.class.equals(fieldType)){
                            field.set(dataBean, fieldValue);
                        }else if(byte.class.equals(fieldType)){
                            field.setByte(dataBean, Byte.parseByte(fieldValue));

                        }else if(Byte.class.equals(fieldType)){
                            field.set(dataBean, Byte.valueOf(fieldValue));

                        }else if(boolean.class.equals(fieldType)){
                            field.setBoolean(dataBean, Boolean.parseBoolean(fieldValue));

                        }else if(Boolean.class.equals(fieldType)){
                            field.set(dataBean, Boolean.valueOf(fieldValue));

                        }else if(short.class.equals(fieldType)){
                            field.setShort(dataBean, Short.parseShort(fieldValue));

                        }else if(Short.class.equals(fieldType)){
                            field.set(dataBean, Short.valueOf(fieldValue));

                        }else if(int.class.equals(fieldType)){
                            field.setInt(dataBean, Integer.parseInt(fieldValue));

                        }else if(Integer.class.equals(fieldType)){
                            field.set(dataBean, Integer.valueOf(fieldValue));

                        }else if(long.class.equals(fieldType)){
                            field.setLong(dataBean, Long.parseLong(fieldValue));

                        }else if(Long.class.equals(fieldType)){
                            field.set(dataBean, Long.valueOf(fieldValue));

                        }else if(float.class.equals(fieldType)){
                            field.setFloat(dataBean, Float.parseFloat(fieldValue));

                        }else if(Float.class.equals(fieldType)){
                            field.set(dataBean, Float.valueOf(fieldValue));

                        }else if(double.class.equals(fieldType)){
                            field.setDouble(dataBean, Double.parseDouble(fieldValue));

                        }else if(Double.class.equals(fieldType)){
                            field.set(dataBean, Double.valueOf(fieldValue));

                        }else if(Date.class.equals(fieldType)){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                            field.set(dataBean, sdf.parse(fieldValue));
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataBean;
    }

    public static <T> List<T> convertClassList(List<Object> objList,Class<List<T>> cla){
       return null;
    }

}
