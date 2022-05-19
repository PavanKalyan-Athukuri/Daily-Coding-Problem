/*Suppose we represent our file system by a string in the following manner:
The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.*/


class Solution {
    public int lengthLongestPath(String input) {
       ArrayList<Integer> arr = new ArrayList<>();
       // int arr[] = new int[1000];
        int count=0;
        int i = 0;
        int tab = 0;
        boolean file = false;
        boolean flag = true;
        int max = Integer.MIN_VALUE;
        count=0;
        for(;i<input.length();i++){
           if(input.charAt(i)!='\n'&&input.charAt(i)!='\t'){
               count++;
           }  
            if(input.charAt(i)=='\t'){
                    tab++;
            }
            if(input.charAt(i)=='.'){
                file = true;
            }
            if(input.charAt(i)=='\n'||i==input.length()-1){
                int temp = count;
                if(tab!=0){
                    temp = temp + arr.get(tab-1);
                }
                if(file){
                    file = false;
                    if(max<temp){
                        flag = false;
                        max = temp;
                    }
                }
                 temp++;
                    if(arr.size()==tab){
                        arr.add(temp);
                    }
                    else{
                        arr.set(tab,temp);
                    }
                    count=0;
                    tab=0;
                }
        }
        if(!flag)
        return max;
        return 0;
    }
}