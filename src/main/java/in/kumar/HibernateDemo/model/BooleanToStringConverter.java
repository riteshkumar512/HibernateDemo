package in.kumar.HibernateDemo.model;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter
                implements AttributeConverter<Boolean,String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        if (aBoolean==null) return null;

        if (aBoolean){
            return "Yes";
        }
        return "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String string) {
        if (string==null) return null;

        if (string.equals("Yes")){
            return true;
        }
        return false;
    }
}
