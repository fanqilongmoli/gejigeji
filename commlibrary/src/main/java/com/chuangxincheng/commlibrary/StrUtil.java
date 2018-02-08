package com.chuangxincheng.commlibrary;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * 字符串常用方法工具类
 *
 * @author peiyu
 */
public final class StrUtil {

    /**
     * 此类不需要实例化
     */
    private StrUtil() {
    }

    /**
     * 判断一个字符串是否为空，null也会返回true
     *
     * @param str 需要判断的字符串
     * @return 是否为空，null也会返回true
     */
    public static boolean isBlank(String str) {
        return null == str || "".equals(str.trim());
    }

    /**
     * 判断一个字符串是否不为空
     *
     * @param str 需要判断的字符串
     * @return 是否为空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断一组字符串是否有空值
     *
     * @param strs 需要判断的一组字符串
     * @return 判断结果，只要其中一个字符串为null或者为空，就返回true
     */
    public static boolean hasBlank(String... strs) {
        if (null == strs || 0 == strs.length) {
            return true;
        } else {
            //这种代码如果用java8就会很优雅了
            for (String str : strs) {
                if (isBlank(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断一个字符串是否为数字 正整数
     *
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        return pattern.matcher(str).matches();
    }

    public static boolean isEmpty(String s) {
        if (null == s)
            return true;
        if (s.length() == 0)
            return true;
        if (s.trim().length() == 0)
            return true;
        return false;
    }

    public static String str2MoneyFormat(double money) {
        String s = String.valueOf(money);
        String substring = s.substring(0, s.indexOf("."));
        return str2MoneyFormat(substring, "");
    }

    public static String str2MoneyFormat(double money, @Nullable String currency) {
        String s = String.valueOf(money);
        String substring = s.substring(0, s.indexOf("."));
        return str2MoneyFormat(substring, currency);
    }

    /**
     * str 货币的格式化
     *
     * @param money    钱的总数
     * @param currency 货币的后缀单位
     * @return 返回值
     */
    public static String str2MoneyFormat(@NonNull String money, @Nullable String currency) {
        int length = money.length();
        if (money.contains(".")) {
            money = money.substring(0, money.indexOf("."));
        }
        if (length == 2) {
            money = "0" + money;
        }
        if (length == 1) {
            money = "00" + money;
        }
        length = money.length();
        String s = money.substring(0, length - 2) + "." + money.substring(length - 2, length);
        Double aDouble = Double.valueOf(s);
        NumberFormat nf = new DecimalFormat("#,###.##");
        String format = nf.format(aDouble);
        if (!format.contains(".")) {
            return format + ".00" + currency;
        } else {
            return format + currency;
        }
    }

    public static String num2English(int s) {
        switch (s) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            default:
                return "";
        }
    }

    public static String english2Num(String s) {
        switch (s) {
            case "A":
                return "0";
            case "B":
                return "1";
            case "C":
                return "2";
            case "D":
                return "3";
            case "E":
                return "4";
            case "F":
                return "5";
            case "G":
                return "6";
            default:
                return "";
        }
    }

    /**
     * 货币单位缩小的字号
     *
     * @param money
     * @return
     */
    public static SpannableString currency2spannable(String money) {
        int length = money.length();
        int pointIndex = money.indexOf(".");
        SpannableString spannableString = new SpannableString(money);
        spannableString.setSpan(new RelativeSizeSpan(0.7f), 0, 1, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(0.7f), pointIndex + 1, length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        return spannableString;
    }

    //gender:0-未知 1-男 2-女 3-其他
    public static String getGender(String gender) {
        if (isBlank(gender))
            return "未知";


        switch (gender) {
            case "0":
                return "未知";
            case "1":
                return "男";
            case "2":
                return "女";
            case "3":
                return "其他";
            default:
                return "";
        }
    }

    public static String getMapString(Map paramMap, String key) {
        String result = "";
        if (paramMap != null && isNotBlank(key)) {
            result = paramMap.get(key) != null ? paramMap.get(key).toString() : "";
            result = replaceEscape(result, "\n\r");
        }
        return result;
    }

    public static String replaceEscape(String str, String escapeReg) {
        if (str != null) {
            if (escapeReg.contains("\n")) {
                str = str.replace("\\n", "\n");
            }
            if (escapeReg.contains("\r")) {
                str = str.replace("\\r", "\r");
            }
            if (escapeReg.contains("<br>")) {
                str = str.replace("<br>", "");
            }
            if (escapeReg.contains("\b")) {
                str = str.replace("\\b", "\b");
            }
            if (escapeReg.contains("\t")) {
                str = str.replace("\\t", "\t");
            }
            if (escapeReg.contains("\\")) {
                str = str.replace("\\", "");
            }
        }
        return str;
    }

    /**
     * 手机号隐藏中间四位
     *
     * @param phone
     * @return
     */
    public static String phoneCloseMid4(String phone) {

        return phone.substring(0, 3) + "****" + phone.substring(7, 11);
    }

    /**
     * 将 gzip byte[]  转成Str
     * @param bytes
     * @param encoding
     * @return
     */
    public static String uncompressZipBytesToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}