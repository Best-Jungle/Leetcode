public class SpliftFind{
    public static int spliftHalf(int[] array , int start, int end , int number)
    {
    	// int length = end - start;
    	// if(length == 1 && array[start] != number){
    		
    	//  	spliftHalf(array,end,end,number);
    	//  }
    	// else if(length == 0 && array[start] != number){
    	// 	return -1;
    	// }
    	// else if(array[length/2]>number){
    	// 	end = length/2 - 1;
    	// 	spliftHalf(array,start,end,number);
    	// }
    	// else if (array[length/2]<number){
    	// 	start = length/2 + 1;
    	// 	spliftHalf(array,start,end,number);
    	// }
    	// else if(array[start + length/2] == number){
    	// 	return start + length;
    	// }
    	//return 2;
    	int index = (start + end)/2;  
        int data = array[index];  
        if(start > end ){  
            return -1;  
        }  
        if(data == number){  
            return index;  
        }else{  
            if(data < number){  
                return spliftHalf(array,index+1,end,number);  
            }else{  
                return spliftHalf(array,start,index-1,number);  
            }  
        }  
    }

    public static void main(String[] args) 
    {  
        int[] array = { 3,5,11,17,21,23,28,30,32,50};  
        System.out.println(array.length);  
        int isExist = spliftHalf(array,0,array.length-1,(int)23);  
        System.out.println("isExist : "+isExist);  
    }  
}