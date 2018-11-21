package cc.xpress.mitaole.user.bean;

import java.util.Map;

/**
 * 键值对实体类
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-08 16:37
 * @modified By:
 */
public class Node<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value=value;
        return this.value;
    }
}
