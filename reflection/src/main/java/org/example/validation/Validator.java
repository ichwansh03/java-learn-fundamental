package org.example.validation;

import org.example.data.NotBlank;

import java.lang.reflect.Field;

public class Validator {

    public static void validateNotBlank(Object object) throws IllegalAccessException {
        Class<?> aClass = object.getClass();

        //dapatkan field dari class Person
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            //dapatkan annotation dari class Person
            NotBlank notBlank = field.getAnnotation(NotBlank.class);

            //cek field yg value annotation notblank != null
            if (notBlank != null) {
                field.setAccessible(true);

                //ambil tipe data dari field di class Person
                Object fieldValue = field.get(object);

                //cek apakah field value dari object turunannya = String?
                if (fieldValue instanceof String) {

                    //cast ke string
                    String stringValue = (String) fieldValue;
                    if (notBlank.allowNull()) {
                        //ignore
                    } else {
                        stringValue = stringValue.trim();
                    }

                    if (stringValue.isEmpty()) {
                        throw new RuntimeException(field.getName() + " cannot be null");
                    }
                } else if (fieldValue instanceof Integer) {
                    Integer intValue = (Integer) fieldValue;
                    if (intValue == 0){
                        throw new RuntimeException(field.getName() + " cannot be null");
                    }
                }
            }
        }
    }

}
