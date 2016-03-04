package utilities;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.tinkerpop.blueprints.Vertex;

public class ObjectMapper<T> {  

    public static List<Field> getAllFields(List<Field> fields, Class<?> type)       {
         fields.addAll(Arrays.asList(type.getDeclaredFields()));

         if (type.getSuperclass() != null) {
             fields = getAllFields(fields, type.getSuperclass());
         }

         return fields;
    }

    public Vertex mapObjToVertex(T obj, Vertex v){
        if (obj == null ) { return null; }

        for (Field field : getAllFields(new LinkedList<Field>(), obj.getClass())) {
            field.setAccessible(true);

            String name = field.getName();
            String type = field.getType().getSimpleName();
            boolean isPrimitive = field.getType().isPrimitive();
            if(isPrimitive || type.equals("String")){
                try {
                    Object value = field.get(obj);
                    if(value!=null){
                        v.setProperty(name,value);
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return v;
    }


    public T mapVertexToObj(Vertex v, T obj) {
        if (v == null) { return null; }

        for (Field field : getAllFields(new LinkedList<Field>(), obj.getClass())) {
            field.setAccessible(true);

            String name = field.getName();
            String type = field.getType().getSimpleName();
            boolean isPrimitive = field.getType().isPrimitive();


            if(!isPrimitive && !type.equals("String")) continue;

            Method setter;
            try {
                setter = new PropertyDescriptor(name, obj.getClass()).getWriteMethod();

            }
            catch(IntrospectionException ie) { continue; }

            try {
                if(name.equals("id")){
                    setter.invoke(obj, v.getId().toString());
                }
                else {
                    Object storedValue = v.getProperty(name);
                    if (storedValue !=null){
                        if(type.equals("String")) setter.invoke(obj, storedValue.toString());
                        else if(type.equals("byte")) setter.invoke(obj, (byte)storedValue);
                        else if(type.equals("int")) setter.invoke(obj, (int)storedValue);
                        else if(type.equals("float")) setter.invoke(obj, (float)storedValue);
                        else if(type.equals("long")) setter.invoke(obj, (long)storedValue);
                        else if(type.equals("double")) setter.invoke(obj, (double)storedValue);
                        else if(type.equals("boolean")) setter.invoke(obj,(boolean)storedValue);
                    }
                }

            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        return obj;
    }
}