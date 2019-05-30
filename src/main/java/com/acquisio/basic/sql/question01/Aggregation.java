package com.acquisio.basic.sql.question01;

import com.acquisio.util.dbutil.H2DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


//ant run-utility-sql-q1 -Dutility=Aggregation

/**
 * Write a query to extract the number of employees that are working on each project.
 * -- The select should output those columns
 * -- |ProjectTitle|NumberOfEmployees|
 *
 * Here is the database schema to use.
 * <p>
 * employees                             projects
 * +---------------+---------+           +---------------+---------+
 * | id            | int     |<----+  +->| id            | int     |
 * | first_name    | varchar |     |  |  | title         | varchar |
 * | last_name     | varchar |     |  |  | start_date    | date    |
 * | salary        | int     |     |  |  | end_date      | date    |
 * | department_id | int     |--+  |  |  | budget        | int     |
 * +---------------+---------+  |  |  |  +---------------+---------+
 * |  |  |
 * departments                  |  |  |  employees_projects
 * +---------------+---------+  |  |  |  +---------------+---------+
 * | id            | int     |<-+  |  +--| project_id    | int     |
 * | name          | varchar |     +-----| employee_id   | int     |
 * +---------------+---------+           +---------------+---------+
 */
public class Aggregation {
    public static void main(String[] args) throws SQLException {
        H2DBUtil.startDatabase();
        try {
            Aggregation instance = new Aggregation();
            instance.printNumberOfEmployeesPerProject();
        } finally {
            H2DBUtil.stopDatabase();
        }
    }

    private void printNumberOfEmployeesPerProject() throws SQLException {
        try (Connection conn = H2DBUtil.getConnection()) {
            // Start : For consultation only, can be removed
//            H2DBUtil.displayTableRows(conn, "projects");
//            H2DBUtil.displayTableRows(conn, "departments");
//            H2DBUtil.displayTableRows(conn, "employees");
//            H2DBUtil.displayTableRows(conn, "employees_projects");
            // End : For consultation only, can be removed

            // TODO: Insert query here
            // See requirement in this class javadoc
            //String query = "select 1 as dummyValue from dual";
			
			
			String query = "SELECT projects.title AS ProjectTitle, COUNT(*) AS NumberOfEmployees FROM projects INNER JOIN employees_projects ON projects.id = employees_projects.project_id GROUP BY projects.id";
					

            ResultSet resultSet = conn.createStatement().executeQuery(query);
            H2DBUtil.displayResultSet(resultSet);

        }
    }
}
