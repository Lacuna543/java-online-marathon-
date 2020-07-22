package Sprint10.task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "", "");
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        return statement = connection.createStatement();

    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        statement.execute("CREATE SCHEMA " + schemaName);
    }

    public void dropSchema() throws SQLException {
        statement.execute("DROP SCHEMA " + schemaName);
    }

    public void useSchema() throws SQLException {
        statement.execute("SET schema " + schemaName);
    }

    public void createTableRoles() throws SQLException {

        statement.execute("CREATE TABLE roles (" +
                " id int NOT NULL AUTO_INCREMENT, " +
                " roleName varchar(255) NULL DEFAULT NULL, " +
                "  PRIMARY KEY (id)) ");
    }

    public void createTableDirections() throws SQLException {
        statement.execute("CREATE TABLE directions (" +
                " id int NOT NULL AUTO_INCREMENT, " +
                " directionName varchar(255) NULL DEFAULT NULL, " +
                "  PRIMARY KEY (id)) ");
    }

    public void createTableProjects() throws SQLException {
        statement.execute("CREATE TABLE projects  (" +
                "  id int NOT NULL AUTO_INCREMENT," +
                "  projectName varchar(255) NULL DEFAULT NULL," +
                "  directionId int NULL DEFAULT NULL," +
                "  PRIMARY KEY (id)," +
                "  FOREIGN KEY (directionId) REFERENCES directions (id))");
    }

    public void createTableEmployee() throws SQLException {
        statement.execute("CREATE TABLE employee  (" +
                "  id int NOT NULL AUTO_INCREMENT," +
                "  firstName varchar(255) NULL DEFAULT NULL," +
                "  roleId int NOT NULL," +
                "  projectId int NOT NULL," +
                "  PRIMARY KEY (id)," +
                "  FOREIGN KEY (roleId) REFERENCES roles (id)," +
                "  FOREIGN KEY (projectId) REFERENCES projects (id))");
    }

    public void dropTable(String tableName) throws SQLException {
        statement.execute("DROP table if exists " + tableName);
    }

    public void insertTableRoles(String roleName) throws SQLException {
        statement.executeUpdate("INSERT INTO roles(roleName) VALUES (" + statement.enquoteLiteral(roleName) + ")");
    }

    public void insertTableDirections(String directionName) throws SQLException {
        statement.executeUpdate("INSERT INTO directions(directionName) VALUES (" + statement.enquoteLiteral(directionName) + ")");
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
// directionName => directionId
        statement.executeUpdate("INSERT INTO projects(projectName, directionId) VALUES (" + statement.enquoteLiteral(projectName)
                + ", (SELECT id FROM directions WHERE directions.directionName = " + statement.enquoteLiteral(directionName) + "))");
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        // roleName => roleId, // projectName => projectId
        statement.executeUpdate("INSERT INTO employee(firstName, roleId, projectId) values (" + statement.enquoteLiteral(firstName)
                + ", (SELECT id FROM roles WHERE roleName = " + statement.enquoteLiteral(roleName) + "), (SELECT id FROM projects WHERE projectName= " + statement.enquoteLiteral(projectName) + "))");

    }

    public int getRoleId(String roleName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM roles WHERE roleName = " + statement.enquoteLiteral(roleName));
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getDirectionId(String directionName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM directions WHERE directionName = " + statement.enquoteLiteral(directionName));
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getProjectId(String projectName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM projects WHERE projectName = " + statement.enquoteLiteral(projectName));
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getEmployeeId(String firstName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM employee WHERE firstName = " + statement.enquoteLiteral(firstName));
        resultSet.next();
        return resultSet.getInt("id");
    }

    public List<String> getAllRoles() throws SQLException {
//        statement.addBatch("insert into roles values roleName");
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select roleName from roles");
        while (resultSet.next()) {
            list.add(resultSet.getString("roleName"));
        }
        return list;
    }

    public List<String> getAllDirestion() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select directionName from directions");
        while (resultSet.next()) {
            list.add(resultSet.getString("directionName"));
        }
        return list;
    }

    public List<String> getAllProjects() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select projectName from projects");
        while (resultSet.next()) {
            list.add(resultSet.getString("projectName"));
        }
        return list;
    }

    public List<String> getAllEmployee() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select firstName from employee");
        while (resultSet.next()) {
            list.add(resultSet.getString("firstName"));
        }
        return list;
    }

    public List<String> getAllDevelopers() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select firstName from employee where roleId = (select id from roles where roleName = 'Developer')");
        while (resultSet.next()) {
            list.add(resultSet.getString("firstName"));
        }
        return list;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select projectName from projects where directionId = (select id from directions where directionName = 'Java')");
        while (resultSet.next()) {
            list.add(resultSet.getString("projectName"));
        }
        return list;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT firstName FROM employee JOIN projects ON directionID = (SELECT id FROM directions WHERE directionName = 'Java') " +
                "WHERE roleId = (Select id FROM roles WHERE roleName='Developer') AND projectId = projects.id");
        while (resultSet.next()) {
            list.add(resultSet.getString("firstName"));
        }
        return list;
    }

}

