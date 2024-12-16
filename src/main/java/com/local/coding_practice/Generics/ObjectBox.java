package com.local.coding_practice.Generics;

import lombok.Data;
import java.util.*;

@Data
public class ObjectBox<T> {

    List<T> list;
    public ObjectBox(List<T> list){
        this.list = list;

    }




}
