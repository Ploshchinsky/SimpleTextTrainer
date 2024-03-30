public class Main {
    public static void main(String[] args) throws Exception {
        String target = "lookatme";
        String user = "liol<left><left><bspace>o<right><delete>k<left><right>ar<bspace>t <left><delete>me";

        char[] res = new char[stringLength(user)];

        char[] chars = user.toCharArray();
        int cursor = 0;
        int cmdStartInd = 0, cmdEndIndex = 0;
        String command = "";

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '<') {
                res[cursor] = chars[i];
                cursor++;
            }
            if (chars[i] == '<') {
                cmdStartInd = i;
                do {
                    i++;
                } while (chars[i] != '>');
                cmdEndIndex = i + 1;
                command = user.substring(cmdStartInd, cmdEndIndex);
                switch (command) {
                    case "<left>":
                        cursor--;
                        break;
                    case "<right>":
                        cursor++;
                        break;
                    case "<bspace>":
                        res[cursor - 1] = ' ';
                        cursor--;
                        break;
                    case "<delete>":
                        res[cursor] = ' ';
                        break;
                }
            }
        }
        System.out.println(target.equals(String.valueOf(res).trim()) ? "Yes" : "No");
    }

    private static int stringLength(String wordWithCommands) {
        return wordWithCommands.replaceAll("<[^>]+>", "").length();
    }
}