package tree.linked;

import java.util.List;
import java.util.Map;

public class LinkedElementFactory {

    public static LinkedElement of(LinkedElement previous, Object object ){
        if ( object instanceof Map ){
            return LinkedElementMap.of( previous, (Map)object );
        } else if ( object instanceof List ){
            return LinkedElementAsList.of( previous, (List)object );
        }
        return LinkedElementAsValue.of( previous, object );
    }

}
