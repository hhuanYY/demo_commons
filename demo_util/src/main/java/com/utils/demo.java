package com.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/5/10
 */
public class demo {
    public static void main(String[] args) throws UnsupportedEncodingException {

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
