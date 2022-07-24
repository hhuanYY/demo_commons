package com.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/5/10
 */
public class demo {
    public static void main(String[] args) throws UnsupportedEncodingException {

        Map<String,Object> params = new HashMap<>();
        params.put( "$organizationId$","tableB.Branch_Region_id" );
        params.put( "$orderValue$","" );
        params.put( "$conditionValue$","tableA.BizDay>=20220201 AND  tableA.BizDay<=20220230" );
        params.put( "$extraCondition$","tableA.BizDay>=20220201 AND  tableA.BizDay<=20220230" );
        params.put( "$organizationName$","tableB.Branch_Region_Name" );
        params.put( "$conditionGroup$","tableB.Branch_Region_id" );
        params.put( "$columnValue$","CASE WHEN SUM(tableA.Leasable_Room_Cnt)=0 THEN 0 ELSE SUM(tableA.Sumup_Occ2)/SUM(tableA.Leasable_Room_Cnt) END AS indexValue" );
        params.put( "$extraColumn$","CASE WHEN SUM(tableA.Leasable_Room_Cnt)=0 THEN 0 ELSE SUM(tableA.Sumup_Occ2)/SUM(tableA.Leasable_Room_Cnt) END AS extraIndexValue" );


        String sql = "SELECT name,indexValue,extraIndexValue FROM (\n" +
                "      SELECT $organizationId$ AS id ,$organizationName$ AS name\n" +
                "            ,$columnValue$\n" +
                "      FROM zc_flow.ads_hotel_operation_day tableA\n" +
                "      LEFT JOIN zc_flow.dim_hotel_curr tableB ON tableA.hotel_id=tableB.hotelid \n" +
                "      WHERE $conditionValue$ \n" +
                "      GROUP BY $conditionGroup$\n" +
                ")A\n" +
                "LEFT JOIN (\n" +
                "      SELECT $organizationId$ AS id\n" +
                "            , $extraColumn$\n" +
                "      FROM zc_flow.ads_hotel_operation_day tableA\n" +
                "      LEFT JOIN zc_flow.dim_hotel_curr tableB ON tableA.hotel_id=tableB.hotelid \n" +
                "      WHERE $extraCondition$\n" +
                "      GROUP BY $conditionGroup$\n" +
                ")B ON A.id = B.id ORDER BY indexValue DESC";

        String regular = "(\\$)(.*?)(\\$)";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(sql);
        //创建一个list保存通过正则取出的字符
        List<String> list = new ArrayList<>();
        while(matcher.find()) {
            list.add(matcher.group(2));
        }

        System.out.println( list );

        for (String replaceChar: list) {
            String replace = "$"+replaceChar+"$";
            Object filter = params.get(replace);
            String condition = String.valueOf( filter );
            if (StringUtils.isEmpty( condition ) || "null".equalsIgnoreCase( condition )){
                break;
            }

            //替换
            sql = sql.replace( replace,condition );
            //将参数MAP中的filter去除
            params.remove(replace);
        }

        System.out.println( sql );


        Random random = new Random();
        System.out.println(random.nextFloat());




        Object o1 = "0.65218";
        Object o2 = "0.68370";

        String s1 = String.valueOf( o1 );
        String s2 = String.valueOf( o2 );

        BigDecimal b1 = new BigDecimal( s1);
        BigDecimal b2 = new BigDecimal( s2 );

        System.out.println( b1.add( b2 ) );

        System.out.println( b1.subtract( b2 ) );

        System.out.println( b1.multiply( b2 ) );

        System.out.println( b1.divide( b2 ,BigDecimal.ROUND_HALF_UP));

        System.out.println(b2.subtract( b1 ).divide( b1,BigDecimal.ROUND_HALF_UP ));




        String url11 = "http:nkns.dossen.com:8450/views/35/sheet0?iid=1&param=";

        int i = url11.indexOf( "8450" );
        int i1 = url11.indexOf( "?" );

        if (url11.indexOf( "8450" ) != -1 && url11.indexOf( "?" ) != -1) {
            System.out.println( "xdsfsf" );
        }

        System.out.println( i );
        System.out.println( i1 );

        String[] split = url11.split( "8450" );
        String[] split1 = split[1].split( "\\?" );
        System.out.println( split1[0] );

//        // 替换 /=bi111 ?=bi222 &=bi333
//        String url = "/Analyzer/dashboard/designer.aspx?action=open&tabindex=2&reportid=-1922565324&folderid=-1725226504&tb=1&token=WUFBQUFnQUFBQVFDSnY1OSs3eTlWYzlTNm1Jak9HdkszdFVkSjIxdGZHWXhHRGhhMkhhMkNFZHBqR01WTlUyTw&cmsUserName=wangchenchen2(%E7%8E%8B%E6%99%A8%E6%99%A8)?userid=report&password=bi123&cmsUserName=wangchenchen2(%E7%8E%8B%E6%99%A8%E6%99%A8)&userid=report&password=bi123&cmsUserName=wangchenchen2(%E7%8E%8B%E6%99%A8%E6%99%A8)" ;
//        System.out.println(url.contains( "?" ));
//        System.out.println(url);
//        System.out.println("--------------");
//
//        String s = url.replaceAll( "/","bi111" ).replaceAll( "\\?","bi222" ).replaceAll( "&","bi333" ).replaceAll( "=","bi444" ).replaceAll( "\\.","bi555" )
//                .replaceAll( "\\(","bi666" ).replaceAll( "\\)","bi777" ).replaceAll( "%","bi888" );
//
//        System.out.println(s);
//
//        System.out.println("--------------");
//        String s1 = url.replaceAll( "bi111","/" ).replaceAll( "bi222","\\?" ).replaceAll( "bi333","&" ).replaceAll( "bi444","=" ).replaceAll( "bi555","\\." )
//                .replaceAll( "bi666","\\(" ).replaceAll( "bi777","\\)" ).replaceAll( "bi888","%" );
//        System.out.println(s1);
//
//        System.out.println(s1.equals( url ));

//        String url = "Analyzer/dashboard/designer.aspx?action=open&tabindex=2&reportCode=828&folderid=-1725226504&tb=1&token=WUFBQUFnQUFBQVFDSnY1OSs3eTlWYzlTNm1Jak9HdkszdFVkSjIxdGZHWXhHRGhhMkhhMkNFZHBqR01WTlUyTw&cmsUserName=wangchenchen2(%E7%8E%8B%E6%99%A8%E6%99%A8)?userid=report&password=bi123&cmsUserName=wangchenchen2(%E7%8E%8B%E6%99%A8%E6%99%A8)&userid=report&password=bi123&cmsUserName=wangchenchen2(%E7%8E%8B%E6%99%A8%E6%99%A8)" ;
//
//        String reportCode = "";
//
//        if (StringUtils.isNotBlank( url )) {
//            String[] split = url.split( "&" );
//
//            for (String i : split) {
//                if (i.contains( "reportCode" )) {
//                    reportCode = i.split( "=" )[1];
//                }
//            }
//        }

        String loginName = "huangzc(%E9%BB%84%E6%B3%BD%E7%BA%AF)";

//        String encode = URLEncoder.encode( loginName,"UTF-8" );

        String url0 = "https://gray-biauth.dossen.com/oneid/auth?returnUrl=bi111Analyzerbi111dashboardbi111designerbi555aspxbi222actionbi444openbi333tabindexbi4442bi333reportidbi444-1922565324bi333folderidbi444-1725226504bi333tbbi4441bi333tokenbi444WUFBQUFnQUFBQVFDSnY1OSs3eTlWYzlTNm1Jak9HdkszdFVkSjIxdGZHWXhHRGhhMkhhMkNFZHBqR01WTlUyTwbi333cmsUserNamebi444huangzcbi666bi888E9bi888BBbi88884bi888E6bi888B3bi888BDbi888E7bi888BAbi888AFbi777bi333reportCodebi444R100bi333useridbi444managerbi333passwordbi444bi123bi333cmsUserNamebi444huangzcbi666bi222bi222bi222bi777bi333useridbi444managerbi333passwordbi444bi123bi333cmsUserNamebi444huangzcbi666bi222bi222bi222bi777bi333useridbi444managerbi333passwordbi444bi123bi333cmsUserNamebi444huangzcbi666bi222bi222bi222bi777&code=A94C77CC8270DAD9DFAC65D23D41832B&state=oneid&responseStatus=100180";
        String url1 = "bi111Analyzerbi111dashboardbi111designerbi555aspxbi222actionbi444openbi333tabindexbi4442bi333reportidbi444-1922565324bi333folderidbi444-1725226504bi333tbbi4441bi333tokenbi444WUFBQUFnQUFBQVFDSnY1OSs3eTlWYzlTNm1Jak9HdkszdFVkSjIxdGZHWXhHRGhhMkhhMkNFZHBqR01WTlUyTwbi333cmsUserNamebi444huangzcbi666bi888E9bi888BBbi88884bi888E6bi888B3bi888BDbi888E7bi888BAbi888AFbi777bi333reportCodebi444R100";
        String url = getDecode( url0 );


        String url100 = "https://analyzer.dossen.com/Analyzer/dashboard/designer.aspx?action=open&tabindex=2&reportid=-1922565324&folderid=-1725226504&tb=1&token=WUFBQUFnQUFBQVFDSnY1OSs3eTlWYzlTNm1Jak9HdkszdFVkSjIxdGZHWXhHRGhhMkhhMkNFZHBqR01WTlUyTw&cmsUserName=huangzc(%E9%BB%84%E6%B3%BD%E7%BA%AF)&reportCode=R100";

        String cms = "huangzc(黄泽纯)";


        String encode1 = URLEncoder.encode( getEncrypt( cms ),"UTF-8" );
        String encrypt = getDecode( encode1 );


        String encode = URLEncoder.encode( getEncrypt( cms ),"UTF-8" );
        String cmsUserName = getDecode( encode );

        System.out.println(cmsUserName);
        System.out.println(encode1);
        System.out.println(encrypt);
        System.out.println("huangzc(%E9%BB%84%E6%B3%BD%E7%BA%AF)");


    }


    /**
     * 自定义装码字符串
     * @param url
     * @return
     */
    private static String getEncrypt(String url){
        if (StringUtils.isNotBlank( url )) {
            return url.replaceAll( "/","bi111" ).replaceAll( "\\?","bi222" ).replaceAll( "&","bi333" ).replaceAll( "=","bi444" ).replaceAll( "\\.","bi555" )
                    .replaceAll( "\\(","bi666" ).replaceAll( "\\)","bi777" ).replaceAll( "%","bi888" );
        }
        return "";
    }


    private static String getDecode(String url){
        if (StringUtils.isNotBlank( url )) {
            return url.replaceAll( "bi111","/" ).replaceAll( "bi222","\\?" ).replaceAll( "bi333","&" ).replaceAll( "bi444","=" ).replaceAll( "bi555","\\." )
                    .replaceAll( "bi666","\\(" ).replaceAll( "bi777","\\)" ).replaceAll( "bi888","%" );
        }
        return "";
    }
}
