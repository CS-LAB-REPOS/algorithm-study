public class Main {
    public static boolean isPalin(String str) {
        int leftIndex = 0;
        int rightIndex = str.length() - 1;

        while(leftIndex < rightIndex){
            if(str.charAt(leftIndex) != str.charAt(rightIndex)){
                return false;
            }

            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static int solution(String s) {
        int strLength = s.length();

        if (strLength == 0 || strLength == 1) {
            return strLength == 0 ? 0 : 1;
        }

        for (int i = strLength; i > 2; i--) {
            for (int j = 0; j <= strLength - i; j++) {
                String selected = s.substring(j, j + i);

                if (isPalin(selected)) {
                    return selected.length();
                }
//                System.out.println(selected + " " + isPalin(selected));
            }
        }

        return 2;
    }

    public static void main(String[] args) {

        System.out.println(solution("aba"));

    }
}