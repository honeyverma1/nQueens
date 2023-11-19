package Manoj;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Queens {

	static List<List<String>> allBoards= new ArrayList<>();
	static int queensCounter = 0;
    public static void saveBoard(char arr[][])
    {
        String row;
        List<String> www=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            row="";
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i][j]=='Q')
                {
                    row+='Q';
                }
                else
                {
                    row+='.';
                }
            }
            www.add(row);
        }
        allBoards.add(www);
    }

    public static boolean isSafe(char arr[][], int i,int j)
    {
        //horizontal
        for(int n=0;n<arr.length;n++)
        {
            if(arr[n][j]=='Q')
            {
                return false;
            }
        }
        //vertical
        for(int n=0;n<arr.length;n++)
        {
            if(arr[i][n]=='Q')
            {
                return false;
            }
        }
        //diagonals
        int m=j;
        for(int n=i;n<arr.length && m<arr.length;n++,m++)
        {
            if(arr[n][m]=='Q')
            {
                return false;
            }
        }
        m=j;
        for(int n=i;n>=0 && m>=0;n--,m--)
        {
            if(arr[n][m]=='Q')
            {
                return false;
            }
        }
        m=j;
        for(int n=i;n<arr.length && m>=0;n++,m--)
        {
            if(arr[n][m]=='Q')
            {
                return false;
            }
        }
        m=j;
        for(int n=i;n>=0 && m<arr.length;n--,m++)
        {
            if(arr[n][m]=='Q')
            {
                return false;
            }
        }
        return true;
    }
    
    public static void helper(char arr[][], int col)
    {
        
        
    	if(col==arr.length)
        {
            

    		saveBoard(arr);
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(isSafe(arr ,i,col))
            {
                arr[i][col]='Q';
                
                helper(arr,col+1);
                arr[i][col]='.';
            }
        }
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter the value of N");
		int n=sc.nextInt();
        char arr[][]=new char [n][n];
        helper(arr,0);
        System.out.println("All possible outcmes are:");
        System.out.println(allBoards);
        int counter = allBoards.size();
        System.out.println("the number of solutions : ");
        System.out.println(counter);
        
	}

}