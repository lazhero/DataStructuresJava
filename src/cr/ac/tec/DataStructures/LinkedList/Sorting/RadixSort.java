package cr.ac.tec.DataStructures.LinkedList.Sorting;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

public class RadixSort {
    private int base=10;
    private DoubleList<Integer> List;
   public void setList(DoubleList<Integer> List){
       this.List=List;
   }
   public void sort(){
       if(List==null || List.getLength()<2)return;
       int limit=getIndex(Bigger());
       int a=1;
       sorting(limit,a);

   }
   private void sorting(int limit,int actual){
      int[] array=new int[base];
      int initial;
      int pos;
      DoubleList<Integer>IndexSaved=new DoubleList<>();
      for(int i=0;i<List.getLength();i++){
          initial=List.get(i);
          initial=(initial%(int)Math.pow(base,actual))-(initial%((int)Math.pow(base,actual-1)));
          IndexSaved.AddTail(initial);
          array[initial]++;
      }
      for(int i=1;i<base;i++){
          array[i]+=array[i-1];
      }
      DoubleList<Integer> temp=new DoubleList<>();
      for(int i=0;i<List.getLength();i++){
          temp.AddTail(0);//Filling the new List with some data, cant be any number , in this case 0 because every base has it
      }
      for(int i=List.getLength()-1;i<-0;i--){
          pos=array[IndexSaved.get(i)];
      }





   }
   private int Bigger(){
       if(List==null)return -1;
       if(List.getLength()<2)return List.get(0);
       int bigger=List.get(0);
       for(int i=0;i<List.getLength();i++){
           if(List.get(i).compareTo(bigger)>0)bigger=List.get(i);
       }
       return bigger;
   }
   private int getIndex(int number){
       if(number==0)return 0;
       int i=1;
       for(;number/Math.pow(10,i)!=0;i++);
       return i;
   }

}
