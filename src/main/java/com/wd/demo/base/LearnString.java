package com.wd.demo.base;

import java.nio.charset.StandardCharsets;

/**
 * @Author wangdi
 * @Date 2022/2/14 5:27 下午
 */
public class LearnString {
    public static void main(String[] args) {
        String B = "𝄞";
        System.out.println(B.length());
        String A = "你好";
        System.out.println(A.length());
        System.out.println(A.getBytes().length);
        String C = "🇻🇺";
        System.out.println(C.length());

        String D = "Java\u2122";
        System.out.println(D);
        int[] codePoints = C.codePoints().toArray();
        System.out.println(new String(codePoints, 0, codePoints.length));

        String E = "\uD83D\uDE02";
        System.out.println(E);


        String F = "\uD83C\uDFF4\uDB40\uDC67\uDB40\uDC62\uDB40\uDC65\uDB40\uDC6E\uDB40\uDC67\uDB40\uDC7F";
        System.out.println(F);

        String G = "\uD83D\uDC19";
        //  https://blog.csdn.net/weixin_37925993/article/details/79522812
        //  "\xF0\x9F\x90\x99";
        System.out.println(G);

        // https://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html

    }
}
