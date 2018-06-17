package tree.recursive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tree.TreeElement;

@Getter
@AllArgsConstructor
public class TreeElementValue implements TreeElement {

    Object value;
    String path;

}