import java.util.Scanner;

public class VigenereSquareCipher {
	public static void main(String[] args) {
        // 关键字。
        String keywordString = "MINJIANG";
        char keyword[] = keywordString.toCharArray();// 转换成字符数组。
        int keyLeng = keywordString.length();//获取长度
        
        //密码本
        char alphabet[] = "ICOXDPBUQJARHKNGWYLEZSVFMT".toCharArray();
        int i, j;
        
        System.out.println("关键字：" + keywordString);
        Scanner in = new Scanner(System.in);
        System.out.print("输入原文：");
        String originalText = in.nextLine();// 读取原文内容。
        
        String upperCaseText = originalText.toUpperCase();// 转成大写。
        System.out.println("大写原文：" + upperCaseText);
        int leng = upperCaseText.length();//获取长度
        char encodedText[] = upperCaseText.toCharArray();//字符串转数组
        
        
        j = 0;// 原文英文字母的索引。
        // 加密
        for (i = 0; i < leng; i++) {
            if (encodedText[i] >= 'A' & encodedText[i] <= 'Z') {
                int k = 0;
                for (k = 0; k < alphabet.length; k++) {
                    if (alphabet[k] == keyword[j % keyLeng]) {
                        j++;
                        break;
                    }
                }
                encodedText[i] = alphabet[(k + (encodedText[i] - 'A') + 26) % 26];
            }
        }
        String encodedString = new String(encodedText);//数组转字符串
        System.out.println("编码密文：" + encodedString);
        
        // 原文英文字母的索引。
        j = 0;
        char decodedText[] = encodedString.toCharArray();//字符串转数组
        // 解码
        for (i = 0; i < leng; i++) {
            if (decodedText[i] >= 'A' & decodedText[i] <= 'Z') {
                int k = 0, l = 0;
                for (k = 0; k < alphabet.length; k++) {
                    if (alphabet[k] == keyword[j % keyLeng]) {
                        j++;
                        break;
                    }
                }
                for (l = 0; l < alphabet.length; l++) {
                    if (alphabet[l] == decodedText[i]) {
                        break;
                    }
                }
                int distance = l > k ? ((26 - l) + k) : (k - l);
                decodedText[i] = (char) ('A' + (26 - distance) % 26);
            }
        }

        String decodedString = new String(decodedText);//数组转字符串
        System.out.print("解码原文：" + decodedString);

        // 关闭输入串流
        in.close();
    }
}
