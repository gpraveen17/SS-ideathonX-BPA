package org.statestreet.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataExtractMapper {

    public DataExtract mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DataExtract.Builder()
                .id(rs.getInt("id"))
                .processId(rs.getInt("process_id"))
                .columnData(rs.getString("column_data"))
                .valueData(rs.getString("value_data"))
                .build();
    }

}
