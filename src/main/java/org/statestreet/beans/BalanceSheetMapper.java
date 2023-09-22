package org.statestreet.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceSheetMapper {

    public BalanceSheet mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BalanceSheet.Builder()
                .id(rs.getInt("id"))
                .productName(rs.getString("product_name"))
                .amount(rs.getDouble("amount"))
                .productType(rs.getString("product_type"))
                .processId(rs.getInt("process_id"))
                .build();
    }
}
