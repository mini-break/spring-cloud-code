package cn.springcloud.book.gateway.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
<<<<<<< HEAD
=======

import org.springframework.util.StringUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
>>>>>>> 93490155c4b9b8723a72cb498c7327f2b6ce7f07

public class JwtUtil {
    public static final String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_AUTH = "Authorization";

    public static String generateToken(String user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", new Random().nextInt());
        map.put("user", user);
        String jwt = Jwts.builder()
                .setSubject("user info") // 主题
                .setClaims(map) // 有效载荷
                .signWith(SignatureAlgorithm.HS512, SECRET) // 签名
                .compact();
        String finalJwt = TOKEN_PREFIX + " " + jwt;
        return finalJwt;
    }

<<<<<<< HEAD
	    public static String generateToken(String user) {
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("id", new Random().nextInt());
	        map.put("user", user);
	        String jwt = Jwts.builder()
    			  .setSubject("user info").setClaims(map)//
    			  .signWith(SignatureAlgorithm.HS512, SECRET) // 签名,用HS512加密
    			  .compact();
	        String finalJwt = TOKEN_PREFIX + " " +jwt;
	        return finalJwt;
	    }
=======
    public static Map<String, String> validateToken(String token) {
        if (token != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String id = String.valueOf(body.get("id"));
            String user = (String) (body.get("user"));
            map.put("id", id);
            map.put("user", user);
            if (StringUtils.isEmpty(user)) {
                throw new PermissionException("user is error, please check");
            }
            return map;
        } else {
            throw new PermissionException("token is error, please check");
        }
    }
>>>>>>> 93490155c4b9b8723a72cb498c7327f2b6ce7f07

}
