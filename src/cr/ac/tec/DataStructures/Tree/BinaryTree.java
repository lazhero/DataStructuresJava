package cr.ac.tec.DataStructures.Tree;

import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;

public class BinaryTree<T extends Comparable> {
    protected DoubleNode root;
    final boolean isEmpty(){
       return root==null;
    }
    final public boolean contains(T data){
        return getNode(root,data)!=null;

    }
    final protected DoubleNode<T> getNode(DoubleNode<T> node,T data){
        if(node==null || node.getInfo().compareTo(data)==0)return node;
        if(data.compareTo(node.getInfo())>0)return getNode(node.getFront(),data);
        else return getNode(node.getBack(),data);

    }
    final public void insertion(T data){
        this.root=insertions(root,data);

    }
    protected DoubleNode<T> insertions(DoubleNode<T> current, T data){
        DoubleNode<T> node;
        if(current==null)return new DoubleNode<T>(data);
        boolean condition=data.compareTo(current.getInfo())>0;
        if(condition){
            current.setFront(insertions(current.getFront(),data));
        }
        else{
            current.setBack(insertions(current.getBack(),data));
        }
        return current;
    }
    final public void deletion(T data){
        this.root=delete(root,data);

    }
    protected DoubleNode<T> delete(DoubleNode<T> node,T data){
        if(node==null)return node;
        if(data.compareTo(node.getInfo())>0){
            node.setFront(delete(node.getFront(),data));
        }
        else if(data.compareTo(node.getInfo())<0){
            node.setBack(delete(node.getBack(),data));
        }
        else if(node.getBack()==null && node.getFront()==null){
            node=null;
        }
        else {
            DoubleNode<T> temp;
            if(node.getBack()!=null)temp=findMax(node.getBack());
            else temp=findMin(node.getFront());
            System.out.println(temp);
            node.setInfo(temp.getInfo());
            delete(temp,node.getInfo());
        }
        return node;



    }
    public DoubleNode<T> findMin(DoubleNode<T> node){
        if(node==null)return null;
        while(node.getBack()!=null){
            node=node.getBack();
        }
        return node;
    }
    public DoubleNode<T> findMax(DoubleNode<T> node){
        if(node==null)return null;
        while(node.getFront()!=null){
            node=node.getFront();
        }
        return node;
    }
    public DoubleNode<T> getRoot(){
        return root;
    }




}
