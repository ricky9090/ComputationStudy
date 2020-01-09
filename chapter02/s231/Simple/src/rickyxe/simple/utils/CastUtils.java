package rickyxe.simple.utils;

import rickyxe.simple.basictype.XBoolean;
import rickyxe.simple.basictype.XNumber;

public class CastUtils {

    public static XNumber castXNumber(Object obj) {
        return (XNumber) obj;
    }

    public static XBoolean castXBoolean(Object obj) {
        return (XBoolean) obj;
    }
}
