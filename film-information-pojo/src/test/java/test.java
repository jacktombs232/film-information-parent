import com.michael.pojo.User;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws Exception{
        User user = new User();
        user.setUserId(1L);
        user.setEmail("fajisgv");
        user.setNicknmae("fsjif");
        Class clazz = user.getClass();
        //获得所有的属性
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        for(Field field:fields)
        {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            Method method = pd.getReadMethod();
            System.out.println(method+":"+method.invoke(user));
        }


    }
}
