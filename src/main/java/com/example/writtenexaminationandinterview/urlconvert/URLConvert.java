package com.example.writtenexaminationandinterview.urlconvert;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/26 8:25 下午
 */
//Amazon一面被问到了这个问题
//URL长链接转换为短链接的算法
public class URLConvert {

    /**
     * 还有一种方法(发号策略)：将长链接存储在数据库(Redis)中作为一条记录，然后把该记录的id转换（可以用高进制来压缩字符串）后拼凑成短链接
     *
     * @param args
     */

    public static void main(String[] args) {

        String longURL = "http://tecsfh.singda.sdfscom.cn/i/201gd1-03-23gd/1128地方个地方官dg的53212g88.shdgdtml";

        String[] result = shortURL(longURL);

        System.out.println(longURL);
        for (String s : result) {
            System.out.println(s);
        }

    }


    /**
     * 这个方法会产生四组6位的字符串 每一组都可以作为当前字符串的短链接地址
     * 生成短链接之后  只要在表中存储映射关系即可
     *
     * @param url
     * @return
     */
    //    使用MD5进行加密并压缩
    public static String[] shortURL(String url) {

//        MD5的混合key
        String key = "dagongdie";

//        字典
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };

//        MD5密码串
        String MD5EncryResult = (new MD5()).getMD5ofStr(key + url);

        String hex = MD5EncryResult;
        String[] resUrl = new String[4];

        for (int i = 0; i < 4; i++) {
//            8位一组
            String TempSubString = hex.substring(i << 3, (i << 3) + 8);
//            这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long HexLong = 0x3FFFFFFF & Long.parseLong(TempSubString, 16);

            String outChars = "";

//            生成6位短串
            for (int j = 0; j < 6; j++) {
//                把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & HexLong;

                outChars += chars[(int) index];

//                每次循环按位右移 5 位
                HexLong = HexLong >> 5;

            }

//            把字符串存入对应的索引数组
            resUrl[i] = outChars;
        }

        return resUrl;
    }


}
