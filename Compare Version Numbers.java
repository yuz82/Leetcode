/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == version2) { return 0; }
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n1 = s1.length;
        int n2 = s2.length;
        int i=0;
        int v1 = 0, v2 = 0;
        while(i<n1 || i<n2){
            if(i> n1-1) { v1 = 0; } else { v1 = Integer.parseInt(s1[i]); }
            if(i> n2-1) { v2 = 0; } else { v2 = Integer.parseInt(s2[i]); }
            if(v1>v2){
                return 1;
            }else if(v1<v2){
                return -1;
            }
            i++;
        }
        return 0;
        
    }
   
}
