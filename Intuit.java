import java.io.*;
import java.util.*;

import jdk.internal.util.xml.impl.Pair;

public class Intuit {
  // If you need extra classes, you can define them privately here within class Solution
  
  public static class Pair{
    int x,y;
    public Pair(int x,int y){
      this.x = x;
      this.y = y;
    }
    public String display(){
      return x+" "+y;
    }
  }
  static List<Pair> result=new ArrayList<>();
  static List<Pair> temp=new ArrayList<>();
  public static void findWord(String word, String[][] grid){
  int m=grid.length;
  int n=grid[0].length;
  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      DFS(word,grid,i,j,0,result,temp);
      if(result.size()>0){
      for(int k=0;k<result.size();k++){
        System.out.println(result.get(k).display());
      }
      return;
    }
      
    }
  }
  
 
}
  public static void DFS(String word, String[][] grid, int i, int j,int cursor,List<Pair> result,List<Pair> temp){
    if(cursor == word.length()){
      if(result.size()==0){
        result.add(temp);
      }
      return;
    }
     if(grid[i][j].equals(word.charAt(cursor))){
        if(isValid(i,j,grid)){
          temp.addAll(new Pair(i,j));
          DFS(word,grid,i,j+1,cursor+1,result,temp);
          DFS(word,grid,i+1,j,cursor+1,result,temp);
          temp.remove(temp.size()-1);
        }
      }
  }
  public static boolean isValid(int x,int y,String[][] grid){
    return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
  }
   
  // DO NOT MODIFY MAIN()
  public static void main(String[] args) {
    String arg0 = "catnip";
//     List<String[]> arg1 = new ArrayList<String[]>();

//     String line;
//     boolean first_arg = true;
//     try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//       while ((line = br.readLine()) != null) {
//         if (line.equals("")) {
//           continue;
//         }

//         if(first_arg) {
//           arg0 = line;
//           first_arg = false;
//         } else {
//           arg1.add(line.split(" "));
//         }
//       }
//     } catch (IOException e) {
//       e.printStackTrace();
//       return;
//     }

//     String[][] grid = arg1.toArray(new String[arg1.size()][]);
      String[][] grid ={{"c","r","c","a","r","s"},
                        {"a","b","i","t","n","b"},
                        {"t","f","n","n","t","i"},
                        {"x","s","i","i","p","t"}};

    findWord(arg0, grid);
    System.out.println(arg0);
  }
}
