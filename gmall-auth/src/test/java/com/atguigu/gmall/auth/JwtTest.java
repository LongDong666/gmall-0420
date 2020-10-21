package com.atguigu.gmall.auth;

import com.atguigu.gmall.common.utils.JwtUtils;
import com.atguigu.gmall.common.utils.RsaUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    // 别忘了创建D:\\project\rsa目录
	private static final String pubKeyPath = "D:\\sh0420\\ideaData\\rsa\\rsa.pub";
    private static final String priKeyPath = "D:\\sh0420\\ideaData\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "12#$#332#$sfsdSDSD%");
    }

    @BeforeEach
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "11");
        map.put("username", "liuyan");
        // 生成token
        String token = JwtUtils.generateToken(map, privateKey, 10);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IjExIiwidXNlcm5hbWUiOiJsaXV5YW4iLCJleHAiOjE2MDMxMTIxMzB9.gzrZvKJsBwVrKABegZrZ9wKtx7kgSRgQP3CsWxZ1RtbhmZSmnlhT2lx3u0DG_JuQQ4Zy5nhsHXDSkvnf9GAJWBBzm6LndduMQiD2ePSyRlkvzd1ve-uYW_JBpAGOanuRMuHUJ4Fj3k6pAwsr-KjXBh3hlIsG9UIa_Qgjxz4zDm6dsa7xcJnkgKG13yqvosE6y2Fqn8a3lHjkeF6-m_J4l5uiGjVH8h6HhmByHKtbfH3r5uPdIKZAyDCWLg9jcIuJzbarEjVKn9Dvy6LVH6zwT-dWXiewOAlWLgBfRQJf1cyF70Pa9JfJwSlA2ZvEh6hJAHsXzgI1yBZw0u_8ij99vg";

        // 解析token
        Map<String, Object> map = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + map.get("id"));
        System.out.println("userName: " + map.get("username"));
    }
}
