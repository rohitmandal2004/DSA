public class Find_Subset {
    public static void findSubset(String str, String ans, int i){
        // Base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            } else{
                System.out.println(ans);
            }
            return;
        }

        // Recursion
        // Include the character at index i
        findSubset(str, ans + str.charAt(i), i + 1);
        // Exclude the character at index i
        findSubset(str, ans, i + 1);
    }

    public static void main(String args[]){
        String str = "abc";
        findSubset(str, "", 0);
    }
}