class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
              for(int j = 0; j < chars.length-i; j++){
                char[] temp = new char[j+1];
                System.arraycopy(chars,i,temp,0,j+1);
                if(isPalindrome(temp)){
                    if(answer < j+1){
                        answer = j+1;
                    }
                  }
                }
           }   
        return answer;
    }
        private static boolean isPalindrome(char[] chars) {
        boolean result = true;
        for (int i = 0; i < chars.length / 2 + 1; i++) {
            if (chars[i] == chars[chars.length - 1 - i]) continue;
            result = false;
        }
        return result;
    }
}