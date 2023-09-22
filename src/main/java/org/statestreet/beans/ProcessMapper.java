package org.statestreet.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessMapper {

    public Process mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Process.Builder()
                .id(rs.getInt("id"))
                .processName(rs.getString("process_name"))
                .build();
    }
}
