package com.futao.biz.user.tools;

import com.futao.common.tools.CodeGen;

/**
 * @author futao
 * @date 2019/12/27.
 */
public class CodeGenTool {
    public static void main(String[] args) {
        CodeGen.run(
                CodeGen
                        .Config
                        .builder()
                        .author("futao")
                        .jdbc("jdbc:mysql://localhost:3306/spring_cloud_learn?useUnicode=true&characterEncoding=utf8")
                        .userName("root")
                        .password("123456789")
                        .modelName("/biz-user")
                        .basePackage("com.futao.biz.user")
                        .tableNames(new String[]{"user_sign_in"})
                        .build()
        );
    }
}
