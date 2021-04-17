package com.manage.sys.sms.dao.typehanlder;

import com.manage.sys.sms.utils.CollectionUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class List2StringTypeHandler implements TypeHandler<List<String>> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, List<String> stringList, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(index,convertList2String(stringList));
    }

    @Override
    public List<String> getResult(ResultSet resultSet, String columnName) throws SQLException {
        return convertString2List(resultSet.getString(columnName));
    }

    @Override
    public List<String> getResult(ResultSet resultSet, int index) throws SQLException {
        return convertString2List(resultSet.getString(index));
    }

    @Override
    public List<String> getResult(CallableStatement callableStatement, int index) throws SQLException {
        return convertString2List(callableStatement.getString(index));
    }

    private String convertList2String(List<String> source) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        source.parallelStream().forEach(sou -> {
            sb.append(sou).append(",");
        });
       return sb.substring(0,sb.length()-1);
    }

    private List<String> convertString2List(String content) {
        if (content == null) {
            return null;
        }
        String[] split = content.split(",");
        return Arrays.asList(split);
    }


}
