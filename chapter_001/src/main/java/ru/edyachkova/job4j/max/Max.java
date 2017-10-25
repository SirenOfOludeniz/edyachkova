package ru.job4j.max;

public class Max {

  public int max(int first, int second, int third) {

   return max((max(first,second)),max(second,third));
      /*public int max ( first,  second){
          return (first > second) ? first : second;
      }*/


  }
    public int max ( int first, int  second){
        return (first > second) ? first : second;
    }


}